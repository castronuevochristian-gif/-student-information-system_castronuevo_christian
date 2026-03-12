package studentinformationsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                // This loads the MySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                
                // Establish connection - CHANGE "your_password" to your real MySQL password
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_information_system",
                    "root", 
                    "Isekaitruck04_" 
                );
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}