/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dell PC
 */
public class ScheduledOrders {

    private String orderID;
    private Date orderDateTime;
    private ArrayList<MenuScheduleOrder> orderedMenu = new ArrayList<MenuScheduleOrder>();
    private ArrayList<Integer> orderedMenuQty = new ArrayList<Integer>();
    private int selectedTimeFrame;
    private String selectedTime;
    private Address deliveryArea;
    private String deliveryAddress;
    private Affiliates restaurant;
    private double totalAmount; // exclude gst amount
    private double gstAmount;
    private double deliveryfees;
    private double subtotal;
    
    public ScheduledOrders() {

    }

    public ScheduledOrders(String orderID, Date orderDateTime, String selectedTime, Address deliveryArea, String deliveryAddress, Affiliates restaurant, double totalAmount, double gstAmount, double deliveryfees, double subtotal) {
        this.orderID = orderID;
        this.orderDateTime = orderDateTime;
        this.selectedTime = selectedTime;
        this.deliveryArea = deliveryArea;
        this.deliveryAddress = deliveryAddress;
        this.restaurant = restaurant;
        this.totalAmount = totalAmount;
        this.gstAmount = gstAmount;
        this.deliveryfees = deliveryfees;
        this.subtotal = subtotal;
    }

    public ScheduledOrders(String orderID, Date orderDate) {
        this.orderID = orderID;
        this.orderDateTime = orderDate;
    }

    public double getDeliveryfees() {
        return deliveryfees;
    }

    public void setDeliveryfees(double deliveryfees) {
        this.deliveryfees = deliveryfees;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Address getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(Address deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Affiliates getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Affiliates restaurant) {
        this.restaurant = restaurant;
    }


    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(Date orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(double gstAmount) {
        this.gstAmount = gstAmount;
    }

    public ArrayList<MenuScheduleOrder> getOrderedMenu() {
        return orderedMenu;
    }

    public void setOrderedMenu(ArrayList<MenuScheduleOrder> orderedMenu) {
        this.orderedMenu = orderedMenu;
    }

    public ArrayList<Integer> getOrderedMenuQty() {
        return orderedMenuQty;
    }

    public void setOrderedMenuQty(ArrayList<Integer> orderedMenuQty) {
        this.orderedMenuQty = orderedMenuQty;
    }

    public String getSelectedTime() {
        if (selectedTimeFrame == 1) {
            selectedTime = "12:00 PM";
        } else if (selectedTimeFrame == 2) {
            selectedTime = "6:00 PM";
        } else {
            selectedTime = "8:00 PM";
        }
        return selectedTime;
    }

    public void setSelectedTime(int selectedTimeFrame) {
        this.selectedTimeFrame = selectedTimeFrame;
    }

    @Override
    public String toString() {
        return "ScheduledOrders{" + "orderID=" + orderID + ", orderDate=" + orderDateTime + ", totalAmount=" + totalAmount + ", gstAmount=" + gstAmount + ", orderedMenu=" + orderedMenu + ", orderedMenuQty=" + orderedMenuQty + ", selectedTime=" + getSelectedTime() + '}';
    }

}
