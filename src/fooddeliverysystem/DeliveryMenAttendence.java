/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

import Entity.Attendence;
import Entity.DeliveryMan;
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

    private final String IN = "IN";
    private final String OUT = "OUT";

    private Scanner scan = new Scanner(System.in);

    private DeliveryMan men = new DeliveryMan();
    private Attendence menAttendence = new Attendence();
    private String currentState = "";

    public DeliveryMenAttendence() {

    }

    public DeliveryMenAttendence(DeliveryMan deliveryMan) {
        this.men = deliveryMan;
        menAttendence.setPerson(men);
        initialize();
    }

    public boolean clockIn(Date clockInDate) {

        if (currentState.compareTo(IN) != 0) {
            menAttendence.addClockIn(clockInDate);
            men.setWorkingStatus(this.WORKING);
            currentState = IN;

            return true;

        } else {
            System.out.println("Sorry, you cannot Clock In as you have not Clock Out.");
            return false;
        }
    }

    public boolean clockOut(Date clockOutDate) {

        if (currentState.compareTo(OUT) != 0) {
            menAttendence.addClockOut(clockOutDate);
            men.setWorkingStatus(this.BREAK);
            currentState = OUT;

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
                    displayAttendence();
                    break;

                case 2:
                    Date clockOutDate = Calendar.getInstance().getTime();
                    success = this.clockOut(clockOutDate);
                    displayAttendence();
                    break;

                default:
                    break;
            }
        } while (!success);
    }

    private void displayAttendence() {
        System.out.println(menAttendence.getPerson().getDeliveryManID());

        for (Date clockIn : menAttendence.getClockIn()) {
            System.out.println("IN: " + clockIn.getTime());
        }
        
        for (Date clockOut : menAttendence.getClockOut()) {
            System.out.println("OUT: " + clockOut.getTime());
        }
    }

}
