/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Calendar;
import java.util.Date;

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
    }

    // Full
    public Menu(String menuID, String menuName, double menuPrice, boolean menuStatus, Date dateAdded) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuStatus = menuStatus;
        this.dateAdded = dateAdded;
    }

    Menu(String m001, String ramen, double d, Calendar cal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        if (menuStatus) {
            return menuID + " \t\t\t " + menuName + " \t\t    " + menuPrice + "\t\t Available" + "\n";
        } else {
            return menuID + " \t\t\t " + menuName + " \t\t    " + menuPrice + "\t\t Not Available" + "\n";
        }
    }

}
