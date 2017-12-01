/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

/**
 *
 * @author goh
 */

import Entity.DeliveryMan;
import Entity.DeliveryRecord;
import java.util.ArrayList;

public class Report {
    
    public void generateReport(){
        DeliveryRecord deliveryRecord1 = new DeliveryRecord(), deliveryRecord2 = new DeliveryRecord(), deliveryRecord3 = new DeliveryRecord();
        DeliveryMan deliveryMan1 = new DeliveryMan(), deliveryMan2 = new DeliveryMan(), deliveryMan3 = new DeliveryMan();
        ArrayList<DeliveryRecord> record = new ArrayList<>();
        int i;
        int a = 1;
        
        //set delivery men 1 information
        deliveryMan1.setDeliveryManID("FT001");
        deliveryMan1.setName("Khong");
        deliveryRecord1.setDeliveryMan(deliveryMan1);
        
        //set distance and total deliveries
        deliveryRecord1.setTotalDeliveries(10);
        deliveryRecord1.setDistanceTravelled(30.3);
        
        deliveryMan2.setDeliveryManID("FT002");
        deliveryMan2.setName("Chun");
        deliveryRecord2.setDeliveryMan(deliveryMan2);
        
        //set distance and total deliveries
        deliveryRecord2.setTotalDeliveries(6);
        deliveryRecord2.setDistanceTravelled(20);
        
        deliveryMan3.setDeliveryManID("FT003");
        deliveryMan3.setName("Peng");
        deliveryRecord3.setDeliveryMan(deliveryMan3);
        
        //set distance and total deliveries
        deliveryRecord3.setTotalDeliveries(4);
        deliveryRecord3.setDistanceTravelled(7);
        
        record.add(deliveryRecord1);
        record.add(deliveryRecord2);
        record.add(deliveryRecord3);
        
        System.out.println("____________________________________________________________________________________________________________________________________");
        System.out.println("Delivery Men ID\t\tDelivery Men Name\tTotal Deliveries Complete\tTotal Distance Travelled(KM)");
        System.out.println("____________________________________________________________________________________________________________________________________");
        
        for(i=0;i<record.size();i++){
            System.out.println(a+ "\t" +record.get(i).getDeliveryMan().getDeliveryManID() + "\t\t\t" + record.get(i).getDeliveryMan().getName() + "\t\t\t" + record.get(i).getTotalDeliveries() + "\t\t\t\t" + record.get(i).getDistanceTravelled());
            a++;
        }
    }
    
    public static void main(String[] args){
    Report report = new Report();
    report.generateReport();
        
    }
}
