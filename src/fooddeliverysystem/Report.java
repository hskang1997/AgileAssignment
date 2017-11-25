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
import Entity.Delivery;
import Entity.DeliveryMan;
import Entity.DeliveryRecord;
import Entity.Order;
import java.util.ArrayList;
import java.util.List;

public class Report {
    
    public void generateReport(){
        DeliveryRecord deliveryRecord = new DeliveryRecord();
        DeliveryMan deliveryMan = new DeliveryMan();
        List<DeliveryRecord> record = new ArrayList<>();
        int i;
        int a =1;
        
        //set delivery men 1 information
        deliveryMan.setDeliveryManID("FT001");
        deliveryMan.setName("Khong Chun Peng");
        deliveryRecord.setDeliveryMan(deliveryMan);
        
        //set distance and total deliveries
        deliveryRecord.setTotalDeliveries(10);
        deliveryRecord.setDistanceTravelled(30.3);
        record.add(deliveryRecord);
        

        System.out.println("____________________________________________________________________________________________________________________________________");
        System.out.println("Delivery Men ID\t\tDelivery Men Name\tTotal Deliveries Complete\tTotal Distance Travelled(KM)");
        System.out.println("____________________________________________________________________________________________________________________________________");
        
        for(i=0;i<record.size();i++){
            System.out.println(a+ "\t" +record.get(i).getDeliveryMan().getDeliveryManID() + "\t\t" + record.get(i).getDeliveryMan().getName() + "\t\t\t" + record.get(i).getTotalDeliveries() + "\t\t\t\t" + record.get(i).getDistanceTravelled());
        }
    }
    
    public static void main(String[] args){
    Report report = new Report();
    report.generateReport();
        
    }
}
