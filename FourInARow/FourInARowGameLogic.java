import javafx.scene.control.Alert;

public class FourInARowGameLogic {
	
	public int currPlayer;
	public int startingPlayer = 1; // 1 means - red turn
	
	private int gameTable[][];
	private final int ROW_SIZE = 6;
	private final int COL_SIZE = 7;
	private String message;
	public boolean winnerSituation = false;
	
	public FourInARowGameLogic(){
		setGameTable(new int[ROW_SIZE][COL_SIZE]);
		currPlayer = startingPlayer;
	}
	
	// Checking if there is a winner in current game table under the "connect4" rules
	public boolean isThereAWinner(int player) {
		// Check in rows
		for(int i = 0; i < ROW_SIZE; i++) {
			for(int j = 0; j < COL_SIZE-3; j++) {
				if(getGameTable()[i][j] == getGameTable()[i][j+1] &&
					getGameTable()[i][j] == getGameTable()[i][j+2] &&
					getGameTable()[i][j] == getGameTable()[i][j+3] &&
					getGameTable()[i][j] == player )
					
					return true;		
			}
		}
		// Check in columns
		for(int i = 0; i < ROW_SIZE - 3; i++) {
			for(int j = 0; j < COL_SIZE; j++) {
				if(getGameTable()[i][j] == getGameTable()[i+1][j] &&
					getGameTable()[i][j] == getGameTable()[i+2][j] &&
					getGameTable()[i][j] == getGameTable()[i+3][j] &&
					getGameTable()[i][j] == player )
					
					return true;
					
			}
		}
		// Check in diagonal (first kind)
		for(int i = 0; i < ROW_SIZE-3; i++) {
			for(int j = 0; j < COL_SIZE-3; j++) {
				if(getGameTable()[i][j] == getGameTable()[i+1][j+1] &&
					getGameTable()[i][j] == getGameTable()[i+2][j+2] &&
					getGameTable()[i][j] == getGameTable()[i+3][j+3] &&
					getGameTable()[i][j] == player )
					return true;
					
			}
		}
		// Check in diagonal (second kind)
		for(int i = 3; i < ROW_SIZE; i++) {
			for(int j = 0; j < COL_SIZE - 3; j++) {
				if(getGameTable()[i][j] == getGameTable()[i-1][j+1] &&
					getGameTable()[i][j] == getGameTable()[i-2][j+2] &&
					getGameTable()[i][j] == getGameTable()[i-3][j+3] &&
					getGameTable()[i][j] == player )
					return true;
					
			}
		}
		// if no kind of winning pattern was found - return false.
		return false;
	}
	
	// Find the next possible row (if exists) that the token can be inserted to in selected column
	public int rowToInsert(int checkdCol){
		int currRow = ROW_SIZE-1;
		while (currRow >= 0 && 
				(getGameTable()[currRow][checkdCol] == 1 || 
				 getGameTable()[currRow][checkdCol] == 2)) {
			currRow--;
		}
		
		return currRow;
	}
	
	// Insertion of the new token to the selected column
	public int insertNewToken(int pressedCol) {
		int chosenRow = rowToInsert(pressedCol);
		if(chosenRow < 0) {
			message = "Column is already full!!!";
			showAlert(message);
		}
		else {
			if (currPlayer == 1) {
				getGameTable()[chosenRow][pressedCol] = currPlayer;
			}
			else {
				getGameTable()[chosenRow][pressedCol] = currPlayer;
			}
			if(isThereAWinner(currPlayer)) {
				winningCeremony();
			}
			reversePlayers();
		}
		return chosenRow;
		
	}
	// Switching between the 2 players turns
	public void reversePlayers() {
		currPlayer = (currPlayer == 1) ? 2 : 1;
	}
	
	// Displays a winning message and resets the game
	public void winningCeremony() {
		if(currPlayer == 1) {
			message = "Player RED has WON!!! \nnew game will start immediately.";
		}
		else {
			message = "Player BLUE has WON!!! \nnew game will start immediately.";
		}
		showAlert(message);
		clearTable();
		currPlayer = startingPlayer;
		winnerSituation = true;
	}
	
	// Clears the game board (sets all cells to 0)
	public void clearTable() {
		for (int i = 0 ; i < ROW_SIZE; i++) {
			for (int j = 0 ;j < COL_SIZE; j++) {
				gameTable[i][j] = 0;
			}
		}
		
	}
	
	 // This function receives a string and it returns it to the user using the pre-initialized JAVAFX tools.
    public void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }// End of showAlert function

	// Game table getter
    public int[][] getGameTable() {
		return gameTable;
	}
    // Game table setter
	public void setGameTable(int gameTable[][]) {
		this.gameTable = gameTable;
	}
}