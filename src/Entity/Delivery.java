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

public class Delivery {
 
    private String deliveryID;
    private Date deliveryDate;
    private Affiliates deliverySource;
    private Address deliveryDestination;
    private ArrayList<Order> orderList = new ArrayList<Order>();
    private double deliveryCharges;

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
            for (int i=this.orderList.size(); i>=0; i--) {
                orderResult += this.orderList.get(i).getOrderID() + " " + this.orderList.get(i).getOrderDate() + " " + this.orderList.get(i).getTotalAmount() + "\n";
            }
        }
        
        return orderResult;
    }

  
    
    
}