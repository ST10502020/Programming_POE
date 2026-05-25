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
import static com.mypoeproject.progpoe_part1.PRogPOE_Part1.firstName;//importing a static variable so I can use it directly 
import static com.mypoeproject.progpoe_part1.PRogPOE_Part1.lastName;//importing a static variable so I can use it directly 
import static com.mypoeproject.progpoe_part1.PRogPOE_Part1.password;//importing a static variable so I can use it directly 
import static com.mypoeproject.progpoe_part1.PRogPOE_Part1.username;//importing a static variable so I can use it directly 
import static com.mypoeproject.progpoe_part1.PRogPOE_Part1.input;//importing a static variable so I can use it directly 
import java.util.Scanner;
public class LogIn{
static String usernameInput;
static String passwordInput;
public static void logIn(){
        System.out.print("Enter your username: ");
         usernameInput = input.nextLine();
        
        System.out.print("Enter your password: ");
        passwordInput = input.nextLine();
        //if the user enters a name and password that is identical to the one they entered when registering then it would welcome them back using the registered firstname and lastname
        if(usernameInput.equals(username) && passwordInput.equals(password)){ 
            System.out.println("LogIn Successful Welcome back " +firstName +" "+ lastName+ " it's grat to see you again");
            messaging();
        }else {
        System.out.println("username or password incorrect, please try again");
        }
    }
}


            