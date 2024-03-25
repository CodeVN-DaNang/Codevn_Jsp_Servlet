/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author codevn
 */
public class Transactions{
    private int id;
    private Cards card;
    private String transaction_date;
    private int amount;
    private String transaction_type;

    public Transactions(int id, Cards card, String transaction_date, int amount, String transaction_type) {
        this.id = id;
        this.card = card;
        this.transaction_date = transaction_date;
        this.amount = amount;
        this.transaction_type = transaction_type;
    }

    public Transactions() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cards getCard() {
        return card;
    }

    public void setCard(Cards card) {
        this.card = card;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    @Override
    public String toString() {
        return "Transactions{" + "id=" + id + ", card=" + card + ", transaction_date=" + transaction_date + ", amount=" + amount + ", transaction_type=" + transaction_type + '}';
    }

    
    
    
}
