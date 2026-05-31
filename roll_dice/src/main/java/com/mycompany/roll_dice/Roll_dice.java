/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.roll_dice;

/**
 *
 * @author MelanieViToM
 */
import java.util.Random;
import java.util.Scanner;

public class Roll_dice {

    public static int RollDice(){
        Random random=new Random();
        return random.nextInt(6)+1;
    }
    
    public static void main(String[] args) {
        Scanner entrance = new Scanner(System.in);
        
        int lives=5, consecutive_equal=0;
        int rolls=0, even_additions=0, odd_additions=0, equal_dice=0;
        String player_name, key;
        
        System.out.println("WELCOME TO ROLL DICE!");
        System.out.println("\nEnter your player name: ");
        player_name = entrance.nextLine();
                      
        while(true){ 
            System.out.println("\nPress enter key to play!");
            key=entrance.nextLine();
            
            int die1=RollDice();
            int die2=RollDice();
            int addition=die1 + die2;
        
            System.out.println("You rolled: " +die1+ " and " +die2);
            System.out.println("The addition is equals to: " +addition);
                        
            if(addition%2!=0){
            lives--;
            System.out.println("Odd sum! You has lost a life.");
            odd_additions++;
            rolls++;
            }else{
                even_additions++;
                rolls++;
            }
            
            if (lives==0){
                System.out.println("\nGAME OVER");
                break;
            }
            
            if(die1==6 && die2==6)
                lives++;
            
            if(die1==die2){
                equal_dice++;
                consecutive_equal++;
                System.out.println("Consecutive equal rolls: " + consecutive_equal + "\n");
                if(consecutive_equal==3){
                System.out.println("YOU WIN");
                break;
                }
            }else{
            consecutive_equal=0;
            }
        }   
        
        System.out.println("\nThanks for playing, " +player_name+ "!");
        System.out.println("Total numbers of rolls: " +rolls);
        System.out.println("Total numbers of rolls with even additions: " +even_additions);
        System.out.println("Total numbers of rolls with odd additions: " +odd_additions);
        System.out.println("Total numbers of rolls with equal dice: " +equal_dice);
            entrance.close();
    }
}
