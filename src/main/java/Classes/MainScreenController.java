package Classes;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainScreenController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Rectangle platform;
    @FXML
    private ImageView floathero;
    @FXML
    private ImageView hero;
    public void login(ActionEvent event) throws IOException {
        Parent root = new FXMLLoader(getClass().getResource("/FXMLs/LoginScreen.fxml")).load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void signUp(ActionEvent event) throws IOException {
        Parent root = new FXMLLoader(getClass().getResource("/FXMLs/SignupScreen.fxml")).load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void floatingHero(){
        hero.setOpacity(0);
        KeyValue floatHeroValue = new KeyValue(floathero.translateYProperty(),125+240);
        KeyFrame floatHeroFrame = new KeyFrame(Duration.seconds(2),floatHeroValue);
        Timeline t1 = new Timeline(floatHeroFrame);
        t1.play();
        t1.setOnFinished(event -> {
            floathero.setOpacity(0);
            hero.setOpacity(1);
        });
    }
    public void continueAsGuest(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLs/PlayScreen.fxml"));
        Parent root = loader.load();

        PlayScreenController playScreen = loader.getController();
        playScreen.starting();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void loadGames(ActionEvent event) throws IOException {
        Parent root = new FXMLLoader(getClass().getResource("/FXMLs/LoginScreen.fxml")).load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
