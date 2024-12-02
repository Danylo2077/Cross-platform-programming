module com.example.new_l7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.new_l7 to javafx.fxml;
    exports com.example.new_l7;
}