module com.example.rubrow {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens com.example.rubrow to javafx.fxml;
    exports com.example.rubrow;
}