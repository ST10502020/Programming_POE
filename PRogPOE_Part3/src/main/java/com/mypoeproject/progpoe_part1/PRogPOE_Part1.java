/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mypoeproject.progpoe_part1;

/**
 *
 * @author corle
 */
import static com.mypoeproject.progpoe_part1.LogIn.logIn;
import static com.mypoeproject.progpoe_part1.Registree.registree;
import java.util.Scanner;
import java.util.ArrayList;

public class PRogPOE_Part1 {
        public static Scanner input = new Scanner(System.in);
        
        static ArrayList<String> usernames = new ArrayList<>();
        static ArrayList<String> passwords = new ArrayList<>();
        static ArrayList<String> firstNames = new ArrayList<>();
        static ArrayList<String> lastNames = new ArrayList<>();
        static ArrayList<String> cellNumbers = new ArrayList<>();
    static Object firstName;
    static Object lastName;
    static Object username;
    static Object password;
    static Object cellNum;
       
    public static void main(String[] args) {
 
        int option = 0;
        //list of visible options so the user can know what they can choose
        
        while(option != 3){
        System.out.println("Options");
        System.out.println("1 - Register");
        System.out.println("2 - Log In");
        System.out.println("3 - Exit");
        System.out.print("Enter your option number: ");
        option = input.nextInt();
                input.nextLine();
        if(option == 1){
            //if user enters 1 it takes them to the registeration form
        registree();
        } else if(option == 2){
            //if user enters 2 it takes them to the log in form
        logIn();
        } else if(option == 3){
            //if user enters 3 it says goodbye and exits the form
         System.out.println("Goodbye!");
        } else {
            //any other number will result in an invalid option message and loop until the user enters one of the given options
        System.out.println("Invalid Option");
        }
    }
}
}
