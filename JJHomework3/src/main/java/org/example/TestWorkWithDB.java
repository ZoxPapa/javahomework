package org.example;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class TestWorkWithDB {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test")) {
            Statement statement = connection.createStatement();
            createDB(statement);
            addStudents(statement);
            readStudents(statement);
            deleteStudent(statement, "Lee");

            updateStudent(connection);
            readStudents(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void updateStudent(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("update Student set secondName = $1 where secondName = 'Havlichek' ");
        statement.setString(1, "Wick");
        statement.execute();
    }

    private static void deleteStudent(Statement statement, String name) throws SQLException {
        statement.execute("delete Student where secondName = '" + name + "'");
    }

    private static void readStudents(Statement statement) throws SQLException {
        ResultSet result = statement.executeQuery("select secondName from Student");
        while(result.next()) System.out.println(result.getString("secondName"));
    }

    private static void addStudents(Statement statement) throws SQLException {
        statement.execute("insert into Student values" +
                "(1, 'Bob', 'Lee', 23)," +
                "(2, 'John', 'Havlichek', 34)");
    }

    static void createDB(Statement statement) throws SQLException {
        statement.execute("create table Student(id bigint, " +
                "firstName varchar(256), secondName varchar(256), age int)");
    }
}
