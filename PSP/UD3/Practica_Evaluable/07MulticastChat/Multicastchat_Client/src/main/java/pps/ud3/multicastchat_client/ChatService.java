package pps.ud3.multicastchat_client;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.TextArea;

import java.net.DatagramPacket;
import java.net.MulticastSocket;

/**
 * Thread to wait for server messages. It receives the messages and puts them
 * in the text area
 */
public class ChatService extends Service<String>
{
    MulticastSocket socket;
    TextArea conversation;

    public ChatService(MulticastSocket socket, TextArea conversation)
    {
        this.socket = socket;
        this.conversation = conversation;
    }

    @Override
    protected Task<String> createTask()
    {
        return new Task<String>()
        {
            @Override
            protected String call() throws Exception
            {
                while (true)
                {
                    try
                    {
                        Thread.sleep(1000);
                        byte[] buf = new byte[1024];
                        DatagramPacket packet = new DatagramPacket(buf, buf.length);
                        socket.receive(packet);
                        String msg = new String(packet.getData()).trim();
                        System.out.println("Received: " + msg);
                        updateMessage(conversation.getText() + "\n" + msg);
                    } catch (Exception e) {}
                }
            }
        };
    }
}
