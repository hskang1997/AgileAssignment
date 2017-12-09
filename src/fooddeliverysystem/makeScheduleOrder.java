/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

/**
 *
 * @author Dell PC
 */
import java.util.ArrayList;
import Entity.*;
import java.util.Date;
import java.util.Scanner;
import java.util.List;
import java.util.InputMismatchException;

public class makeScheduleOrder {

    Scanner scan = new Scanner(System.in);
    Scanner stringScan = new Scanner(System.in);
    Scanner scan1 = new Scanner(System.in);
    String defaultOrderID = "SO0001";
    int orderID = Integer.parseInt(defaultOrderID.substring(2));
    String nextOrderID = "S0" + orderID + 1;
    Address restaurantAddress1 = new Address("L032", "Jalan Danau Jaya 1", 13500, "Setapak", "Kuala Lumpur", "Malaysia");
    Address restaurantAddress2 = new Address("B021", "Jalan Tembikai 3", 13500, "Pasar Seni", "Kuala Lumpur", "Malaysia");
    Address restaurantAddress3 = new Address("L332", "Jalan Danau Jaya 3", 13500, "Setapak", "Kuala Lumpur", "Malaysia");
    Address address1 = new Address("B21-10", "Jalan Danau Jaya 1", 13500, "Setapak", "Kuala Lumpur", "Malaysia");
    Address address2 = new Address("A32-5", "Jalan Danau Jaya 3", 13500, "Setapak", "Kuala Lumpur", "Malaysia");
    Address address3 = new Address("D-215", "Jalan Lang Lama 2", 13500, "Klang", "Kuala Lumpur", "Malaysia");
    Affiliates restaurant1 = new Affiliates("Lim", "971010-02-1234", "KFC123", "123456789", "KFC", "AS0365550-V", "012-3456789", address1, "KFC@gmail.com");
    Affiliates restaurant2 = new Affiliates("Kang", "961111-02-6456", "Domino123", "987654321", "Domino", "AS0361230-V", "012-3456789", address2, "Domino@gmail.com");
    Affiliates restaurant3 = new Affiliates("Koh", "901212-02-9875", "Mcdonald123", "5201314", "Mcdonald", "AS0335680-V", "012-3456789", address3, "Mcdonald@gmail.com");
    ArrayList<Affiliates> arrRestaurant = new ArrayList<>();
    Date menuDate = new Date(2017, 11, 3);
    MenuScheduleOrder menu1 = new MenuScheduleOrder("M001", "Meat", 13.00, true, menuDate, restaurant1);
    MenuScheduleOrder menu2 = new MenuScheduleOrder("M002", "Chicken", 15.00, false, menuDate, restaurant1);
    MenuScheduleOrder menu3 = new MenuScheduleOrder("M003", "Fish", 21.00, true, menuDate, restaurant1);
    MenuScheduleOrder menu4 = new MenuScheduleOrder("M004", "Burger", 8.00, true, menuDate, restaurant2);
    MenuScheduleOrder menu5 = new MenuScheduleOrder("M005", "Noodle", 6.00, false, menuDate, restaurant2);
    MenuScheduleOrder menu6 = new MenuScheduleOrder("M006", "Ham", 4.00, true, menuDate, restaurant2);
    MenuScheduleOrder menu7 = new MenuScheduleOrder("M007", "Bacon", 11.00, true, menuDate, restaurant3);
    MenuScheduleOrder menu8 = new MenuScheduleOrder("M008", "Spagehtti", 10.00, true, menuDate, restaurant3);
    MenuScheduleOrder menu9 = new MenuScheduleOrder("M009", "Mee Goreng", 6.00, true, menuDate, restaurant3);
    ArrayList<MenuScheduleOrder> arrListMenu = new ArrayList<>();
    ArrayList<MenuScheduleOrder> arrlistMenu1 = new ArrayList<>();
    Date libraryDate = new Date(System.currentTimeMillis());
    ScheduledOrders scheduledOrders = new ScheduledOrders();
    ArrayList<MenuScheduleOrder> selectedMenu = new ArrayList<>();
    ArrayList<Integer> orderQty = new ArrayList<>();
    List<ScheduledOrders> listScheduleOrders = new ArrayList<>();
    Customer customer = new Customer("Koh Yee Chieh", "012-4939984", address2, "ycsasa@gamil.com");

