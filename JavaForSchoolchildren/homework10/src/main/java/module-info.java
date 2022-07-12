module ua.hillel.homework10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ua.hillel.homework10 to javafx.fxml;
    exports ua.hillel.homework10;
}