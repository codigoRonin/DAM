/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise_multicastmessage_server;

import java.net.*;
import java.util.Scanner;

/**
 * Multicast project where the server asks the user to Enter messages, and then
 * it sends them to all the clients connected to a multicast group
 */
public class MulticastMessage_Server 
{
    public static final int PORT = 6000;
    public static final String HOST = "225.0.0.1";
    
    public static void main(String[] args) 
    {
        String message = "";
        
        try (
            MulticastSocket ms = new MulticastSocket(PORT);
            Scanner in = new Scanner(System.in);
        )
        {
            InetAddress group = InetAddress.getByName(HOST);
            ms.joinGroup(group);
            
            while (!message.trim().equals("finish")) 
            {
                System.out.println("Enter a message for the group: ");
                message = in.nextLine();

                DatagramPacket packet = new DatagramPacket(message.getBytes(), 
                        message.length(), group, PORT);

                ms.send(packet);
            }
            
            ms.leaveGroup(group);
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
