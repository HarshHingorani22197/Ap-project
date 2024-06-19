package Classes;

import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
//Facade design pattern is used in the overall code
public class MainClass extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        music();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXMLs/MainScreen.fxml"));
        Parent root = fxmlLoader.load();
        MainScreenController floatingHero = fxmlLoader.getController();
        floatingHero.floatingHero();
        Scene scene = new Scene(root);
        stage.setTitle("Stick Hero");

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Image icon = new Image("/images/stickLogo.png");
        stage.getIcons().add(icon);

    }
    MediaPlayer mediaPlayer;

    public void music() {
        String musicFile = "/Music/background_music_birds.mp3";
        Media media = new Media(Objects.requireNonNull(getClass().getResource(musicFile)).toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        mediaPlayer.setVolume(0.3);
    }
}


