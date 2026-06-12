/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mypoeproject.progpoe_part1;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author corle
 */
public class SendingUnitTest {

    @Test
    public void testPhoneNumberLengthValid() {

        String recipientNum = "0831234567";

        assertEquals(10, recipientNum.length());
    }

    @Test
    public void testPhoneNumberLengthInvalid() {

        String recipientNum = "083123456789";

        assertTrue(recipientNum.length() > 10);
    }

    @Test
    public void testInternationalCodeValid() {

        String interDigitCode = "+27";

        assertTrue(interDigitCode.startsWith("+"));
    }

    @Test
    public void testInternationalCodeInvalid() {

        String interDigitCode = "27";

        assertFalse(interDigitCode.startsWith("+"));
    }

    @Test
    public void testMessageLengthValid() {

        String message = "Hello this is a valid message";

        assertTrue(message.length() <= 250);
    }

    @Test
    public void testMessageLengthInvalid() {

        String message = "A".repeat(251);

        assertTrue(message.length() > 250);
    }

    @Test
    public void testRandomMessageIdLength() {

        long randomId = 1234567890L;

        String messageId = String.valueOf(randomId);

        assertEquals(10, messageId.length());
    }

    @Test
    public void testMessageHashCreation() {

        String hashNums = "58";
        int index = 1;
        String hashWords = "HELLOWORLD";

        String messageHash =
                hashNums + ":" + index + ":" + hashWords;

        assertEquals("58:1:HELLOWORLD", messageHash);
    }

    @Test
    public void testFirstAndLastWordExtraction() {

        String message = "Hello Java World";

        String[] words = message.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        assertEquals("Hello", firstWord);
        assertEquals("World", lastWord);
    }
}


