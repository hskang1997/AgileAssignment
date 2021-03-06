/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

import Entity.Affiliates;
import Entity.Menu;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sky
 */
public class FoodManagement {
   
    Scanner scanner = new Scanner(System.in);
    private static List<Menu> foodList = new ArrayList<>();
    
    String foodStat;
    String name;
    double price;
    boolean status;
    String promoDetail;
    Menu menu;
    String foodId;
    
    
    

    public void mainMenu() {
        
        
        String login;
        boolean check;
        do {
            System.out.println("Welcome");
            System.out.println("1. Add Food");
            System.out.println("2. Update Food");
            System.out.println("3. Delete Food");
            System.out.println("4. Exit");
            System.out.print("Please enter your selection: ");
            login = scanner.next();
            check = check1(login.charAt(0));
        } while (check == false);
    }

    public boolean check1(char ch) {
        if ((!Character.isDigit(ch))) {
            System.out.println("Enter number only");
            return false;
        } else if (ch == '1') {
            addMenu();
        } else if (ch == '2') {
            updateFood();
        } else if (ch == '3') {
            deleteFood();
        } else if (ch == '4') {
            System.exit(-1);
        }
        return true;
    }

    public void addMenu() {
        char ch;
        Date date = Calendar.getInstance().getTime();
        int day = date.getDate();
        boolean chk = false;
        String foodName;
        double foodPrice;
        String foodStatus;
        
        boolean check;
        boolean available = false;
        String promo;
        boolean checkPromo;
        Scanner scan = new Scanner(System.in);

        
        //Food Info
        
        System.out.println("Food Information");
        
        System.out.print("Name : ");
        foodName = scan.nextLine();
        System.out.print("Price : ");
        foodPrice = Double.parseDouble(scan.nextLine());
        do{
            System.out.println("Status(Available):");
            System.out.println("1. Yes   2. No");
            foodStatus = scan.nextLine();
            check = checkAvailable(foodStatus.charAt(0));
        }while(check == false);
       if(foodStat.equals("True")){
           available = true;
       }else if(foodStat.equals("False")){
           available = false;
       }
       do{
            System.out.println("Any Promotion?:");
            System.out.println("1. Yes   2. No");
            promo = scan.nextLine();
            checkPromo = chkPromo(promo.charAt(0));
        }while(check == false);
        
        Menu menu = new Menu(generatefoodID(), foodName, foodPrice, available, promoDetail, date);
        
        System.out.println("\n\nConfirm Information");
        System.out.println("ID: " + menu.getMenuID());
        System.out.println("Food Name: " + menu.getMenuName());
        System.out.println("Price: RM " + menu.getMenuPrice());
        System.out.println("Available Status: " + menu.isMenuStatus());
        System.out.println("Promotion: " + menu.getPromotion());
        System.out.println("Date Added: " + menu.getDateAdded().getDate()+"-" + (menu.getDateAdded().getMonth()+1)+"-" +  (menu.getDateAdded().getYear()+1900));
        String confirm;
        do {
            System.out.println("\nConfirm add Food?");
            System.out.println("1. Yes           2. No");
            confirm = scanner.next();
            chk = checkConfirm(confirm.charAt(0));
        } while (chk == false);

        foodList.add(menu);
        System.out.println("You have successfully add food to menu");
        mainMenu();
        
    }
    public boolean checkAvailable(char foodStatus){
        
        if ((!Character.isDigit(foodStatus) || foodStatus == '0' || foodStatus > '2')) {
            System.out.println("Please enter 1 or 2 only");
            return false;
        } else if (foodStatus == '1') {
            foodStat = "True";
            return true;
        } else if (foodStatus == '2') {
            foodStat = "False";
            return true;
        }

        return true;
    }
    public boolean chkPromo(char foodStatus){
        Scanner scan = new Scanner(System.in);
        
        if ((!Character.isDigit(foodStatus) || foodStatus == '0' || foodStatus > '2')) {
            System.out.println("Please enter 1 or 2 only");
            return false;
        } else if (foodStatus == '1') {
            System.out.println("Promo Detail: ");
            promoDetail = scan.nextLine();
            return true;
        } else if (foodStatus == '2') {
            promoDetail = "No Promotion";
            return true;
        }

        return true;
    }
    public boolean checkConfirm(char ch) {
        if ((!Character.isDigit(ch) || ch == '0' || ch > '2')) {
            System.out.println("Select 1 and 2 only");
            return false;
        } else if (ch == '1') {
            return true;
        } else if (ch == '2') {
            mainMenu();
            return false;
        }
        
        return true;
    }

    

    public String generatefoodID() {
        
        String foodID;
        String front = "FD";
        if (foodList.isEmpty()) {
            foodID = front + "001";
        } else {
            int code = foodList.size() + 1;
            foodID = String.format(front + "%04d", code);            
        }
        return foodID;
    }
    public void updateFood(){
        boolean chk = false;
        boolean checkID = false;
        String foodID;
        String updatechk;
        boolean chkUpdate;
        
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("Please enter the food ID to update detail(-1 to exit): ");
            foodID = scan.nextLine();
            if(foodId.compareTo("-1") == 0){
                mainMenu();
            }
            checkID = chkID(foodID);
        }while(!checkID);
        
