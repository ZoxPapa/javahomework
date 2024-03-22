package ru.gb.lesson1.hw;

import ru.gb.lesson1.Streams;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Streams.Person> persons = generatePersons();
//        printNamesOrdered(persons);
//        System.out.println(printDepartmentOldestPerson(persons));
//        System.out.println(findFirstPersons(persons));
//        System.out.println(findTopDepartment(persons));
    }

    /**
     * Вывести на консоль отсортированные (по алфавиту) имена персонов
     */
    public static void printNamesOrdered(List<Streams.Person> persons) {
        persons.stream()
                .map(Streams.Person::getName)
                .sorted()
                .forEach(System.out::println);
    }


    /**
     * В каждом департаменте найти самого взрослого сотрудника.
     * Вывести на консоль мапинг department -> personName
     * Map<Department, Person>
     */
    public static Map<Streams.Department, Streams.Person> printDepartmentOldestPerson(List<Streams.Person> persons) {
        return persons.stream()
                .collect(Collectors.toMap(
                        Streams.Person::getDepartment,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(Streams.Person::getAge))));
    }


    /**
     * Найти 10 первых сотрудников, младше 30 лет, у которых зарплата выше 50_000
     */
    public static List<Streams.Person> findFirstPersons(List<Streams.Person> persons) {
        return persons.stream()
                .filter(it -> it.getAge() < 30)
                .filter(it -> it.getSalary() > 50_000)
                .limit(10)
                .toList();

    }


    /**
     * Найти депаратмент, чья суммарная зарплата всех сотрудников максимальна
     */
    public static Optional<Streams.Department> findTopDepartment(List<Streams.Person> persons) {
        Map<Streams.Department, Double> preResult = persons.stream()
                .collect(
                        Collectors.groupingBy(
                                Streams.Person::getDepartment,
                                Collectors.summingDouble(Streams.Person::getSalary)));
        Optional<Streams.Department> result = Optional.ofNullable(preResult.entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .get().getKey());
        return result;
    }
    private static List<Streams.Person> generatePersons() {
        List<Streams.Department> departments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            departments.add(new Streams.Department("Department #" + i));
        }

        List<Streams.Person> persons = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            persons.add(new Streams.Person(
                    "Person #" + i,
                    ThreadLocalRandom.current().nextInt(20, 61),
                    ThreadLocalRandom.current().nextInt(20_000, 100_000) * 1.0,
                    departments.get(ThreadLocalRandom.current().nextInt(departments.size()))
            ));
        }
        return persons;
    }

}