/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

import Entity.Attendence;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Hskang
 */
public class DeliveryMenAttendence {

    private final String WORKING = "Working";
    private final String BREAK = "Break";

//    private final String IN = "IN";
//    private final String OUT = "OUT";

    private Scanner scan = new Scanner(System.in);

    private Attendence menAttendence = new Attendence();

    public DeliveryMenAttendence() {

    }

    public DeliveryMenAttendence(Attendence menAttendence) {
        this.menAttendence = menAttendence;
        initialize();
    }

    public boolean clockIn(Date clockInDate) {
        if (menAttendence.getPerson().getWorkingStatus().compareTo(WORKING) != 0) {
            menAttendence.addClockIn(clockInDate);
            menAttendence.getPerson().setWorkingStatus(this.WORKING);

            return true;

        } else {
            System.out.println("Sorry, you cannot Clock In as you have not Clock Out.");
            return false;
        }
    }

    public boolean clockOut(Date clockOutDate) {
        if (menAttendence.getPerson().getWorkingStatus().compareTo(BREAK) != 0) {
            menAttendence.addClockOut(clockOutDate);
            menAttendence.getPerson().setWorkingStatus(this.BREAK);

            return true;

        } else {
            System.out.println("Sorry, you cannot Clock Out as you have not Clock In.");
            return false;
        }
    }

    private void initialize() {
        boolean failed = true, success = true;
        int result = 0;

        System.out.println("\nDelivery Man Attendence");
        System.out.println("========================");

        do {
            System.out.println("\n1. Clock In");
            System.out.println("2. Clock Out");
            System.out.println("0. Exit");

            do {
                System.out.print("\nChoose your option : ");

                try {
                    result = scan.nextInt();

                    if (result == 0) {
                        failed = false;
                    } else if (result < 1 || result > 2) {
                        System.out.print("Please Enter Number that displayed on Menu only.\n");
                        failed = true;
                    } else {
                        failed = false;
                    }

                } catch (NumberFormatException | java.util.InputMismatchException ex) {
                    System.out.print("Please Enter Number Only based on the Menu only.\n");
                    failed = true;
                    scan.next();
                }

            } while (failed);

            switch (result) {
                case 0:
                    success = true;
                    break;

                case 1:
                    Date clockInDate = Calendar.getInstance().getTime();
                    success = this.clockIn(clockInDate);
                    if (success) {
                        System.out.println("\nYou had Clock In on " + clockInDate.getDate() + "/" + (clockInDate.getMonth()+1) + "/" + (clockInDate.getYear()+1900) + " at " + clockInDate.getHours() + ":" + clockInDate.getMinutes() + ":" + clockInDate.getSeconds());
                        displayAttendence();
                    }
                    break;

                case 2:
                    Date clockOutDate = Calendar.getInstance().getTime();
                    success = this.clockOut(clockOutDate);
                    if (success) {
                        System.out.println("\nYou had Clock Out on " + clockOutDate.getDate() + "/" + (clockOutDate.getMonth()+1) + "/" + (clockOutDate.getYear()+1900) + " at " + clockOutDate.getHours() + ":" + clockOutDate.getMinutes() + ":" + clockOutDate.getSeconds());
                        displayAttendence();
                    }
                    break;

                default:
                    break;
            }
        } while (!success);
    }

    private void displayAttendence() {
        
        System.out.println("\n Attendence Today ");
        System.out.println("==================");
        System.out.println("Your Delivery Men ID: " + menAttendence.getPerson().getDeliveryManID());

        System.out.print("\nIN: ");
        for (Date clockIn : menAttendence.getClockIn()) {
            System.out.print(clockIn.getHours() + ":" + clockIn.getMinutes() + ":" + clockIn.getSeconds() + "\t");
        }

        System.out.print("\nOUT: ");
        for (Date clockOut : menAttendence.getClockOut()) {
            System.out.print(clockOut.getHours() + ":" + clockOut.getMinutes() + ":" + clockOut.getSeconds() + "\t");
        }
    }

}
