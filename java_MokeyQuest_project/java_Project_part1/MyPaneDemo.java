import  javafx.animation.KeyFrame;
import  javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.*;
import  javafx.beans.property.DoubleProperty;
import javafx.scene.image.*;
import  javafx.scene.layout.Pane;
import  javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import  javafx.scene.shape.Circle;
import  javafx.util.Duration;
import  javafx.scene.Scene;
public class MyPaneDemo extends Application {
    public void start(Stage prStage){
        MyPane2 pane  = new MyPane2();
        Scene scene  = new Scene(pane,560,560);
        prStage.setScene(scene);
        prStage.show();
    }
    public static void main(String[] args){
        Application.launch(args);
    }
}