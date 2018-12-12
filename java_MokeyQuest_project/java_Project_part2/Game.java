
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
import javafx.application.Platform;

public class Game extends Application {
    
    private static String[] arg;
    private Map map1;
    private Map map2;
    private MyBotPlayer player1;
    private MyBotPlayer player2;
    private Food1 food1;
    private Food1 food2;
    private MyPane3 mypane;
    private Button btTraverse;
    private Button btEat;
    private Button btFind ;
   
    public void start( Stage primaryStage) throws Exception{
      
        map1 = new Map(arg[0]);
        map2 = new Map(arg[1]);

        player1 = new MyBotPlayer(map1);
        player2 = new MyBotPlayer(map2);

        food1 = new Food1(map1,player1);
        food2 = new Food1(map2,player2);

        mypane = new MyPane3();
        btTraverse  = mypane.getButtonTraverse();
        btEat  = mypane.getButtonEat();
        btFind  = mypane.getButtonFind();
       

        btTraverse.setOnAction(e -> {
            primaryStage.setScene(new Scene(map1,map1.getUnit()*map1.getSize(),map1.getUnit()*map1.getSize()));
            primaryStage.show();
            player1.feed(food1);
            player1.traverse();
            map1.requestFocus();
            
            map1.setOnKeyPressed( r -> {
                MyPane3 mypane2 = new MyPane3();
                switch(r.getCode()){
                    case ENTER : primaryStage.setScene(new Scene(mypane2,map1.getUnit()*map1.getSize(),map1.getUnit()*map1.getSize()));primaryStage.show();break;
                    default:  primaryStage.setScene(new Scene(mypane2,map1.getUnit()*map1.getSize(),map1.getUnit()*map1.getSize()));primaryStage.show();break;
                }
            });
           
        });

        btEat.setOnAction(e -> {
            primaryStage.setScene(new Scene(map1,map1.getUnit()*map1.getSize(),map1.getUnit()*map1.getSize()));
            primaryStage.show();
            player1.feed(food1);
            player1.eat();
            map1.requestFocus();
            map1.setOnKeyPressed( r -> {
                MyPane3 mypane3 = new MyPane3();
                switch(r.getCode()){
                    case ENTER : primaryStage.setScene(new Scene(mypane3,map1.getUnit()*map1.getSize(),map1.getUnit()*map1.getSize()));primaryStage.show();break;
                    default:  primaryStage.setScene(new Scene(mypane3,map1.getUnit()*map1.getSize(),map1.getUnit()*map1.getSize()));primaryStage.show();break;
                }
            });

        });

        btFind.setOnAction(e -> {
            primaryStage.setScene(new Scene(map2,map2.getUnit()*map2.getSize(),map2.getUnit()*map2.getSize()));
            primaryStage.show();
            player2.feed(food2);
            player2.find();
            map2.requestFocus();
            map2.setOnKeyPressed( r -> {
                MyPane3 mypane4 = new MyPane3();
                switch(r.getCode()){
                    case ENTER : primaryStage.setScene(new Scene(mypane4,map2.getUnit()*map2.getSize(),map2.getUnit()*map2.getSize()));primaryStage.show();break;
                    default:  primaryStage.setScene(new Scene(mypane4,map2.getUnit()*map2.getSize(),map2.getUnit()*map2.getSize()));primaryStage.show();break;
                }
            });
        });
    
        

        Scene scene = new Scene(mypane,map1.getUnit()*map1.getSize(),map1.getUnit()*map1.getSize());
        primaryStage.setTitle("Bot Player");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("monkey.png"));
        primaryStage.show();
       
        
    }

    public static void main(String[] args) {
        arg = args;
        launch(args);
    }
  
    
}