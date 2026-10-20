module com.mycompany.ejercicio3_1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.ejercicio3_1 to javafx.fxml;
    exports com.mycompany.ejercicio3_1;
}
