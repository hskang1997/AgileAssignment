/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Hskang
 */
public class DeliveryMan {
    
    private String deliveryManID;
    private String name;
    private String icNo;
    private String phone;
    private String homeAddress;
    private String email;
    private Vehicle vehicle;
    private String workingStatus; // Eg: retired, fired, ...
    private String deliveryStatus; // Eg: delivering, available, picking up, ...

    // Empty Constructor
    public DeliveryMan() {
    }

    // Full
    public DeliveryMan(String deliveryManID, String name, String icNo, String phone, String homeAddress, String email, Vehicle vehicle, String workingStatus, String deliveryStatus) {
        this.deliveryManID = deliveryManID;
        this.name = name;
        this.icNo = icNo;
        this.phone = phone;
        this.homeAddress = homeAddress;
        this.email = email;
        this.vehicle = vehicle;
        this.workingStatus = workingStatus;
        this.deliveryStatus = deliveryStatus;
    }

    public String getDeliveryManID() {
        return deliveryManID;
    }

    public void setDeliveryManID(String deliveryManID) {
        this.deliveryManID = deliveryManID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcNo() {
        return icNo;
    }

    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    
    public String displayDeliveryMan() {
        
        return String.format("%-20s\t%-20s\t%-15s\n", this.getDeliveryManID(), this.getWorkingStatus(), this.getDeliveryStatus());
    }
}
