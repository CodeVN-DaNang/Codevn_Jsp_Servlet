/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entity;

/**
 *
 * @author codevn
 */
public class Order {
    private int order_id;
    private Product product;
    private int quantity;

    public Order(int order_id, Product product, int quantity) {
        this.order_id = order_id;
        this.product = product;
        this.quantity = quantity;
    }

    public Order() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" + "order_id=" + order_id + ", product=" + product + ", quantity=" + quantity + '}';
    }
    
}
