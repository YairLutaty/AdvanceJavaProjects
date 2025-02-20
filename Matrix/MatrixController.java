import java.util.ArrayList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * This class is the controller class for Matrix class using Javafx.
 */
public class MatrixController {

	@FXML
	private Canvas canv;

	private GraphicsContext gc;
	// As instructed on the assignment  - assuming the gap between two lines in matrix is 10 pixels.
	final private int CELL_WIDTH = 10;
	final private int CELL_HEIGHT= 10;

	public void initialize() {
		gc = canv.getGraphicsContext2D(); 
	}

	@FXML
	//The function that is activated when a button is pressed by user.
	void drawPressed(ActionEvent event) {
		// Acquiring the canvas height and width values.
		int canvWidth = (int) canv.getWidth();
		int canvHeight = (int) canv.getHeight();

		// Acquiring the matrix number of rows and column values based on canvas size.
		int numRows = canvHeight/10;
		int numCols = canvWidth/10;

		gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());

		// Painting the column of our matrix.
		for (int col = 0; col <= numCols; col++) {
			double x = col * CELL_WIDTH;
			gc.strokeLine(x, 0, x, canvHeight);
		}

		// Painting the rows of our matrix.
		for (int row = 0; row <= numRows; row++) {
			double y = row * CELL_HEIGHT;
			gc.strokeLine(0, y, canvWidth, y);
		}

		paintMatrixSlots(numRows,numCols);
	}


	// This method paints the slots of initialized, identified by its number of rows and column
	// such that 10% of all available slots are painted over exactly in each time the program runs.
	public void paintMatrixSlots (int numRows , int numCols) {
		Random r = new Random(); // Selecting random value for further iterations with rows and column.
		ArrayList<String> existingSlots = new ArrayList<String>();// Creating arraylist to "host" all found painted slots.
		int limitOfSize = (numRows*numCols)/10; // Determining the size that is the 10% of all matrix slots limit
		String addedSlot;
		boolean flag = true;


		while(existingSlots.size() < limitOfSize) {
			int randRow = r.nextInt(numRows);
			int randCol = r.nextInt(numCols);
			double x = randCol * CELL_WIDTH;
			double y = randRow * CELL_HEIGHT;
			// Creating a "name" for each slot we'll find to compare to all found slots to this point.
			addedSlot = ""+x+","+y+".";
			// Painting slots in the created matrix with the limit of 10% of available slots to reach.
			for(int j = 0 ; j < existingSlots.size() ; j++ ) {
				if (existingSlots.get(j).equals(addedSlot)) {
					flag = false; // Identifier  - if slot that was previously selected has come up, know to ignore it.
					continue;
				}
			}
			if (flag == true) {// New slot not yet painted was found
				existingSlots.add(addedSlot);// Adding to list of slots already painted
				gc.fillRect(x, y, CELL_WIDTH, CELL_HEIGHT); // Paint our new found slot
			}
			else {
				flag = true; //Reinstate it to true for next iteration.
			}
		}
	}
}
