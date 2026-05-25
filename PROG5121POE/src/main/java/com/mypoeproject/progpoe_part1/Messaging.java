/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mypoeproject.progpoe_part1;

/**
 *
 * @author corle
 */
import static com.mypoeproject.progpoe_part1.LogIn.passwordInput;
import static com.mypoeproject.progpoe_part1.LogIn.usernameInput;
import static com.mypoeproject.progpoe_part1.PRogPOE_Part1.password;
import static com.mypoeproject.progpoe_part1.PRogPOE_Part1.username;
import static com.mypoeproject.progpoe_part1.Sending.sendMessage;
import java.util.Scanner;
public class Messaging {
    public static void messaging(){
    if(usernameInput.equals(username) && passwordInput.equals(password)){
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to QuickChat");
        int action = 0;
        
        while(action != 3 ){
        System.out.println("Please select action");
        System.out.println("1: Send Message");
        System.out.println("2: View previous Messages");
        System.out.println("3: Exit Program");
        System.out.println(" ");
        System.out.print(" Enter action: ");
        action = input.nextInt();
        
        System.out.println(" ");
        if(action == 1){
        sendMessage();
        }else if(action == 2){
        System.out.println("Coming Soon");
        }else if(action == 3){
        System.out.println("Goodbye and come again");
        }
        
}
}
}
}