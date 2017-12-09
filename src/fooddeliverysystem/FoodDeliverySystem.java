/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

import Entity.Address;
import Entity.Affiliates;
import Entity.Attendence;
import Entity.Customer;
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
        System.out.println("3. Tracking Delivery Order");
        System.out.println("0. Exit");

        do {
            System.out.print("\nChoose your menu option : ");

            try {
                result = scan.nextInt();

                if (result == 0) {
                    failed = false;
                } else if (result < 1 || result > 3) {
                    System.out.print("Please Enter Number that displayed on Main Menu only.\n");
                    failed = true;
                } else {
                    failed = false;
                }

            } catch (NumberFormatException | java.util.InputMismatchException ex) {
                System.out.print("Please Enter Number Only based on the Main Menu.\n");
                failed = true;
                scan.next();
            }

        } while (failed);

        return result;
    }

    public boolean continueMsg() {
        boolean result = true, valid;

        do {
            System.out.print("\n\nDo you wish to continue ? (Y/N)");
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

        System.out.print("\nEnter Your Delivery Men ID (0 to exit): ");
        deliveryMenID = scan.next();

        // Have to do checking on symbol
        return deliveryMenID;
    }

    public Attendence checkDeliveryMen(String deliveryMenID, ArrayList<Attendence> deliveryManAttendence) {

        Attendence attendence = null;

        for (int i = 0; i < deliveryManAttendence.size(); i++) {
            if (deliveryManAttendence.get(i).getPerson().getDeliveryManID().compareTo(deliveryMenID) == 0) {
                attendence = deliveryManAttendence.get(i);
                break;
            }
        }

        return attendence;
    }

    public String readInCustomerPhone() {
        String customerPhone = null;

        System.out.print("\nEnter Your Phone Number (0 to exit): ");
        customerPhone = scan.next();

        // Have to do checking on symbol
        return customerPhone;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Data Declaration
        Date dateAdded = new Date(2017, 1, 1, 10, 45, 50);
        Date orderDate = new Date(2017, 10, 12, 15, 10, 31);
        Date deliveryDate = new Date(2017, 11, 3, 19, 11, 12);
        Date arrivedDate = new Date(2017, 11, 3, 20, 11, 12);

        Address address = new Address("135", "Taman Kaya", 55333, "Setapak", "Kuala Lumpur", "Malaysia");
        Address address1 = new Address("123", "Taman ABC", 55333, "Setapak", "Kuala Lumpur", "Malaysia");
        Address address2 = new Address("456", "Taman DEF", 55333, "Setapak", "Kuala Lumpur", "Malaysia");
        Address address3 = new Address("789", "Taman GHI", 55333, "Setapak", "Kuala Lumpur", "Malaysia");
        Address address4 = new Address("246", "Taman XYZ", 55333, "Setapak", "Kuala Lumpur", "Malaysia");

        Customer firstCustomer = new Customer("Jason Lim", "0123456789", address, "jason@yahoo.com");
        Customer secondCustomer = new Customer("Jacky Lim", "0129876543", address1, "jacky@google.com");
        Customer thirdCustomer = new Customer("Peter Lim", "0198765432", address2, "peter@hotmail.com");

        Menu menu1 = new Menu("M0001", "Fish", 10.50, "", dateAdded);
        Menu menu2 = new Menu("M0002", "Chicken", 11.50, "", dateAdded);
        Menu menu3 = new Menu("M0003", "Pork", 11.00, "", dateAdded);

        Order order1 = new Order("P0001", orderDate, firstCustomer);
        order1.placeOrder(menu1, 1);
        order1.placeOrder(menu2, 2);
        order1.placeOrder(menu3, 1);

        Order order2 = new Order("P0002", orderDate, secondCustomer);
        order2.placeOrder(menu2, 3);
        order2.placeOrder(menu1, 1);

        Order order3 = new Order("P0003", orderDate, thirdCustomer);
        order3.placeOrder(menu3, 1);
        order3.placeOrder(menu1, 1);

        Vehicle vehicle = new Vehicle("Honda", "ABC 1234", "May 2012");

        Affiliates deliverySource = new Affiliates("Kelvin Tan", "600121021263", "User1", "abc123", "R0001", "Western Food Restaurant", "012-3456789", address, "western@gmail.com");

        DeliveryMan man1 = new DeliveryMan("S0001", "Jason", "750303075313", "012-3456789", address1, "jason@gmail.com", vehicle, WORKING, "Available");
        DeliveryMan man2 = new DeliveryMan("S0002", "David", "850512025411", "013-3456789", address2, "daivd@hotmail.com", vehicle, BREAK, "Not Available");
        DeliveryMan man3 = new DeliveryMan("S0003", "John", "781013016315", "016-3456789", address3, "john@yahoo.com", vehicle, WORKING, "Delivering");
        DeliveryMan man4 = new DeliveryMan("S0004", "Kelvin", "901220101317", "017-3456789", address4, "kelvin@live.com", vehicle, WORKING, "Available");

        Address destination1 = new Address("215", "Taman Bunga Raya", 55333, "Setapak", "Kuala Lumpur", "Malaysia");
        Address destination2 = new Address("190", "Taman Melati", 55333, "Setapak", "Kuala Lumpur", "Malaysia");
        Address destination3 = new Address("128", "Taman Wangsa", 55333, "Setapak", "Kuala Lumpur", "Malaysia");

        Delivery delivery1 = new Delivery("L0001", deliveryDate, deliverySource, destination1, 4.90);
        Delivery delivery2 = new Delivery("L0002", deliveryDate, deliverySource, destination2, 2.50);
        Delivery delivery3 = new Delivery("L0003", deliveryDate, deliverySource, destination3, 3.60);
        delivery1.setOrder(order1);
        delivery2.setOrder(order2);
        delivery3.setOrder(order3);
        delivery1.setArrivedDate(arrivedDate);
        delivery2.setArrivedDate(arrivedDate);
        delivery3.setArrivedDate(arrivedDate);

        Attendence menAttendence1 = new Attendence(man1);
        menAttendence1.addClockIn(new Date("11/26/2017 9:50:25"));

        Attendence menAttendence2 = new Attendence(man2);
        menAttendence2.addClockIn(new Date("11/26/2017 9:40:19"));
        menAttendence2.addClockOut(new Date("11/26/2017 12:00:20"));

        Attendence menAttendence3 = new Attendence(man3);
        menAttendence3.addClockIn(new Date("11/26/2017 9:55:10"));

        Attendence menAttendence4 = new Attendence(man4);
        menAttendence4.addClockIn(new Date("11/26/2017 9:59:40"));

        ArrayList<DeliveryMan> deliveryManList = new ArrayList<>();
        deliveryManList.add(man1);
        deliveryManList.add(man2);
        deliveryManList.add(man3);
        deliveryManList.add(man4);

        ArrayList<Attendence> deliveryManAttendence = new ArrayList<>();
        deliveryManAttendence.add(menAttendence1);
        deliveryManAttendence.add(menAttendence2);
        deliveryManAttendence.add(menAttendence3);
        deliveryManAttendence.add(menAttendence4);

        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);

        ArrayList<Delivery> deliveryList = new ArrayList<>();
        deliveryList.add(delivery1);
        deliveryList.add(delivery2);
        deliveryList.add(delivery3);

        // TODO code application logic here
        FoodDeliverySystem fds = new FoodDeliverySystem();
        boolean response = false;
        boolean loop = false;
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
                    Attendence deliveryMan = null;
                    loop = false;

                    do {
                        String deliveryMenID = fds.readInDeliveryMen();

                        if (deliveryMenID.compareTo("0") != 0) {
                            deliveryMan = fds.checkDeliveryMen(deliveryMenID, deliveryManAttendence);

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
                    break;

                case 3:
                    String customerPhone = "";
                    loop = false;
                    boolean nonDigitOccured = false;

                    do {
                        try {
                            customerPhone = fds.readInCustomerPhone();
                        } catch (NullPointerException ex) {
                            System.out.println("Please enter a valid Phone Number.");
                        }

                        // System.out.println(customerPhone.compareTo("") != 0);

                        if (customerPhone.length() == 10) {
                            if (customerPhone.compareTo("0") == 0) {
                                loop = false;

                            } else if (customerPhone.compareTo("") != 0) {

                                for (int i = 0; i < customerPhone.length(); i++) {
                                    char c = customerPhone.charAt(i);

                                    if (!Character.isDigit(c)) {
                                        nonDigitOccured = true;
                                        System.out.println("Please enter only digit for phone number.");
                                        break;
                                    }
                                }

                                if (!nonDigitOccured) {

                                    CustomerTrackOrder cto = new CustomerTrackOrder(deliveryList, customerPhone);
                                    cto.displayPendingDelivery();
                                    response = fds.continueMsg();
                                    loop = false;

                                } else {

                                    loop = true;
                                }

                            } else {
                                loop = true;
                            }
                        } else {
                            System.out.println("Please enter a valid Phone Number without dash(-).");
                            loop = true;
                        }
                    } while (loop);

                    break;

                default:
                    break;
            }
        } while (response);

        fds.displayThankYou();
    }

}
