/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Cards;
import model.Transactions;

/**
 *
 * @author codevn
 */
public class DAO {

    DBContext db = new DBContext();

    public void addNewCard(String cardNumber, String accountNumber, String customerName, String releaseDate, String expirationDate, int isBlocked) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement("INSERT INTO cards VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, cardNumber);
            statement.setString(2, accountNumber);
            statement.setString(3, customerName);
            statement.setString(4, releaseDate);
            statement.setString(5, expirationDate);
            statement.setInt(6, isBlocked);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new transaction to the database
    public void addNewTransaction(int id, String cardNumber, String transactionDate, int amount, String transactionType) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement("INSERT INTO Transactions VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, id);
            statement.setString(2, cardNumber);
            statement.setString(3, transactionDate);
            statement.setInt(4, amount);
            statement.setString(5, transactionType);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all cards from the database
    public ArrayList<Cards> getAllCards() {
        ArrayList<Cards> cards = new ArrayList<>();
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cards");
            while (resultSet.next()) {
                cards.add(new Cards(resultSet.getString("card_number"),
                        resultSet.getString("account_number"),
                        resultSet.getString("customer_name"),
                        resultSet.getString("release_date"),
                        resultSet.getString("expiration_date"),
                        Boolean.parseBoolean(resultSet.getInt("is_blocked") + "")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

    public Cards getCardByNumber(String card_number) {
        try {
            PreparedStatement statement = db.getConnection().prepareStatement("SELECT * FROM cards where card_number = ?");
            statement.setString(1, card_number);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Cards(resultSet.getString("card_number"),
                    resultSet.getString("account_number"),
                    resultSet.getString("customer_name"),
                    resultSet.getString("release_date"),
                    resultSet.getString("expiration_date"),
                    Boolean.parseBoolean(resultSet.getInt("is_blocked") + ""));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to retrieve all transactions from the database
    public ArrayList<Transactions> getAllTransactions() {
        ArrayList<Transactions> transactions = new ArrayList<>();
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Transactions");
            while (resultSet.next()) {
                transactions.add(new Transactions(resultSet.getInt("id"), getCardByNumber(resultSet.getString("card_number")), resultSet.getString("transaction_date"), resultSet.getInt("amount"), resultSet.getString("transaction_type")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
    
    public ArrayList<Transactions> getAllTransactionsFilterDate(String date) {
        ArrayList<Transactions> transactions = new ArrayList<>();
        try {
            PreparedStatement statement = db.getConnection().prepareStatement("SELECT * FROM Transactions where transaction_date like ?");
            statement.setString(1, "%" + date + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                transactions.add(new Transactions(resultSet.getInt("id"), getCardByNumber(resultSet.getString("card_number")), resultSet.getString("transaction_date"), resultSet.getInt("amount"), resultSet.getString("transaction_type")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
    
    public ArrayList<Transactions> getAllTransactionsFilterNumber(String number) {
        ArrayList<Transactions> transactions = new ArrayList<>();
        try {
            PreparedStatement statement = db.getConnection().prepareStatement("SELECT * FROM Transactions where card_number like ?");
            statement.setString(1, "%" + number + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                transactions.add(new Transactions(resultSet.getInt("id"), getCardByNumber(resultSet.getString("card_number")), resultSet.getString("transaction_date"), resultSet.getInt("amount"), resultSet.getString("transaction_type")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

}
