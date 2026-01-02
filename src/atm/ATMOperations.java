package atm;

import java.sql.*;

public class ATMOperations {

    public static double checkBalance(String card) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT balance FROM users WHERE card_number=?");
        ps.setString(1, card);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getDouble(1);
    }

    public static void deposit(String card, double amount) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE users SET balance = balance + ? WHERE card_number=?");
        ps.setDouble(1, amount);
        ps.setString(2, card);
        ps.executeUpdate();
    }

    public static void withdraw(String card, double amount) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE users SET balance = balance - ? WHERE card_number=?");
        ps.setDouble(1, amount);
        ps.setString(2, card);
        ps.executeUpdate();
    }
}
