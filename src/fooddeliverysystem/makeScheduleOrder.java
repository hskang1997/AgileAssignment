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

public class makeScheduleOrder {

    Scanner scan = new Scanner(System.in);
    Scanner stringScan = new Scanner(System.in);
    Scanner scan1 = new Scanner(System.in);
    String defaultOrderID = "SO1000";
    int orderID = Integer.parseInt(defaultOrderID.substring(2));
    String nextOrderID = "S0" + orderID + 1;
    Address restaurantAddress1 = new Address("L032", "Jalan Danau Jaya 1", 13500, "Setapak", "Kuala Lumpur", "Malaysia");
    Address restaurantAddress2 = new Address("B021", "Jalan Tembikai 3", 13500, "Pasar Seni", "Kuala Lumpur", "Malaysia");
    Address restaurantAddress3 = new Address("L332", "Jalan Danau Jaya 3", 13500, "Setapak", "Kuala Lumpur", "Malaysia");
    Address address1 = new Address("B21-10", "Jalan Danau Jaya 1", 13500, "Setapak", "Kuala Lumpur", "Malaysia");
    Address address2 = new Address("A32-5", "Jalan Danau Jaya 3", 13500, "Setapak", "Kuala Lumpur", "Malaysia");
    Address address3 = new Address("D-215", "Jalan Lang Lama 2", 13500, "Klang", "Kuala Lumpur", "Malaysia");
    Affiliates restaurant1 = new Affiliates("R001", "GWSheep", "03-5071321", restaurantAddress1, "gwsheep@gmail.com");
    Affiliates restaurant2 = new Affiliates("R002", "Grand", "03-5521321", restaurantAddress2, "grand@gmail.com");
    Affiliates restaurant3 = new Affiliates("R003", "Blue", "03-3215211", restaurantAddress3, "blue@gmail.com");
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
        test.makeOrders();

    }

    public void makeOrders() {
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
            System.out.print("Please choose a restaurant(0 to exit) > ");
            userselectedRestaurant = scan.nextInt();
            actualSelectedRestaurantIndex = userselectedRestaurant - 1;
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

            continueOrder();
        }
    }

    public void continueOrder() {
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
            System.out.print("Please select the meal(0 to back) > ");
            userEnteredMeal = scan.nextInt();
            actualSelectedMealIndex = userEnteredMeal - 1;
            if (userEnteredMeal < 0 || userEnteredMeal >= arrlistMenu1.size() + 1) {
                System.out.println("Please enter integer values within the range only.");
            }
        } while (userEnteredMeal < 0 || userEnteredMeal >= arrlistMenu1.size() + 1);
        if (userEnteredMeal == 0) {
            makeOrders();
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

                    System.out.print("The meal is currently not available. Please select again (0 to back) >");
                    userEnteredMeal = scan.nextInt();
                    actualSelectedMealIndex = userEnteredMeal - 1;
                } while (userEnteredMeal < 0 || userEnteredMeal >= arrlistMenu1.size() + 1);
                if (userEnteredMeal == 0) {
                    makeOrders();
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
                            System.out.print("The meal is currently not available. Please select again (0 to back) >");
                            userEnteredMeal = scan.nextInt();
                            actualSelectedMealIndex = userEnteredMeal - 1;
                        } while (userEnteredMeal < 0 || userEnteredMeal >= arrlistMenu1.size() + 1);
                        if (userEnteredMeal == 0) {
                            makeOrders();
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
            System.out.print("Please Enter Quantity to order (0 to back to select restaurant) >");
            qty = scan.nextInt();
            if (qty < 0 || qty > 10) {
                System.out.println("Please enter integer values within the range that less than 11 only.");
            }
        } while (qty < 0 || qty > 10);
        if (qty == 0) {
            makeOrders();
        } else {
            selectedMenu.add(arrlistMenu1.get(actualSelectedMealIndex));
            orderQty.add(qty);
            System.out.println();
            do {
                System.out.print("Press 1 to back to menu and order more food (2 to proceed to time selection) > ");
                contChoice = scan.nextInt();
                if (contChoice < 1 || contChoice > 2) {
                    System.out.println("Please enter integer values within the range only.");
                }
            } while (contChoice < 1 || contChoice > 2);
            if (contChoice == 1) {
                continueOrder();
            } else {
                orderAddressTime();
            }
        }
    }

    public void orderAddressTime() {
        System.out.println();
        System.out.println("Delivery Schedule: ");
        System.out.println("1 12:00 PM");
        System.out.println("2 6:00 PM");
        System.out.println("3 8:00 PM");
        do {
            System.out.print("Please Select time to deliver (0 to back) >");
            selectedTime = scan.nextInt();
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
                    System.out.print("Please Select Area to deliver (0 to back) >");
                    selectedArea = scan.nextInt();
                    if (selectedArea < 0 || selectedArea > 3) {
                        System.out.println("Please enter integer values within the range only.");
                    }
                } while (selectedArea < 0 || selectedArea > 3);
                switch (selectedArea) {
                    case 0:
                        orderAddressTime();
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
                        orderCalculationAndSummary();
                        break;

                }
                break;
            case 0:
                continueOrder();
                break;

        }
    }

    public void orderCalculationAndSummary() {
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

        System.out.println();
        System.out.println("Menu Name   Quantity    Price(per unit)");
        for (int i = 0; i < selectedMenu.size(); i++) {
            System.out.println(scheduledOrders.getOrderedMenu().get(i).getMenuName() + "      " + scheduledOrders.getOrderedMenuQty().get(i)
                    + "     " + selectedMenu.get(i).getMenuPrice());
        }
        System.out.println("Deliver Time    Deliver Address  Amount  GST  Delivery Fees   Subtotal");
        System.out.println(scheduledOrders.getSelectedTime() + "         " + scheduledOrders.getDeliveryAddress()
                + "         " + scheduledOrders.getTotalAmount() + "  " + scheduledOrders.getGstAmount() + "  " + scheduledOrders.getDeliveryfees()
                + "  " + scheduledOrders.getSubtotal());

        System.out.println();

        do {
            System.out.print("Are you sure you want to place schedule order? [y/n]");
            confirm = scan1.next();
            valid = check(confirm);
            if (valid == false) {
                System.out.println("Please enter [y/n] only.");
            }
        } while (valid == false);

        if (confirm.equals("y") || confirm.equals("Y")) {
            listScheduleOrders.add(scheduledOrders);
            System.out.println("Thanks for using our system");
            System.out.println("Order Summary");
            System.out.println("Order ID    Order Date & Time");
            System.out.println(scheduledOrders.getOrderID() + "  " + scheduledOrders.getOrderDateTime());
            System.out.println("Menu Name   Quantity    Price(per unit)");
            for (int i = 0; i < selectedMenu.size(); i++) {
                System.out.println(scheduledOrders.getOrderedMenu().get(i).getMenuName() + "      " + scheduledOrders.getOrderedMenuQty().get(i)
                        + "     " + selectedMenu.get(i).getMenuPrice());
            }
            System.out.println("Deliver Time    Deliver Address  Amount  GST  Delivery Fees   Subtotal");
            System.out.println(scheduledOrders.getSelectedTime() + "         " + scheduledOrders.getDeliveryAddress()
                    + "         " + scheduledOrders.getTotalAmount() + "  " + scheduledOrders.getGstAmount() + "  " + scheduledOrders.getDeliveryfees()
                    + "  " + scheduledOrders.getSubtotal());

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
