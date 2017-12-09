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


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Entity.*;

public class updateDeliveryMen {
    public List<DeliveryMan> delivery = new ArrayList<>();
    Address address = new Address();
   
    public void search(){
        int i;
        Scanner scanner = new Scanner(System.in);
        DeliveryMan deliveryMen = new DeliveryMan();
        boolean check = false;
        
        address.setUnitNo("59");
        address.setStreetName1("Lorong Seroja");
        address.setArea("Kuah");
        address.setCountry("Malaysia");
        address.setPostcode(Integer.parseInt("7000"));
        address.setState("Kedah");
        DeliveryMan man1 = new DeliveryMan("121314","Goh","9712266025713","0175979783",address,"gohwei1@gmail.com",null,"Full-Time",null);
        delivery.add(man1);
        

        do{   
        System.out.println("Enter the delivery men ID:");
        String id = scanner.nextLine();
        
        for(i =0;i <delivery.size();i++){
            if(delivery.get(i).getDeliveryManID().equals(id)){
                System.out.println("Delivery Men ID:" + delivery.get(i).getDeliveryManID());
                System.out.println("Name:" + delivery.get(i).getName());
                System.out.println("Email:" + delivery.get(i).getEmail());
                System.out.println("Contact Number:" + delivery.get(i).getPhone());
                System.out.println("Identity Card No:" + delivery.get(i).getIcNo());
                System.out.println("Address:" + delivery.get(i).getHomeAddress());
                System.out.println("Working status: " + delivery.get(i).getWorkingStatus());
                deliveryMen = delivery.get(i);
                System.out.println("\nWhich information you wish to update?");
                check = true;
                break;

        }else{
                System.out.println("No such staff.Please try again");
                check = false;
              
            }
        }}while(check == false);
         update(deliveryMen);
        
    }
    
