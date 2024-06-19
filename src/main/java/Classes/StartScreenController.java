package Classes;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class StartScreenController {
    @FXML
    private ImageView startImage;
    @FXML
    private Button startButton;
    @FXML
    private ImageView hero;
    public void startButtonAnimation(){
        KeyValue startImageValue = new KeyValue(startImage.translateYProperty(),161+239);
        KeyFrame startImageFrame = new KeyFrame(Duration.seconds(1),startImageValue);
        Timeline t1 = new Timeline(startImageFrame);
        t1.play();
    }
    public void startGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLs/PlayScreen.fxml"));
        Parent root = loader.load();

        PlayScreenController playScreen = loader.getController();
        playScreen.starting();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void startGame() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLs/PlayScreen.fxml"));
        Parent root = loader.load();

        PlayScreenController playScreen = loader.getController();
        playScreen.starting();
        Stage stage = (Stage) hero.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
