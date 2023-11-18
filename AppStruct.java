package org.example;
import javafx.application.Application;  
import java.util.ArrayList;


public class WrongKeyPress extends Exception {
    public WrongKeyPress(String message) {
        super(message);
    }
}




public class WrongLogin extends Exception {
    public WrongLogin(String message) {
        super(message);
    }
}



public class InsufficientCherries extends Exception {
    public InsufficientCherries(String message) {
        super(message);
    }
}




interface Canvas{
    void shiftAndTranslateOrigin();


}
class ScoringSystem{
    private int highScore;
    private int cherries;

    ScoringSystem(int high, int cherry){
        this.highScore = high;
        this.cherries = cherry;

    }

    public int getCherries() {
        return this.cherries;
    }

    public int getHighScore() {
        return this.highScore;
    }

    public void updateCherries(int val) {
        this.cherries += val;
    }


    public void doublePoints(){
        this.highScore+=2;
    }
    public void updateHighScore(){
        this.highScore+=1;
    }



}




class Stick {
    public void extendStick(){
        //With mouse input and/or keyboard down key stick will extend
    }
    public void stickRotating(){
        //Stick will either land on the block or will fall off
    }

    public void stickPosition(){
        //To check its position relative to block and
        //whether it landed on double point system
    }


}

class Hero implements Canvas{
    public void walking(){
        //To walk over the stick
        //resulting in either falling or
        //progressing to the next block
    }

    public void flipping(){
        //flipping to collect cherries
    }


    @Override
    public void shiftAndTranslateOrigin() {
        //To move either to the next block or downwards
    }
}

class Blocks implements Canvas{
    public void renderBlock(){
        //Rendering blocks of different types
    }

    public void doublePointsBlock(){
        //Would be rendered in middle of a block
    }

    @Override
    public void shiftAndTranslateOrigin() {
        //To move the screen for viewing the next block
    }
}

class PowerUps extends ScoringSystem{
    PowerUps(int high, int cherry) {
        super(high, cherry);
    }

    public void invincibility(){
        //Check for a specific number of cherries to
        //provide invincibility for a time period
    }

    public void magnetism(){
        //would attract cherries
    }
    public void teleportation(){
        //would teleport and skip next few blocks
    }


}


class User{
    String username;
    String passwd;
    ArrayList<ScoringSystem> gameStates = new ArrayList<>();
    User(String username,String pass) {

        this.username=username;
        this.passwd=pass;
    }

    public ArrayList<ScoringSystem> getGameStates() {
        return gameStates;
    }

}






class BasicFunctions{

    private final static ArrayList<User> users = new ArrayList<>();
    public void startScreen(){
        //To start the game and display start screen using JavaFX.
    }
    public void login(){
        //would log in a user
    }
    public boolean loginChecker(){
        //Check in the array for the username and provide with previous
        //game state
    }


    public void displayHighScore(){
        //To display high score of the person.
    }
    public void displayCherries(){
        //Number of Cherries would be displayed.
    }


    public void saveCurrentProgress(){
        //To save the current state of the game.
    }
    public void restartLevel(){
        //Will restart level and save the progress if the high score scored was more than current
    }

    public void loadProgress(){
        //Load some different progress for the user.
    }

    public void revive(){
        //Check cherries to revive the player
    }

    public void afterFallMenu(){
        //Menu after the fall
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}

public class AppStruct extends Application{
    public static void main( String[] args ){


    }
}
