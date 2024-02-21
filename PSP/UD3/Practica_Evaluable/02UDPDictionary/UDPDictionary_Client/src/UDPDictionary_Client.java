
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class UDPDictionary_Client 
{
    public static final int PORT = 6000;
    public static void main(String[] args) 
    {
        try (DatagramSocket mySocket = new DatagramSocket())
        {
            mySocket.setSoTimeout(5000);
            
            // Create the packet to be sent
            System.out.println("Type the word to be translated: ");
            String text = new Scanner(System.in).nextLine();
            byte[] message = text.getBytes();
            DatagramPacket packetS = new DatagramPacket(message, message.length, InetAddress.getLocalHost(), PORT);
            mySocket.send(packetS);
            
            // Receive the response
            try
            {
                byte[] buffer = new byte[1024];
                DatagramPacket packetR = new DatagramPacket(buffer, buffer.length);
                mySocket.receive(packetR);            
                System.out.println("Translation: " + new String(packetR.getData()).trim());
            } catch (InterruptedIOException ex) {
                System.err.println("No translation found");
            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
