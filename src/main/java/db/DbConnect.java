package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

    static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/songs";
            String user = "postgres";
            String password = "admin";
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Class error: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getMessage());
            System.out.println("Error: " + e.getErrorCode());
        }

        return connection;
    }

}
