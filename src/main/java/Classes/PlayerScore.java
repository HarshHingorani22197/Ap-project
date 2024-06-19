package Classes;

public class PlayerScore {
    private int score;
    private int redPotion;
    private int bluePotion;

    PlayerScore(int scoreInput,int red,int blue){
        score=scoreInput;
        redPotion=red;
        bluePotion=blue;

    }

    public int getScore() {
        return score;
    }

    public int getRedPotion() {
        return redPotion;
    }

    public int getBluePotion() {
        return bluePotion;
    }
}
