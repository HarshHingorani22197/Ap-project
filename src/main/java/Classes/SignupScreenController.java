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
import java.util.ArrayList;

public class SignupScreenController {
    int flag=0;
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
    private ArrayList<Player> players = new ArrayList<>();

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void submit(ActionEvent event) throws IOException, ClassNotFoundException {
        players = Playerdata.deserialize();
        //Flyweight
        if(players.isEmpty()){
           Player admin = new Player("admin","123");
           Player admin1 = new Player("admin1","123");
           Player admin2 = new Player("admin2","123");

           players.add(admin);
        }
        Playerdata.serialize(players);

        username = inputUsername.getText();
        password = inputPassword.getText();
        if(username.isEmpty()||password.isEmpty()){
            myLabel.setText("Enter both username and password");
            myLabel.setTextFill(Color.DARKRED);
        }
        else {
            Player newplayer = new Player(username,password);
            for(Player p : players){
                if(p.getUsername().equals(username)){
                    myLabel.setText("Username already exists");
                    myLabel.setTextFill(Color.DARKRED);
                    flag=1;
                    break;
                }
                else {
                    flag=0;
                }
            }
            if(flag==0){
                myLabel.setText("User added successfully");
                myLabel.setTextFill(Color.BLACK);
                players.add(newplayer);
                Playerdata.serialize(players);
//                System.out.println(players);
            }
        }
   }

}
