/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

import Entity.Affiliates;
import Entity.Date;
import Entity.Delivery;
import Entity.DeliveryMan;
import Entity.DeliveryRecord;
import Entity.Menu;
import Entity.Order;
import Entity.Vehicle;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hskang
 */
public class AssignDeliveryMan {

    private static String DELIVERING_STATUS = "Delivering";
    private static String AVAILABLE_STATUS = "Available";
    private static String NOTAVAILABLE_STATUS = "Not Available";

    private Scanner scan = new Scanner(System.in);
    
    private Date dateAdded = new Date(1, 1, 2017);
    private Date deliveryDate = new Date(11, 3, 2017);

    private Affiliates deliverySource;
    private ArrayList<Order> orderList = new ArrayList<Order>();
    private ArrayList<Delivery> deliveryList = new ArrayList<Delivery>();
    private ArrayList<DeliveryMan> deliveryManList = new ArrayList<DeliveryMan>();
    private ArrayList<DeliveryMan> availableDeliveryMan = new ArrayList<DeliveryMan>();
    private ArrayList<DeliveryRecord> deliveryRecordList = new ArrayList<DeliveryRecord>();
    private Menu menu1, menu2, menu3;
    private Order order1, order2, order3;
    private Delivery delivery1, delivery2, delivery3;
    private DeliveryMan man1, man2, man3, man4;
    private Vehicle vehicle = new Vehicle("Honda", "ABC 1234", "May 2012");
    private boolean failed = true;

    public AssignDeliveryMan() {

        deliverySource = new Affiliates("R0001", "Western Food Restaurant", "012-3456789", "135, Taman Kaya, 55333 Setapak, Kuala Lumpur", "western@gmail.com");

        man1 = new DeliveryMan("S0001", "Jason", "750303075313", "012-3456789", "123, Jalan ABC, 11200 Penang.", "jason@gmail.com", vehicle, "Employed", "Available");
        man2 = new DeliveryMan("S0002", "David", "850512025411", "013-3456789", "456, Jalan DEF, 53300 KL.", "daivd@hotmail.com", vehicle, "Retired", "Not Available");
        man3 = new DeliveryMan("S0003", "John", "781013016315", "016-3456789", "789, Jalan GHI, 30200 Perak.", "john@yahoo.com", vehicle, "Employed", "Delivering");
        man4 = new DeliveryMan("S0004", "Kelvin", "901220101317", "017-3456789", "246, Jalan XYZ, 53430 KL.", "kelvin@live.com", vehicle, "Employed", "Available");

        deliveryManList.add(man1);
        deliveryManList.add(man2);
        deliveryManList.add(man3);
        deliveryManList.add(man4);

        menu1 = new Menu("M0001", "Fish", 10.50, dateAdded);
        menu2 = new Menu("M0002", "Chicken", 11.50, dateAdded);
        menu3 = new Menu("M0003", "Pork", 11.00, dateAdded);

        order1 = new Order("P0001", deliveryDate);
        order1.placeOrder(menu1, 1);
        order1.placeOrder(menu2, 2);
        order1.placeOrder(menu3, 1);

        order2 = new Order("P0002", deliveryDate);
        order2.placeOrder(menu2, 3);
        order2.placeOrder(menu1, 1);

        order3 = new Order("P0003", deliveryDate);
        order3.placeOrder(menu3, 1);
        order3.placeOrder(menu1, 1);

        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);

        delivery1 = new Delivery("L0001", deliveryDate, deliverySource, "123,Taman Selamat", 4.90);
        delivery2 = new Delivery("L0002", deliveryDate, deliverySource, "456,Taman Bahagia", 2.50);
        delivery3 = new Delivery("L0003", deliveryDate, deliverySource, "789,Taman Sejahtera", 3.60);

        delivery1.setOrder(order1);
        delivery2.setOrder(order2);
        delivery3.setOrder(order3);

