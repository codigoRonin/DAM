
import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * This is an echo client-server application. The client sends messages to
 * the server and receives them in uppercase format. The communication finishes
 * when the client sends "bye" to the server
 */
public class Echo_Client {
    public static final String HOST = "localhost";
    public static final int PORT = 6000;

    public static void main(String[] args) {
        try (
                Socket mySocket = new Socket(HOST, PORT);
                DataInputStream socketIn = new DataInputStream(mySocket.getInputStream());
                DataOutputStream socketOut = new DataOutputStream(mySocket.getOutputStream());
                Scanner in = new Scanner(System.in);
        ) {
            String line;

            do {
                System.out.println("Write the echo message or \"bye\" to finish: ");
                // Read message from keyboard
                line = in.nextLine();
                // Send message to server
                socketOut.writeUTF(line);
                // Read response from server
                line = socketIn.readUTF();
                // Print response
                System.out.println("Response : " + line);
                // If client writes "bye", the communication finishes
            } while (!line.equals("BYE"));
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
