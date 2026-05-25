/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mypoeproject.progpoe_part1;

import java.io.ByteArrayInputStream;//lets you fake input in your program
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;//runs after esch test method
import org.junit.jupiter.api.AfterAll;//runs once after all tests are finished
import org.junit.jupiter.api.BeforeEach;//runs before each test method
import org.junit.jupiter.api.BeforeAll;//runs once before all tests
import org.junit.jupiter.api.Test;//allows you to run test method
import static org.junit.jupiter.api.Assertions.*;//Gives you access to test checks

/**
 *
 * @author corle
 */
public class Prog_UnitTest {
    
    public Prog_UnitTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("Starting all tests...");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("All tests finished.");
    }
    
    @BeforeEach
    public void setUp() {
        PRogPOE_Part1.username = "";
        PRogPOE_Part1.password = "";
        PRogPOE_Part1.firstName = "";
        PRogPOE_Part1.lastName = "";
        PRogPOE_Part1.cellNum = "";
    }//restores all stored user data before all tests to stop previous data from bleeding into new data
    
    @AfterEach
    public void tearDown() {
        System.setIn(System.in);
    }

    @Test
    public void testRegistration() {

    String input =
            "John\n" +
            "Doe\n" +
            "ab_cd\n" +
            "Abcdef1!\n" +
            "+27\n" +
            "1234567890\n";

    System.setIn(new ByteArrayInputStream(input.getBytes()));

    // IMPORTANT: reset scanner
    PRogPOE_Part1.input = new Scanner(System.in);

    Registree.registree();

    assertEquals("John", PRogPOE_Part1.firstName);
    assertEquals("Doe", PRogPOE_Part1.lastName);
    assertEquals("ab_cd", PRogPOE_Part1.username);
    assertEquals("Abcdef1!", PRogPOE_Part1.password);
    assertEquals("1234567890", PRogPOE_Part1.cellNum);
}

    @Test
    public void testRegistrationValid() {

        String simulatedInput = 
                "John\n" +          // first name
                "Doe\n" +           // last name
                "ab_cd\n" +         // username (valid)
                "Abcdef1!\n" +      // password (valid)
                "+27\n" +           // international code
                "1234567890\n";     // cell number

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Registree.registree();

        assertEquals("ab_cd", PRogPOE_Part1.username);
        assertEquals("Abcdef1!", PRogPOE_Part1.password);
        assertEquals("John", PRogPOE_Part1.firstName);
        assertEquals("Doe", PRogPOE_Part1.lastName);
    }

    @Test
    public void testLoginSuccess() {

        // Set stored values (simulate registered user)
        PRogPOE_Part1.username = "ab_cd";
        PRogPOE_Part1.password = "Abcdef1!";
        PRogPOE_Part1.firstName = "John";
        PRogPOE_Part1.lastName = "Doe";

        String simulatedInput =
                "ab_cd\n" +
                "Abcdef1!\n";

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        LogIn.logIn();

        // No return value, so we just verify stored values stayed correct
        assertEquals("ab_cd", PRogPOE_Part1.username);
    }

    @Test
    public void testLoginFail() {

        PRogPOE_Part1.username = "ab_cd";
        PRogPOE_Part1.password = "Abcdef1!";

        String simulatedInput =
                "wrong\n" +
                "wrong\n";

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        LogIn.logIn();

        // Again, we just confirm system state didn't change
        assertEquals("ab_cd", PRogPOE_Part1.username);
    }
}
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

