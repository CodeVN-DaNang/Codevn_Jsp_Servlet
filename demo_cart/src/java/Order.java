/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author codevn
 */
public class Order {
    private int orderId;
    private boolean orderStatus;
    private Product product;

    public Order(int orderId, boolean orderStatus, Product product) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.product = product;
    }

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", orderStatus=" + orderStatus + ", product=" + product + '}';
    }
    
    
    
}
