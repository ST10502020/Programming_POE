/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mypoeproject.progpoe_part1;

import static com.mypoeproject.progpoe_part1.PRogPOE_Part1.input;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/**
 *
 * @author corle
 */
public class Stored_Messages {
    public static void viewStoredMessages(){
        
        int viewStored = 0;
        while(viewStored != 4){

    System.out.println("1 - View Messages");
    System.out.println("2 - Search function");
    System.out.println("3 - Delete Message");
    System.out.println("4 - Back");

    System.out.println("Enter option");
    viewStored = input.nextInt();
    input.nextLine();

    if(viewStored == 1){
        view();
    }else if(viewStored == 2){
        search();
    }else if(viewStored == 3){
        deleteMessage();
    }else if(viewStored == 4){
        System.out.println("Returning...");
    }else{
        System.out.println("Invalid option");
    }
        }
    }
    
        public static void view(){
            if(Messaging.storedMessages.length() == 0){
            System.out.println("No messages found");
        }else{

            for(int i = 0; i < Messaging.storedMessages.length(); i++){

                JSONObject obj = Messaging.storedMessages.getJSONObject(i);

                System.out.println("Message ID: " + obj.getString("messageId"));
                System.out.println("Sender: " + obj.getString("sender"));
                System.out.println("Recipient: " + obj.getString("recipient"));
                System.out.println("Message: " + obj.getString("message"));
                System.out.println("Hash: " + obj.getString("messageHash"));
                System.out.println("--------------------------------");
        }
        }
}
        
        public static void search(){
            
            System.out.println("Would you like to search for: ");
            System.out.println("1 - The longest message");
            System.out.println("2 - Use message ID to display recipient and message");
            System.out.println("3 - Use recipient phone number to search for all messages");
            System.out.println("4 - Display a report that lists the full details  of the stored messages");
            
            System.out.println("Enter your option");
            int searchOpt = input.nextInt();
            input.nextLine();
            
            if(searchOpt == 1){
                longestMessage();
            }else if(searchOpt == 2){
                searchID();
            }else if(searchOpt == 3){
                searchRecipient();
            }else if(searchOpt == 4){
                messageReport();
            }else{
                System.out.println("Invalid option");
            }
        }
        public static void longestMessage(){

    // Check if there are stored messages
        if(Messaging.storedMessages.length() == 0){

        System.out.println("No messages found");
        return;
        }

    // Assume first message is longest
        JSONObject longest = Messaging.storedMessages.getJSONObject(0);

    // Loop through all messages
    for(int i = 1; i < Messaging.storedMessages.length(); i++){

        JSONObject current = Messaging.storedMessages.getJSONObject(i);

        // Compare message lengths
        if(current.getString("message").length() >
           longest.getString("message").length()){

            longest = current;
        }
    }

    // Display longest message
    System.out.println("Longest Stored Message");
    System.out.println("----------------------");
    System.out.println("Message ID: " + longest.getString("messageId"));
    System.out.println("Sender: " + longest.getString("sender"));
    System.out.println("Recipient: " + longest.getString("recipient"));
    System.out.println("Message: " + longest.getString("message"));
    System.out.println("Hash: " + longest.getString("messageHash"));
    System.out.println("Character Length: " + longest.getString("message").length());
     }
        
        public static void searchID(){

    System.out.print("Enter message ID: ");
    String searchId = input.nextLine();

    boolean found = false;

    for(int i = 0; i < Messaging.storedMessages.length(); i++){

        JSONObject obj = Messaging.storedMessages.getJSONObject(i);

        // Compare entered ID with stored ID
        if(obj.getString("messageId").equals(searchId)){

            System.out.println("Message Found");
            System.out.println("-------------------");
            System.out.println("Recipient: " + obj.getString("recipient"));
            System.out.println("Message: " + obj.getString("message"));

            found = true;
            break;
        }
    }

    if(!found){

        System.out.println("Message ID not found");
    }
}
        public static void searchRecipient(){

    System.out.print("Enter recipient phone number: ");
    String recipientSearch = input.nextLine();

    boolean found = false;

    System.out.println("Messages sent to: " + recipientSearch);
    System.out.println("-----------------------------------");

    for(int i = 0; i < Messaging.storedMessages.length(); i++){

        JSONObject obj = Messaging.storedMessages.getJSONObject(i);

        // Check if recipient matches
        if(obj.getString("recipient").equals(recipientSearch)){

            System.out.println("Message ID: " + obj.getString("messageId"));
            System.out.println("Sender: " + obj.getString("sender"));
            System.out.println("Message: " + obj.getString("message"));
            System.out.println("Hash: " + obj.getString("messageHash"));
            System.out.println("--------------------------------");

            found = true;
        }
    }

    if(!found){

        System.out.println("No messages found for this recipient");
    }
}
        public static void messageReport(){

    // Check if messages exist
    if(Messaging.storedMessages.length() == 0){

        System.out.println("No stored messages found");
        return;
    }

    System.out.println("FULL MESSAGE REPORT");
    System.out.println("================================================");

    // Loop through all stored messages
    for(int i = 0; i < Messaging.storedMessages.length(); i++){

        JSONObject obj = Messaging.storedMessages.getJSONObject(i);

        System.out.println("Message Number: " + (i + 1));
        System.out.println("Message ID: " + obj.getString("messageId"));
        System.out.println("Sender: " + obj.getString("sender"));
        System.out.println("Recipient: " + obj.getString("recipient"));
        System.out.println("Message: " + obj.getString("message"));
        System.out.println("Message Hash: " + obj.getString("messageHash"));
        System.out.println("Message Length: " + obj.getString("message").length());

        System.out.println("------------------------------------------------");
    }

    System.out.println("Total Messages: " + Messaging.storedMessages.length());
}
        
        public static void deleteMessage(){


    if(Messaging.storedMessages.length() == 0){

        System.out.println("No messages to delete");
        return;
    }

    // Display all message hashes
    for(int i = 0; i < Messaging.storedMessages.length(); i++){

        JSONObject obj = Messaging.storedMessages.getJSONObject(i);

        System.out.println("Hash: " + obj.getString("messageHash")+ " | Recipient: " + obj.getString("recipient")+ " | Message: " + obj.getString("message"));
    }

    System.out.print("Enter message hash to delete: ");
    String hashInput = input.nextLine();

    boolean found = false;

    for(int i = 0; i < Messaging.storedMessages.length(); i++){

        JSONObject obj = Messaging.storedMessages.getJSONObject(i);

        if(obj.getString("messageHash").equals(hashInput)){

            Messaging.storedMessages.remove(i);

            try {

                FileWriter file = new FileWriter("messages.json");

                file.write(Messaging.storedMessages.toString(4));

                file.close();

            } catch(IOException e){

                System.out.println("Error updating file");
            }

            System.out.println("Message deleted successfully");
            found = true;
            break;
        }
    }

    if(!found){
        System.out.println("Message hash not found");
    }
}
}