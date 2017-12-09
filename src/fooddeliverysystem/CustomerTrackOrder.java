/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

import Entity.Delivery;
import java.util.ArrayList;

/**
 *
 * @author Hskang
 */
public class CustomerTrackOrder {

    private final String DELIVERING = "Delivering";
    private ArrayList<Delivery> deliveryList;
    private String customerPhone;

    public CustomerTrackOrder(ArrayList<Delivery> deliveryList, String customerPhone) {
        this.deliveryList = deliveryList;
        this.customerPhone = customerPhone;
    }

    private ArrayList<Delivery> findPendingDelivery() {
        ArrayList<Delivery> delivery = new ArrayList<Delivery>();

        for (int i = 0; i < deliveryList.size(); i++) {
            if (deliveryList.get(i).getOrder().getCustomer().getCustPhone().compareTo(this.customerPhone) == 0) {
                delivery.add(deliveryList.get(i));
            }
        }

        return delivery;
    }

    public void displayPendingDelivery() {
        ArrayList<Delivery> delivery = findPendingDelivery();

        if (delivery == null) {
            System.out.println("You have no order to be delivered.");
        } else {
            System.out.println("\nTracking Delivery Order\n");
            System.out.println(String.format("%-3s\t%-10s\t%-20s\t%-20s\t%-60s\t%-10s", "No.", "Delivery ID", "Delivery Date", "Delivery ETA", "Delivery Destination", "Order ID"));
            System.out.println("=================================================================================================================================================");
            
            for(int i=0; i<delivery.size(); i++) {
                System.out.print(String.format("%-3s\t%-10s\t%-20s\t%-20s\t%-60s\t%-10s\n", (i+1) + ".", delivery.get(i).getDeliveryID(), delivery.get(i).getFormattedDeliveryDateTime(), delivery.get(i).getFormattedArrivedDateTime(), delivery.get(i).getDeliveryDestination().toString(), delivery.get(i).getOrder().getOrderID()));
            }
        }
    }

}
