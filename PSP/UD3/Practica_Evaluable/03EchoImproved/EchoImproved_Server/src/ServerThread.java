

import java.io.*;
import java.net.*;

/**
 * Thread to handle each client connection individually
 */
public class ServerThread extends Thread
{
    Socket service;
    
    public ServerThread(Socket s)
    {
        service = s;
    }
    
    @Override
    public void run()
    {
        DataInputStream socketIn = null;
        DataOutputStream socketOut = null;
        
        try 
        {
            socketIn = new DataInputStream(service.getInputStream());
            socketOut = new DataOutputStream(service.getOutputStream());
            
            String line; 
            do {
                // Read message from the client
                line = socketIn.readUTF();
                System.out.println("Read: " + line);
                
                // Send it back in uppercase
                socketOut.writeUTF(line.toUpperCase());

            }while (!line.equals("bye")); // If message is "bye", we finish the communication process


        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (socketOut != null)
                    socketOut.close();
            } catch (IOException ex) {}
            try {            
                if (socketIn != null)
                    socketIn.close();
            } catch (IOException ex) {}
            try {            
                if (service != null)
                    service.close();
            } catch (IOException ex) {}
        }
        
    }
    
}