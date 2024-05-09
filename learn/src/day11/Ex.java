package day11;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex {

    // JDBC URL, username, and password
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/example_database";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Abhay@3690";

    // SQL queries
    private static final String INSERT_QUERY = "INSERT INTO example_table (name, age, email) VALUES (?, ?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM example_table";
    // Additional queries for UPDATE and DELETE can be defined similarly

    public static void main(String[] args) {
        try {
            // Establishing a connection to the database
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Insert operation
            insertRecord(connection, "John Doe", 30, "john@example.com");

            // Read operation
            readRecords(connection);

            // Closing the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to perform insert operation
    private static void insertRecord(Connection connection, String name, int age, String email) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
        statement.setString(1, name);
        statement.setInt(2, age);
        statement.setString(3, email);
        statement.executeUpdate();
        statement.close();
    }

    // Method to perform read operation
    private static void readRecords(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String email = resultSet.getString("email");
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email);
        }
        resultSet.close();
        statement.close();
    }

    // Additional methods for update and delete operations can be defined similarly
}
