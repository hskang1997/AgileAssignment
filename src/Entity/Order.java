/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author Hskang
 */
public class Order {
    
    private final double GST_RATE = 0.06;
    
    private String orderID;
    private Date orderDate;
    private double totalAmount; // exclude gst amount
    private double gstAmount;
    private ArrayList<Menu> orderedMenu = new ArrayList<Menu>();
    private ArrayList<Integer> orderedMenuQty = new ArrayList<Integer>();

    // Empty Constructor
    public Order() {
    }

    // Only Order ID & Order Date
    public Order(String orderID, Date orderDate) {
        this.orderID = orderID;
        this.orderDate = orderDate;
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
    
    public void placeOrder(Menu menu, int qty) {
        this.orderedMenu.add(menu);
        this.orderedMenuQty.add(qty);
        this.totalAmount += (menu.getMenuPrice() * (double)qty);
        this.setGstAmount(totalAmount * GST_RATE);
    }
    
    public String displayOrder() {
        String orderResult = "";
        
        orderResult += this.getOrderID() + " " + this.getOrderDate() + " " + this.getTotalAmount() + "\n";
        
        return orderResult;
    }
}
