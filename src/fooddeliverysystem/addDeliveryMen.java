/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Entity.*;

public class addDeliveryMen {

    public List<DeliveryMan> delivery = new ArrayList<>();

    public void add() {
        Scanner scanner = new Scanner(System.in);
        DeliveryMan deliveryMen = new DeliveryMan();
        Vehicle vehicle = new Vehicle();
        Address address = new Address();
        String working;
        char option,option2;
        int a =0001;

        System.out.println("Please enter delivery men name:");
        deliveryMen.setName(scanner.nextLine());
        System.out.println("Please enter delivery men email:");
        deliveryMen.setEmail(scanner.nextLine());
        System.out.println("Please enter delivery men contact number:");
        deliveryMen.setPhone(scanner.nextLine());
        System.out.println("Please enter delivery men IC No:");
        deliveryMen.setIcNo(scanner.nextLine());
        System.out.println("Please enter delivery men unit no:");
        address.setUnitNo(scanner.nextLine());
        System.out.println("Please enter delivery men street name:");
        address.setStreetName1(scanner.nextLine());
        System.out.println("Please enter delivery men post code:");
        address.setPostcode(scanner.nextInt());
        System.out.println("Please enter delivery men area:");
        address.setArea(scanner.next());
        System.out.println("Please enter delivery men state:");
        address.setState(scanner.next());
        System.out.println("Please enter delivery men contry:");
        address.setCountry(scanner.next());
        deliveryMen.setHomeAddress(address);
//        System.out.println("Please enter delivery men address:");
//        deliveryMen.setHomeAddress(scanner.nextLine());
//        System.out.println("Please enter vehicle plat number:");
//        vehicle.setPlateNo(scanner.nextLine());
//        deliveryMen.setVehicle(vehicle);

        do {
            System.out.println("Please enter delivery men working status:");
            System.out.println("1. Full time");
            System.out.println("2. Part Time");
            // System.out.println("3. Leave");
            working = scanner.next();

            if (working.compareTo("1") == 0) {
                deliveryMen.setWorkingStatus("Full time");
                deliveryMen.setDeliveryManID("STA"+ String.format("%03d", a));
                a++;
            } else if (working.compareTo("2") == 0) {
                deliveryMen.setWorkingStatus("Part Time");
                deliveryMen.setDeliveryManID("STA"+ String.format("%03d", a));
                b++;
            }
            else {
                System.out.println("Invalid Option.Please try again.");
            }
        } while (!(working.compareTo("1") == 0 || working.compareTo("2") == 0));

        delivery.add(deliveryMen);
        for (int i = 0; i < delivery.size(); i++) {
            System.out.println("Delivery Men ID:" + delivery.get(i).getDeliveryManID());
            System.out.println("Name:" + delivery.get(i).getName());
            System.out.println("Email:" + delivery.get(i).getEmail());
            System.out.println("Contact Number:" + delivery.get(i).getPhone());
            System.out.println("Identity Card No:" + delivery.get(i).getIcNo());
            System.out.println("Address:" + delivery.get(i).getHomeAddress().toString());
            //System.out.println("Vehicle Plate No:"+delivery.get(i).getVehicle().getPlateNo());
            System.out.println("Working status: " + delivery.get(i).getWorkingStatus());
        }

        System.out.println("Are you sure you want to add this new delivery men information? (Y/N)");
        char confirm;
        do {
            confirm = scanner.next().charAt(0);
            
            if (confirm == 'y' || confirm == 'Y') {
                System.out.println("The information add successfully");
                do {
                    System.out.println("Do you wish to continue? (Y/N)");
                    option = scanner.next().charAt(0);
                    if (option == 'y' || option == 'Y') {
                        add();
                    } else if (option == 'n' || option == 'N') {
                        System.out.println("Thank for using our system.");
                    } else {
                        System.out.println("Invalid option.Please try again");
                    }
                } while (!(option == 'n' || option == 'N' || option == 'y' || option == 'Y'));
            } else if (confirm == 'n' || confirm == 'N') {
                delivery.remove(deliveryMen);
                a--;
                do{
                System.out.println("Do you wish to continue? (Y/N)");
                    option2 = scanner.next().charAt(0);
                    if (option2 == 'y' || option2 == 'Y') {
                        add();
                    } else if (option2 == 'n' || option2 == 'N') {
                        System.out.println("Thank for using our system.");
                    }
                }while(!(option2 == 'n' || option2 == 'N' || option2 == 'y' || option2 == 'Y'));
            } else {
                System.out.println("Invalid option.Please try again.");
                System.out.println("Are you sure you want to add this new delivery men information? (Y/N)");
            }
        } while (!(confirm == 'y' || confirm == 'Y' || confirm == 'n' || confirm == 'N'));

//        for (int i = 0; i < delivery.size(); i++) {
//            System.out.println("Delivery Men ID:" + delivery.get(i).getDeliveryManID());
//            System.out.println("Name:" + delivery.get(i).getName());
//            System.out.println("Email:" + delivery.get(i).getEmail());
//            System.out.println("Contact Number:" + delivery.get(i).getPhone());
//            System.out.println("Identity Card No:" + delivery.get(i).getIcNo());
//            System.out.println("Address:" + delivery.get(i).getHomeAddress());
//            //System.out.println("Vehicle Plate No:"+delivery.get(i).getVehicle().getPlateNo());
//            System.out.println("Working status:" + delivery.get(i).getWorkingStatus());
//        }

    }

    public static void main(String[] args) {
        addDeliveryMen addDelivery = new addDeliveryMen();
        addDelivery.add();

    }

}