        deliveryList.add(delivery1);
        deliveryList.add(delivery2);
        deliveryList.add(delivery3);

        initialize();
    }

    private void displayDeliveryJob() {
        
        // Display Delivery
        System.out.println("List of Delivery : ");
        System.out.println(String.format("%-3s\t%-10s\t%-20s\t%-30s\t%-30s\t%-10s\t%-10s", "No.", "Delivery ID", "Delivery Date", "Delivery Source", "Delivery Destination", "Order ID", "Delivery Charges(RM)"));

        for (int i = 0; i < deliveryList.size(); i++) {
            System.out.print("" + (i + 1) + ". \t" + deliveryList.get(i).displayDelivery());
        }
    }

    private void displayDeliveryMan() {
        int count = 0;
        // Display Delivery Man
        System.out.println("List of Delivery Man : ");
        System.out.println(String.format("%-3s\t%-20s\t%-20s\t%-15s", "No.", "Delivery Man ID", "Working Status", "Delivery Status"));
        availableDeliveryMan.clear();
        for (int i = 0; i < deliveryManList.size(); i++) {
            if (deliveryManList.get(i).getWorkingStatus().compareTo("Employed") == 0 && deliveryManList.get(i).getDeliveryStatus().compareTo("Available") == 0) {
                availableDeliveryMan.add(deliveryManList.get(i));
                System.out.print("" + (++count) + ". \t" + deliveryManList.get(i).displayDeliveryMan());
            }
        }
    }

    private int selectDeliveryJob() {
        int deliverySelected = 0;
        // Select a Delivery
        do {
            System.out.print("\n\nChoose a Delivery : ");
            try {
                deliverySelected = scan.nextInt();

                if (deliverySelected <= 0 || deliverySelected > deliveryList.size()) {
                    System.out.print("Please Enter Number that displayed in Delivery List only.");
                    failed = true;
                } else {
                    failed = false;
                }
            } catch (NumberFormatException | java.util.InputMismatchException ex) {
                System.out.print("Please Enter Number Only based on the Delivery List.");
                failed = true;
                scan.next();
            }
        } while (failed);

        return deliverySelected;
    }

    private int selectDeliveryMan() {
        int deliveryManSelected = 0;
        // Select a Delivery Man to assign the Selected Delivery
        do {
            System.out.print("\n\nAssign to Delivery Man : ");
            try {
                deliveryManSelected = scan.nextInt();

                if (deliveryManSelected <= 0 || deliveryManSelected > availableDeliveryMan.size()) {
                    System.out.print("Please Enter Number that displayed on Delivery Man List only.");
                    failed = true;
                } else {
                    failed = false;
                }

            } catch (NumberFormatException | java.util.InputMismatchException ex) {
                System.out.print("Please Enter Number Only based on the Delivery Man list.");
                failed = true;
                scan.next(); 
            }
        } while (failed);

        return deliveryManSelected;
    }

    private boolean confirmAssignation(int deliverySelected, int deliveryManSelected) {
        String deliveryID = deliveryList.get(deliverySelected - 1).getDeliveryID();
        String deliveryManID = availableDeliveryMan.get(deliveryManSelected - 1).getDeliveryManID();
        boolean result = true, valid;
        
        do {
            System.out.println("\n\nAre you confirm to assign");
            System.out.println("Delivery (DeliveryID : " + deliveryID + ") to Delivery Man (DeliveryManID : " + deliveryManID + ")");
            System.out.print("(Y/N) : ");
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

    private void assignDeliveryJob(int deliverySelected, int deliveryManSelected) {
        Delivery selectedDelivery = deliveryList.get(deliverySelected - 1);
        String manID = availableDeliveryMan.get(deliveryManSelected - 1).getDeliveryManID();

        DeliveryMan selectedDeliveryMan = new DeliveryMan();

        for (int i = 0; i < deliveryManList.size(); i++) {
            if (deliveryManList.get(i).getDeliveryManID().compareTo(manID) == 0) {
                deliveryManList.get(i).setDeliveryStatus(DELIVERING_STATUS);
                selectedDeliveryMan = deliveryManList.get(i);
                break;
            }
        }

        if (deliveryRecordList.isEmpty()) {
            DeliveryRecord deliveryRecord = new DeliveryRecord(selectedDeliveryMan);
            deliveryRecord.addDeliveryList(selectedDelivery);
            deliveryRecordList.add(deliveryRecord); // Create new Delivery Record when there is no existing Delivery Man in the Delivery Record List
        } else {
            String selectedDeliveryManID = selectedDeliveryMan.getDeliveryManID();
            String existingDeliveryManID;

            for (int i = 0; i < deliveryRecordList.size(); i++) {
                existingDeliveryManID = deliveryRecordList.get(i).getDeliveryMan().getDeliveryManID();

                if (selectedDeliveryManID.compareTo(existingDeliveryManID) == 0) { // Check whether there is the similar Delivery Man in the Delivery Record List
                    // if there is similar Delivery Man in the Delivery Record List, just add the selected Delivery into the existing Delivery Man Records
                    deliveryRecordList.get(i).addDeliveryList(selectedDelivery);
                    break;
                } else {
                    // else create a new Delivery Record based on the new Delivery Man
                    DeliveryRecord deliveryRecord = new DeliveryRecord(selectedDeliveryMan);
                    deliveryRecord.addDeliveryList(selectedDelivery);
                    deliveryRecordList.add(deliveryRecord);
                    break;
                }
            }
        }
    }

    private void displayDeliveryRecord() {
        // Display all the Delivery Record of every Delivery Man in the Delivery Record List
        System.out.println("\n\nSUMMARY of Deliveries\n");
        System.out.println(String.format("%-3s\t%-20s\t%-20s\t%-15s", "No.", "Delivery Man ID", "Working Status", "Delivery Status"));
        for (int i = 0; i < deliveryRecordList.size(); i++) {
            System.out.println("======================================================================");
            System.out.println("" + (i + 1) + ". \t" + deliveryRecordList.get(i).getDeliveryMan().displayDeliveryMan());

            System.out.println(String.format("\t%-3s\t%-10s\t%-20s\t%-30s\t%-30s\t%-10s\t%-10s", "No.", "Delivery ID", "Delivery Date", "Delivery Source", "Delivery Destination", "Order ID", "Delivery Charges(RM)"));
            for (int j = 0; j < deliveryRecordList.get(i).getDeliveryList().size(); j++) {
                System.out.println("\t=====================================================================================================================================================");
                System.out.println("\t" + (j + 1) + ". \t" + deliveryRecordList.get(i).getDeliveryList().get(j).displayDelivery());
            }
            System.out.println("\n\n");
        }
    }

    private void initialize() {
        System.out.println("\n\n\t\t\tAssign Delivery Job");
        System.out.println("-----------------------------------------------------------------------\n");

        /*  Display the Delivery Job haven't been delivered to customer  */
        displayDeliveryJob(); 

        System.out.println("");

        /*  Display the Available Delivery Man  */
        displayDeliveryMan();

        int deliverySelected = selectDeliveryJob();
        int deliveryManSelected = selectDeliveryMan();

        /*  Ask the user to confirm the Assignation  */
        if (confirmAssignation(deliverySelected, deliveryManSelected)) {
            
            /*  Assign the Delivery Job to the Delivery Man Selected  */
            assignDeliveryJob(deliverySelected, deliveryManSelected);
            
            /*  Display the Delivery Record based on the Delivery Man's Delivering  */
            displayDeliveryRecord();
        } else {
            
            System.out.println("\n\n*** Back to Main Menu ***");
            /*  
                Back to Main Menu
            */
        }

        

        // List of order
        // List of Available Delivery Man 
        // Assign the order to the Available Delivery Man
        // Create Delivery Object
        // Display List of Delivery of the Delivery Man

    }
}
