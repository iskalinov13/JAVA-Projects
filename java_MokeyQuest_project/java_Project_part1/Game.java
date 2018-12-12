import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.application.*;
import  javafx.scene.media.*;
import javafx.scene.image.*;

public class Game extends Application {
    private static String[] arg;
    private Map map;
    private MyPlayer player;
    private Scene scene;
    private MyPane mypane;
    private Food1 food;
    
    private static final String MEDIA_URL ="http://www.orangefreesounds.com/wp-content/uploads/2016/04/Rainforest-sounds.mp3?_=1";
   
    public void start( Stage primaryStage) throws Exception{
        Media media = new  Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new  MediaPlayer(media);
        MediaView mediaView = new  MediaView(mediaPlayer);
        map = new Map(arg[0]);
        player = new MyPlayer(map);
       
        mypane =  new MyPane();
        Button btPlay  = mypane.getButton();
        
        btPlay.setOnAction(e -> {
            Position position = map.getStartPosition();
            scene = new Scene(map,map.getUnit()*map.getSize(),map.getUnit()*map.getSize());
            food = new Food1(map,player);
            MyPane2 myPane2 = new MyPane2();
            primaryStage.setScene(scene);
            primaryStage.show();
            mediaPlayer.play();
            map.requestFocus();

            map.setOnKeyPressed(r -> {
          
                switch(r.getCode()) {
                    case RIGHT: player.moveRight();
                    if(food.getNumOfCircles()==0){
                        primaryStage.setScene(new Scene(myPane2,map.getUnit()*map.getSize(),map.getUnit()*map.getSize()));
                        myPane2.setScore(food.getPoints() + "");
                        myPane2.setName(mypane.getUserName());
                        primaryStage.show();
                    }
                    break;
                    case LEFT:  player.moveLeft();
                    if(food.getNumOfCircles()==0){
                        primaryStage.setScene(new Scene(myPane2,map.getUnit()*map.getSize(),map.getUnit()*map.getSize()));
                        myPane2.setScore(food.getPoints() + "");
                        myPane2.setName(mypane.getUserName());
                        primaryStage.show();
                    }
                    break;
                    case DOWN:  player.moveDown();
                    if(food.getNumOfCircles()==0){
                        primaryStage.setScene(new Scene(myPane2,map.getUnit()*map.getSize(),map.getUnit()*map.getSize()));
                        myPane2.setScore(food.getPoints() + "");
                        myPane2.setName(mypane.getUserName());
                        primaryStage.show();
                    }
                    break;
                    case UP:    player.moveUp();
                    if(food.getNumOfCircles()==0){
                        primaryStage.setScene(new Scene(myPane2,map.getUnit()*map.getSize(),map.getUnit()*map.getSize()));
                        myPane2.setScore(food.getPoints() + "");
                        myPane2.setName(mypane.getUserName());
                        primaryStage.show();
                    }
                    break;
                    default:
                    if(food.getNumOfCircles()==0){
                        primaryStage.setScene(new Scene(myPane2,map.getUnit()*map.getSize(),map.getUnit()*map.getSize()));
                        myPane2.setScore(food.getPoints() + "");
                        myPane2.setName(mypane.getUserName());
                        primaryStage.show();
                    }break;

                }  
            
        });});
    
        

        scene = new Scene(mypane,560,560);
        
        primaryStage.setTitle("Monkey Quest");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("monkey.png"));
        primaryStage.show();
        
        
    }

    public static void main(String[] args) {
        arg = args;
        launch(args);
    }
  
    
}