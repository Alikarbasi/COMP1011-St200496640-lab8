module com.example.comp1011st200496640lab8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.comp1011st200496640lab8 to javafx.fxml;
    exports com.example.comp1011st200496640lab8;
}