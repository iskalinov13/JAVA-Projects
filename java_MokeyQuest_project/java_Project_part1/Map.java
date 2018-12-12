import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;

public class Map extends Pane {
    private final int unit = 70;
    private int size;
    private int[][] map ;
    private Position start;

    public Map(String fileName) throws FileNotFoundException {
        Image image  = new Image("fon.jpg",false);
        ImageView imageView = new ImageView(image);;
        imageView.setFitHeight(unit*8);
        imageView.setFitWidth(unit*8);
        getChildren().add(imageView);

        File file = new File(fileName);
        Scanner input = new Scanner(file);
        
        while(input.hasNext()) {
                size=input.nextInt();
                map = new int[size][size];
                Image wall = new Image("plant1.gif",false);

            for(int i=0;i<map.length;i++){
                for(int j=0;j<map[i].length;j++){
                    map[i][j]=input.nextInt();
                    
                    if(map[i][j]==2)
                        start=new Position(j,i);
                        
                    Rectangle rec = new Rectangle(unit*j, unit*i, unit, unit);
                    rec.setStroke(Color.BLACK);
                    rec.setFill((map[i][j]==1) ? (new ImagePattern(wall, 0, 0, 1, 1, true)):Color.TRANSPARENT);
                    getChildren().add(rec);
                            
            
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
              

        }
        
    }
    public int getUnit(){
        return this.unit;
    }
    public int getSize(){
        return this.size;
    }
    public Position getStartPosition(){
        return start;
    } 
    public int[][] getMap(){
        int [][] array = new int[this.size][this.size];
        for(int i=0;i<this.map.length;i++)
        {
            for(int j=0;j<this.map[i].length;j++)
            {
                array[i][j]=map[j][i];
            }
        }
        return array;
    }
}