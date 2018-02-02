/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chaseallen
 */
public class CheckerboardFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public AnchorPane anchorPane;
    
    private int numRows = 8;
    private int numCols = 8;
    private double boardWidth;
    private double boardHeight;
    private double offsetWidth;
    private double offsetHeight;
    private String color = "";
    board.Checkerboard checker;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void start(Stage stage){
        
        boardHeight = stage.getHeight();
        boardWidth = stage.getWidth();
        offsetHeight = stage.getHeight() - anchorPane.getHeight();
        
        
        board.Checkerboard checker = new board.Checkerboard(numRows,numCols,anchorPane.getWidth(), anchorPane.getHeight());
        AnchorPane anchor = checker.build();
        anchorPane.getChildren().add(anchor);
        
        stage.heightProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            boardHeight = newValue.doubleValue();
            create();
        });
        
        stage.widthProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            boardWidth = newValue.doubleValue();
            create();
        });
    }
    
    private void create(){
        clear();
        board.Checkerboard board;
        if(color.equals("Blue")){
            board = new board.Checkerboard(numRows, numCols, boardWidth, boardHeight - offsetHeight, Color.SKYBLUE, Color.DARKBLUE);
        }else{
            board = new board.Checkerboard(numRows, numCols, boardWidth, boardHeight - offsetHeight);
        }
        AnchorPane anchor = board.build();
        anchorPane.getChildren().add(anchor);
    }
    
    private void clear(){
        anchorPane.getChildren().clear();
    }
    
    
    @FXML
    private void blueBoard(){
        color = "Blue";
        create();
    }
    
    @FXML
    private void defaultBoard(){
        color = "";
        create();
    }
    
    @FXML
    private void set16(){
        numRows = 16;
        numCols = 16;
        create();
    }
    
    @FXML
    private void set10(){
        numRows = 10;
        numCols = 10;
        create();
    }
    
    @FXML
    private void set8(){
        numRows = 8;
        numCols = 8;
        create();
    }
    
    @FXML
    private void set3(){
        numRows = 3;
        numCols = 3;
        create();
    }
    
}
