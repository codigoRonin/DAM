
import java.io.*;
import java.net.*;

/**
 * An improved version of the "Echo" project, with a client that connects
 * to a server regardless its location, and a server that allows multiple
 * clients
 */
public class EchoImproved_Server 
{
    public static final int PORT = 6000;

    public static void main(String[] args) 
    {    
        try (ServerSocket server = new ServerSocket(PORT))
        {
            System.out.println("Listening...");
            while (true)
            {
                Socket service = server.accept();
                System.out.println("Connection established");
                ServerThread st = new ServerThread(service);
                st.start();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }        
}
