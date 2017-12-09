/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

import Entity.DeliveryMan;
import java.util.ArrayList;

/**
 *
 * @author Hskang
 */
public class TrackDeliveryMan {

    private ArrayList<DeliveryMan> deliveryManList = new ArrayList<DeliveryMan>();

    public TrackDeliveryMan(ArrayList<DeliveryMan> deliveryManList) {
        this.deliveryManList = deliveryManList;
    }
    
    public void displayAllDeliveryManStatus() {
        System.out.println("\nAll Delivery Man\n");
        System.out.println(String.format("%-5s%-15s%-25s%-20s", "No.", "Delivery ID", "Delivery Man Name", "Delivery Status"));
        System.out.println("============================================================");
        
        for (int i = 0; i < deliveryManList.size(); i++) {
            System.out.println(String.format("%-5s%-15s%-25s%-20s", (i + 1) + ".", deliveryManList.get(i).getDeliveryManID(), deliveryManList.get(i).getName(), deliveryManList.get(i).getDeliveryStatus()));
        }
    }

    public void displaySelectedDeliveryStatus(String deliveryStatus) {
        int count = 0;
        System.out.println("\nDelivery Man ( Status : " + deliveryStatus + " )\n");
        System.out.println(String.format("%-5s%-15s%-25s%-20s", "No.", "Delivery ID", "Delivery Man Name", "Delivery Status"));
        System.out.println("============================================================");

        for (int i = 0; i < deliveryManList.size(); i++) {
            if (deliveryManList.get(i).getDeliveryStatus().compareTo(deliveryStatus) == 0) {
                System.out.println(String.format("%-5s%-15s%-25s%-20s", (count + 1) + ".", deliveryManList.get(i).getDeliveryManID(), deliveryManList.get(i).getName(), deliveryManList.get(i).getDeliveryStatus()));
                count++;
            }
        }
    }
}
