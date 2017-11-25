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

    private final static String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private String deliveryID;
    private Date deliveryDate;
    private Affiliates deliverySource;
    private Address deliveryDestination;
    private ArrayList<Order> orderList = new ArrayList<Order>();
    private double deliveryCharges;
    private DeliveryMan deliveryMan;
    private ScheduledOrders so;

    // Empty Constructor
    public Delivery() {
    }

    // Full
    public Delivery(String deliveryID, Date deliveryDate, Affiliates deliverySource, Address deliveryDestination, double deliveryCharges) {
        this.deliveryID = deliveryID;
        this.deliveryDate = deliveryDate;
        this.deliverySource = deliverySource;
        this.deliveryDestination = deliveryDestination;
        this.deliveryCharges = deliveryCharges;
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

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    public void addOrderList(Order order) {
        this.orderList.add(order);
    }

    public double getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(double deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public String displayOrderList() {
        String orderResult = "";

        if (!orderList.isEmpty()) {
            orderResult += "No. \t Order ID \t Order Date \t Amount(RM)\n";
            for (int i = this.orderList.size(); i >= 0; i--) {
                orderResult += this.orderList.get(i).getOrderID() + " " + this.orderList.get(i).getOrderDate() + " " + this.orderList.get(i).getTotalAmount() + "\n";
            }
        }

        return orderResult;
    }

    public String displayDelivery() {
        String orderIDs = "";
        
        for (int i=0; i < orderList.size(); i++) {
            orderIDs += orderList.get(i).getOrderID() + " ";
        }
            
        return String.format("%-10s\t%-20s\t%-30s\t%-60s\t%-10s\t%-10.2f\n", this.deliveryID, this.deliveryDate.getDate() + " " + this.month[this.deliveryDate.getMonth()] + " " + this.deliveryDate.getYear(), this.deliverySource.getRestaurantName(), this.deliveryDestination.toString(), orderIDs, this.deliveryCharges);
    }
}
