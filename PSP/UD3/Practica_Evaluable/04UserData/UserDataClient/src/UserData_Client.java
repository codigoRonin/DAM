
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import userdata.model.User;

/**
 * A client-server application that sends a User object to the client to fill
 * the data, and then it sends it back to the server to show it
 */
public class UserData_Client 
{
    public static final int PORT = 6000;
    public static final String HOST = "localhost";
    public static void main(String[] args) 
    {
        try (
            Socket mySocket = new Socket(HOST, PORT);
            ObjectInputStream socketIn = new ObjectInputStream(mySocket.getInputStream());
            ObjectOutputStream socketOut = new ObjectOutputStream(mySocket.getOutputStream());
            Scanner in = new Scanner(System.in);
        )
        {
            // Connect to the server port number, in a given address (for instance, "localhost")
            
            // Read user data from the server
            User u = (User)(socketIn.readObject());
            // Fill user data
            System.out.println("Enter your login: ");
            u.setLogin(in.nextLine());
            System.out.println("Enter your password: ");
            u.setPassword(in.nextLine());
            
            // Send user data to back to the server
            socketOut.writeObject(u);

        } catch (Exception e) {
            System.err.println(e);
        }        
    }
    
}
