
import auction.model.Client;
import auction.model.Product;
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Client side of the auction application. It will receive product information,
 * send a bid and get the final results
 */
public class Auction_Client 
{
    public static final int PORT = 6000;
    
    public static void main(String[] args) 
    {
        Scanner sc = null;
        
        try (DatagramSocket socket = new DatagramSocket())
        {
            sc = new Scanner(System.in);

            // Send a message to server, in order to connect
            DatagramPacket packet = new DatagramPacket("Hello".getBytes(), "Hello".length(), InetAddress.getLocalHost(), PORT);
            socket.send(packet);
            
            System.out.println("Connected. Waiting for product info...");

            // Get product info
            byte[] bytes = new byte[1024];
            packet = new DatagramPacket(bytes, bytes.length);
            socket.receive(packet);
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream in = new ObjectInputStream(bis);
            Product product = (Product)(in.readObject());
            
            System.out.println("Product name: " + product.getName());
            System.out.println("Product initial price: " + product.getPrice());
            
            System.out.println("Enter your name and bid, separated by a whitespace:");
            String message = sc.nextLine();
            
            // Send bid to server
            packet = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getLocalHost(), PORT);
            socket.send(packet);
            
            // Wait for results
            bytes = new byte[1024];
            packet = new DatagramPacket(bytes, bytes.length);
            socket.receive(packet);
            bis = new ByteArrayInputStream(bytes);
            in = new ObjectInputStream(bis);
            Client winner = (Client)(in.readObject());
            
            System.out.println("Final price: " + winner.getBid() + " euros");
            System.out.println("Buyer's name: " + winner.getName());
            

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        
        
    }
}
