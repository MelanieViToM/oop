/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arraydata;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MelanieViToM
 */
public class ArrayData {

    public static void mainMenu(){ 
        System.out.println("""
                           \n::: MAIN MENU :::
                           [1]. Register users 
                           [2]. List users 
                           [3]. Search user 
                           [4]. Update user 
                           [5]. Delete user 
                           [6]. Exit 
                           .::: Press an option: """);
    }
    
    public static void userData(){ 
        System.out.println("""
                           \nChoose the field that you want to update
                           [1]. Identification number 
                           [2]. First name 
                           [3]. Last name 
                           [4]. Email 
                           [5]. Age 
                           .::: Press an option: """);
    }
    
    public static void main(String[] args) {
        Scanner entrance=new Scanner(System.in);
   
        ArrayList<String> identNumbers = new ArrayList<>();
        ArrayList<String> firstNames = new ArrayList<>();
        ArrayList<String> lastNames = new ArrayList<>();
        ArrayList<String> emails = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();
        String firstname, lastname, email, ident_number;
        int age, opt, datum;
        boolean menu_status = true;
        
        while(menu_status){
            mainMenu();
            opt=entrance.nextInt();
            entrance.nextLine();
            
            switch (opt){
                case 1 -> {
                    
                    System.out.println("::: REGISTER NEW USER :::");
                                        
                    System.out.println("Identification number: ");   
                    ident_number=entrance.nextLine();
                    boolean exists = false;
                    
                    for(int i=0; i<identNumbers.size(); i+=1){
                        if(identNumbers.get(i).equals(ident_number)){
                           exists=true;
                           break;
                        }
                    }
                    
                    if(exists){
                        System.out.println("\nUser already exists!");
                        break;
                    }
                    
                    System.out.println("First name: ");   
                    firstname=entrance.nextLine();
                    System.out.println("Last name: ");   
                    lastname=entrance.nextLine();
                    System.out.println("Email: ");   
                    email=entrance.nextLine();
                    System.out.println("Age: ");   
                    age=entrance.nextInt();
                    entrance.nextLine();

                    System.out.println("User Nro.: " + (identNumbers.size()+1));
                    System.out.println("\nUser has been registered successfully!");
                    System.out.println("\nPress any key to back to main menu.");
                    
                    identNumbers.add(ident_number);
                    firstNames.add(firstname);
                    lastNames.add(lastname);
                    emails.add(email);
                    ages.add(age);
                }
                
                case 2 -> {
                    System.out.println("\nREGISTERED USERS:" + identNumbers.size());
                    
                    if (identNumbers.isEmpty()){
                        
                        System.out.println("There aren't registered users!");
                    
                    }else{
                        for(int  j = 0; j < identNumbers.size(); j+=1){
                            
                            System.out.println("\nUser " + (j+1) +
                                    "\nIdentification number: " + identNumbers.get(j) + 
                                    "\nFirst name: " + firstNames.get(j) +
                                    "\nLast name: " + lastNames.get(j) +
                                    "\nEmail: " + emails.get(j) + 
                                    "\nAge: " + ages.get(j) +
                                    "\n");
                        }
                    }
                    System.out.println("\nPress any key to back to main menu.");
                    entrance.nextLine();
                }
                
                case 3 -> {
                    System.out.println("\n::: SEARCH USER :::");
                    String entered_ident;
                    boolean found_user=false;
                    System.out.println("\nEnter an identification number: ");
                    entered_ident=entrance.nextLine();
                    
                    for(int k = 0;k < identNumbers.size(); k+=1){
                        if(identNumbers.get(k).equals(entered_ident)){
                            
                            System.out.println("\nUser found!");
                            System.out.println("\nIdentification number: " + identNumbers.get(k) + 
                                    "\nFirst name: " + firstNames.get(k) +
                                    "\nLast name: " + lastNames.get(k) +
                                    "\nEmail: " + emails.get(k) + 
                                    "\nAge: " + ages.get(k));
                            
                            found_user=true;
                            break;
                        }
                    }
                    if(!found_user){
                        System.out.println("User not found!");
                    }
                    System.out.println("\nPress any key to back to main menu.");
                    entrance.nextLine();
                }
                
                case 4 -> {
                    System.out.println("::: UPDATE USER DATA :::");
                    userData();
                    datum=entrance.nextInt();
                    entrance.nextLine();
                    
                    switch (datum){
                        case 1 ->{
                            System.out.println("\nEnter your identification number");
                            String entered_ident = entrance.nextLine();
                                                       
                            for(int l = 0; l < identNumbers.size(); l+=1){
                                if(identNumbers.get(l).equals(entered_ident)){
                                   
                                    System.out.println("\nEnter new identification number");
                                    String new_number=entrance.nextLine();
                                    identNumbers.set(l, new_number);
                                    
                                    System.out.println("User updated successfully!");
                                    break;
                                }
                            }
                        }
                            
                        case 2 ->{
                            System.out.println("\nEnter your first name");
                            String entered_name = entrance.nextLine();
                                                       
                            for(int m = 0; m < firstNames.size(); m+=1){
                                if(firstNames.get(m).equals(entered_name)){
                                    
                                    System.out.println("\nEnter new first name");
                                    String new_name=entrance.nextLine();
                                    firstNames.set(m, new_name);
                                    
                                    System.out.println("\nUser updated successfully");
                                    break;
                                }
                            }
                        }
                        
                        case 3 ->{
                            System.out.println("\nEnter your last name");
                            String entered_lastname = entrance.nextLine();
                                                       
                            for(int n = 0; n < lastNames.size(); n+=1){
                                if(lastNames.get(n).equals(entered_lastname)){
                                    
                                    System.out.println("\nEnter new last name");
                                    String new_lastname=entrance.nextLine();
                                    lastNames.set(n, new_lastname);
                                    
                                    System.out.println("\nUser updated successfully");
                                    break;
                                }
                            }
                        }
                        
                        case 4 ->{
                            System.out.println("\nEnter your email");
                            String entered_email = entrance.nextLine();
                                                       
                            for(int p = 0; p < emails.size(); p+=1){
                                if(emails.get(p).equals(entered_email)){
                                    
                                    System.out.println("\nEnter new email");
                                    String new_email=entrance.nextLine();
                                    emails.set(p, new_email);
                                    
                                    System.out.println("\nUser updated successfully");
                                    break;
                                }
                            }
                        }
                        
                        case 5 ->{
                            System.out.println("\nEnter your age");
                            int entered_age = entrance.nextInt();
                            entrance.nextLine();
                                                       
                            for(int q = 0; q < ages.size(); q+=1){
                                if(ages.get(q).equals(entered_age)){
                                    
                                    System.out.println("\nEnter new age");
                                    int new_age=entrance.nextInt();
                                    entrance.nextLine();
                                    ages.set(q, new_age);
                                    
                                    System.out.println("\nUser updated successfully");
                                    break;
                                }
                            }
                        }
                        
                        default -> System.out.println("Invalid option. Try again.");
                    }    
                        
                    System.out.println("\nPress any key to back to main menu.");
                    entrance.nextLine();
                }
                    
                case 5 -> {
                    System.out.println("\n::: DELETE USER :::");
                    String entered_ident;
                    System.out.println("\nEnter your identification number: ");
                    entered_ident=entrance.nextLine();
                    
                    for(int r = 0;r < identNumbers.size(); r+=1){
                        if(identNumbers.get(r).equals(entered_ident)){
                            
                            identNumbers.remove(r);
                            firstNames.remove(r);
                            lastNames.remove(r);
                            emails.remove(r);
                            ages.remove(r);
                            
                            System.out.println("\nUser deleted successfully!");
                            break;
                        }
                    }
                    
                    System.out.println("\nPress any key to back to main menu.");
                    entrance.nextLine();
                }

                    
                case 6 -> {
                    System.out.println("\nHAVE A GREAT DAY!");
                    menu_status = false;
                }
                    
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
