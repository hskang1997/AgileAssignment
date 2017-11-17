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
public class Address {

    private String unitNo;
    private String streetName1 = "";
    private String streetName2 = "";
    private int postcode;
    private String area;
    private String state;
    private String country;

    // Empty Constructor
    public Address() {
    }

    // Without Street Name 2
    public Address(String unitNo, String streetName1, int postcode, String area, String state, String country) {
        this.unitNo = unitNo;
        this.streetName1 = streetName1;
        this.postcode = postcode;
        this.area = area;
        this.state = state;
        this.country = country;
    }

    // Full
    public Address(String unitNo, String streetName1, String streetName2, int postcode, String area, String state, String country) {
        this.unitNo = unitNo;
        this.streetName1 = streetName1;
        this.streetName2 = streetName2;
        this.postcode = postcode;
        this.area = area;
        this.state = state;
        this.country = country;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getStreetName1() {
        return streetName1;
    }

    public void setStreetName1(String streetName1) {
        this.streetName1 = streetName1;
    }

    public String getStreetName2() {
        return streetName2;
    }

    public void setStreetName2(String streetName2) {
        this.streetName2 = streetName2;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public String toString() {
        if (!this.streetName2.isEmpty()) {
            return this.unitNo + ", " + this.streetName1 + ", " + this.streetName2 + ", " + this.postcode + " " + this.area + ", " + this.state + ", " + this.country + ".";
        } else {
            return this.unitNo + ", " + this.streetName1 + ", " + this.postcode + " " + this.area + ", " + this.state + ", " + this.country + ".";
        }
    }
    
}
