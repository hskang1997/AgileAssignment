/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

import java.util.Scanner;
import Entity.Affiliates;
import Entity.Address;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Register {

    Scanner scanner = new Scanner(System.in);
    private static List<Affiliates> affiliatesList = new ArrayList<>();
    String restaurantType;
    String ownerName;

    /**
     * @param args the command line arguments
     */
    public void mainmenu() {

        Address address = new Address("B-21-10", "Jalan Danau Saujana", 53000, "Setapak", "Kuala Lumpur", "Malaysia");
        Affiliates affiliates = new Affiliates("Lim Sin Kheng", "971114-02-6025", "skylimgg", "5201314", "KFC", "AS0365550-V", "012-3456789", address, "KFC@gmail.com");
        affiliatesList.add(affiliates);

        String login;
        boolean check;
        do {
            System.out.println("Welcome");
            System.out.println("1. Sign up");
            System.out.println("2. Sign in");
            System.out.println("3. Exit");
            System.out.print("Please enter your selection: ");
            login = scanner.next();
            check = checkYN(login.charAt(0));
        } while (check == false);
    }

    public boolean checkYN(char ch) {
        if ((!Character.isDigit(ch))) {
            System.out.println("Select 1 and 2 only");
            return false;
        } else if (ch == '1') {
            menu1();
        } else if (ch == '2') {
            menu2();
        } else if (ch == '3') {
            System.exit(-1);
        }
        return true;
    }

    public void menu1() {

        String type;
        boolean check;
        boolean chk;

        do {
            System.out.println("Welcome to register as a Affiliates");
            System.out.println("Which type of restaurant do you want to restaurant?");
            System.out.println("1. Chinese");
            System.out.println("2. Malay");
            System.out.println("3. Indian");
            System.out.println("4. Western");
            System.out.println("5. Japanese");
            System.out.println("6. Others");
            System.out.println("7. Back to Main Menu");
            System.out.print("Please select your restaurant type:");
            type = scanner.next();
            check = checkType(type.charAt(0));
        } while (check == false);
        
        Affiliates restaurant = restaurantInfo();
        System.out.println("\n\nConfirm Information");
        System.out.println("Owner Information");
        System.out.println("Owner Name: " + restaurant.getOwnerName() + "        IC: " + restaurant.getIC());
        System.out.println("Username: " + restaurant.getUserName());
        System.out.println("Password: " + restaurant.getPassword());

        System.out.println("\nRestaurant Information");
        System.out.println("Restaurant Type: " + restaurantType);
        System.out.println("Name: " + restaurant.getRestaurantName());
        System.out.println("ID: " + restaurant.getRestaurantID());
        System.out.println("Tel: " + restaurant.getRestaurantPhone());
        System.out.println("Email: " + restaurant.getRestaurantEmail());
        System.out.println("Address: " + restaurant.getRestaurantAddress().toString());

        String confirm;
        do {
            System.out.println("\nConfirm as Affiliates?");
            System.out.println("1. Yes           2. No");
            confirm = scanner.next();
            chk = checkConfirm(confirm.charAt(0));
        } while (chk == false);
        affiliatesList.add(restaurant);
        System.out.println("You have successfully register as our affiliates");
        mainmenu();

    }

    public boolean checkType(char ch) {
        Scanner scan = new Scanner(System.in);

        if ((!Character.isDigit(ch)) || ch > '7' || ch == '0') {
            System.out.println("Please only enter from the selection\n");
            return false;
        } else if (ch == '1') {
            restaurantType = "Chinese";
        } else if (ch == '2') {
            restaurantType = "Malay";
        } else if (ch == '3') {
            restaurantType = "Indian";
        } else if (ch == '4') {
            restaurantType = "Western";
        } else if (ch == '5') {
            restaurantType = "Japanese";
        } else if (ch == '6') {
            System.out.println("Please Enter Your Restaurant Type: ");
            restaurantType = scan.nextLine();
        } else if (ch == '7') {
            mainmenu();
        }

        return true;
    }

    public boolean checkConfirm(char ch) {
        if ((!Character.isDigit(ch) || ch == '0' || ch > '2')) {
            System.out.println("Select 1 and 2 only");
            return false;
        } else if (ch == '1') {
            return true;
        } else if (ch == '2') {
            menu1();
            return false;
        }
        
        return true;
    }

    public Affiliates restaurantInfo() {
        String ownerName;
        String ownerIC;
        String userName;
        String password;

        boolean user;

        String restName;
        String restID;
        String restPhone;
        String restEmail;
        String unitNo;
        String streetName = "";
        int postcode;
        String area;
        String state;
        String country;
        Scanner scan = new Scanner(System.in);

        //Owner Info
        System.out.println("Owner Information");
        System.out.print("Owner Name : ");
        ownerName = scan.nextLine();
        System.out.print("Owner IC(with '-') : ");
        ownerIC = scan.nextLine();
        do {
            System.out.print("Username : ");
            userName = scan.nextLine();
            user = checkUser(userName);
        } while (user == false);
        System.out.print("Password : ");
        password = scan.nextLine();

        //Restaurant Info
        System.out.println("\nRestaurant Information");
        System.out.print("Restaurant Name* : ");
        restName = scan.nextLine();
        System.out.print("Restaurant ID* : ");
        restID = scan.nextLine();
        System.out.print("Restaurant Phone Number : ");
        restPhone = scan.nextLine();
        System.out.print("Restaurant Email* : ");
        restEmail = scan.nextLine();

        //Address
        System.out.println("\nRestaurant Address*");
        System.out.print("Unit Number* : ");
        unitNo = scan.nextLine();
        System.out.print("Street Name* : ");
        streetName = scan.nextLine();
        System.out.print("Postcode* : ");
        postcode = Integer.parseInt(scan.nextLine());
        System.out.print("Area* : ");
        area = scan.nextLine();
        System.out.print("State* : ");
        state = scan.nextLine();
        System.out.print("Country* : ");
        country = scan.nextLine();

        Address address = new Address(unitNo, streetName, postcode, area, state, country);
        Affiliates affiliates = new Affiliates(ownerName, ownerIC, userName, password, restName, restID, restPhone, address, restEmail);
        return affiliates;

    }

    public boolean checkUser(String username) {
        boolean check = false;
        if (!affiliatesList.isEmpty()) {
            for (int i = 0; i < affiliatesList.size(); i++) {
                if (affiliatesList.get(i).getUserName().compareTo(username) == 0) {
                    System.out.println("Username has been used, Please enter another username.");
                    check = false;
                    break;
                } else {
                    check = true;
                }

            }
        }

        return check;
    }

    public void menu2() {
        boolean chkLogin;
        String username;
        String password;
        System.out.println("Welcome");
        do {
            System.out.print("Username: ");
            username = scanner.next();
            System.out.print("Password: ");
            password = scanner.next();
            chkLogin = checkLogin(username, password);

        } while (chkLogin == false);
        System.out.println("Welcome " + ownerName);
        System.exit(-1);

    }

    public boolean checkLogin(String username, String pass) {
        boolean check = false;
        if (!affiliatesList.isEmpty()) {
            for (int i = 0; i < affiliatesList.size(); i++) {
                if (affiliatesList.get(i).getUserName().compareTo(username) == 0 && affiliatesList.get(i).getPassword().compareTo(pass) == 0) {
                    ownerName = affiliatesList.get(i).getOwnerName();
                    check = true;
                    break;
                } else {

                    check = false;
                }

            }
            if (!check) {
                System.out.println("Please enter correct username or password");
            }

        }
        return check;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Register affiliates = new Register();
        affiliates.mainmenu();
    }

}
