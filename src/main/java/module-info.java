module com.example.shapedraw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.shapedraw to javafx.fxml;
    exports com.example.shapedraw;
}