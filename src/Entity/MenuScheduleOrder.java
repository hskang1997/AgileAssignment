/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
import java.util.Date;
/**
 *
 * @author Hskang
 */
public class MenuScheduleOrder {

    private String menuID;
    private String menuName;
    private double menuPrice;
    private boolean menuStatus; // Available or Not Available
    private Date dateAdded;
    private Affiliates owner;

    // Empty Constructor
    public MenuScheduleOrder() {
    }

    // Constructor without menu status
    public MenuScheduleOrder(String menuID, String menuName, double menuPrice, Date dateAdded, Affiliates restaurant) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.dateAdded = dateAdded;
        this.owner = restaurant;
    }

    // Full
    public MenuScheduleOrder(String menuID, String menuName, double menuPrice, boolean menuStatus, Date dateAdded, Affiliates restaurant) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuStatus = menuStatus;
        this.dateAdded = dateAdded;
        this.owner = restaurant;
    }

    public Affiliates getOwner() {
        return owner;
    }

    public void setOwner(Affiliates owner) {
        this.owner = owner;
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
    
    public String getMenuStatus() {
        String status = "";
        if(menuStatus){
            status = "Available";
        }else{
            status = "Not Available";
        }
        return status;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String toString() {
        if (menuStatus) {
            return "Menu Name: " + menuName + "\n Menu Price: " + menuPrice + "\n Menu Status: Available";
        } else {
            return "Menu Name: " + menuName + "\n Menu Price: " + menuPrice + "\n Menu Status: Not Available";
        }
    }

}
