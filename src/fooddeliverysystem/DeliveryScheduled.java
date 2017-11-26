package fooddeliverysystem;

import Entity.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DeliveryScheduled {

    int delManID;
    Scanner scan = new Scanner(System.in);
    DeliveryMan delierMan = new DeliveryMan();
    Delivery delivery;
    Date date = new Date(2017 + 1900, 11 - 1, 25, 11, 22, 30);
    Address address = new Address("L332", "Jalan Danau Jaya 3", 13500, "Setapak", "Kuala Lumpur", "Malaysia");
    Address address1 = new Address("L032", "Jalan Danau Jaya 1", 13500, "Setapak", "Kuala Lumpur", "Malaysia");
    Address address3 = new Address("D-215", "Jalan Lang Lama 2", 13500, "Klang", "Kuala Lumpur", "Malaysia");
    Affiliates restaurant3 = new Affiliates("Koh", "901212-02-9875", "Mcdonald123", "5201314", "Mcdonald", "AS0335680-V", "012-3456789", address3, "Mcdonald@gmail.com");
    ScheduledOrders so = new ScheduledOrders("SO0000", date, "8:00 PM", address1, "12, Lorong Hati 3, Setapak", restaurant3, 12, 0.72, 5, 17.72);
    List<Delivery> listDelivery = new ArrayList<>();

    public static void main(String[] args) {
        DeliveryScheduled ds = new DeliveryScheduled();
    }

    public void createDeliverySchedule(List<ScheduledOrders> orderList) {
        boolean check = false;
        boolean valid = false;
        String decision;
        String cont;
        System.out.println("Schedule Orders");
        if (orderList.isEmpty()) {
            System.out.println("Currently There are no scheduled orders.");
            checkScheduleDeliver checkSD = new checkScheduleDeliver();
            checkSD.viewDelivery(listDelivery);
        } else {
            int index = orderList.size() - 1;
            System.out.println();
            System.out.println("Order ID \t Dilivery Time \t Delievry Area \t Delivery Address");
            System.out.println("======== \t ============= \t ============= \t ================");
            System.out.println(String.format("%s \t\t %s \t %s \t %s", orderList.get(index).getOrderID(),
                    orderList.get(index).getSelectedTime(), orderList.get(index).getDeliveryArea().getArea(), orderList.get(index).getDeliveryAddress()));
            System.out.println("================================================================");
            delierMan.setDeliveryManID("D001");
            System.out.println("Delivery Man");
            System.out.println("1 : " + delierMan.getDeliveryManID());
            delivery = new Delivery("Dil0001", delierMan, orderList.get(index).getRestaurant(), address, so);
            System.out.println("Current Schedule: ");
            System.out.println("Time \t\t Destination Area \t Restaurant");
            System.out.println(delivery.getSo().getSelectedTime() + "\t\t" + delivery.getDeliveryDestination().getArea() + "\t\t\t" + delivery.getDeliverySource().getRestaurantName());
            listDelivery.add(delivery);

            do {
                try {
                    System.out.print("Please choose a delivery man > ");
                    delManID = scan.nextInt();
                    check = false;

                } catch (InputMismatchException ex) {
                    System.out.println("Please enter integer values within the range only.");
                    scan.next();
                    check = true;

                }
                if (delManID != 1) {
                    System.out.println("Please enter integer values within the range only.");
                }
            } while (check == true || delManID != 1);

            if (delivery.getSo().getSelectedTime().equals(orderList.get(index).getSelectedTime())) {
                if (delivery.getDeliveryDestination().getArea().equals(orderList.get(index).getDeliveryArea().getArea())) {

                    do {
                        System.out.println("Are you sure to assign to this delivery man? [y/n]");
                        decision = scan.next();
                        valid = check(decision);
                        if (valid == false) {
                            System.out.println("Please enter [y/n] only.");
                        }
                    } while (valid == false);

                    if (decision.equals("y") || decision.equals("Y")) {
                        System.out.println("This order is succesfully scheduled");
                        Address address = new Address(orderList.get(index).getDeliveryAddress(), orderList.get(index).getDeliveryArea().getArea());
                        orderList.get(index).setAddress(address);
                        Delivery newDelivery = new Delivery("Dil0002", delierMan, orderList.get(index).getRestaurant(), orderList.get(index).getAddress(), orderList.get(index));
                        listDelivery.add(newDelivery);
                        orderList.remove(index);

                        do {
                            System.out.println("Do you want to continue in scheduling the order?[y/n]");
                            cont = scan.next();
                            valid = check(cont);
                            if (valid == false) {
                                System.out.println("Please enter [y/n] only.");
                            }
                        } while (valid == false);

                        if (cont.equals("Y") || cont.equals("y")) {
                            createDeliverySchedule(orderList);
                        } else {
                            System.out.println("Thanks for using our system.");
                            checkScheduleDeliver checkSD = new checkScheduleDeliver();
                            checkSD.viewDelivery(listDelivery);
                        }

                    } else {
                        createDeliverySchedule(orderList);
                    }
                } else {
                    System.out.println("The delivery man is busy at that time.");
                    createDeliverySchedule(orderList);
                }
            } else {
                do {
                    System.out.println("Are you sure to assign to this delivery man? [y/n]");
                    decision = scan.next();
                    valid = check(decision);
                    if (valid == false) {
                        System.out.println("Please enter [y/n] only.");
                    }
                } while (valid == false);
                if (decision.equals("y") || decision.equals("Y")) {
                    System.out.println("This order is succesfully scheduled");
                    Address address = new Address(orderList.get(index).getDeliveryAddress(), orderList.get(index).getDeliveryArea().getArea());
                    orderList.get(index).setAddress(address);
                    Delivery newDelivery = new Delivery("Dil0002", delierMan, orderList.get(index).getRestaurant(), orderList.get(index).getAddress(), orderList.get(index));
                    listDelivery.add(newDelivery);
                    orderList.remove(index);;

                    do {
                        System.out.println("Do you want to continue in scheduling the order?[y/n]");
                        cont = scan.next();
                        valid = check(cont);
                        if (valid == false) {
                            System.out.println("Please enter [y/n] only.");
                        }
                    } while (valid == false);

                    if (cont.equals("Y") || cont.equals("y")) {
                        createDeliverySchedule(orderList);
                    } else {
                        System.out.println("Thanks for using our system.");
                        checkScheduleDeliver checkSD = new checkScheduleDeliver();
                        checkSD.viewDelivery(listDelivery);
                    }

                } else {
                    createDeliverySchedule(orderList);
                }
            }
        }
    }

    public boolean check(String confirm) {
        boolean status = false;
        if (confirm.equals("y") || confirm.equals("Y") || confirm.equals("n") || confirm.equals("N")) {
            status = true;
        }

        return status;
    }
}
