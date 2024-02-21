package exercise_auction_server;

import auction.model.Client;
import java.net.*;
import auction.model.Product;
import java.io.*;
import java.util.*;

/**
 * Server side of the auction application. It will create a product, send it
 * to the 3 clients that will be connected, receive their bids and send the
 * final results
 */
public class Auction_Server 
{
    public static final int PORT = 6000;
    public static final int NUM_CLIENTS = 3;
    
    public static void main(String[] args) 
    {
        List<Client> clients = new ArrayList<>();
        // Create the product
        Product product = new Product("Xbox One", 100);
        
        try (DatagramSocket socket = new DatagramSocket(PORT, InetAddress.getLocalHost());)
        {            
            // Wait for 3 different clients to connect
            System.out.println("Waiting for clients...");
            while (clients.size() < NUM_CLIENTS)
            {
                try
                {
                    // Receive the connection
                    byte[] buffer = new byte[1024];
                    DatagramPacket packetR = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packetR);   
                    // Get host and port from the message
                    int destPort = packetR.getPort();
                    InetAddress destAddr = packetR.getAddress();

                    // Add a new client to the list, if the address does not exit
                    boolean exists = false;
                    for(int i = 0; i < clients.size() && !exists; i++)
                    {
                        if (clients.get(i).getAddress().equals(destAddr) && clients.get(i).getPort() == destPort)
                        {
                            exists = true;
                        }
                    }
                    if (!exists)
                    {
                        System.out.println("Client added");
                        clients.add(new Client(destAddr, destPort));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }

            System.out.println("Finished accepting clients");
            System.out.println("Sending product info");

            // Send product to each client
            for(Client c: clients)
            {
                try
                {
                    ByteArrayOutputStream bs = new ByteArrayOutputStream();
                    ObjectOutputStream objOut = new ObjectOutputStream(bs);
                    objOut.writeObject(product);
                    byte[] bytes = bs.toByteArray();
                    DatagramPacket packet = new DatagramPacket(bytes, bytes.length, c.getAddress(), c.getPort());
                    socket.send(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Finished sending product info");
            System.out.println("Getting bids");

            // Receive responses and assign names and bids to each client
            for (int i = 0; i < clients.size(); i++)
            {
                try
                {
                    byte[] buffer = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);
                    // Get host and port from the message
                    int destPort = packet.getPort();
                    InetAddress destAddr = packet.getAddress();
                    // Get and process the response
                    String data = new String(packet.getData()).trim();
                    System.out.println("Received bid: " + data);
                    String[] parts = data.split(" ");
                    Client c = null;
                    for (int j = 0; j < clients.size() && c==null; j++)
                    {
                        if (clients.get(j).getAddress().equals(destAddr) && clients.get(j).getPort() == destPort)
                            c = clients.get(j);
                    }
                    if (c != null)
                    {
                        System.out.println("Updating bid from " + parts[0]);
                        c.setName(parts[0]);
                        c.setBid(Float.parseFloat(parts[1]));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Finished getting bids");
            System.out.println("Calculating and sending results");


            // Get the maximum bid 
            Client maxClient = null;
            float maxBid = -1;
            for (Client c: clients)
            {
                if (c.getBid() > maxBid)
                {
                    maxClient = c;
                    maxBid = c.getBid();
                }
            }

            // Send information to the clients
            for(Client c: clients)
            {
                try
                {
                    ByteArrayOutputStream bs = new ByteArrayOutputStream();
                    ObjectOutputStream objOut = new ObjectOutputStream(bs);
                    objOut.writeObject(maxClient);
                    byte[] bytes = bs.toByteArray();
                    DatagramPacket packet = new DatagramPacket(bytes, bytes.length, c.getAddress(), c.getPort());
                    socket.send(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Finished");        
        
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
