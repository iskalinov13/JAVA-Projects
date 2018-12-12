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

public class  MyPane2 extends Pane {
    public static int n=50;
    public Button btPlay = new Button("Play");
    private Text score = new Text(50,320,"0");
    private Text name = new Text(50,230,"Monkey");


    public MyPane2(){
        Image image  = new Image("fon2.jpg");
        ImageView i = new ImageView(image);
        i.setFitHeight(560);
        i.setFitWidth(560);
        getChildren().add(i);

        Pane pane = new Pane();
        pane.setLayoutX(30);
        pane.setLayoutY(100);
        
       

        Text t = new Text(50,70,"Game");
        t.setFont(Font.font("Forte", 85));
        t.setFill(Color.MAGENTA);
        t.setStroke(Color.BLACK);
        t.setStrokeWidth(3);
        pane.getChildren().add(t);
        pane.setPrefSize(300, 350);

        Text userName = new Text(30,180,"Nickname");
        userName.setFont(Font.font("Times New Roman", 35));
        userName.setFill(Color.BLACK);
        userName.setStroke(Color.BLACK);
        userName.setStrokeWidth(3);
        pane.getChildren().add(userName);

        Image nickName = new Image("monkey.png");
        ImageView nickNameIV = new ImageView(nickName);
        nickNameIV.setFitHeight(50);
        nickNameIV.setFitWidth(50);
        nickNameIV.setLayoutX(210);
        nickNameIV.setLayoutY(140);
        pane.getChildren().add(nickNameIV);

        name.setFont(Font.font("Times New Roman", 40));
        name.setFill(Color.BLACK);
        name.setStroke(Color.BLACK);
        name.setStrokeWidth(3);
        pane.getChildren().add(name);

        
        
        
        Text t2 = new Text(70,130,"Over");
        t2.setFont(Font.font("Forte", 85));
        t2.setFill(Color.BLUE);
        t2.setStroke(Color.BLACK);
        t2.setStrokeWidth(3);
        pane.getChildren().add(t2);
        getChildren().add(pane);
        pane.setStyle("-fx-background-color: rgba(199, 255, 251, 0.7); -fx-border-color: black; ");

       
        score.setFont(Font.font("Times New Roman",40));
        score.setFill(Color.BLACK);
        score.setStroke(Color.BLACK);
        score.setStrokeWidth(5);
        pane.getChildren().add(score);

        Image banana = new Image("banana.png");
        ImageView bananaIV = new ImageView(banana);
        bananaIV.setFitHeight(50);
        bananaIV.setFitWidth(50);
        bananaIV.setLayoutX(210);
        bananaIV.setLayoutY(230);
        pane.getChildren().add(bananaIV);
        
        
     

        Image imageM = new Image("welcomeMonkey.gif");
        ImageView imageView = new ImageView(imageM);
        imageView.setLayoutX(260);
        imageView.setLayoutY(80);
        getChildren().add(imageView);

        Text points = new Text(30,270,"Score");
        points.setFont(Font.font("Times New Roman", 35));
        points.setFill(Color.BLACK);
        points.setStroke(Color.BLACK);
        points.setStrokeWidth(3);
        pane.getChildren().add(points);

    } 
    public void setScore(String s){
        this.score.setText(s);
    }
    public void setName(String s){
        this.name.setText(s);
    }
    
}