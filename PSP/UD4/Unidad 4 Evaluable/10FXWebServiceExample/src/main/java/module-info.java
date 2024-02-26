module com.example.fxwebserviceexample {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxwebserviceexample to javafx.fxml;
    exports com.example.fxwebserviceexample;
}