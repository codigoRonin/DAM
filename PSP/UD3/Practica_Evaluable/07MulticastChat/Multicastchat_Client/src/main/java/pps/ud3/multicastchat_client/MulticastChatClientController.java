package pps.ud3.multicastchat_client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastChatClientController {
    public static final int PORT = 6000;
    MulticastSocket ms;
    InetAddress group;
    ChatService service;
    String nickName = "";
    @FXML
    private TextField txtNick;
    @FXML
    private TextArea txtConversation;
    @FXML
    private Button btnConnect;
    @FXML
    private TextField txtMessage;
    @FXML
    private Button btnSend;

    public void sendMessage(String text, boolean connect)
    {

        try
        {
            // If it's our first message, connect to the group

            if (connect)
            {
                ms = new MulticastSocket(PORT);
                group = InetAddress.getByName("225.0.0.1");
                ms.joinGroup(group);
                nickName = txtNick.getText();
            }
            DatagramPacket packet = new DatagramPacket(text.getBytes(), text.length(), group, PORT);
            ms.send(packet);
            btnConnect.setDisable(true);
            txtNick.setDisable(true);
            txtConversation.setDisable(false);
            txtMessage.setDisable(false);
            btnSend.setDisable(false);

            // If it's our first message, start the service (after sending our
            // first connection message), and bind the text area to it
            if (connect)
            {
                service = new ChatService(ms, txtConversation);
                txtConversation.textProperty().bind(service.messageProperty());
                service.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            showErrorMessage("Error connecting to server", "Unable to send message to server");
        }
    }
    public void showErrorMessage(String title, String msg)
    {
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Error");
        dialog.setHeaderText(title);
        dialog.setContentText(msg);
        dialog.showAndWait();
    }

    public void connect(ActionEvent actionEvent) {

        String nick = txtNick.getText().trim();
        if (nick.length() > 0)
            sendMessage(nick + " enters the chat", true);
        else
            showErrorMessage("Error connecting to server", "You must specify a valid nickname");
    }

    public void send(ActionEvent actionEvent) {
        if (txtMessage.getText().trim().length() > 0)
        {
            String msg = "[" + nickName + "]" + txtMessage.getText();
            sendMessage(msg, false);
        }
        else
            showErrorMessage("Error sending message", "Message is empty");
    }
}
