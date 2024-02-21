package exercise_multicastmessage_client;

import java.net.*;

/**
 * Multicast project where the server asks the user to Enter messages, and then
 * it sends them to all the clients connected to a multicast group
 */
public class MulticastMessage_Client 
{
    public static final int PORT = 6000;
    public static final String HOST = "225.0.0.1";
    
    public static void main(String[] args) 
    {                
        try (MulticastSocket ms = new MulticastSocket(PORT))
        {
            InetAddress group = InetAddress.getByName(HOST);
            ms.joinGroup(group);

            String msg="";
            byte[] buf;
            while(!msg.trim().equals("finish")) 
            {
                buf = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                ms.receive(packet);
                msg = new String(packet.getData());
                System.out.println("Received: " + msg.trim());
            }
            
            ms.leaveGroup(group);
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
