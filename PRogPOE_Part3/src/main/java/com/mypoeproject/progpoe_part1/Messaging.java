/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mypoeproject.progpoe_part1;

/**
 *
 * @author corle
 */



import static com.mypoeproject.progpoe_part1.PRogPOE_Part1.input;
import static com.mypoeproject.progpoe_part1.Sending.sendMessage;
import static com.mypoeproject.progpoe_part1.Stored_Messages.viewStoredMessages;

import org.json.JSONArray;

public class Messaging {
    static JSONArray storedMessages = new JSONArray();

    public static void messaging(){
    
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
        input.nextLine();
        System.out.println(" ");
        if(action == 1){
        sendMessage();
        }else if(action == 2){
        viewStoredMessages();
        }else if(action == 3){
        System.out.println("Goodbye and come again");
        }else{
    System.out.println("Invalid option");
}
}
}
}
