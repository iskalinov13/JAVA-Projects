import  javafx.animation.KeyFrame;
import  javafx.animation.*;
import javafx.application.Application;
import  javafx.beans.property.DoubleProperty;
import javafx.scene.image.*;
import  javafx.scene.layout.*;
import  javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import  javafx.scene.shape.*;
import  javafx.util.Duration;
import javafx.scene.text.*;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import java.util.concurrent.TimeUnit;
import javafx.geometry.*;

public class  MyPane3 extends Pane {
 
    private Button btTraverse = new Button("Traverse");
    private Button btEat = new Button("Eat");
    private Button btFind = new Button("Find");
    

    public MyPane3(){
        Image image  = new Image("fon.jpg");
        ImageView i = new ImageView(image);
        i.setFitHeight(560);
        i.setFitWidth(560);
        getChildren().add(i);

        Line line  = new Line(30,530,530,530);
        line.setStroke(Color.TRANSPARENT);
    
       

        Pane pane = new Pane();
        pane.setLayoutX(30);
        pane.setLayoutY(100);
        pane.setStyle("-fx-border-color: black; -fx-background-color: null;");
       
      
        
        Text scenetitle = new Text(15,70,"Bot Player");
        scenetitle.setFont(Font.font("Forte", 65));
        scenetitle.setFill(Color.GREEN);
        scenetitle.setStroke(Color.BLACK);
        scenetitle.setStrokeWidth(3);
        pane.setPrefSize(330, 370);
        pane.getChildren().add(scenetitle);
    
      

        btTraverse.setFont(Font.font("Forte", 30));
        btTraverse.setTextFill(Color.WHITE);
        btTraverse.setStyle("-fx-border-color: white; -fx-background-color: green;");
        btTraverse.setLayoutX(45);
        btTraverse.setLayoutY(120);
        btTraverse.setPrefSize(240, 30);
        pane.getChildren().add(btTraverse);

        btEat.setFont(Font.font("Forte", 30));
        btEat.setTextFill(Color.WHITE);
        btEat.setStyle("-fx-border-color: white; -fx-background-color: green;");
        btEat.setLayoutX(45);
        btEat.setLayoutY(200);
        btEat.setPrefSize(240, 30);
        pane.getChildren().add(btEat);

        btFind.setFont(Font.font("Forte", 30));
        btFind.setTextFill(Color.WHITE);
        btFind.setStyle("-fx-border-color: white; -fx-background-color: green;");
        btFind.setLayoutX(45);
        btFind.setLayoutY(280);
        btFind.setPrefSize(240, 30);
        pane.getChildren().add(btFind);


        
        Image welcomeMonkey = new Image("welcomeMonkey.gif");
        ImageView welcomeImageView = new ImageView(welcomeMonkey);
        welcomeImageView.setLayoutX(320);
        welcomeImageView.setLayoutY(80);
        welcomeImageView.setFocusTraversable(false);
        getChildren().add(welcomeImageView);
        getChildren().add(pane);
        pane.setStyle("-fx-background-color: rgba(199, 255, 251, 0.7); -fx-border-color: white; ");
      
      
    }
 
    public Button getButtonTraverse(){
        return this.btTraverse;
    }
    public Button getButtonEat(){
        return this.btEat;
    }
    public Button getButtonFind(){
        return this.btFind;
    }
    
  
    
}