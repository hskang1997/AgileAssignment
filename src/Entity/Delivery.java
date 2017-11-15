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
public class Delivery {
 
    private String deliveryID;
    private Date deliveryDate;
    private Affiliates deliverySource;
    private String deliveryDestination;
    private Order order;
    private double deliveryCharges;

    // Empty Constructor
    public Delivery() {
    }

    // Full
    public Delivery(String deliveryID, Date deliveryDate, Affiliates deliverySource, String deliveryDestination, double deliveryCharges) {
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

    public String getDeliveryDestination() {
        return deliveryDestination;
    }

    public void setDeliveryDestination(String deliveryDestination) {
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
    
    public String displayDelivery() {
        return String.format("%-10s\t%-20s\t%-30s\t%-30s\t%-10s\t%-10.2f\n", this.getDeliveryID(), this.getDeliveryDate().toString(), this.getDeliverySource().getRestaurantName(), this.getDeliveryDestination(), this.getOrder().getOrderID(), this.getDeliveryCharges());
    }
}
