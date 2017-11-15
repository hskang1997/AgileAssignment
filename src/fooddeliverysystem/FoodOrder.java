/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
import Entity.*;

/**
 *
 * @author LYS
 */
public class FoodOrder {

    private ArrayList<Order> foodOrder = new ArrayList<Order>();
    private ArrayList<Menu> menuList = new ArrayList<Menu>();
    private ArrayList<Menu> menuList2 = new ArrayList<Menu>();
    private ArrayList<Affiliates> restaurantList = new ArrayList<Affiliates>();
    static int foSize = 0;
    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        FoodOrder fo = new FoodOrder();
        fo.start();
    }

    public void start() {
        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.JANUARY, 9); //Year, month and day of month
        Date date = cal.getTime();
        Order order = new Order();
        String foName = "";
        String foodID = "";
        double totalPrice = 0;
        double gst = 0;
        double totalAmount = 0;
        boolean check = false;

        menuList.clear();
        menuList2.clear();
        restaurantList.clear();
        int noRest;

        Menu menu1 = new Menu("M001", "Curry Ramen", 12.90, true, date);
        Menu menu2 = new Menu("M002", "Blue eyes white Ramen", 22.90, true, date);
        Menu menu3 = new Menu("M003", "Sushi AF", 10.90, true, date);
        Menu menu4 = new Menu("M004", "Zheng Sushi", 5.90, true, date);
        menuList.add(menu1);
        menuList.add(menu2);
        menuList2.add(menu3);
        menuList2.add(menu4);
        Address address = new Address("B-21-10", "Jalan Danau Saujana", 53000, "Setapak", "Kuala Lumpur", "Malaysia");
        Address address2 = new Address("B-21-10", "Jalan Danau Saujana", 53000, "Setapak", "Kuala Lumpur", "Malaysia");
        Affiliates restaurant1 = new Affiliates("R01", "LYSRamen", "0167025919", address, "Ramen@hotmail.com");
        Affiliates restaurant2 = new Affiliates("R02", "GWHSushi", "0161234919", address2, "Sushi@hotmail.com");
        restaurantList.add(restaurant1);
        restaurantList.add(restaurant2);

        for (int r = 0; r < restaurantList.size(); r++) {
            System.out.print(String.format("\n%d. ", r + 1));
            System.out.println(restaurantList.get(r).toString());
        }

        System.out.print("Enter a restaurant number: ");
        try {
            noRest = scan.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid Input");
            return;
        }
        do {
            if (noRest == 1) {
                for (int i = 0; i < menuList.size(); i++) {
                    System.out.println(menuList.get(i).toString());
                }
            } else if (noRest == 2) {
                for (int i = 0; i < menuList2.size(); i++) {
                    System.out.println(menuList2.get(i).toString());
                }
            }

            System.out.print("\nEnter Menu ID: ");
            foodID = scan.next();//Menu ID
            if(foodID.length() > 4){
                System.out.println("Invalid Input");
                return;
            }

            int foodQty;

            System.out.print("\nEnter quantity: ");
            try {
                foodQty = scan.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid Input");
                return;
            }

            System.out.print("\nAre you confirm your order?(Y/N)(-1 to exit) ");
            char confirm = scan.next().charAt(0);

            if (confirm == 'y' || confirm == 'Y') {
                int count = 0;
                if (noRest == 1) {
                    for (int o = 0; o < menuList.size(); o++) {
                        if (foodID.compareToIgnoreCase(menuList.get(o).getMenuID()) == 0) {
                            count++;
                            order.setFoodName(menuList.get(o).getMenuName());
                            foName = menuList.get(o).getMenuName();

                            if (count == 1) {
                                order.placeOrder(menu1, foodQty);
                                totalPrice = order.getTotalAmount();
                                gst = order.getGstAmount();
                                totalAmount = order.getTotalPrice();
                                
                            } else {
                                order.placeOrder(menu2, foodQty);
                                totalPrice = order.getTotalAmount();
                                gst = order.getGstAmount();
                                totalAmount = order.getTotalPrice();
                            }
                        }
                    }
                } else if (noRest == 2) {
                    for (int o = 0; o < menuList2.size(); o++) {
                        if (foodID.compareToIgnoreCase(menuList2.get(o).getMenuID()) == 0) {
                            count++;
                            order.setFoodName(menuList2.get(o).getMenuName());
                            foName = menuList2.get(o).getMenuName();

                            if (count == 1) {
                                order.placeOrder(menu3, foodQty);
                                totalPrice = order.getTotalAmount();
                                gst = order.getGstAmount();
                                totalAmount = order.getTotalPrice();

                            } else {
                                order.placeOrder(menu4, foodQty);
                                totalPrice = order.getTotalAmount();
                                gst = order.getGstAmount();
                                totalAmount = order.getTotalPrice();
                            }
                        }
                    }
                }

                Calendar today = Calendar.getInstance();
                Date todayDate = today.getTime();
                String orderID = order.generateOrderID(foSize);
                order.setOrderID(orderID);
                order.setOrderDate(todayDate);
                check = confirmation();
                

                Order order2 = new Order(todayDate, orderID, foName, totalPrice, gst, foodQty, totalAmount);
                foodOrder.add(order2);

            } else {
                check = confirmation();
                
            }
        } while (check == true);
        System.out.println("Ordered Date: " + order.getOrderDate());
        System.out.println("Ordered ID: " + order.getOrderID());
        for (int f = 0; f < foodOrder.size(); f++) {
            System.out.println(foodOrder.get(f).toString());
        }
        System.out.println("Sub Total: " + order.getTotalAmount());
        System.out.println("GST: " + order.getGstAmount());
        System.out.println("Total Price: " + order.getTotalPrice());

    }

    public boolean confirmation() {
        System.out.print("\nDo you want to continue order?(Y/N) ");
        char want = scan.next().charAt(0);
        foSize++;

        if (want == 'y' || want == 'Y') {
            return true;
        }
        return false;
    }
}
