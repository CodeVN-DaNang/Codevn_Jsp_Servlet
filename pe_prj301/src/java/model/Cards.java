/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author codevn
 */
public class Cards {
    private String card_number;
    private String account_number;
    private String customer_name;
    private String release_date;
    private String expiration_date;
    private boolean is_blocked;

    public Cards(String card_number, String account_number, String customer_name, String release_date, String expiration_date, boolean is_blocked) {
        this.card_number = card_number;
        this.account_number = account_number;
        this.customer_name = customer_name;
        this.release_date = release_date;
        this.expiration_date = expiration_date;
        this.is_blocked = is_blocked;
    }

    public Cards() {
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public boolean isIs_blocked() {
        return is_blocked;
    }

    public void setIs_blocked(boolean is_blocked) {
        this.is_blocked = is_blocked;
    }

    @Override
    public String toString() {
        return "Cards{" + "card_number=" + card_number + ", account_number=" + account_number + ", customer_name=" + customer_name + ", release_date=" + release_date + ", expiration_date=" + expiration_date + ", is_blocked=" + is_blocked + '}';
    }
            
    
            
}
