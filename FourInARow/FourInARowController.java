
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class FourInARowController {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button clear;

    @FXML
    private GridPane grid;

    private Pane gameGrid[][];	// Array of panes representing the game cells
    private final int ROW_SIZE = 6;
    private final int COL_SIZE = 7;
    private FourInARowGameLogic gameLogic; // Game logic instance
    private final double centerX = 35;	// X-coordinate for token center
    private final double centerY = 35;	// Y-coordinate for token center
    private final double radius = 30;	// Radius of the tokens
    
    
 // Initializes the game board and sets up the panes
    public void initialize() {
    	gameGrid = new Pane [ROW_SIZE][COL_SIZE];
    	
    	gameLogic = new FourInARowGameLogic();
    	
    	for (int i = 0; i < ROW_SIZE; i++) {
    		
    		for (int j = 0; j < COL_SIZE; j++) {
    			// building the gameGrid
    			gameGrid[i][j] = new Pane();
    			gameGrid[i][j].setStyle("-fx-border-color: black; -fx-border-width: 1px;");
    			gameGrid[i][j].setPrefSize((grid.getPrefWidth()/COL_SIZE),(grid.getPrefHeight()/ROW_SIZE));
    			grid.add(gameGrid[i][j], j, i);
    			
    		}
    	}
    		
    	
    }
    // Event handler for the "Clear" button
    @FXML
    void pressedClear(ActionEvent event) {
    	gameLogic.clearTable();
    	gameLogic.currPlayer = gameLogic.startingPlayer;
    	resetGame();
    }
    // Event handler for column buttons (1-7)
    @FXML
    void insertionPressed(ActionEvent event) {
    	Button chosenButton = (Button)event.getSource();
    	int selectedCol = Integer.parseInt(chosenButton.getText()) - 1;
    	
    	insertTokenToCol(selectedCol);
    	
    	if(gameLogic.winnerSituation == true) {
    		resetGame();
    		gameLogic.winnerSituation = false;
    	}
    	
    }
    // Inserts a token into the specified column
    public void insertTokenToCol(int selectedCol) {
    	int row = gameLogic.insertNewToken(selectedCol); 
    	if(row < 0) { // illegal move - ignore this turn.
    		return;
    	}
    	else {
    		int turn = gameLogic.getGameTable()[row][selectedCol];
    		if (turn == 1) { // Red's turn
    			drawCircle(row,selectedCol,Color.RED);
    		}
    		else{ // Blue's turn
    			drawCircle(row,selectedCol,Color.BLUE);
    		}
    	}
    }
    // Draws a colored circle (token) in the specified cell
    public void drawCircle(int row, int col, Color color) {
    	Circle token = new Circle(centerX, centerY, radius);
    	token.setFill(color);
    	gameGrid[row][col].getChildren().add(token);
    }
    // Resets the game board by removing all tokens
    private void resetGame() {
    	for (int i = 0; i < ROW_SIZE; i++) {
    		for (int j = 0; j < COL_SIZE; j++) {
    			
    			if(gameGrid[i][j].getChildren().size() > 0) {
    			gameGrid[i][j].getChildren().remove(0);
    			}
    		}
    	}
    }

}
