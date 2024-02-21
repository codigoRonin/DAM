module pps.ud3.multicastchat_client {
    requires javafx.controls;
    requires javafx.fxml;


    opens pps.ud3.multicastchat_client to javafx.fxml;
    exports pps.ud3.multicastchat_client;
}