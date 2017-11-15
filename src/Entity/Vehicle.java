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
public class Vehicle {
    
    private String model;
    private String plateNo;
    private String productionDate; // Eg: May2017

    // Empty Constructor
    public Vehicle() {
    }

    // Full
    public Vehicle(String model, String plateNo, String productionDate) {
        this.model = model;
        this.plateNo = plateNo;
        this.productionDate = productionDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }
    
    
}
