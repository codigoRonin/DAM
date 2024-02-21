import java.net.*;
import java.io.*;
import java.util.HashMap;

/**
 * An exercise that uses UDP sockets to ask the server for a word translation
 * If there is no response from server after 5 seconds, then the client will
 * assume that there is no translation available.
 */
public class UDPDictionary_Server 
{
    public static final int PORT = 6000;
    public static void main(String[] args) 
    {
        // Built-in hashtable with some translations
        HashMap dictionary = new HashMap();
        dictionary.put("one", "uno");
        dictionary.put("two", "dos");
        dictionary.put("three", "tres");
        
        try (DatagramSocket mySocket = new DatagramSocket(PORT, InetAddress.getLocalHost()))
        {
            // Connect to a given address ("localhost", for instance)
            // and a known port (6000)
            
            // Receive the word
            byte[] buffer = new byte[1024];
            DatagramPacket packetR = new DatagramPacket(buffer, buffer.length);
            mySocket.receive(packetR);   
            String word = new String(packetR.getData()).trim();
            System.out.println("Received: " + word);
            
            // Get host and port from the message
            int destPort = packetR.getPort();
            InetAddress destAddr = packetR.getAddress();

            // Create the packet to be sent
            if (dictionary.get(word) != null)
            {
                String text = (String)(dictionary.get(word));
                byte[] message = text.getBytes();
                DatagramPacket packetS = new DatagramPacket(message, message.length, destAddr, destPort);
                mySocket.send(packetS);
            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
