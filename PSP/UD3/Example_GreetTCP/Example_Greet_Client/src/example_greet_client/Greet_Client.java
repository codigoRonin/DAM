package example_greet_client;

import java.io.*;
import java.net.*;

/**
 * This project is a basic example of how to use sockets to communicate a
 * client-server application. Regarding the client, it just connects to the server,
 * sends a "Hello" message to it, waits for a response and prints it in the console
 */
public class Greet_Client {

  public static void main(String[] args) {
    try (
      Socket mySocket = new Socket("localhost", 2000);
      DataInputStream socketIn = new DataInputStream(mySocket.getInputStream());
      DataOutputStream socketOut = new DataOutputStream(
        mySocket.getOutputStream()
      );
    ) {
      socketOut.writeUTF("Hello");
      String response = socketIn.readUTF();
      System.out.println("Received: " + response);
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
