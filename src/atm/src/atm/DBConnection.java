package atm;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/atm_db",
                "root",    // Replace with your MySQL username
                "password" // Replace with your MySQL password
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
