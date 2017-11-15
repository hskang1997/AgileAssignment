/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Hskang
 */
public class Menu {

    private String menuID;
    private String menuName;
    private double menuPrice;
    private boolean menuStatus; // Available or Not Available
    private Date dateAdded;

    // Empty Constructor
    public Menu() {
    }

    // Constructor without menu status
    public Menu(String menuID, String menuName, double menuPrice, Date dateAdded) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.dateAdded = dateAdded;
        this.menuStatus = true;
    }

    // Full
    public Menu(String menuID, String menuName, double menuPrice, boolean menuStatus, Date dateAdded) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuStatus = menuStatus;
        this.dateAdded = dateAdded;
    }

    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public double getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(double menuPrice) {
        this.menuPrice = menuPrice;
    }

    public boolean isMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(boolean menuStatus) {
        this.menuStatus = menuStatus;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String toString() {
        if (this.isMenuStatus()) {
            return "Menu Name: " + this.getMenuName() + "\n Menu Price: " + this.getMenuPrice() + "\n Menu Status: Available";
        } else {
            return "Menu Name: " + this.getMenuName() + "\n Menu Price: " + this.getMenuPrice() + "\n Menu Status: Not Available";
        }
    }

}
