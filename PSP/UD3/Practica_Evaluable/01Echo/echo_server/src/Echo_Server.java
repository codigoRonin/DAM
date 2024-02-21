
import java.net.*;
import java.io.*;

/**
 * This is an echo client-server application. The server waits for client's
 * messages (until it types "bye") and sends the messages back to the client
 * converted into uppercase
 */
public class Echo_Server {
    public static final int PORT = 6000;

    public static void main(String[] args) {
        try (
                ServerSocket server = new ServerSocket(PORT);
                Socket service = server.accept();
                DataInputStream socketIn = new DataInputStream(service.getInputStream());
                DataOutputStream socketOut = new DataOutputStream(service.getOutputStream());
        ) {
            String line="";
            do {
                // Read message from the client
                line = socketIn.readUTF();
                System.out.println("Read: " + line);
                // Send it back in uppercase
                socketOut.writeUTF(line.toUpperCase());
                // If message is "bye", we finish the communication process
            } while (!line.equals("bye"));
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}