
package com.mypoeproject.progpoe_part1;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class part3Testing {

    @BeforeEach
    public void setup(){

        // Clear previous messages
        Messaging.storedMessages.clear();

        // Message 1
        JSONObject msg1 = new JSONObject();
        msg1.put("messageId", "1001");
        msg1.put("sender", "Developer");
        msg1.put("recipient", "+27834557896");
        msg1.put("message", "Did you get the cake?");
        msg1.put("messageHash", "10:1:CAKE");
        msg1.put("flag", "Sent");

        // Message 2
        JSONObject msg2 = new JSONObject();
        msg2.put("messageId", "1002");
        msg2.put("sender", "Developer");
        msg2.put("recipient", "+27838884567");
        msg2.put("message",
                "Where are you? You are late! I have asked you to be on time.");
        msg2.put("messageHash", "10:2:LATE");
        msg2.put("flag", "Stored");

        // Message 3
        JSONObject msg3 = new JSONObject();
        msg3.put("messageId", "1003");
        msg3.put("sender", "Developer");
        msg3.put("recipient", "+27834484567");
        msg3.put("message", "Yohoooo, I am at your gate.");
        msg3.put("messageHash", "10:3:GATE");
        msg3.put("flag", "Disregard");

        // Message 4
        JSONObject msg4 = new JSONObject();
        msg4.put("messageId", "0838884567");
        msg4.put("sender", "Developer");
        msg4.put("recipient", "0838884567");
        msg4.put("message", "It is dinner time !");
        msg4.put("messageHash", "10:4:DINNER");
        msg4.put("flag", "Sent");

        // Message 5
        JSONObject msg5 = new JSONObject();
        msg5.put("messageId", "1005");
        msg5.put("sender", "Developer");
        msg5.put("recipient", "+27838884567");
        msg5.put("message", "Ok, I am leaving without you.");
        msg5.put("messageHash", "10:5:LEAVING");
        msg5.put("flag", "Stored");

        // Add messages
        Messaging.storedMessages.put(msg1);
        Messaging.storedMessages.put(msg2);
        Messaging.storedMessages.put(msg3);
        Messaging.storedMessages.put(msg4);
        Messaging.storedMessages.put(msg5);
    }

    // =========================================
    // Test 1
    // Sent Messages array correctly populated
    // =========================================
    @Test
    public void testSentMessagesArray(){

        String firstMessage =
                Messaging.storedMessages
                .getJSONObject(0)
                .getString("message");

        String fourthMessage =
                Messaging.storedMessages
                .getJSONObject(3)
                .getString("message");

        assertEquals("Did you get the cake?", firstMessage);

        assertEquals("It is dinner time !", fourthMessage);
    }

    // =========================================
    // Test 2
    // Display longest message
    // =========================================
    @Test
    public void testLongestMessage(){

        JSONObject longest =
                Messaging.storedMessages.getJSONObject(0);

        for(int i = 1;
            i < Messaging.storedMessages.length();
            i++){

            JSONObject current =
                    Messaging.storedMessages.getJSONObject(i);

            if(current.getString("message").length() >
               longest.getString("message").length()){

                longest = current;
            }
        }

        assertEquals(
            "Where are you? You are late! I have asked you to be on time.",
            longest.getString("message")
        );
    }

    // =========================================
    // Test 3
    // Search for message ID
    // =========================================
    @Test
    public void testSearchMessageID(){

        String foundMessage = "";

        for(int i = 0;
            i < Messaging.storedMessages.length();
            i++){

            JSONObject obj =
                    Messaging.storedMessages.getJSONObject(i);

            if(obj.getString("messageId")
                    .equals("0838884567")){

                foundMessage =
                        obj.getString("message");
            }
        }

        assertEquals(
            "It is dinner time !",
            foundMessage
        );
    }

    // =========================================
    // Test 4
    // Search all messages for recipient
    // =========================================
    @Test
    public void testSearchRecipientMessages(){

        String results = "";

        for(int i = 0;
            i < Messaging.storedMessages.length();
            i++){

            JSONObject obj =
                    Messaging.storedMessages.getJSONObject(i);

            if(obj.getString("recipient")
                    .equals("+27838884567")){

                results += obj.getString("message") + " ";
            }
        }

        assertEquals(
            "Where are you? You are late! I have asked you to be on time. " +
            "Ok, I am leaving without you. ",
            results
        );
    }

// =========================================
// Test 5
// Delete a message using message hash
// =========================================
@Test
public void testDeleteByHash(){

    boolean deleted = false;

    for(int i = 0;
        i < Messaging.storedMessages.length();
        i++){

        JSONObject obj =
                Messaging.storedMessages.getJSONObject(i);

        // Test Message 2
        if(obj.getString("messageHash")
                .equals("10:2:LATE")){

            String deletedMessage =
                    obj.getString("message");

            Messaging.storedMessages.remove(i);

            deleted = true;

            assertEquals(
                "Where are you? You are late! I have asked you to be on time.",
                deletedMessage
            );

            break;
        }
    }

    assertTrue(deleted);
}

// =========================================
// Test 6
// Display Report
// =========================================
@Test
public void testDisplayReport(){

    String report = "";

    for(int i = 0;
        i < Messaging.storedMessages.length();
        i++){

        JSONObject obj =
                Messaging.storedMessages.getJSONObject(i);

        report +=
                "Hash: " +
                obj.getString("messageHash") +
                "\nRecipient: " +
                obj.getString("recipient") +
                "\nMessage: " +
                obj.getString("message") +
                "\n\n";
    }

    // Check report contains required fields
    assertTrue(report.contains("Hash:"));
    assertTrue(report.contains("Recipient:"));
    assertTrue(report.contains("Message:"));

    // Check report contains expected message
    assertTrue(report.contains("Did you get the cake?"));
}

}
