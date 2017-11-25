/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

import Entity.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LYS
 */
public class CustomerDetails {

    private ArrayList<Customer> customerList = new ArrayList<Customer>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CustomerDetails custPhone = new CustomerDetails();
        custPhone.searchPhone();

    }

    public void searchPhone() {
        boolean valid = true;
        Scanner scan = new Scanner(System.in);
        String phoneNumber = "";

        Address address1 = new Address("B-21-10", "Jalan Danau Saujana", 53000, "Setapak", "Kuala Lumpur", "Malaysia");
        Address address2 = new Address("B28", "Jalan Kaki", 53000, "Setapak", "Penang", "Malaysia");
        Address address3 = new Address("1-10", "Jalan Zheng", 13400, "Setapak", "Butterworth", "Malaysia");
        Customer customer1 = new Customer("Black Red", "0167025919", address1, "kingkong4311@hotmail.com");
        Customer customer2 = new Customer("My Love", "0143094205", address2, "MyLove@hotmail.com");
        Customer customer3 = new Customer("Osas", "0178787887", address3, "OsasSipekO@hotmail.com");

        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);

        do {
            System.out.print("Enter customer phone number: ");
            phoneNumber = scan.nextLine();
            for (int c = 0; c < phoneNumber.length(); c++) {
                char charAt = phoneNumber.charAt(c);
                if (Character.isLetter(charAt)) {
                    System.out.println("Consist Alphabetic in phone number.");
                    valid = false;
                }
            }

        } while (valid == false);

        for (int i = 0; i < customerList.size(); i++) {
            if (phoneNumber.compareTo(customerList.get(i).getCustPhone()) == 0) {
                System.out.println(customerList.get(i).toString());
            }else{
                System.out.println("Not found.");
                searchPhone();
            }
        }
        //forget commit
    }
}
