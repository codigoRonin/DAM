package example_greetudp_client;

import java.io.*;
import java.net.*;

/**
 * This project is a basic example of how to use UDP sockets to communicate a
 * client-server application. Regarding the client, it just connects to the server,
 * sends a "Hello" message to it, waits for a response and prints it in the console
 */
public class GreetUDP_Client {
    public static void main(String[] args) {
        try (DatagramSocket mySocket = new DatagramSocket()) {
            // Create the packet to be sent
            String text = "Hello";
            byte[] message = text.getBytes();
            DatagramPacket packetS = new DatagramPacket(message, message.length, InetAddress.getLocalHost(), 2000);
            mySocket.send(packetS);

            // Receive the response
            byte[] buffer = new byte[1024];
            DatagramPacket packetR = new DatagramPacket(buffer, buffer.length);
            mySocket.receive(packetR);
            System.out.println("Received: " + new String(packetR.getData()).trim());

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
