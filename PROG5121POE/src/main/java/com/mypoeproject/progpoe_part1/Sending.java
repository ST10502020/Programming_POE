/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mypoeproject.progpoe_part1;

/**
 *
 * @author corle
 */
import java.util.Scanner;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public class Sending {
    static String recipientNum;
    public static void sendMessage(){
        Scanner input = new Scanner(System.in);
        System.out.println(" ");
        System.out.print("Enter the recipients phone number: ");
            String plus = "+";
	    recipientNum= "            ";
	    String interDigitCode = " ";

	    recipientNum = interDigitCode +" ";
	    final int CELL_NUM = 10; //maximum character length for cellNum is 10
	    do{//loop while cellphone length is greater than declared CELL_NUM OR international digit code does not contain a +
	    System.out.println("");
	    System.out.println("Your international digit code should start with a '+'");
	    System.out.print("Enter international digit code: ");
	    interDigitCode = input.nextLine();
	    System.out.println("");
	    System.out.print("Enter your cellphone number: " + interDigitCode);
	    recipientNum = input.nextLine();
	    System.out.println("");
	    if(recipientNum.length() > CELL_NUM || !interDigitCode.contains(plus)){//show error if cellphone length is greater than declared CELL_NUM OR international digit code does not contain a +
	        System.out.println("Cellphone number incorrectly formatted or does not have international digit code.");
	    }
	    }while(recipientNum.length() > CELL_NUM || !interDigitCode.contains(plus));
	    System.out.println("Cellphone number successfully added");
            
        System.out.println("");
        System.out.print("How many messages do you want to send: ");
        int messageNum = input.nextInt();
        input.nextLine();
        
        String[] messageId = new String[messageNum];
        String[] message = new String[messageNum];
        Random random = new Random();
        JSONArray messagesArray = new JSONArray();
        
        for(int index = 0; index < messageNum; index++){
            long randomId = 1000000000L + (long)(random.nextDouble() * 9000000000L);
            messageId[index] = String.valueOf(randomId);
            System.out.println(" ");
            
            System.out.println("Enter message " + (index +1) + ": ");
            message[index] = input.nextLine();
            
            
            
            while(message[index].length() > 250 ){
                System.out.println("Please Enter a message less than 250 characters");
                message[index] = input.nextLine();
            }
            System.out.println("message Sent");
            String[] words = message[index].split(" ");
            String firstWord = words[0];
            String lastWord = words[words.length - 1];
            String hashWords = firstWord.toUpperCase() + lastWord.toUpperCase();
            
            String hashNums = messageId[index].substring(0,2);
            
            String messageHash = hashNums + ":" +(index + 1) + ":" + hashWords;
            System.out.println(messageHash);
            
            JSONObject messageObject = new JSONObject();
            messageObject.put("messageId", messageId[index]);
            messageObject.put("recipient", recipientNum);
            messageObject.put("message", message[index]);
            messageObject.put("messageHash", messageHash);
            messagesArray.put(messageObject);
        }
        
        System.out.println(messagesArray.toString(4));
        System.out.println("You have sent: " + messageNum + " messages");
    }
}