        System.out.println("Food Information");
        System.out.println("================");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Available status: " + status);
        System.out.println("Promotion " + promoDetail);
        do{
        System.out.println("Which one do you want to update? ");
        System.out.println("1. Name");
        System.out.println("2. Price");
        System.out.println("3. Status");
        System.out.println("4. Promotion");
        System.out.println("5. Save");
        updatechk = scan.nextLine();
        chkUpdate = checkUpdate(updatechk.charAt(0));
        }while(chkUpdate== false);
        System.out.println("Food Information");
        System.out.println("================");
        System.out.println("Name: " + menu.getMenuName());
        System.out.println("Price: RM " + menu.getMenuPrice());
        System.out.println("Available status: " + menu.isMenuStatus());
        System.out.println("Promotion: " + menu.getPromotion());
        String confirm;
        do {
            System.out.println("\nSave Changes");
            System.out.println("1. Yes           2. No");
            confirm = scanner.next();
            
            chk = checkConfirm(confirm.charAt(0));
        } while (chk == false);
        System.out.println("You have successful update the food");
        mainMenu();
                
        
    }
    public boolean chkID(String foodID) {
        boolean check = false;
        
        if (!foodList.isEmpty()) {
            for (int i = 0; i < foodList.size(); i++) {
                if (foodList.get(i).getMenuID().compareTo(foodID) == 0) {
                    name = foodList.get(i).getMenuName();
                    price = foodList.get(i).getMenuPrice();
                    status = foodList.get(i).isMenuStatus();
                    promoDetail = foodList.get(i).getPromotion();
                    menu = foodList.get(i);     
                    check = true;              
                    break;
                } else {
                    check = false;
                }

            }
            if (!check) {
                System.out.println("Please enter correct foodID");
            }

        }
        return check;
    }
    public boolean checkUpdate(char update){
        String food;
        boolean check;
        Scanner scan = new Scanner(System.in);
        if ((!Character.isDigit(update) || update == '0' || update > '5')) {
            System.out.println("Enter from the selection only");
            return false;
        } else if (update == '1') {
            System.out.print("Name: ");
            name = scan.nextLine();
            menu.setMenuName(name);
            return false;
        } else if (update == '2') {
            System.out.print("Price: ");
            price = Double.parseDouble(scan.nextLine());
            menu.setMenuPrice(price);
            return false;
        }
        else if (update == '3') {
            do{
                System.out.println("Status:");
                System.out.println("1. Yes   2. No");
                food = scan.nextLine();
                check = checkAvailable(food.charAt(0));
            }while(check == false);
            if(foodStat.equals("True")){
                status = true;
                menu.setMenuStatus(status);
            }else if(foodStat.equals("False")){
                status = false;
                menu.setMenuStatus(status);
            }
            return false;
        }
        else if (update == '4') {
            System.out.print("Promotion: ");
            promoDetail = scan.nextLine();
            if(promoDetail == null){
                promoDetail = "No Promotion";
            }
            menu.setMenuName(promoDetail);
            return false;
        }
        else if (update == '5'){
            return true;
        }
        return true;
    }
    public void deleteFood(){
        
        boolean checkId;
        String confirm;
        boolean delete;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("Please enter the food ID to delete(-1 to exit): ");
            foodId = scan.nextLine();
            if(foodId.compareTo("-1") == 0){
                mainMenu();
            }
            checkId = chkID(foodId);
        }while(!checkId);
        
        System.out.println("Food Information");
        System.out.println("================");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Available status: " + status);
        System.out.println("Promotion: " + promoDetail);
        do {
            System.out.println("\nConfirm Delete?");
            System.out.println("1. Yes           2. No");
            confirm = scanner.next();
            delete = checkDelete(confirm.charAt(0));
        } while (delete == false);
    }
    
    public boolean checkDelete(char ch) {
        
                
        if ((!Character.isDigit(ch) || ch == '0' || ch > '2')) {
            System.out.println("Select 1 and 2 only");
            return false;
        } else if (ch == '1') {
            for (int i = 0; i < foodList.size(); i++) {
                if (foodList.get(i).getMenuID().compareTo(foodId) == 0) {
                    foodList.remove(i);
                    System.out.println("You have successful delete the food\n\n");
                    mainMenu();
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } else if (ch == '2') {
            mainMenu();
            return false;
        }
        
        return true;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Date date = Calendar.getInstance().getTime();
        FoodManagement food = new FoodManagement();
        Menu menu4 = new Menu();
        menu4.setMenuID("M004");
        menu4.setMenuName("Zheng Sushi");
        menu4.setMenuPrice(5.90);
        menu4.setMenuStatus(true);
        menu4.setPromotion("");
        menu4.setDateAdded(date);
        
        foodList.add(menu4);
        food.mainMenu();
        
    }
}
