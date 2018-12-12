import javafx.scene.image.*;

import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.paint.*;

public class MyPlayer implements Player {
    private Circle ball;
    public Map map;
    private Position position;
    
    private int[][] arrayOfMap;
    private int unit;
    
    public MyPlayer(Map map) {
        this.map = map;
        position = map.getStartPosition();
        arrayOfMap = map.getMap();
        unit = map.getUnit();
        
        int ballRadius  = unit/2;
        int ballCenterX = position.getX()*unit + ballRadius;
        int ballCenterY = position.getY()*unit + ballRadius;
        
        ball = new Circle(ballCenterX,ballCenterY,ballRadius);
        ball.setFill(Color.PINK);
        map.getChildren().add(ball);

    }

    @Override
    public void moveRight() {
        if(ball.getCenterX() + unit <= map.getWidth() && arrayOfMap[position.getX()+1][position.getY()] != 1){
            ball.setCenterX(ball.getCenterX() + unit);
            position.setX(position.getX()+1);
        }
    }

    @Override
    public void moveLeft() {
        if(ball.getCenterX() - unit >=0 && arrayOfMap[position.getX()-1][position.getY()] != 1){
            ball.setCenterX(ball.getCenterX() - unit);
            position.setX(position.getX()-1);
        }
    }

    
    @Override
    public void moveDown() {
        if(ball.getCenterY() + unit <= map.getWidth() && arrayOfMap[position.getX()][position.getY()+1] != 1){
            ball.setCenterY(ball.getCenterY() + unit);
            position.setY(position.getY()+1);
        }
    }

    
    @Override
    public void moveUp() {
        if(ball.getCenterY() - unit >=0 && arrayOfMap[position.getX()][position.getY()-1] != 1){
            ball.setCenterY(ball.getCenterY() - unit);
            position.setY(position.getY()-1);
        }
    }

    @Override
    public Position getPosition(){
        return this.position;
    }

}