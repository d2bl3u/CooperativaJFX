module com.example.cooperativajfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.cooperativajfx to javafx.fxml;
    exports com.example.cooperativajfx;
}