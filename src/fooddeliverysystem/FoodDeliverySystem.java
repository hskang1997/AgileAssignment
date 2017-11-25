/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

import Entity.Address;
import Entity.Affiliates;
import Entity.Delivery;
import Entity.DeliveryMan;
import Entity.Menu;
import Entity.Order;
import Entity.Vehicle;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Hskang
 */
public class FoodDeliverySystem {

    private final static String WORKING = "Working";
    private final static String BREAK = "Break";
    private Scanner scan = new Scanner(System.in);

    public void displayTitle() {
        System.out.println("\t\tWelcome to Fastest Deliveryman Service\t\t");
        System.out.println("-----------------------------------------------------------------------\n");
    }

    public int displayMenu() {
        int result = 0;
        boolean failed = true;
        System.out.println("\n *** Main Menu *** \n");
        System.out.println("1. Assign Delivery to Delivery Man");
        System.out.println("2. Delivery Man Attendence");
        System.out.println("0. Exit\n");

        do {
            System.out.print("\nChoose your menu option : ");

            try {
                result = scan.nextInt();

                if (result == 0) {
                    failed = false;
                }else if (result < 1 || result > 2) {
                    System.out.print("Please Enter Number that displayed on Main Menu only.\n");
                    failed = true;
                } else {
                    failed = false;
                }

            } catch (NumberFormatException | java.util.InputMismatchException ex) {
                System.out.print("Please Enter Number Only based on the Main Menu only.\n");
                failed = true;
                scan.next();
            }

        } while (failed);

        return result;
    }

    public boolean continueMsg() {
        boolean result = true, valid;

        do {
            System.out.print("Do you wish to continue ? (Y/N)");
            char response = scan.next().charAt(0);

            if (response == 'Y' | response == 'y') {
                result = true;
                valid = true;
            } else if (response == 'N' | response == 'n') {
                result = false;
                valid = true;
            } else {
                valid = false;
            }
        } while (!valid);

        return result;
    }

    public void displayThankYou() {
        System.out.println("\n\n  Thanks for using Fastest Deliveryman !  ");
        System.out.println("            Have a Nice Day !             ");
        System.out.println("------------------------------------------\n");
    }
    
    public String readInDeliveryMen() {
        String deliveryMenID = "";
        
        System.out.print("\n Your Delivery Men ID (0 to exit): ");
        deliveryMenID = scan.next();
        
        // Have to do checking on symbol
        
        return deliveryMenID;
    }
    
