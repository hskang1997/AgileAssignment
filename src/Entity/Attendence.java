/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Hskang
 */
public class Attendence {
    
    private ArrayList<Date> clockIn = new ArrayList<>();
    private ArrayList<Date> clockOut = new ArrayList<>();
    private DeliveryMan person = new DeliveryMan();
    
    public Attendence() {
        
    }
    
    public Attendence(DeliveryMan deliveryMan){
        this.person = deliveryMan;
    }

    public ArrayList<Date> getClockIn() {
        return clockIn;
    }

    public void setClockIn(ArrayList<Date> clockIn) {
        this.clockIn = clockIn;
    }

    public ArrayList<Date> getClockOut() {
        return clockOut;
    }

    public void setClockOut(ArrayList<Date> clockOut) {
        this.clockOut = clockOut;
    }

    public DeliveryMan getPerson() {
        return person;
    }

    public void setPerson(DeliveryMan person) {
        this.person = person;
    }
    
    public void addClockIn(Date clockInDate) {
        this.clockIn.add(clockInDate);
    }
    
    public void addClockOut(Date clockOutDate) {
        this.clockOut.add(clockOutDate);
    }
    
}
