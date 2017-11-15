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
public class DeliveryRecord {
    
    private DeliveryMan deliveryMan;
    private ArrayList<Delivery> deliveryRecords = new ArrayList<Delivery>();
    private int totalDeliveries = 0;
    private double distanceTravelled;

    // Empty Constructor
    public DeliveryRecord() {
    }

    // Only Delivery Man
    public DeliveryRecord(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    // Full
    public DeliveryRecord(DeliveryMan deliveryMan, double distanceTravelled) {
        this.deliveryMan = deliveryMan;
        this.distanceTravelled = distanceTravelled;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public int getTotalDeliveries() {
        return totalDeliveries;
    }

    public void setTotalDeliveries(int totalDeliveries) {
        this.totalDeliveries = totalDeliveries;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

//    public ArrayList<Delivery> getDeliveryList() {
//        return deliveryList;
//    }
//
//    public void setDeliveryList(ArrayList<Delivery> deliveryList) {
//        this.deliveryList = deliveryList;
//    }
//    
//    public void addDeliveryList(Delivery delivery) {
//        this.deliveryList.add(delivery);
//        this.totalDeliveries++;
//    }

    public ArrayList<Delivery> getDeliveryRecords() {
        return deliveryRecords;
    }
    
    
     public void setDeliveryRecords(ArrayList<Delivery> deliveryRecords) {
        this.deliveryRecords = deliveryRecords;
    }
    
    public void addDeliveryRecords(Delivery delivery) {
        this.deliveryRecords.add(delivery);
    }
}
