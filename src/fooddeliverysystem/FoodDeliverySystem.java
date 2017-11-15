/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

import java.util.Scanner;

/**
 *
 * @author Hskang
 */
public class FoodDeliverySystem {

    Scanner scan = new Scanner(System.in);

    public void displayTitle() {
        System.out.println("\t\tWelcome to Fastest Deliveryman Service\t\t");
        System.out.println("-----------------------------------------------------------------------\n");
    }

    public int displayMenu() {
        int result = 0;
        boolean failed = true;
        System.out.println("\n *** Main Menu *** \n");
        System.out.println("1. Assign Delivery to Delivery Man");
        System.out.println("0. Exit\n");

        do {
            System.out.print("\nChoose your menu option : ");

            try {
                result = scan.nextInt();

                if (result == 0) {
                    failed = false;
                }else if (result != 1) {
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
                    AssignDeliveryMan adm = new AssignDeliveryMan();
                    response = fds.continueMsg();
                    break;

                default:
                    break;
            }
        } while (response);

        fds.displayThankYou();
    }

}
