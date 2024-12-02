module com.example.java_lab6 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.L6.view to javafx.fxml;

    exports com.example.L6;
    exports com.example.L6.view;
}
