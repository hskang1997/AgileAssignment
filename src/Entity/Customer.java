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
public class Customer {
    
    private String custName;
    private String custPhone;
    private Address custAddress;
    private Address altAddress1;
    private Address altAddress2;
    private String custEmail;

    // Empty Constructor
    public Customer() {
    }

    // One Address Constructor
    public Customer(String custName, String custPhone, Address custAddress, String custEmail) {
        this.custName = custName;
        this.custPhone = custPhone;
        this.custAddress = custAddress;
        this.custEmail = custEmail;
    }

    // Two Address Constructor
    public Customer(String custName, String custPhone, Address custAddress, Address altAddress1, String custEmail) {
        this.custName = custName;
        this.custPhone = custPhone;
        this.custAddress = custAddress;
        this.altAddress1 = altAddress1;
        this.custEmail = custEmail;
    }

    // Three Address Constructor
    public Customer(String custName, String custPhone, Address custAddress, Address altAddress1, Address altAddress2, String custEmail) {
        this.custName = custName;
        this.custPhone = custPhone;
        this.custAddress = custAddress;
        this.altAddress1 = altAddress1;
        this.altAddress2 = altAddress2;
        this.custEmail = custEmail;
    }

    // No email Constructor
    public Customer(String custName, String custPhone, Address custAddress, Address altAddress1, Address altAddress2) {
        this.custName = custName;
        this.custPhone = custPhone;
        this.custAddress = custAddress;
        this.altAddress1 = altAddress1;
        this.altAddress2 = altAddress2;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public Address getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(Address custAddress) {
        this.custAddress = custAddress;
    }

    public Address getAltAddress1() {
        return altAddress1;
    }

    public void setAltAddress1(Address altAddress1) {
        this.altAddress1 = altAddress1;
    }

    public Address getAltAddress2() {
        return altAddress2;
    }

    public void setAltAddress2(Address altAddress2) {
        this.altAddress2 = altAddress2;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }
    
    public String toString() {
        if (altAddress1 == null && altAddress2 == null) {
            return "Customer Name: " + custName + "\n Customer Phone: " + custPhone + "\n Customer Email: " + custEmail + "\n Customer Address: " + custAddress.toString() + "\n";
        } else if (altAddress2 == null) {
            return "Customer Name: " + custName + "\n Customer Phone: " + custPhone + "\n Customer Email: " + custEmail + "\n Customer Address: " + custAddress.toString() + "\n Customer Alt Address 1: " + altAddress1.toString();
        } else if (custEmail.isEmpty()) {
            return "Customer Name: " + custName + "\n Customer Phone: " + custPhone + "\n Customer Address: " + custAddress.toString() + "\n Customer Alt Address 1: " + altAddress1.toString() + "\n Customer Alt Address 2: " + altAddress2.toString();
        } else {
            return "Customer Name: " + custName + "\n Customer Phone: " + custPhone + "\n Customer Email: " + custEmail + "\n Customer Address: " + custAddress.toString() + "\n Customer Alt Address 1: " + altAddress1.toString() + "\n Customer Alt Address 2: " + altAddress2.toString();
        }
    }
}
