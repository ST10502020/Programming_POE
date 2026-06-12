/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author corle
 */
package com.mypoeproject.progpoe_part1;
import static com.mypoeproject.progpoe_part1.Messaging.messaging;
import static com.mypoeproject.progpoe_part1.PRogPOE_Part1.input;

public class LogIn{
static String usernameInput;
static String passwordInput;
public static void logIn(){
        
        
        boolean found = false;
        //if the user enters a name and password that is identical to the one they entered when registering then it would welcome them back using the registered firstname and lastname
        while(found == false){
            System.out.print("Enter your username: ");
         usernameInput = input.nextLine();
        
        System.out.print("Enter your password: ");
        passwordInput = input.nextLine();
        for(int i = 0; i < PRogPOE_Part1.usernames.size(); i++){ 
             if(usernameInput.equals(PRogPOE_Part1.usernames.get(i)) && passwordInput.equals(PRogPOE_Part1.passwords.get(i))){
                 found = true;
            System.out.println("LogIn Successful Welcome back " + PRogPOE_Part1.firstNames.get(i) + " "+ PRogPOE_Part1.lastNames.get(i)+ " it's great to see you again");
             messaging();
            break;
        }
        
        }
        if(!found){
        System.out.println("username or password incorrect, please try again");
    }
        }
    }
}