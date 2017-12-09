/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Hskang
 */
import java.util.ArrayList;
import java.util.Date;

public class Delivery {

    private final static String PENDING = "Pending";
    private final static String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private String deliveryID;
    private Date deliveryDate;
    private Affiliates deliverySource;
    private Address deliveryDestination;
    private Order order = null;
    private double deliveryCharges;
    private String deliveryStatus; // Delivering or Pending or Delivered
    private DeliveryMan deliveryMan;
    private ScheduledOrders so;
    private Date arrivedDate = null;

    // Empty Constructor
    public Delivery() {
        this.deliveryStatus = PENDING;
    }

    // Full
    public Delivery(String deliveryID, Date deliveryDate, Affiliates deliverySource, Address deliveryDestination, double deliveryCharges) {
        this.deliveryID = deliveryID;
        this.deliveryDate = deliveryDate;
        this.deliverySource = deliverySource;
        this.deliveryDestination = deliveryDestination;
        this.deliveryCharges = deliveryCharges;
        this.deliveryStatus = PENDING;
    }
    
    public Delivery(String deliveryID, DeliveryMan deliveryMan, Affiliates deliverySource, Address deliveryDestination, ScheduledOrders so) {
        this.deliveryID = deliveryID;
        this.deliveryMan = deliveryMan;
        this.deliverySource = deliverySource;
        this.deliveryDestination = deliveryDestination;
        this.so = so;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public ScheduledOrders getSo() {
        return so;
    }

    public void setSo(ScheduledOrders so) {
        this.so = so;
    }

    public String getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(String deliveryID) {
        this.deliveryID = deliveryID;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
    public String getFormattedDeliveryDate() {
        return this.deliveryDate.getDate() + " " + this.month[this.deliveryDate.getMonth()] + " " + this.deliveryDate.getYear();
    }
    
    public String getFormattedDeliveryDateTime() {
        return this.deliveryDate.getDate() + " " + this.month[this.deliveryDate.getMonth()] + " " + this.deliveryDate.getYear() + " " + this.deliveryDate.getHours() + ":" + this.deliveryDate.getMinutes() + ":" + this.deliveryDate.getSeconds();
    }

    public Affiliates getDeliverySource() {
        return deliverySource;
    }

    public void setDeliverySource(Affiliates deliverySource) {
        this.deliverySource = deliverySource;
    }

    public Address getDeliveryDestination() {
        return deliveryDestination;
    }

    public void setDeliveryDestination(Address deliveryDestination) {
        this.deliveryDestination = deliveryDestination;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(double deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Date getArrivedDate() {
        return arrivedDate;
    }
    
    public void setArrivedDate(Date arrivedDate) {
        this.arrivedDate = arrivedDate;
    }

    public void setArrivedDate(long arrivedDate) {
        this.arrivedDate = new Date(arrivedDate);
    }

    public String getFormattedArrivedDate() {
        return this.arrivedDate.getDate() + " " + this.month[this.arrivedDate.getMonth()] + " " + this.arrivedDate.getYear();
    }
    
    public String getFormattedArrivedDateTime() {
        return this.arrivedDate.getDate() + " " + this.month[this.arrivedDate.getMonth()] + " " + this.arrivedDate.getYear() + " " + this.arrivedDate.getHours() + ":" + this.arrivedDate.getMinutes() + ":" + this.arrivedDate.getSeconds();
    }
    
    public String displayOrderList() {
        String orderResult = "";

        if (order!=null) {
            orderResult += "No. \t Order ID \t Order Date \t Amount(RM)\n";
            
                orderResult += this.order.getOrderID() + " " + this.order.getOrderDate() + " " + this.order.getTotalAmount() + "\n";
        }

        return orderResult;
    }

    public String displayDelivery() {
            
        return String.format("%-10s\t%-20s\t%-30s\t%-60s\t%-10s\t%-10.2f\n", this.deliveryID, this.getFormattedDeliveryDate(), this.deliverySource.getRestaurantName(), this.deliveryDestination.toString(), this.order.getOrderID(), this.deliveryCharges);
    }
}