    public DeliveryMan checkDeliveryMen(String deliveryMenID, ArrayList<DeliveryMan> deliveryManList) {
        
        DeliveryMan deliveryMan = null;
        
        for (int i=0; i < deliveryManList.size(); i++) {
            if (deliveryManList.get(i).getDeliveryManID().compareTo(deliveryMenID) == 0) {
                deliveryMan = deliveryManList.get(i);
                break;
            }
        }
        
        return deliveryMan;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Data Declaration
        Date dateAdded = new Date(2017, 1, 1);
        Date deliveryDate = new Date(2017, 11, 3);
        
        Menu menu1 = new Menu("M0001", "Fish", 10.50, dateAdded);
        Menu menu2 = new Menu("M0002", "Chicken", 11.50, dateAdded);
        Menu menu3 = new Menu("M0003", "Pork", 11.00, dateAdded);
        
        Order order1 = new Order("P0001", deliveryDate);
        order1.placeOrder(menu1, 1);
        order1.placeOrder(menu2, 2);
        order1.placeOrder(menu3, 1);

        Order order2 = new Order("P0002", deliveryDate);
        order2.placeOrder(menu2, 3);
        order2.placeOrder(menu1, 1);

        Order order3 = new Order("P0003", deliveryDate);
        order3.placeOrder(menu3, 1);
        order3.placeOrder(menu1, 1);
                
        Vehicle vehicle = new Vehicle("Honda", "ABC 1234", "May 2012");
        
        Address address = new Address("135", "Taman Kaya", 55333, "Setapak", "Kuala Lumpur", "Malaysia");
        
        Affiliates deliverySource = new Affiliates("Kelvin Tan", "600121021263", "User1", "abc123", "R0001", "Western Food Restaurant", "012-3456789", address, "western@gmail.com");
        
        DeliveryMan man1 = new DeliveryMan("S0001", "Jason", "750303075313", "012-3456789", "123, Jalan ABC, 11200 Penang.", "jason@gmail.com", vehicle, WORKING, "Available");
        DeliveryMan man2 = new DeliveryMan("S0002", "David", "850512025411", "013-3456789", "456, Jalan DEF, 53300 KL.", "daivd@hotmail.com", vehicle, BREAK, "Not Available");
        DeliveryMan man3 = new DeliveryMan("S0003", "John", "781013016315", "016-3456789", "789, Jalan GHI, 30200 Perak.", "john@yahoo.com", vehicle, WORKING, "Delivering");
        DeliveryMan man4 = new DeliveryMan("S0004", "Kelvin", "901220101317", "017-3456789", "246, Jalan XYZ, 53430 KL.", "kelvin@live.com", vehicle, WORKING, "Available");
        
        Address destination1 = new Address("215", "Taman Bunga Raya", 55333, "Setapak", "Kuala Lumpur", "Malaysia");
        Address destination2 = new Address("190", "Taman Melati", 55333, "Setapak", "Kuala Lumpur", "Malaysia");
        Address destination3 = new Address("128", "Taman Wangsa", 55333, "Setapak", "Kuala Lumpur", "Malaysia");
        
        Delivery delivery1 = new Delivery("L0001", deliveryDate, deliverySource, destination1, 4.90);
        Delivery delivery2 = new Delivery("L0002", deliveryDate, deliverySource, destination2, 2.50);
        Delivery delivery3 = new Delivery("L0003", deliveryDate, deliverySource, destination3, 3.60);
        delivery1.addOrderList(order1);
        delivery2.addOrderList(order2);
        delivery3.addOrderList(order3);
        
        ArrayList<DeliveryMan> deliveryManList = new ArrayList<DeliveryMan>();
        deliveryManList.add(man1);
        deliveryManList.add(man2);
        deliveryManList.add(man3);
        deliveryManList.add(man4);
        
        ArrayList<Order> orderList = new ArrayList<Order>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        
        ArrayList<Delivery> deliveryList = new ArrayList<Delivery>();
        deliveryList.add(delivery1);
        deliveryList.add(delivery2);
        deliveryList.add(delivery3);
        
        // TODO code application logic here
        
        FoodDeliverySystem fds = new FoodDeliverySystem();
        boolean response = false;
        fds.displayTitle();

        do {
            int choice = fds.displayMenu();

            switch (choice) {
                case 0:
                    response = false;
                    break;
                    
                case 1:
                    AssignDeliveryMan assign = new AssignDeliveryMan(deliveryList, deliveryManList);
                    response = fds.continueMsg();
                    break;
                    
                case 2:
                    String deliveryMenID;
                    DeliveryMan deliveryMan = null;
                    boolean loop = false;
                    
                    do {
                        deliveryMenID = fds.readInDeliveryMen();
                        
                        if (deliveryMenID.compareTo("0") != 0) {
                            deliveryMan = fds.checkDeliveryMen(deliveryMenID, deliveryManList);
                            
                            if (deliveryMan == null) {
                                loop = true;
                            } else {
                                loop = false;
                                break;
                            }
                        } else {
                            loop = false;
                        }
                    } while (loop);
                    
                    if (deliveryMan != null) {
                        DeliveryMenAttendence attendence = new DeliveryMenAttendence(deliveryMan);
                        response = fds.continueMsg();
                    }
                    System.out.println(deliveryMan.getWorkingStatus() + "\n" +deliveryMan.getDeliveryManID());
                    break;

                default:
                    break;
            }
        } while (response);

        fds.displayThankYou();
    }

}
