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

public class  MyPane extends Pane {
    public static int n=50;
    private  Text t;
    private  Text t2;
    private String name;
    
    private Button btPlay = new Button("Play");
    private TextField userTextField = userTextField = new TextField();;
    private PasswordField pwBox;

    public MyPane(){
        Image image  = new Image("fon2.jpg");
        ImageView i = new ImageView(image);
        i.setFitHeight(560);
        i.setFitWidth(560);
        getChildren().add(i);
        t = new Text(40,230,"Monkey Quest");
        t.setFont(Font.font("Forte", 80));
        t.setFill(Color.YELLOW);
        t.setStroke(Color.BROWN);
        t.setStrokeWidth(5);
        getChildren().add(t);

        Circle circle2 =new Circle(165,356,80);
        Image image2  = new Image("monkey1.gif",false);
        circle2.setFill(new ImagePattern(image2));
        getChildren().add(circle2);


     
        t2 = new Text(145,480,"Loading ...");
        t2.setFont(Font.font("Forte", 70));
        t2.setFill(Color.BLUE);
        t2.setStroke(Color.AZURE);
        t2.setStrokeWidth(2);
        getChildren().add(t2);

        Line line  = new Line(30,530,530,530);
        line.setStroke(Color.TRANSPARENT);
       

        Circle circle = new Circle(20,Color.YELLOW);
        Image im = new Image("packman1.png",false);
        circle.setFill(new ImagePattern(im));
       
       
        Timeline animation = new  Timeline(new  KeyFrame(Duration.millis(700), e -> setBanana()));
        animation.setCycleCount(10);
        animation.play();  
      
    }
    public void setBanana(){
        if(n>=500){
            t.setText("");
            t2.setText("");
           
          
            Pane pane = new Pane();
            pane.setLayoutX(30);
            pane.setLayoutY(100);
            pane.setStyle("-fx-border-color: black; -fx-background-color: null;");
           
            Image imageM = new Image("welcomeMonkey3.gif");
            ImageView imageView = new ImageView(imageM);
            
            Text scenetitle = new Text(20,70,"Welcome");
            scenetitle.setFont(Font.font("Forte", 75));
            scenetitle.setFill(Color.MAGENTA);
            scenetitle.setStroke(Color.BLACK);
            scenetitle.setStrokeWidth(3);
            pane.getChildren().add(t);
            pane.setPrefSize(330, 350);
            pane.getChildren().add(scenetitle);
        
            Text userName = new Text(30,160,"Nickname");
            userName.setFont(Font.font("Times New Roman", 45));
            
            userName.setFill(Color.BLUE);
            userName.setStroke(Color.BLACK);
            userName.setStrokeWidth(2);
            pane.getChildren().add(userName);

            Image nickName = new Image("monkey.png");
            ImageView nickNameIV = new ImageView(nickName);
            nickNameIV.setFitHeight(50);
            nickNameIV.setFitWidth(50);
            nickNameIV.setLayoutX(230);
            nickNameIV.setLayoutY(130);
            pane.getChildren().add(nickNameIV);
        
            userTextField.setFont(Font.font("Forte", FontWeight.NORMAL, 25));
            userTextField.setPrefSize(180, 10);
            userTextField.setLayoutX(30);
            userTextField.setLayoutY(200);
            pane.getChildren().add(userTextField);

            btPlay.setFont(Font.font("Forte", 40));
            btPlay.setTextFill(Color.WHITE);
            btPlay.setStyle("-fx-border-color: black; -fx-background-color: green;");
            btPlay.setLayoutX(150);
            btPlay.setLayoutY(270);
            btPlay.setPrefSize(160, 50);
            pane.getChildren().add(btPlay);

            
            Image welcomeMonkey = new Image("welcomeMonkey3.gif");
            ImageView welcomeImageView = new ImageView(welcomeMonkey);
            welcomeImageView.setLayoutX(240);
            welcomeImageView.setLayoutY(80);
            welcomeImageView.setFocusTraversable(false);
            getChildren().add(welcomeImageView);
            getChildren().add(pane);
            pane.setStyle("-fx-background-color: rgba(199, 255, 251, 0.7); -fx-border-color: black; ");
          

            
        }
        Circle circle = new Circle(n,520,30);
        Image im = new Image("banana.png",false);
        circle.setFill(new ImagePattern(im));
        getChildren().add(circle);
        n=n+50;
    }
    public Button getButton(){
        return this.btPlay;
    }
    public String getUserName(){
        return userTextField.getText();
    }
  
    
}