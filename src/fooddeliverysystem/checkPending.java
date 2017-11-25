package FoodDeliverySystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author goh
 */
import Entity.Address;
import Entity.Delivery;
import Entity.DeliveryMan;
import Entity.DeliveryRecord;
import Entity.Order;
import java.util.ArrayList;

public class checkPending {
    
    public void check(){
        Order order = new Order();
        Address address = new Address();
        DeliveryRecord record = new DeliveryRecord();
        Delivery delivery = new Delivery();
        DeliveryMan deliveryMan = new DeliveryMan();
        ArrayList<Delivery> deliveryRecord = new ArrayList<>();
        ArrayList<Order> orderList = new ArrayList<>();
        int i;
        int a=1;
        
        delivery.setDeliveryID("DM001");
        
        //set address
        address.setUnitNo("59");
        address.setStreetName1("Lorong Seroja");
        address.setArea("Kuah");
        address.setCountry("Malaysia");
        address.setPostcode(Integer.parseInt("7000"));
        address.setState("Kedah");
        delivery.setDeliveryDestination(address);
        
        //set delivery status
        deliveryMan.setDeliveryStatus("Pending");
        record.setDeliveryMan(deliveryMan);
        deliveryRecord.add(delivery);
        record.addDeliveryRecords(delivery);
        
        //Problem here. How to get orderID
        order.setOrderID("ORD111111");
        orderList.add(order);
        delivery.setOrderList(orderList);
        delivery.addOrderList(order);

        
        if(record.getDeliveryMan().getDeliveryStatus().compareTo("Pending")==0){
             System.out.println("______________________________________________________________________________________________________________________________");
                System.out.println("Delivery Men ID\t\t\tStatus\t\t\t\tDestination\t\t\t\t\tOrder ID");
                System.out.println("______________________________________________________________________________________________________________________________");
            for(i=0;i<deliveryRecord.size();i++){
                System.out.println(a +"\t" + deliveryRecord.get(i).getDeliveryID() +"\t\t\t"+ record.getDeliveryMan().getDeliveryStatus() +"\t\t"+ deliveryRecord.get(i).getDeliveryDestination().toString()+"\t\t\t"+ delivery.getOrderList().get(i).getOrderID());
                a++;
        }
        
    }
    }
    
    public static void main(String[] args){
        checkPending CheckPending = new checkPending();
        CheckPending.check();
    }
}
