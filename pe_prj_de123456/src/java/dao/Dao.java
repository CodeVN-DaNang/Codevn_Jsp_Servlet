/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author codevn
 */
import java.sql.*;
import model.Card;
import model.Transaction;

public class Dao {

    DBContext db = new DBContext();

    public double getTotalAmountByType(String cardNumber, String transactionType) {
        double totalAmount = 0;
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT SUM(amount) AS total FROM Transactions WHERE card_number = ? AND transaction_type = ?");
            ps.setString(1, cardNumber);
            ps.setString(2, transactionType);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                totalAmount += rs.getDouble("total");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return totalAmount;
    }
    
    public Card getCardByCardNumber(String cardNumber){
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from transactions where card_number like ?");
            ps.setString(1, cardNumber);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Card(cardNumber, rs.getString("account_number"), rs.getString("customer_name"), rs.getDate("expiration_date"), Boolean.parseBoolean(rs.getInt("is_blocked")+""));
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void insertTransaction(Transaction transaction) {
        try {
            String sql = "INSERT INTO Transactions (id, card_number, transaction_date, amount, transaction_type) VALUES (?, ?, ?, ?, ?)";
            Connection conn = db.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, transaction.getId());
            pstmt.setString(2, transaction.getCard().getCardNumber());
            pstmt.setDate(3, transaction.getTransactionDate());
            pstmt.setDouble(4, transaction.getAmount());
            pstmt.setString(5, transaction.getTransactionType());
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
