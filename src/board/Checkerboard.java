/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author chaseallen
 */
public class Checkerboard {
    
    private int numRows;
    private int numCols;
    private int x = 0;
    private int y = 0;
    private double rectWidth;
    private double rectHeight;
    private double boardWidth;
    private double boardHeight;
    private Color lightColor;
    private Color darkColor;
    private int switcher = 0;
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
   
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight){
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        lightColor = Color.RED;
        darkColor = Color.BLACK;
    }
    
    
    public AnchorPane build(){
        rectWidth = getRectangleWidth();
        rectHeight = getRectangleHeight();
        AnchorPane anchorPane = new AnchorPane();
        
        for(int i = 0; i < numRows; i++){
            switcher = i;
            for(int j = 0; j < numCols; j++){
                Rectangle rect = new Rectangle(x, y, rectWidth, rectHeight);
                Color color = switcher % 2 == 0 ? lightColor : darkColor;
                rect.setFill(color);
                anchorPane.getChildren().add(rect);
                switcher++;
                x += rectWidth;
            }
            x = 0;
            y += rectHeight;
        }
        return anchorPane;
    }
    
    public AnchorPane getBoard(){
        if(build() != null){
            return null;
        }else{
            return build();
        }
    }
    
    public int getNumRows(){
        return numRows;
    }
    
    public int getNumCols(){
        return numCols;
    }
    
    public double getWidth(){
        return boardWidth;
    }
    
    public double getHeight(){
        return boardHeight;
    }
    
    public Color getLightColor(){
        return lightColor;
    }
    
    public Color getDarkColor(){
        return darkColor;
    }
    
    public double getRectangleWidth(){
        return Math.ceil(boardWidth / numCols);
    }
    
    public double getRectangleHeight(){
        return Math.ceil(boardHeight / numRows);
    }
    
}
