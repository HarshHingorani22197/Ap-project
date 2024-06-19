package Classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GameOverController {
    private Stage stage;
    private Scene scene;
    @FXML
    private Label reviveLabel;

    @FXML
    private ImageView hero;
    @FXML
    private Button restartButton;
    @FXML
    private Button mainmenu;

    @FXML
    public void restart(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLs/PlayScreen.fxml"));
        Parent root = loader.load();
        PlayScreenController playerScreen = loader.getController();
        playerScreen.startUpAnimation();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void mainMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXMLs/MainScreen.fxml"));
        Parent root = fxmlLoader.load();
        MainScreenController floatingHero = fxmlLoader.getController();
        floatingHero.floatingHero();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void revive(ActionEvent event) throws IOException {
        boolean flag = false;
//        PlayScreenController playerObject = new PlayScreenController();
        ArrayList<PlayerScore> infoList = PlayScreenController.getInfo();
        for(int i=0;i<infoList.size();i++){
            if(infoList.get(i).getRedPotion()==3){
                flag=true;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLs/PlayScreen.fxml"));
                Parent root = loader.load();
                PlayScreenController playerScreen = loader.getController();
                playerScreen.startUpAnimation(infoList.get(i).getScore(),infoList.get(i).getRedPotion()-3,infoList.get(i).getBluePotion());
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }
        }
        if(!flag){
            reviveLabel.setText("Not Enough Red Potions (Need 3 or more)");
            reviveLabel.setOpacity(1);

        }
    }




}