module com.example.shapedraw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.shapedraw to javafx.fxml;
    exports com.example.shapedraw;
    exports com.example.shapedraw.shapes;
    opens com.example.shapedraw.shapes to javafx.fxml;
}