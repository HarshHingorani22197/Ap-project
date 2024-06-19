package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private String username;
    private String password;

    private int redPotion;
    private int bluePotion;

    public void setRedPotion(int redPotion) {
        this.redPotion = redPotion;
    }

    public void setBluePotion(int bluePotion) {
        this.bluePotion = bluePotion;
    }

    public int getRedPotion() {
        return redPotion;
    }

    public int getBluePotion() {
        return bluePotion;
    }

    public static void setLoginGames(ArrayList<PlayerScore> loginGames) {
        Player.loginGames = loginGames;
    }

    private static ArrayList<PlayerScore> loginGames = new ArrayList<>();

    public static ArrayList<PlayerScore> getLoginGames() {
        return loginGames;
    }


    public Player(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Player{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
