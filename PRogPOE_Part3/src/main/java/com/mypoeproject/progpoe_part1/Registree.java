/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mypoeproject.progpoe_part1;



/**
 *
 * @author corle
 */

import static com.mypoeproject.progpoe_part1.PRogPOE_Part1.cellNumbers;
import static com.mypoeproject.progpoe_part1.PRogPOE_Part1.firstNames;
import static com.mypoeproject.progpoe_part1.PRogPOE_Part1.input;
import static com.mypoeproject.progpoe_part1.PRogPOE_Part1.lastNames;
import static com.mypoeproject.progpoe_part1.PRogPOE_Part1.passwords;
import static com.mypoeproject.progpoe_part1.PRogPOE_Part1.usernames;
public class Registree{
   public static void registree(){
       
        //the maximum allowed length of the string of characters
		final int MAX_LENGTH = 5;
		
		//declare username and underscor
	        String username = "";
		String underscore = "_"; 
		
		//fullname is needed so it can say welcome "firstName & lastName"
		System.out.print("Enter First Name: ");
                String firstName = input.nextLine();
		System.out.print("Enter Last Name: ");
                String lastName = input.nextLine();
		
		//if username is greater than maxlength or does not contain underscore then loop runs
		while(username.length() > MAX_LENGTH  || !username.contains(underscore)){
		System.out.println(" ");//line spacing
		System.out.println("Username rules");//the user must know what details to input
		System.out.println("Username must not be longer than 5 characters");
		System.out.println("Username must contain an underscore (_)");
		System.out.print("Enter username: ");
	        username = input.nextLine();//username datatype is already delcared as static
	    
	    //.conatains checks whether what the user enters has the condition in the parameters
	    if(username.length() > MAX_LENGTH || !username.contains(underscore)){
        System.out.println("Username is not properly formatted please ensure that your username contains an underscore and is not more than five characters in length.");
           }
		}
		//exit loop when correct information is input
		
		       System.out.println("Username successfully captured");
                       System.out.println(" ");
        
	    //PASSWORD Code
                String password = "";
		final int PASSWORD = 8; //minimum number of characters in the password
		System.out.println("Password rules");//the user must know what details to input
		System.out.println("Password must at least eight characters long.");
		System.out.println("Password must contain a capital letter.");
		System.out.println("Password must contain a number.");
		System.out.println("Password must contain a special character. eg.!@#$%");
		
		//do while loop instead of while loop since it's easier to manage 
		do{//loop if password length is less than 8 characters OR password does not contain a capital letter OR does not contain a number OR does not contain a special character
		System.out.println("");
		System.out.print("Enter password: ");
		password = input.nextLine();
		//matches(".*[A-Z].*") checks whether the string has a capital letter, matches(".*\\d.*") checks whether the string contains a number, matches(".*[^a-zA-Z0-9 ].*") checks whether the string has special characters
		if(password.length()< PASSWORD || !password.matches(".*[A-Z].*") || !password.matches(".*\\d.*") || !password.matches(".*[^a-zA-Z0-9 ].*")){
		System.out.println("Password is not properly formatted please ensure that the password contains atleast 8 characters, a capital letter, a number, and a special character.");
		}
		}while(password.length() < PASSWORD || !password.matches(".*[A-Z].*") || !password.matches(".*\\d.*") || !password.matches(".*[^a-zA-Z0-9 ].*"));
		System.out.println(" ");
		System.out.println("Password is successfully captured");
		
		
		//CELLPHONE NUMBER code
		//declarations
	    String plus = "+";
	    String cellNum= "            ";
	    String interDigitCode = " ";

	    cellNum = interDigitCode +" ";
	    final int CELL_NUM = 10; //maximum character length for cellNum is 10
	    do{//loop while cellphone length is greater than declared CELL_NUM OR international digit code does not contain a +
	    System.out.println("");
	    System.out.println("Your international digit code should start with a '+'");
	    System.out.print("Enter international digit code: ");
	    interDigitCode = input.nextLine();
	    System.out.println("");
	    System.out.print("Enter your cellphone number: " + interDigitCode);
	    cellNum = input.nextLine();
	    System.out.println("");
	    if(cellNum.length() > CELL_NUM || !interDigitCode.contains(plus)){//show error if cellphone length is greater than declared CELL_NUM OR international digit code does not contain a +
	        System.out.println("Cellphone number incorrectly formatted or does not have international digit code.");
	    }
	    }while(cellNum.length() > CELL_NUM || !interDigitCode.contains(plus));
	    System.out.println("Cellphone number successfully added");
            
            if(username.length() <= MAX_LENGTH && username.contains(underscore) && password.length() >= PASSWORD && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[^a-zA-Z0-9 ].*") && cellNum.length() < CELL_NUM && interDigitCode.contains(plus)){
                System.out.println(" ");
                System.out.println("Registration successful");
            }
            usernames.add(username);
            passwords.add(password);
            firstNames.add(firstName);
            lastNames.add(lastName);
            cellNumbers.add(cellNum);
    }     
}