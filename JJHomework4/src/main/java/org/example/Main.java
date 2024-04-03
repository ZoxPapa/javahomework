package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration conf = new Configuration().configure();
        try(SessionFactory sessionFactory = conf.buildSessionFactory()){
            List<Student> students = createStudents();

            try (Session session = sessionFactory.openSession()){ //Add 10 students to DB
                Transaction tx = session.beginTransaction();
                students.forEach(session::persist);

                tx.commit();
            }

            try(Session session = sessionFactory.openSession()){
                findById(session, 4);
                updateById(session, 4);
                findById(session, 4);
                removeById(session, 4);
                findById(session, 4);
                findAllOlderThen(session, 20);
            }
        }catch(RuntimeException e){
            e.printStackTrace();
        }
    }

    private static void findAllOlderThen(Session session, int age) {
        Transaction transaction = session.beginTransaction();
        Query<Student> studentQuery = session.createQuery("from Student where age > :borderAge", Student.class);
        studentQuery.setParameter("borderAge", age);
        studentQuery.getResultList().forEach(System.out::println);
        transaction.commit();
    }

    private static void removeById(Session session, int i) {
        Transaction transaction = session.beginTransaction();
        Student student = session.find(Student.class, i);
        session.remove(student);
        transaction.commit();
    }

    private static void updateById(Session session, int i) {
        Transaction transaction = session.beginTransaction();
        Student student = session.find(Student.class, i);
        student.setFirstName("John");
        session.merge(student);
        transaction.commit();
    }

    public static List<Student> createStudents(){
        List<Student> resultList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Student stud = new Student();
            stud.setId((long) i);
            stud.setFirstName("Student#"+i);
            stud.setAge(15+i);
            resultList.add(stud);
        }
        return resultList;
    }

    public static void findById(Session session, int id){
        Transaction transaction = session.beginTransaction();
        Student student = session.find(Student.class, id);
        System.out.println(student);
        transaction.commit();
    }



}