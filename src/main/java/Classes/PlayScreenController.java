package Classes;

import javafx.animation.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class PlayScreenController {

    private boolean playFlag=true;



    private static ArrayList<Player> games = new ArrayList<>();
    private boolean rotationFlag=true;
    private double random;

    private int redPotionNumber;
    private int bluePotionNumber;

    @FXML
    private Label bluePotionCounter;
    @FXML
    private Label redPotionCounter;
    @FXML
    private ImageView pRedPotion;
    @FXML
    private ImageView pBluePotion;
    @FXML
    private Label scoreLabel;
    @FXML
    private AnchorPane screenMain;

    @FXML

    private Rectangle platform;
    @FXML
    private Rectangle nextPlatform;
    @FXML
    private ImageView hero;
    private int score;
    private Timeline MainTimeline;

    private double stickLength;

    @FXML
    private Line stick;

    public static ArrayList<Player> getGames() {
        return games;
    }

    private static ArrayList<PlayerScore> info = new ArrayList<>();

    public static ArrayList<PlayerScore> getInfo() {
        return info;
    }

    public void startUpAnimation(int scoreInput, int redPowerUp, int bluePowerUp){


//        pRedPotion.setVisible(false);
        score = scoreInput;
        redPotionNumber = redPowerUp;

        redPotionCounter.setText(Integer.toString(redPowerUp));

        bluePotionNumber = bluePowerUp;

        bluePotionCounter.setText(Integer.toString(bluePowerUp));

        scoreLabel.setText(Integer.toString(score));
        pRedPotion.setOpacity(0);
        pBluePotion.setOpacity(0);
        if(score%3==0 && score!=0){
            pRedPotion.setOpacity(1);
        }
        else if(score%5==0 && score!=0){
            pBluePotion.setOpacity(1);
        }

        nextPlatform.setWidth(Math.random()*(200-50+1)+50);

        KeyValue oriPlatform = new KeyValue(platform.translateXProperty(),-100);
        KeyFrame oriPlatformFrame = new KeyFrame(Duration.seconds(1),oriPlatform);
        stick.setVisible(false);
        random = -(Math.random()*(500-200+1)+200);
        KeyValue startNextPlatform = new KeyValue(nextPlatform.translateXProperty(),random);
        KeyFrame nextPlatformFrame = new KeyFrame(Duration.seconds(1),startNextPlatform);

        KeyValue heroTranslation = new KeyValue(hero.translateXProperty(),-100);
        KeyFrame heroFrame = new KeyFrame(Duration.seconds(1),heroTranslation);

        KeyValue stickTranslation = new KeyValue(stick.translateXProperty(),-100);
        KeyFrame stickFrame = new KeyFrame(Duration.seconds(1),stickTranslation);

        KeyValue potionValue = new KeyValue(pRedPotion.translateXProperty(),random);
        KeyFrame potionFrame = new KeyFrame(Duration.seconds(1),potionValue);

        KeyValue bluePotionValue = new KeyValue(pBluePotion.translateXProperty(),random);
        KeyFrame bluePotionFrame = new KeyFrame(Duration.seconds(1),bluePotionValue);

        Timeline t0 = new Timeline(oriPlatformFrame);
        Timeline t1 = new Timeline(potionFrame);
        Timeline t2 = new Timeline(heroFrame);
        Timeline t3 = new Timeline(stickFrame);
        Timeline t4 = new Timeline(nextPlatformFrame);
        Timeline t5 = new Timeline(bluePotionFrame);

        t2.setCycleCount(1);
        t1.setCycleCount(1);
        t0.setCycleCount(1);
        t3.setCycleCount(1);
        t4.setCycleCount(1);
        t5.setCycleCount(1);

        ParallelTransition p = new ParallelTransition(t0,t1,t2,t3,t4,t5);
        p.play();


        t4.setOnFinished(event ->{
            nextPlatform.setTranslateX(0);
            nextPlatform.setLayoutX(765+random);
            platform.setTranslateX(0);
            platform.setLayoutX(34);
        });

    }
    public void starting(){

        KeyValue startPlatform = new KeyValue(platform.translateXProperty(),-100);
        KeyFrame platformFrame = new KeyFrame(Duration.seconds(1),startPlatform);
        Timeline t1 = new Timeline(platformFrame);
        t1.setCycleCount(1);
        t1.play();
        startUpAnimation();
    }
    public void loop2() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLs/PlayScreen.fxml"));
        Parent root = loader.load();
        PlayScreenController playerScreen = loader.getController();
        playerScreen.startUpAnimation(score,redPotionNumber,bluePotionNumber);
        Stage stage = (Stage) hero.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void loop(){


        pRedPotion.setOpacity(0);
        pBluePotion.setOpacity(0);

        stick.setVisible(false);
        platform.setVisible(false);
        KeyValue nextPlatformTranslate = new KeyValue(nextPlatform.translateXProperty(),-Math.abs(platform.getLayoutX()-nextPlatform.getLayoutX()));
        KeyFrame nextPlatformFrame = new KeyFrame(Duration.seconds(2),nextPlatformTranslate);
        Timeline t1 = new Timeline(nextPlatformFrame);
        t1.play();

        KeyValue heroTranslate = new KeyValue(hero.translateXProperty(),-Math.abs(hero.getLayoutX()-platform.getLayoutX()));
        KeyFrame heroFrame = new KeyFrame(Duration.seconds(2),heroTranslate);
        Timeline t2= new Timeline(heroFrame);
        t2.play();

        t2.setOnFinished(actionEvent -> {
            try {
                loop2();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
    public void startUpAnimation(){
        stick.setVisible(false);
        pRedPotion.setVisible(false);
        random = -(Math.random()*(500-200+1)+200);
        KeyValue oriPlatform = new KeyValue(platform.translateXProperty(),-100);
        KeyFrame oriPlatformFrame = new KeyFrame(Duration.seconds(1),oriPlatform);

        KeyValue startNextPlatform = new KeyValue(nextPlatform.translateXProperty(),random);
        KeyFrame nextPlatformFrame = new KeyFrame(Duration.seconds(1),startNextPlatform);

        KeyValue heroTranslation = new KeyValue(hero.translateXProperty(),-100);
        KeyFrame heroFrame = new KeyFrame(Duration.seconds(1),heroTranslation);

        KeyValue stickTranslation = new KeyValue(stick.translateXProperty(),-100);
        KeyFrame stickFrame = new KeyFrame(Duration.seconds(1),stickTranslation);

        KeyValue potionValue = new KeyValue(pRedPotion.translateXProperty(),random);
        KeyFrame potionFrame = new KeyFrame(Duration.seconds(1),potionValue);

        Timeline t1 = new Timeline(potionFrame);
        Timeline t0 = new Timeline(oriPlatformFrame);
        Timeline t2 = new Timeline(heroFrame);
        Timeline t3 = new Timeline(stickFrame);
        Timeline t4 = new Timeline(nextPlatformFrame);

        t2.setCycleCount(1);
        t1.setCycleCount(1);
        t0.setCycleCount(1);
        t3.setCycleCount(1);
        t4.setCycleCount(1);


        ParallelTransition p = new ParallelTransition(t0,t1,t2,t3,t4);
        p.play();

        t4.setOnFinished(event ->{
            nextPlatform.setTranslateX(0);
            nextPlatform.setLayoutX(765+random);
            platform.setTranslateX(0);
            platform.setLayoutX(34);
        });
    }

    @FXML
    public void extendStick(MouseEvent event){

        if(playFlag) {
            stick.setVisible(true);
            MainTimeline = new Timeline(
                    new KeyFrame(Duration.seconds(0.1), e -> mousePressAction())
            );
            MainTimeline.setCycleCount(Timeline.INDEFINITE);
            MainTimeline.play();

        }
    }
    public double getLineLength(Line line) {
        Point2D start = new Point2D(line.getStartX(), line.getStartY());
        Point2D end = new Point2D(line.getEndX(), line.getEndY());
        return start.distance(end);

    }

    public void mouseReleased(MouseEvent event){
        stickLength = getLineLength(stick);

        if (MainTimeline != null) {
            MainTimeline.stop();
        }
        playFlag=false;
        if(rotationFlag){
            KeyFrame kf = new KeyFrame(Duration.seconds(0.1),e -> rotateStick(stick.getStartX(),stick.getStartY(),stick.getEndX(),stick.getEndY()));
            Timeline t1 = new Timeline(kf);

            t1.play();
            stick.setEndY(stick.getStartY());
        }
        rotationFlag=false;

        if(stickLength+10 < nextPlatform.getLayoutX()-(platform.getLayoutX()+platform.getWidth())){
            dyingPlayerForward();
        } else if (stickLength > nextPlatform.getLayoutX()+nextPlatform.getWidth()-(platform.getLayoutX()+platform.getWidth())) {
            dyingPlayerForward();
        } else {
                playerForward();




        }

    }

    public void mousePressAction(){
        boolean flag = screenMain.isPressed();

        if(flag){

            Timeline t1 = new Timeline();
            t1.setCycleCount(1);
            KeyValue kv1 = new KeyValue(stick.endYProperty(), stick.getEndY() - 20);
            KeyFrame kf1 = new KeyFrame(Duration.seconds(0.1), kv1);
            t1.getKeyFrames().add(kf1);
            t1.play();

        }
    }

    public double[] rotateStick(int val,double x0,double y0,double x1,double y1){



        // Linear Algebra coordi ke liye
        double x2 = x0 - (y1-y0);
        double y2 = y0 + (x1-x0);


        double[] ans = new double[2];
        ans[0]=x2;
        ans[1]=y2;
        return ans;


    }
    public void rotateStick(double x0,double y0,double x1,double y1){



        // Linear Algebra coordi ke liye
        double x2 = x0 - (y1-y0);
        double y2 = y0 + (x1-x0);

        stick.setEndX(x2);
        stick.setEndY(y2);



    }



    public void playerForward(){
        TranslateTransition transition = new TranslateTransition(Duration.seconds(2),hero);
        //transition.setByX(stickLength+100);
        transition.setToX(nextPlatform.getLayoutX()-132);
        transition.play();

        score+=1;
        scoreLabel.setText(Integer.toString(score));

        if(score%3==1 && score!=0 && score!=1){

            redPotionNumber+=1;
            redPotionCounter.setText(Integer.toString(redPotionNumber));
        }

        if(score%5==1 && score!=0 && score!=1){
            bluePotionNumber+=1;
            bluePotionCounter.setText(Integer.toString(bluePotionNumber));
            score+=3;
        }
        transition.setOnFinished(actionEvent -> loop());
    }
    public void dyingPlayerForward(){

        TranslateTransition transition = new TranslateTransition();
        transition.setNode(hero);
        transition.setDuration(Duration.seconds(2));
        transition.setToX(stickLength);
        transition.play();

        transition.setOnFinished(event ->{
            TranslateTransition translate2 = new TranslateTransition();
            translate2.setNode(hero);
            translate2.setDuration(Duration.seconds(2));
            translate2.setByY(250);
            translate2.play();
            translate2.setOnFinished(event1 ->{
                try {
                    switchToGameOver();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        });



        info.clear();
        info.add(new PlayerScore(score,redPotionNumber,bluePotionNumber));
    }
    public void switchToGameOver() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLs/GameOver.fxml"));
        Parent root = loader.load();
//        PlayScreenController playScreen = loader.getController();
//        playScreen.startUpAnimation();
        Stage stage = (Stage) hero.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}