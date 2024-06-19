package Classes;

import java.io.*;
import java.util.ArrayList;

public class Playerdata {

    public static ArrayList<Player> players = new ArrayList<>();
    public static ArrayList<Player> getPlayers() {
        return players;
    }
    public static void setPlayers(ArrayList<Player> newPlayers) {
        players = newPlayers;
    }
    public static void serialize(ArrayList<Player> players) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("playerFile.txt"));
        if(oos.equals(null)){
            Player admin = new Player("admin","123");
            players.add(admin);
        }
        oos.writeObject(players);
        oos.close();
    }
    public static ArrayList<Player> deserialize() throws IOException,ClassNotFoundException{
        ArrayList<Player> filePlayers = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("playerFile.txt"));
            filePlayers = (ArrayList<Player>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return filePlayers;
            //throw new RuntimeException(e);
        }
        return filePlayers;
    }
}
