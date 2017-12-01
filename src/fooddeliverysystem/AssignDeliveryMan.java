/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

import Entity.Delivery;
import Entity.DeliveryMan;
import Entity.DeliveryRecord;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hskang
 */
public class AssignDeliveryMan {

    private final static String DELIVERING_STATUS = "Delivering";
    private final static String AVAILABLE_STATUS = "Available";
    private final static String NOTAVAILABLE_STATUS = "Not Available";
    private final static String WORKING = "Working";
    private final static String BREAK = "Break";
    private final static String PENDING = "Pending";
    private final static String DELIVERING = "Delivering";

    private Scanner scan = new Scanner(System.in);

    private ArrayList<Delivery> deliveryList = new ArrayList<Delivery>();
    private ArrayList<DeliveryMan> deliveryManList = new ArrayList<DeliveryMan>();
    private ArrayList<Delivery> availableDelivery = new ArrayList<Delivery>();
    private ArrayList<DeliveryMan> availableDeliveryMan = new ArrayList<DeliveryMan>();
    private ArrayList<DeliveryRecord> deliveryRecordList = new ArrayList<DeliveryRecord>();
    
    private boolean failed = true;

    public AssignDeliveryMan(ArrayList<Delivery> deliveryList, ArrayList<DeliveryMan> deliveryManList) {
        this.deliveryList = deliveryList;
        this.deliveryManList = deliveryManList;
        
        initialize();
    }

    private void displayDeliveryJob() {
        int count = 0;
        // Display Delivery
        System.out.println("List of Delivery : ");
        System.out.println(String.format("%-3s\t%-10s\t%-20s\t%-30s\t%-60s\t%-10s\t%-10s", "No.", "Delivery ID", "Delivery Date", "Delivery Source", "Delivery Destination", "Order ID", "Delivery Charges(RM)"));
        availableDelivery.clear();
        for (int i = 0; i < deliveryList.size(); i++) {
            if (deliveryList.get(i).getDeliveryStatus().compareTo(PENDING) == 0) {
                availableDelivery.add(deliveryList.get(i));
                System.out.print("" + (++count) + ". \t" + deliveryList.get(i).displayDelivery());
            }
        }
    }

    private void displayDeliveryMan() {
        int count = 0;
        // Display Delivery Man
        System.out.println("List of Delivery Man : ");
        System.out.println(String.format("%-3s\t%-20s\t%-20s\t%-15s", "No.", "Delivery Man ID", "Working Status", "Delivery Status"));
        availableDeliveryMan.clear();
        for (int i = 0; i < deliveryManList.size(); i++) {
            if (deliveryManList.get(i).getWorkingStatus().compareTo(this.WORKING) == 0 && deliveryManList.get(i).getDeliveryStatus().compareTo(this.AVAILABLE_STATUS) == 0) {
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

                if (deliverySelected <= 0 || deliverySelected > availableDelivery.size()) {
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
        String deliveryID = availableDelivery.get(deliverySelected - 1).getDeliveryID();
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
        String deliveryID = availableDelivery.get(deliverySelected - 1).getDeliveryID();
        String manID = availableDeliveryMan.get(deliveryManSelected - 1).getDeliveryManID();

        Delivery selectedDelivery = new Delivery();

        for (int i = 0; i < deliveryList.size(); i++) {
            if (deliveryList.get(i).getDeliveryID().compareTo(deliveryID) == 0) {
                deliveryList.get(i).setDeliveryStatus(DELIVERING);
                selectedDelivery = deliveryList.get(i);
                break;
            }
        }
        
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
            deliveryRecord.addDeliveryRecords(selectedDelivery);
            deliveryRecordList.add(deliveryRecord); // Create new Delivery Record when there is no existing Delivery Man in the Delivery Record List
        } else {
            String selectedDeliveryManID = selectedDeliveryMan.getDeliveryManID();
            String existingDeliveryManID;

            for (int i = 0; i < deliveryRecordList.size(); i++) {
                existingDeliveryManID = deliveryRecordList.get(i).getDeliveryMan().getDeliveryManID();

                if (selectedDeliveryManID.compareTo(existingDeliveryManID) == 0) { // Check whether there is the similar Delivery Man in the Delivery Record List
                    // if there is similar Delivery Man in the Delivery Record List, just add the selected Delivery into the existing Delivery Man Records
                    deliveryRecordList.get(i).addDeliveryRecords(selectedDelivery);
                    break;
                } else {
                    // else create a new Delivery Record based on the new Delivery Man
                    DeliveryRecord deliveryRecord = new DeliveryRecord(selectedDeliveryMan);
                    deliveryRecord.addDeliveryRecords(selectedDelivery);
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
            System.out.println("=======================================================================");
            System.out.println("" + (i + 1) + ". \t" + deliveryRecordList.get(i).getDeliveryMan().displayDeliveryMan());

            System.out.println(String.format("\t%-3s\t%-10s\t%-20s\t%-30s\t%-60s\t%-10s\t%-10s", "No.", "Delivery ID", "Delivery Date", "Delivery Source", "Delivery Destination", "Order ID", "Delivery Charges(RM)"));
            for (int j = 0; j < deliveryRecordList.get(i).getDeliveryRecords().size(); j++) {
                System.out.println("\t====================================================================================================================================================================================");
                System.out.println("\t" + (j + 1) + ". \t" + deliveryRecordList.get(i).getDeliveryRecords().get(j).displayDelivery());
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