    int userEnteredMeal = 0;
    int actualSelectedMealIndex = 0;
    int userselectedRestaurant = 0;
    int actualSelectedRestaurantIndex = 0;
    int wrongCount = 0;
    int qty = 0;
    int contChoice = 0;
    int selectedTime = 0;
    int selectedArea = 0;
    String deliverAddress = "";
    Address area = new Address();
    String confirm = "";

    public static void main(String[] args) {
        // TODO code application logic here
        makeScheduleOrder test = new makeScheduleOrder();
        test.mainMenu(test.customer, test.listScheduleOrders);

    }

    public void mainMenu(Customer customer, List<ScheduledOrders> listScheduleOrders) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int choice = 0;
        do {
            System.out.println("Available choice: ");
            System.out.println("1. Place Schedule Order ");
            System.out.println("2. Check Order ");

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

            if (choice <= 0 && choice > 2) {
                System.out.println("Please enter interger within the available options only.");
            }
        } while (choice <= 0 && choice > 2);
        if (choice == 1) {
            makeOrders(customer, listScheduleOrders);
        } else {
            checkOrders(customer, listScheduleOrders);
        }

    }

    public void checkOrders(Customer customer, List<ScheduledOrders> listScheduleOrders) {
        System.out.println();
        for (int i = 0; i < listScheduleOrders.size(); i++) {
            if (customer.getCustName().equals(listScheduleOrders.get(i).getCustomer().getCustName())) {
                System.out.println("Order Details");
                System.out.println("=============");
                System.out.print("Order ID: ");
                System.out.println(listScheduleOrders.get(i).getOrderID());
                System.out.println("Order Date & Time :" + listScheduleOrders.get(i).getOrderDateTime());
                System.out.println("Menu Name   Quantity    Price(per unit)");
                for (int j = 0; j < listScheduleOrders.get(i).getOrderedMenu().size(); j++) {
                    System.out.println(listScheduleOrders.get(i).getOrderedMenu().get(j).getMenuName() + "           "
                            + listScheduleOrders.get(i).getOrderedMenuQty().get(j)
                            + "           " + listScheduleOrders.get(i).getOrderedMenu().get(j).getMenuPrice());
                }
                System.out.println("Deliver Time : " + listScheduleOrders.get(i).getSelectedTime());
                System.out.println("Deliver Address : " + listScheduleOrders.get(i).getDeliveryAddress());
                System.out.println("Subtotal: " + listScheduleOrders.get(i).getSubtotal());
                System.out.println();
                System.out.println();
                
                DeliveryScheduled ds = new DeliveryScheduled();
                ds.createDeliverySchedule(listScheduleOrders);
            }
        }

    }

    public void makeOrders(Customer customer, List<ScheduledOrders> listScheduleOrders) {
        scheduledOrders = new ScheduledOrders();
        selectedMenu.clear();
        arrRestaurant.clear();
        arrListMenu.clear();
        arrlistMenu1.clear();
        userEnteredMeal = 0;
        userselectedRestaurant = 0;
        actualSelectedMealIndex = 0;
        actualSelectedRestaurantIndex = 0;
        wrongCount = 0;
        qty = 0;
        boolean check = false;
        //System.out.println("Restaurant Available > ");
        do {
            System.out.println("Restaurant Available > ");
            arrRestaurant.clear();
            arrRestaurant.add(restaurant1);
            arrRestaurant.add(restaurant2);
            arrRestaurant.add(restaurant3);
            for (int i = 0; i < arrRestaurant.size(); i++) {
                System.out.println(i + 1 + "  " + arrRestaurant.get(i).getRestaurantName());

            }
            do {
                try {
                    System.out.print("Please choose a restaurant(0 to exit) > ");
                    userselectedRestaurant = scan.nextInt();
                    actualSelectedRestaurantIndex = userselectedRestaurant - 1;
                    check = false;
                    break;

                } catch (InputMismatchException ex) {
                    System.out.println("Please enter integer values within the range only.");
                    scan.next();
                    check = true;

                }
            } while (check == true);

            if (userselectedRestaurant < 0 || userselectedRestaurant >= arrRestaurant.size() + 1) {
                System.out.println("Please enter integer values within the range only.");
            }
        } while (userselectedRestaurant < 0 || userselectedRestaurant >= arrRestaurant.size() + 1);
        if (userselectedRestaurant == 0) {
            System.out.println("Thank you for using our system.");
            System.exit(0);
        } else if (userselectedRestaurant > 0 && userselectedRestaurant < arrRestaurant.size() + 1) {
            arrListMenu.add(menu1);
            arrListMenu.add(menu2);
            arrListMenu.add(menu3);
            arrListMenu.add(menu4);
            arrListMenu.add(menu5);
            arrListMenu.add(menu6);
            arrListMenu.add(menu7);
            arrListMenu.add(menu8);
            arrListMenu.add(menu9);

            continueOrder(customer, listScheduleOrders);
        }
    }

    public void continueOrder(Customer customer, List<ScheduledOrders> listScheduleOrders) {
        boolean check = false;
        arrlistMenu1.clear();
        System.out.println();
        System.out.println(arrRestaurant.get(actualSelectedRestaurantIndex).getRestaurantName());
        System.out.println("No  Menu ID    Menu Name       Price(RM)          Status");
        for (int i = 0; i < arrListMenu.size(); i++) {
            if (arrListMenu.get(i).getOwner().getRestaurantName().equals(arrRestaurant.get(actualSelectedRestaurantIndex).getRestaurantName())) {
                arrlistMenu1.add(arrListMenu.get(i));
            }
        }

        do {
            for (int j = 0; j < arrlistMenu1.size(); j++) {

                System.out.println(j + 1 + "    " + arrlistMenu1.get(j).getMenuID() + "       " + arrlistMenu1.get(j).getMenuName()
                        + String.format("\t\t %.2f", arrlistMenu1.get(j).getMenuPrice())
                        + String.format("\t\t %s", arrlistMenu1.get(j).getMenuStatus()));
                System.out.println();
            }
            do {
                try {
                    System.out.print("Please select the meal(0 to back) > ");
                    userEnteredMeal = scan.nextInt();
                    actualSelectedMealIndex = userEnteredMeal - 1;
                    check = false;
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Please enter integer values within the range only.");
                    scan.next();
                    check = true;
                }

            } while (check == true);

            if (userEnteredMeal < 0 || userEnteredMeal >= arrlistMenu1.size() + 1) {
                System.out.println("Please enter integer values within the range only.");
            }
        } while (userEnteredMeal < 0 || userEnteredMeal >= arrlistMenu1.size() + 1);
        if (userEnteredMeal == 0) {
            makeOrders(customer, listScheduleOrders);
        } else {
            if (arrlistMenu1.get(actualSelectedMealIndex).isMenuStatus()) {
                System.out.println();
                System.out.println("Your selected meal is " + arrlistMenu1.get(actualSelectedMealIndex).getMenuName());
            } else {
                userEnteredMeal = 0;
                actualSelectedMealIndex = 0;
                ++wrongCount;
                System.out.println();
                do {
                    do {
                        try {
                            System.out.print("The meal is currently not available. Please select again (0 to back) >");
                            userEnteredMeal = scan.nextInt();
                            actualSelectedMealIndex = userEnteredMeal - 1;
                            check = false;
                            break;
                        } catch (InputMismatchException ex) {
                            System.out.println("Please enter integer values within the range only.");
                            scan.next();
                            check = true;
                        }
                    } while (check == true);

                } while (userEnteredMeal < 0 || userEnteredMeal >= arrlistMenu1.size() + 1);
                if (userEnteredMeal == 0) {
                    makeOrders(customer, listScheduleOrders);
                } else {
                    if (arrlistMenu1.get(actualSelectedMealIndex).isMenuStatus() && wrongCount < 2) {
                        System.out.println();
                        System.out.println("Your selected meal is " + arrlistMenu1.get(actualSelectedMealIndex).getMenuName());
                    } else {
                        userEnteredMeal = 0;
                        actualSelectedMealIndex = 0;
                        ++wrongCount;
                        System.out.println();
                        do {

                            do {
                                try {
                                    System.out.print("The meal is currently not available. Please select again (0 to back) >");
                                    userEnteredMeal = scan.nextInt();
                                    actualSelectedMealIndex = userEnteredMeal - 1;
                                    check = false;
                                    break;
                                } catch (InputMismatchException ex) {
                                    System.out.println("Please enter integer values within the range only.");
                                    scan.next();
                                    check = true;
                                }
                            } while (check == true);
                        } while (userEnteredMeal < 0 || userEnteredMeal >= arrlistMenu1.size() + 1);
                        if (userEnteredMeal == 0) {
                            makeOrders(customer, listScheduleOrders);
                        } else {
                            if (arrlistMenu1.get(actualSelectedMealIndex).isMenuStatus() && wrongCount < 3) {
                                System.out.println();
                                System.out.println("Your selected meal is " + arrlistMenu1.get(actualSelectedMealIndex).getMenuName());

                            } else {
                                System.out.print("Good Bye");
                                System.exit(0);
                            }
                        }
                    }
                }
            }
        }
        System.out.println();
        do {
            do {
                try {
                    System.out.print("Please Enter Quantity to order (0 to back to select restaurant) >");
                    qty = scan.nextInt();
                    check = false;
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Please enter integer values within the range that less than 11 only.");
                    scan.next();
                    check = true;
                }
            } while (check == true);

            if (qty < 0 || qty > 10) {
                System.out.println("Please enter integer values within the range that less than 11 only.");
            }
        } while (qty < 0 || qty > 10);
        if (qty == 0) {
            makeOrders(customer, listScheduleOrders);
        } else {
            selectedMenu.add(arrlistMenu1.get(actualSelectedMealIndex));
            orderQty.add(qty);
            System.out.println();
            do {
                do {
                    try {
                        System.out.print("Press 1 to back to menu and order more food (2 to proceed to time selection) > ");
                        contChoice = scan.nextInt();
                        check = false;
                        break;
                    } catch (InputMismatchException ex) {
                        System.out.println("Please enter integer values within the range only.");
                        scan.next();
                        check = true;
                    }
                } while (check == true);

                if (contChoice < 1 || contChoice > 2) {
                    System.out.println("Please enter integer values within the range only.");
                }
            } while (contChoice < 1 || contChoice > 2);
            if (contChoice == 1) {
                continueOrder(customer, listScheduleOrders);
            } else {
                orderAddressTime(customer, listScheduleOrders);
            }
        }
    }

    public void orderAddressTime(Customer customer, List<ScheduledOrders> listScheduleOrders) {
        boolean check = false;
        System.out.println();
        System.out.println("Delivery Schedule: ");
        System.out.println("1 12:00 PM");
        System.out.println("2 6:00 PM");
        System.out.println("3 8:00 PM");
        do {
            do {
                try {
                    System.out.print("Please Select time to deliver (0 to back) >");
                    selectedTime = scan.nextInt();
                    check = false;
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Please enter integer values within the range only.");
                    scan.next();
                    check = true;
                }

            } while (check == true);

            if (selectedTime < 0 || selectedTime > 3) {
                System.out.println("Please enter integer values within the range only.");
            }
        } while (selectedTime < 0 || selectedTime > 3);

        switch (selectedTime) {
            case 1:
            case 2:
            case 3:
                System.out.println();
                System.out.println("Area: ");
                System.out.println("1 Setapak");
                System.out.println("2 Kuala Lumpur");
                System.out.println("3 Klang");
                do {
                    do {
                        try {
                            System.out.print("Please Select Area to deliver (0 to back) >");
                            selectedArea = scan.nextInt();
                            check = false;
                            break;
                        } catch (InputMismatchException ex) {
                            System.out.println("Please enter integer values within the range only.");
                            scan.next();
                            check = true;
                        }
                    } while (check == true);

                    if (selectedArea < 0 || selectedArea > 3) {
                        System.out.println("Please enter integer values within the range only.");
                    }
                } while (selectedArea < 0 || selectedArea > 3);
                switch (selectedArea) {
                    case 0:
                        orderAddressTime(customer, listScheduleOrders);
                        break;
                    case 1:
                    case 2:
                    case 3:
                        System.out.println();
                        do {
                            if (selectedArea == 1) {
                                area.setArea("Setapak");
                            } else if (selectedArea == 2) {
                                area.setArea("Kuala Lumpur");
                            } else {
                                area.setArea("Klang");
                            }

                            System.out.println("Please enter exact deliver address >");
                            deliverAddress = stringScan.nextLine();
                        } while (deliverAddress.equals(""));
                        scheduledOrders.setOrderID(defaultOrderID);
                        defaultOrderID = nextOrderID;
                        scheduledOrders.setOrderDateTime(libraryDate);
                        scheduledOrders.setOrderedMenu(selectedMenu);
                        scheduledOrders.setOrderedMenuQty(orderQty);
                        scheduledOrders.setSelectedTime(selectedTime);
                        scheduledOrders.setDeliveryAddress(deliverAddress);
                        scheduledOrders.setDeliveryArea(area);

                        scheduledOrders.setRestaurant(restaurant1);
                        orderCalculationAndSummary(customer, listScheduleOrders);
                        break;

                }
                break;
            case 0:
                continueOrder(customer, listScheduleOrders);
                break;

        }
    }

    public void orderCalculationAndSummary(Customer cust, List<ScheduledOrders> listScheduleOrders) {
        boolean valid = false;
        double amount = 0;
        double gstAmount = 0;
        double total = 0;
        double deliveryFee = 0;
        if (area.getArea().equals("Setapak")) {
            deliveryFee = 5.00;
        } else if (area.getArea().equals("Kuala Lumpur")) {
            deliveryFee = 10.00;
        } else {
            deliveryFee = 18.00;
        }
        for (int i = 0; i < selectedMenu.size(); i++) {
            amount += (selectedMenu.get(i).getMenuPrice() * orderQty.get(i));
        }
        gstAmount = amount * 0.06;
        total = amount + gstAmount + deliveryFee;
        scheduledOrders.setGstAmount(gstAmount);
        scheduledOrders.setTotalAmount(amount);
        scheduledOrders.setDeliveryfees(deliveryFee);
        scheduledOrders.setSubtotal(total);
        scheduledOrders.setCustomer(cust);

        System.out.println();
        System.out.println();
        System.out.println("Menu Name   Quantity    Price(per unit)");
        for (int i = 0; i < selectedMenu.size(); i++) {
            System.out.println(scheduledOrders.getOrderedMenu().get(i).getMenuName() + "           " + scheduledOrders.getOrderedMenuQty().get(i)
                    + "            " + selectedMenu.get(i).getMenuPrice());
        }
        System.out.println("Deliver Time : " + scheduledOrders.getSelectedTime());
        System.out.println("Deliver Address : " + scheduledOrders.getDeliveryAddress());
        System.out.println("Amount: " + scheduledOrders.getTotalAmount());
        System.out.println("GST : " + String.format("%.2f", scheduledOrders.getGstAmount()));
        System.out.println("Delivery Fees: " + scheduledOrders.getDeliveryfees());
        System.out.println("Subtotal: " + scheduledOrders.getSubtotal());

        System.out.println();

        do {
            System.out.print("Are you sure you want to place schedule order? [y/n] >");
            confirm = scan1.next();
            valid = check(confirm);
            if (valid == false) {
                System.out.println("Please enter [y/n] only.");
            }
        } while (valid == false);

        if (confirm.equals("y") || confirm.equals("Y")) {
            listScheduleOrders.add(scheduledOrders);
            System.out.println();
            System.out.println();
            System.out.println("Thanks for using our system");
            System.out.println();
            System.out.println("Order Summary");
            System.out.println("=============");
            System.out.println("Order ID : " + scheduledOrders.getOrderID());
            System.out.println("Order Date & Time :" + scheduledOrders.getOrderDateTime());
            System.out.println("Menu Name   Quantity    Price(per unit)");
            for (int i = 0; i < selectedMenu.size(); i++) {
                System.out.println(scheduledOrders.getOrderedMenu().get(i).getMenuName() + "           " + scheduledOrders.getOrderedMenuQty().get(i)
                        + "           " + selectedMenu.get(i).getMenuPrice());
            }
            System.out.println("Deliver Time : " + scheduledOrders.getSelectedTime());
            System.out.println("Deliver Address : " + scheduledOrders.getDeliveryAddress());
            System.out.println("Amount: " + scheduledOrders.getTotalAmount());
            System.out.println("GST : " + String.format("%.2f", scheduledOrders.getGstAmount()));
            System.out.println("Delivery Fees: " + scheduledOrders.getDeliveryfees());
            System.out.println("Subtotal: " + scheduledOrders.getSubtotal());
            System.out.println();
            System.out.println("Thanks for using our system");
            do {
                System.out.println("Back to main menu?[y/n]");
                confirm = scan.next();
                valid = check(confirm);
                if (valid == false) {
                    System.out.println("Please enter [y/n] only.");
                }
            } while (valid == false);
            if (confirm.equals("y") || confirm.equals("Y")) {
                mainMenu(customer, listScheduleOrders);
            } else {
                DeliveryScheduled ds = new DeliveryScheduled();
                ds.createDeliverySchedule(listScheduleOrders);
            }
        } else {
            System.out.println("Thanks for using our system");
            scheduledOrders = new ScheduledOrders();
            System.exit(0);
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