    public void update(DeliveryMan deliveryMan){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        int choice,i,status;
        String contact,email;
        char confirm;
        
                   do{
                System.out.println("1.Contact No\n2.Address\n3.Email\n4.Working status");
                choice = scanner.nextInt();
                
                if(choice==1){
                    System.out.println("Please enter new contact number:");
                    contact = scanner.next();
                    deliveryMan.setPhone(contact);
                    System.out.println("Update successful.Here is the new information");
                    System.out.println("Delivery Men ID:" + deliveryMan.getDeliveryManID());
                    System.out.println("Name:" + deliveryMan.getName());
                    System.out.println("Email:" + deliveryMan.getEmail());
                    System.out.println("Contact Number:" + deliveryMan.getPhone());
                    System.out.println("Identity Card No:" + deliveryMan.getIcNo());
                    System.out.println("Address:" + deliveryMan.getHomeAddress());
                    System.out.println("Working status: " + deliveryMan.getWorkingStatus());      
                    
                    do{
                    System.out.println("\nDo you want to update another information?(Y/N)");
                    confirm= scanner.next().charAt(0);
                     if (confirm == 'y' || confirm == 'Y') {
                         update(deliveryMan);
                    } else if (confirm == 'n' || confirm == 'N') {
                        System.out.println("Thank for using our system.");
                    }else{
                System.out.println("Invalid option.Please try again.");}
                    }while(!(confirm == 'n' || confirm == 'N' || confirm == 'y' || confirm == 'Y'));
                }else if(choice ==2){                  
                    
                    System.out.println("Please enter delivery men unit no:");
                    address.setUnitNo(scanner.next());
                    System.out.println("Please enter delivery men street name:");
                    address.setStreetName1(scanner.next());
                    System.out.println("Please enter delivery men post code:");
                    address.setPostcode(scanner.nextInt());
                    System.out.println("Please enter delivery men area:");
                    address.setArea(scanner.next());
                    System.out.println("Please enter delivery men state:");
                    address.setState(scanner.next());
                    System.out.println("Please enter delivery men contry:");
                    address.setCountry(scanner.next());
                    deliveryMan.setHomeAddress(address);
                    
                    System.out.println("Update successful.Here is the new information");
                    System.out.println("Delivery Men ID:" + deliveryMan.getDeliveryManID());
                    System.out.println("Name:" + deliveryMan.getName());
                    System.out.println("Email:" + deliveryMan.getEmail());
                    System.out.println("Contact Number:" + deliveryMan.getPhone());
                    System.out.println("Identity Card No:" + deliveryMan.getIcNo());
                    System.out.println("Address:" + deliveryMan.getHomeAddress().toString());
                    System.out.println("Working status: " + deliveryMan.getWorkingStatus());  
                    
                    do{
                    System.out.println("\nDo you want to update another information?(Y/N)");
                    confirm= scanner.next().charAt(0);
                     if (confirm == 'y' || confirm == 'Y') {
                         update(deliveryMan);
                    } else if (confirm == 'n' || confirm == 'N') {
                        System.out.println("Thank for using our system.");
                    }else{
                System.out.println("Invalid option.Please try again.");}
                    }while(!(confirm == 'n' || confirm == 'N' || confirm == 'y' || confirm == 'Y'));
                    
                }else if(choice==3){
                    System.out.println("Please enter new email:");
                    email = scanner1.nextLine();
                    deliveryMan.setEmail(email);
                    System.out.println("Update successful.Here is the new information");
                    System.out.println("Delivery Men ID:" + deliveryMan.getDeliveryManID());
                    System.out.println("Name:" + deliveryMan.getName());
                    System.out.println("Email:" + deliveryMan.getEmail());
                    System.out.println("Contact Number:" + deliveryMan.getPhone());
                    System.out.println("Identity Card No:" + deliveryMan.getIcNo());
                    System.out.println("Address:" + deliveryMan.getHomeAddress());
                    System.out.println("Working status: " + deliveryMan.getWorkingStatus()); 
                    
                    do{
                    System.out.println("\nDo you want to update another information?(Y/N)");
                    confirm= scanner.next().charAt(0);
                     if (confirm == 'y' || confirm == 'Y') {
                         update(deliveryMan);
                    } else if (confirm == 'n' || confirm == 'N') {
                        System.out.println("Thank for using our system.");
                    }else{
                System.out.println("Invalid option.Please try again.");
                    }
                    }while(!(confirm == 'n' || confirm == 'N' || confirm == 'y' || confirm == 'Y'));
                    
                }else if (choice ==4){
                 do{   
                 System.out.println("\n1.Resign\n2.Full-Time");
                 status = scanner1.nextInt();
                 
                 if(status==1){
                    deliveryMan.setWorkingStatus("Resign");
                    System.out.println("Update successful.Here is the new information");
                    System.out.println("Delivery Men ID:" + deliveryMan.getDeliveryManID());
                    System.out.println("Name:" + deliveryMan.getName());
                    System.out.println("Email:" + deliveryMan.getEmail());
                    System.out.println("Contact Number:" + deliveryMan.getPhone());
                    System.out.println("Identity Card No:" + deliveryMan.getIcNo());
                    System.out.println("Address:" + deliveryMan.getHomeAddress());
                    System.out.println("Working status: " + deliveryMan.getWorkingStatus()); 
                 }else if(status ==2){
                    deliveryMan.setWorkingStatus("Full-Time");
                    System.out.println("Update successful.Here is the new information");
                    System.out.println("Delivery Men ID:" + deliveryMan.getDeliveryManID());
                    System.out.println("Name:" + deliveryMan.getName());
                    System.out.println("Email:" + deliveryMan.getEmail());
                    System.out.println("Contact Number:" + deliveryMan.getPhone());
                    System.out.println("Identity Card No:" + deliveryMan.getIcNo());
                    System.out.println("Address:" + deliveryMan.getHomeAddress());
                    System.out.println("Working status: " + deliveryMan.getWorkingStatus()); 
                 }else{
                     System.out.println("Invalid option.Please try again.");
                 }
                 
                  }while(!(status == 1 || status == 2 ));
                 
                 do{
                    System.out.println("\nDo you want to update another information?(Y/N)");
                    confirm= scanner.next().charAt(0);
                     if (confirm == 'y' || confirm == 'Y') {
                        update(deliveryMan);
                    } else if (confirm == 'n' || confirm == 'N') {
                        System.out.println("Thank for using our system.");
                    }else{
                System.out.println("Invalid option.Please try again.");}
                    }while(!(confirm == 'n' || confirm == 'N' || confirm == 'y' || confirm == 'Y'));
                }
                else{
                    System.out.println("Invalid Option.Please try again.");
                }
            }while(!(choice == 1 || choice == 2 || choice == 3 || choice ==3));
}
    
    
    public static void main(String[] args){
        updateDeliveryMen UpdateDeliveryMen = new updateDeliveryMen();
        UpdateDeliveryMen.search();
    }
}
