/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Hskang
 */
public class Order {

    private final double GST_RATE = 0.06;

    private String orderID;
    private Date orderDate;
    private int foodQty;
    private String foodName;
    private double totalPrice;
    private double foodPrice;
    private Customer customer;
    private double totalAmount; // exclude gst amount
    private double gstAmount;
    private ArrayList<Menu> orderedMenu = new ArrayList<Menu>();
    private ArrayList<Integer> orderedMenuQty = new ArrayList<Integer>();

    // Empty Constructor
    public Order() {
        
    }

    public Order(Date orderDate, String orderID, String foodName, double totalAmount, double gstAmount, int foodQty, double totalPrice, double foodPrice) {
        this.orderDate = orderDate;
        this.orderID = orderID;
        this.foodName = foodName;
        this.totalAmount = totalAmount;
        this.gstAmount = gstAmount;
        this.foodQty = foodQty;
        this.totalPrice = totalPrice;
        this.foodPrice = foodPrice;
    }

    public String generateOrderID(int size) {
        return String.format("D%03d", size + 1);
    }

    // Only Order ID & Order Date
    public Order(String orderID, Date orderDate, Customer customer) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.customer = customer;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    private void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getGstAmount() {
        return gstAmount;
    }

    private void setGstAmount(double gstAmount) {
        this.gstAmount = gstAmount;
    }

    public ArrayList<Menu> getOrderedMenu() {
        return orderedMenu;
    }

    public void setOrderedMenu(ArrayList<Menu> orderedMenu) {
        this.orderedMenu = orderedMenu;
    }
    
    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getFoodQty() {
        return foodQty;
    }

    public void setFoodQty(int foodQty) {
        this.foodQty = foodQty;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void placeOrder(Menu menu, int qty) {
        this.orderedMenu.add(menu);
        this.orderedMenuQty.add(qty);
        this.totalAmount += (menu.getMenuPrice() * (double) qty);
        this.setGstAmount(totalAmount * GST_RATE);
        this.setTotalPrice(totalAmount + gstAmount);
        this.setFoodQty(qty);
    }

    public String toString() {
        return foodName + "\t\t   " + foodQty + "\t\t\t " + foodPrice;
    }
    
    public String total(){
        return String.format("\nSub Total: RM%.2f \nGST: RM%.2f \nTotal Price: RM%.2f",totalAmount,gstAmount,totalPrice);
    }
}
