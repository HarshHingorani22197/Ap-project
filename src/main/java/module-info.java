module com.example.mygame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens Classes to javafx.fxml;
    exports Classes;

}