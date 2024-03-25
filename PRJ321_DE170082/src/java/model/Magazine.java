/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

public class Magazine {
    private String maz_id;
    private String magazine_title;
    private String publisher;
    private double price;

    public Magazine(String maz_id, String magazine_title, String publisher, double price) {
        this.maz_id = maz_id;
        this.magazine_title = magazine_title;
        this.publisher = publisher;
        this.price = price;
    }

    public Magazine() {
    }

    public String getMaz_id() {
        return maz_id;
    }

    public void setMaz_id(String maz_id) {
        this.maz_id = maz_id;
    }

    public String getMagazine_title() {
        return magazine_title;
    }

    public void setMagazine_title(String magazine_title) {
        this.magazine_title = magazine_title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Magazine{" + "maz_id=" + maz_id + ", magazine_title=" + magazine_title + ", publisher=" + publisher + ", price=" + price + '}';
    }

    
    
    
}
