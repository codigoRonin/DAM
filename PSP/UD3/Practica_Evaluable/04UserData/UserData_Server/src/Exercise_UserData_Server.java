
import java.io.*;
import java.net.*;
import userdata.model.User;

/**
 * A client-server application that sends a User object to the client to fill
 * the data, and then it sends it back to the server to show it
 */
public class Exercise_UserData_Server 
{
    public static final int PORT = 6000;
    
    User regUser;
    
    public static void main(String[] args) 
    {
        try (
            ServerSocket server = new ServerSocket(PORT);            
            Socket service = server.accept();
            ObjectOutputStream socketOut = new ObjectOutputStream(service.getOutputStream());
            ObjectInputStream socketIn = new ObjectInputStream(service.getInputStream());
        )
        {

            // Create a user object and send it to the client
            User u = new User();
            socketOut.writeObject(u);
            
            // Read the user object from the client and print it
            u = (User)(socketIn.readObject());
            System.out.println(u);
            
        } catch (Exception e) {
            System.err.println(e);
        }
        
    }
    
}
