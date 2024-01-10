package example_greet_server;

import java.net.*;
import java.io.*;

/**
 * This project is a basic example of how to use sockets to communicate a client-
 * server application. Regarding the server, it just waits for a message, prints
 * it in the console, and answers with a "Goodbye" message.
 */
public class Greet_Server {
    public static void main(String[] args) {
        try (
                ServerSocket server = new ServerSocket(2000);
                Socket service = server.accept();
                DataInputStream socketIn = new DataInputStream(service.getInputStream());
                DataOutputStream socketOut = new DataOutputStream(service.getOutputStream());
        ) {
            // Read the message from the client
            String message = socketIn.readUTF();
            // Print the message
            System.out.println("Received: " + message);
            // Answer goodbye to the client
            socketOut.writeUTF("Goodbye");

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
