package example_greetudp_server;

import java.net.*;
import java.io.*;

/**
 * This project is a basic example of how to use UDP sockets to communicate a
 * client-server application. Regarding the server, it receives a message from the
 * client and sends a "Goodbye" to it.
 */
public class GreetUDP_Server {
    public static void main(String[] args) {
        try (DatagramSocket mySocket = new DatagramSocket(2000, InetAddress.getLocalHost())) {
            // Receive the response
            byte[] buffer = new byte[1024];
            DatagramPacket packetR = new DatagramPacket(buffer, buffer.length);
            mySocket.receive(packetR);
            System.out.println("Received: " + new String(packetR.getData()).trim());

            // Get host and port from the message
            int destPort = packetR.getPort();
            InetAddress destAddr = packetR.getAddress();

            // Create the packet to be sent
            String text = "Goodbye";
            byte[] message = text.getBytes();
            DatagramPacket packetS = new DatagramPacket(message, message.length, destAddr, destPort);
            mySocket.send(packetS);

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
