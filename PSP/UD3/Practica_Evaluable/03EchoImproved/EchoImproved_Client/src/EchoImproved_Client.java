
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * An improved version of the "Echo" project, with a client that connects
 * to a server regardless its location, and a server that allows multiple
 * clients
 */
public class EchoImproved_Client 
{
    public static final int PORT = 6000;

    public static void main(String[] args) 
    {
        InetAddress server = null;

        try (
            Scanner in = new Scanner(System.in);  
        )
        {
            System.out.println("Enter the server address: ");
            server = InetAddress.getByName(in.nextLine());
            
            try (
                Socket mySocket = new Socket(server, PORT);
                DataInputStream socketIn = new DataInputStream(mySocket.getInputStream());
                DataOutputStream socketOut = new DataOutputStream(mySocket.getOutputStream());
            )
            {
                String line; 
                do
                {
                    // Read message from keyboard
                    line = in.nextLine();
                    // Send message to server
                    socketOut.writeUTF(line);
                    // Read response from server
                    line = socketIn.readUTF();
                    // Print response
                    System.out.println("Response : " + line);

                } while (!line.equals("BYE"));  // If client writes "bye", the communication finishes
            } catch (IOException e) {
                System.err.println(e);
            }
        } catch (UnknownHostException ex) {
            System.err.println("Unknown host: " + ex.getMessage());
            System.exit(-1);
        }
    }    
}
