/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author Hskang
 */
public class Affiliates {
    
    private String restaurantID;
    private String restaurantName;
    private String restaurantPhone;
    private Address restaurantAddress;
    private String restaurantEmail;
    private ArrayList<Menu> menuList = new ArrayList<Menu>();

    // Empty Constructor
    public Affiliates() {
    }

    // Full
    public Affiliates(String restaurantID, String restaurantName, String restaurantPhone, Address restaurantAddress, String restaurantEmail) {
        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.restaurantPhone = restaurantPhone;
        this.restaurantAddress = restaurantAddress;
        this.restaurantEmail = restaurantEmail;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public Address getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(Address restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantEmail() {
        return restaurantEmail;
    }

    public void setRestaurantEmail(String restaurantEmail) {
        this.restaurantEmail = restaurantEmail;
    }

    public ArrayList<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<Menu> menuList) {
        this.menuList = menuList;
    }
    
    public String toString() {
        return "Restaurant Name: " + restaurantName + "\n Restaurant Contact: " + restaurantPhone + "\n Restaurant Email: " + restaurantEmail + "\n Restaurant Address: " + restaurantAddress.toString() + "\n";
    }
}
