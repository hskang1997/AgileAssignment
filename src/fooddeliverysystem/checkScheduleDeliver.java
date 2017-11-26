package fooddeliverysystem;

import Entity.*;
import java.util.List;
import java.util.Scanner;

public class checkScheduleDeliver {

    Scanner scan = new Scanner(System.in);
    String deliverManID;

    public static void main(String[] args) {
        checkScheduleDeliver checkScheduleDeliver = new checkScheduleDeliver();
    }

    public void viewDelivery(List<Delivery> deliveryList) {
        boolean check = false;
        System.out.println("Delivery Schedule:");
        System.out.println("Please enter your Delivery Man ID");
        deliverManID = scan.next().toUpperCase();

        for (int i = 0; i < deliveryList.size(); i++) {
            if (deliverManID.equals(deliveryList.get(i).getDeliveryMan().getDeliveryManID())) {
                check = true;
                break;
            }
        }

        if (!check) {
            System.out.println("You have no scheduled delivery currently.");
        } else {
            for (int i = 0; i < deliveryList.size(); i++) {
                if (deliverManID.equals(deliveryList.get(i).getDeliveryMan().getDeliveryManID())) {
                    System.out.println("Order ID: " +deliveryList.get(i).getSo().getOrderID());
                    System.out.println("Delivery Address : " + deliveryList.get(i).getDeliveryDestination().getAddress());
                    System.out.println("Delivery Time : " + deliveryList.get(i).getSo().getSelectedTime());
                    System.out.println("Restaurant :"+ deliveryList.get(i).getDeliverySource().getRestaurantName());
                    System.out.println();
                }
            }

        }
    }
}
