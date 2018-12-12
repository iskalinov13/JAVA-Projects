import javafx.scene.image.*;

import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.paint.*;

import java.util.*;


public class MyBotPlayer implements BotPlayer {
    private Circle ball;
    public Map map;
    private Position position;
    private Food1 food;
    private boolean bool = true;


    private int[][] arrayOfMap;
    private int unit;
    private boolean[][] isWall;
    private int startX, startY, endX, endY;
    private int width, height;

    
    public MyBotPlayer(Map map) {
        this.map = map;
        position = map.getStartPosition();
        arrayOfMap = map.getMap();
        unit = map.getUnit();
        
        int ballRadius  = unit/2;
        int ballCenterX = position.getX()*unit + ballRadius;
        int ballCenterY = position.getY()*unit + ballRadius;
        
        ball = new Circle(ballCenterX,ballCenterY,ballRadius);
        Image image = new Image("monkey.png",false);
        ball.setFill(new ImagePattern(image));
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
    
    @Override
    public void feed(Food1 f){
        this.food = f;
    }

    @Override 
    public void traverse(){
        Position p = food.getPosition();
        new Thread(new Runnable(){
            public void run(){
                while(true){
                    if(position.getY()==p.getY() && position.getX()==p.getX() || food.getPoints()!=0){
                        break;
                    }
                    if(position.getY()%2==0){
                        moveRight();
                        try{
                            Thread.sleep(100);
                        }catch(InterruptedException ex){}
                        if(position.getY()==p.getY() && position.getX()==p.getX()){
                            try{
                                Thread.sleep(100);
                            }catch(InterruptedException ex){}
                           
                        }
                    }
                    if(position.getX()==7 || position.getX()==0){
                        moveDown();
                        try{
                            Thread.sleep(100);
                        }catch(InterruptedException ex){}
                       if(position.getY()==p.getY() && position.getX()==p.getX()){
                        try{
                            Thread.sleep(100);
                        }catch(InterruptedException ex){}
                           
                        }
                    }
                    if(position.getY()%2!=0){
                        moveLeft();
                        try{
                            Thread.sleep(100);
                        }catch(InterruptedException ex){}
                        if(position.getY()==p.getY() && position.getX()==p.getX()){
                            try{
                                Thread.sleep(100);
                            }catch(InterruptedException ex){}
                           
                        }
                    }
                }
            }
        }).start();
        
    }

    @Override 
    public void eat(){
     
        new Thread(new Runnable(){
            public void run(){
                while(true){
                    
                    if(food.getPosition()==null){
                        break;
                    }
                    else if(position.getY()<food.getPosition().getY() && position.getX()==food.getPosition().getX()){
                        moveDown();
                        try{
                            Thread.sleep(200);
                        }catch(InterruptedException ex){}  
                    }
                    else if(position.getY()>food.getPosition().getY()&& position.getX()==food.getPosition().getX()){
                         moveUp();
                         try{
                            Thread.sleep(200);
                        }catch(InterruptedException ex){}
                    }
                    else if(position.getX()<food.getPosition().getX()){
                        moveRight();
                        try{
                            Thread.sleep(200);
                        }catch(InterruptedException ex){}
                    }
                    else if(position.getX()>food.getPosition().getX()){
                        moveLeft();
                        try{
                            Thread.sleep(200);
                        }catch(InterruptedException ex){}
                        
                    }
                }
            }
        }).start();
    }

    @Override 
    public void find(){
       int[][] array = map.getMap();
       makeArrayOfWall(array);
       new Thread(new Runnable(){
        public void run(){
            while(true){
                
                if(food.getPosition()==null){break;}
                
                startX = position.getX();
                startY = position.getY();
                endX = food.getPosition().getX();
                endY = food.getPosition().getY();
                
                String path  = findShortWay();
                for(int i = 0; i<path.length();i++){
                    switch(path.charAt(i)){
                        case 'E' : moveRight();try{
                            Thread.sleep(200);
                        }catch(InterruptedException ex){};if(food.getPosition()==null){break;}if(position.equals(food.getPosition())){break;};break;
                        case 'W' : moveLeft();try{
                            Thread.sleep(200);
                        }catch(InterruptedException ex){};if(food.getPosition()==null){break;}if(position.equals(food.getPosition())){break;}break;
                        case 'S' : moveDown();try{
                            Thread.sleep(200);
                        }catch(InterruptedException ex){};if(food.getPosition()==null){break;}if(position.equals(food.getPosition())){break;}break;
                        case 'N' : moveUp();try{
                            Thread.sleep(200);
                        }catch(InterruptedException ex){};if(food.getPosition()==null){break;}if(position.equals(food.getPosition())){break;}break;

                    }
                }  
            }
        }
    }).start();
}
       
            
    
    public void makeArrayOfWall(int[][] arrayOfmap){
        this.width = map.getSize();
        this.height = map.getSize();
        this.isWall = new boolean[this.width][this.height];
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                isWall[x][y] = (arrayOfmap[x][y] == 1);
                
            }
        }
    }
    private boolean isWall(int x, int y)
    {
        if(x< 0 || x>width|| y < 0 || y > height || x==map.getSize() || y==map.getSize())
            return true;
        else{
            return isWall[x][y];
        }
    }
    public String findShortWay()
    {
        String [][] path = new String[this.width][this.height];
        path[this.startX][this.startY] = " ";
        boolean ArrayChanged = true;
        while(ArrayChanged)
        {
            ArrayChanged = false;
            for(int x = 0; x < this.width; x++)
                for(int y = 0; y < this.height; y++)
                {
                    if(isWall(x,y))
                        continue;
                    String pathS = null, pathN = null, pathE = null, pathW = null;
                    if(!isWall(x-1,y)&& path[x-1][y] !=null)
                     pathW = path[x-1][y] + "E";
                    if(!isWall(x+1,y)&& path[x+1][y] !=null)
                        pathE = path[x+1][y] + "W";
                    if(!isWall(x,y-1)&& path[x][y-1] !=null)
                     pathN = path[x][y-1] + "S";
                    if(!isWall(x,y+1)&& path[x][y+1] !=null)
                     pathS = path[x][y+1] + "N";
                     
                    String shortWay = null;
                    if(pathW !=null && (shortWay == null || pathW.length()<shortWay.length()))
                            shortWay = pathW;
                    if(pathE !=null && (shortWay == null || pathE.length()<shortWay.length()))
                        shortWay = pathE;
                    if (pathN !=null && (shortWay == null || pathN.length()<shortWay.length()))
                        shortWay = pathN;
                    if (pathS !=null && (shortWay == null || pathS.length()<shortWay.length()))
                        shortWay = pathS;
                     
                    if(shortWay ==null)
                        continue;
                     
                    if(path[x][y] ==null || shortWay.length()<path[x][y].length()){
                        path[x][y] = shortWay;
                        ArrayChanged = true;
                    }
                     
                }
        }
        return path[endX][endY];
    }
}

   
