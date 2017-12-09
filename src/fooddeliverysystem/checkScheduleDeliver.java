package fooddeliverysystem;

import Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class checkScheduleDeliver {

    Scanner scan = new Scanner(System.in);
    String deliverManID;
    List<Delivery> lastDeliveryList = new ArrayList<>();

    public static void main(String[] args) {
        checkScheduleDeliver checkScheduleDeliver = new checkScheduleDeliver();
    }

    public void viewDelivery(List<Delivery> deliveryList) {
        boolean check = false;
        boolean valid = false;
        int choice = 0;
        Scanner input = new Scanner(System.in);
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
            lastDeliveryList = arrangeSchedule(deliveryList);
            for (int i = 0; i < lastDeliveryList.size(); i++) {
                if (deliverManID.equals(lastDeliveryList.get(i).getDeliveryMan().getDeliveryManID())) {
                    System.out.println(i+1 + "  Order ID: " + lastDeliveryList.get(i).getSo().getOrderID());
                    System.out.println("Delivery Address : " + lastDeliveryList.get(i).getDeliveryDestination().getAddress());
                    System.out.println("Delivery Time : " + lastDeliveryList.get(i).getSo().getSelectedTime());
                    System.out.println("Restaurant :" + lastDeliveryList.get(i).getDeliverySource().getRestaurantName());
                    System.out.println();
                }
            }

            do {
                System.out.println("Select any delivery to view information [0 to cancel] >");
                do {
                    try {
                        System.out.println("Please select a option: ");
                        choice = input.nextInt();
                        valid = false;
                        break;
                    } catch (InputMismatchException ex) {
                        System.out.println("Please enter interger within the available options only.");
                        input.next();
                        valid = true;
                    }
                } while (valid == true);

                if (choice < 0 || choice >= lastDeliveryList.size() +1) {
                    System.out.println("Please enter interger within the available options only.");
                }
            } while (choice < 0 || choice >= lastDeliveryList.size() +1);

            if(choice ==0){
                System.out.println("Thanks for using our system");
                System.exit(0);
            }
            if(choice > 0 && choice < lastDeliveryList.size() +1) {
                checkDeliveryDetails(choice);
            } 

        }
    }

    public List<Delivery> arrangeSchedule(List<Delivery> deliveryList) {
        List<Delivery> listDelivery = new ArrayList<>();
        List<Delivery> finalListDelivery = new ArrayList<>();
        Delivery tempDelivery;
        boolean valid = false;
        boolean check = false;
        int position = 0;

        for (int i = 0; i < deliveryList.size(); i++) {
            listDelivery.add(deliveryList.get(i));
        }

        for (int i = 0; i < listDelivery.size(); i++) {
            for (int j = 0; j < deliveryList.size(); j++) {
                int time = Integer.parseInt(deliveryList.get(j).getSo().getSelectedTime().substring(0, 1));
                int time2 = Integer.parseInt(listDelivery.get(i).getSo().getSelectedTime().substring(0, 1));
                if (finalListDelivery.isEmpty() && time < time2) {
                    finalListDelivery.add(0, deliveryList.get(j));
                } else if (!finalListDelivery.isEmpty() && time < time2) {
                    for (int k = 0; i < finalListDelivery.size(); i++) {
                        if (time < Integer.parseInt(finalListDelivery.get(k).getSo().getSelectedTime().substring(0, 1))) {
                            position = k;
                            break;
                        }
                    }
                    finalListDelivery.add(position, deliveryList.get(j));
                } else {
                    if (finalListDelivery.isEmpty()) {
                        finalListDelivery.add(listDelivery.get(i));
                    } else {
                        for (int l = 0; l < finalListDelivery.size(); l++) {
                            if (!finalListDelivery.get(l).getSo().getOrderID().equals(listDelivery.get(i).getSo().getOrderID())) {
                                valid = true;
                            } else {
                                valid = false;
                                break;
                            }
                        }
                        if (valid) {
                            finalListDelivery.add(listDelivery.get(i));
                        }

                    }

                }
            }
        }

        for (int i = 0; i < finalListDelivery.size(); i++) {
            for (int j = finalListDelivery.size() - 1; j >= 0; j--) {
                if (finalListDelivery.get(i).getSo().getSelectedTime().equals(finalListDelivery.get(j).getSo().getSelectedTime())) {
                    if (finalListDelivery.get(i).getDeliverySource().getRestaurantName().equals(finalListDelivery.get(j).getDeliverySource().getRestaurantName())) {
                        //do nothing
                    } else {
                        if (finalListDelivery.get(i).getDeliverySource().getRestaurantName().equals("AS0365550-V")) {
                            //do nothing
                        } else if (finalListDelivery.get(i).getDeliverySource().getRestaurantName().equals("AS0361230-V")) {
                            if (finalListDelivery.get(j).getDeliverySource().getRestaurantName().equals("AS0365550-V")) {
                                if (i == 0) {
                                    finalListDelivery.add(0, finalListDelivery.get(j));
                                    finalListDelivery.remove(j + 1);
                                    break;
                                } else {
                                    finalListDelivery.add(i, finalListDelivery.get(j));
                                    finalListDelivery.remove(j + 1);
                                    break;
                                }
                            } else {
                                // do nothing
                            }
                        } else {
                            if (i == 0) {
                                finalListDelivery.add(0, finalListDelivery.get(j));
                                finalListDelivery.remove(j + 1);
                                break;
                            } else {
                                for (int k = 0; k < finalListDelivery.size(); k++) {
                                    if (!finalListDelivery.get(k).getSo().getOrderID().equals(finalListDelivery.get(j).getSo().getOrderID()) && j != 0) {
                                        check = true;
                                    } else {
                                        check = false;
                                        break;
                                    }
                                }
                                if (check) {
                                    finalListDelivery.add(i, finalListDelivery.get(j));
                                    finalListDelivery.remove(j + 1);
                                    break;
                                }
                                break;
                            }
                        }
                    }

                }
            }
        }
        return finalListDelivery;
    }

    public void checkDeliveryDetails(int choice) {
        choice = choice - 1;
        if (!lastDeliveryList.isEmpty()) {
            if (choice < lastDeliveryList.size()) {
                System.out.println();
                System.out.println("Delivery Details");
                System.out.println("================");
                System.out.println("Customer Name :" + lastDeliveryList.get(choice).getSo().getCustomer().getCustName());
                System.out.println("Customer Phone Number :" + lastDeliveryList.get(choice).getSo().getCustomer().getCustPhone());
                System.out.println("Order ID: " + lastDeliveryList.get(choice).getSo().getOrderID());
                System.out.println("Order Date & Time :" + lastDeliveryList.get(choice).getSo().getOrderDateTime());
                System.out.println("Menu Name   Quantity    Price(per unit)");
                for (int i = 0; i < lastDeliveryList.get(choice).getSo().getOrderedMenu().size(); i++) {
                    System.out.println(lastDeliveryList.get(choice).getSo().getOrderedMenu().get(i).getMenuName() + "           "
                            + lastDeliveryList.get(choice).getSo().getOrderedMenuQty().get(i)
                            + "           " + lastDeliveryList.get(choice).getSo().getOrderedMenu().get(i).getMenuPrice());
                }
                System.out.println("Deliver Time : " + lastDeliveryList.get(choice).getSo().getSelectedTime());
                System.out.println("Deliver Address : " + lastDeliveryList.get(choice).getSo().getDeliveryAddress());
                System.out.println("Subtotal: " + lastDeliveryList.get(choice).getSo().getSubtotal());

            } else {
                System.out.println("Invalid Input.");
            }
        } else {
            System.out.println("There are currently no delivery to be shown.");
        }
    }
}
