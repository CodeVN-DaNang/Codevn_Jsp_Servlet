/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.sql.Date;

public class Transaction {
    private int id;
    private Card card;
    private Date transactionDate;
    private double amount;
    private String transactionType;

    public Transaction() {
    }

    public Transaction(int id, Card card, Date transactionDate, double amount, String transactionType) {
        this.id = id;
        this.card = card;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", card=" + card + ", transactionDate=" + transactionDate + ", amount=" + amount + ", transactionType=" + transactionType + '}';
    }

    
}
