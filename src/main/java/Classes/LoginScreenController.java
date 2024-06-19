package Classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginScreenController {
    private int flag=0;

    private int playerID;
    @FXML
    private Label myLabel;
    @FXML
    private TextField inputUsername;
    @FXML
    private TextField inputPassword;
    @FXML
    private Button enterButton;
    @FXML
    private Button goBack;

    String username;
    String password;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void goBack(ActionEvent event) throws IOException {
        Parent root = new FXMLLoader(getClass().getResource("/FXMLs/MainScreen.fxml")).load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public int getPlayerID() {
        return playerID;
    }

    public void login(ActionEvent event) throws IOException, ClassNotFoundException {
//        if(Playerdata.getPlayers().size()==0){
//            Player admin = new Player("admin","123");
//            Playerdata.getPlayers().add(admin);
//        }
        username = inputUsername.getText();
        password = inputPassword.getText();
        if(username.isEmpty()||password.isEmpty()){
            myLabel.setText("Enter both username and password");
            myLabel.setTextFill(Color.DARKRED);
        }
        else {
            try{
                if(Playerdata.deserialize().isEmpty()){
                    myLabel.setText("Incorrect combination");
                    myLabel.setTextFill(Color.DARKRED);
                }
                else{
                    for(Player p : Playerdata.deserialize()){
                        if(p.getUsername().equals(username)&&p.getPassword().equals(password)){
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLs/StartScreen.fxml"));
                            Parent root = loader.load();
                            StartScreenController startButtonContr = loader.getController();
                            startButtonContr.startButtonAnimation();
                            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                            flag=1;
                            playerID = Playerdata.deserialize().indexOf(p);
                            break;
                        }
                        else {
                            flag=0;
                        }
                    }
                    if(flag==0){
                        myLabel.setText("Incorrect combination");
                        myLabel.setTextFill(Color.DARKRED);
                    }
                }
            }catch (Exception e){
                myLabel.setText("User not found");
                myLabel.setTextFill(Color.DARKRED);
            }
        }
    }
}
