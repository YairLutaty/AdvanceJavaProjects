import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

public class ShapesDrawerController {

    @FXML
    private ColorPicker colorPicked;

    @FXML
    private Pane paneTop;

    @FXML
    private ChoiceBox<String> shapeChoiceBox;

    @FXML
    private ChoiceBox<String> shapeFillChoiceBox;

    @FXML
    void colorPressed(ActionEvent event) {
    }
    
    private Shape currShape = null;
    
    // List of available shapes    
    ObservableList<String> shapeChoiceBoxList = FXCollections
    		.observableArrayList("Line", "Rectangle", "Ellipse");
    
    // List of fill options
    ObservableList<String> shapeFillChoiceBoxList = FXCollections
    		.observableArrayList("Fill", "Dont fill");
    
    final ArrayList<Shape> drawnShapesList = new ArrayList<>();
    
    final Color Transparant =  new Color(0, 0, 0, 0);
    
    static double paneTopFirstX;
    static double paneTopFirstY;
    static double paneTopSecondX;
    static double paneTopSecondY;
    
    public void initialize() {
    	// Initialize shape choice box
    	shapeChoiceBox.setItems(shapeChoiceBoxList);
    	shapeChoiceBox.setValue("Line");
    	// Initialize fill choice box
    	shapeFillChoiceBox.setItems(shapeFillChoiceBoxList);
    	shapeFillChoiceBox.setValue("Fill");
    	// Set default color to black
    	colorPicked.setValue(Color.BLACK);
    }
    // Handles the "Undo" button press event by removing the last drawn shape from the list of drawn shapes.
    @FXML
    void undoPressed(ActionEvent event) {
    	int listSize = drawnShapesList.size();
    	if (listSize > 0) {
    		Shape shape = drawnShapesList.get(listSize-1);
    		paneTop.getChildren().remove(shape);
    		drawnShapesList.remove(shape);
    	}
    }
    
    // Handles the "Clear" button press event by removing all shapes from the pane.
    @FXML
    void clearPressed(ActionEvent event) {
    	paneTop.getChildren().remove(currShape);
    	paneTop.getChildren().clear();
    	
    	
    }
    // Retrieves the selected color from the color picker.
    Paint getTopPaneColor() {
    	Paint color = colorPicked.getValue();
		return color;
    }
    
    //Handles the mouse press event by recording the initial coordinates.
    @FXML
    void mousePress(MouseEvent event) {
    	double x = event.getX();
    	double y = event.getY();
    	paneTopFirstX = x;
    	paneTopFirstY = y;

    }
    // Handles the mouse release event by recording the final coordinates 
    // and calling the appropriate shape creation method.
    @FXML
    void mouseRelease(MouseEvent event) {
    	double x = event.getX();
    	double y = event.getY();
    	paneTopSecondX = x;
    	paneTopSecondY = y;
    	
    	handleSelectionOfShape();	
    }
    
    // Creates a new line shape.
    Line createLine(Pane pane, double startX, double startY, double endX, double endY) {
    	Line newLine = new Line();
    	newLine.setStartX(startX);
    	newLine.setStartY(startY);
    	newLine.setEndX(endX);
    	newLine.setEndY(endY);
    	newLine.setFill(getTopPaneColor());
    	return newLine;
    	
    }
    // Creates a new Rectangle shape.
    Rectangle createRectangle(Pane pane, double startX, double startY, double endX, double endY) {
    	Rectangle newRectangle = new Rectangle();
    	newRectangle.setX(Math.min(startX,endX));
    	newRectangle.setY(Math.min(startY, endY));
    	newRectangle.setWidth(Math.abs(startX - endX));
    	newRectangle.setHeight(Math.abs(startY - endY));
    	shapesManager(newRectangle);
    	
    	return newRectangle;
    	
    	
    }
    // Creates a new Ellipse shape.
    Ellipse createEllipse(Pane pane, double startX, double startY, double endX, double endY) {
    	Ellipse newEllipse = new Ellipse();
    	newEllipse.setCenterX((startX + endX)/2);
    	newEllipse.setCenterY((startY + endY)/2);
    	newEllipse.setRadiusX((Math.abs(startX - endX))/2);
    	newEllipse.setRadiusY((Math.abs(startY - endY))/2);
    	shapesManager(newEllipse);
    	
    	return newEllipse;
    }
    
    // Sets the fill color of the given shape based on the selected fill option.
    void shapesManager(Shape shape) {
    	String selectedFill = shapeFillChoiceBox.getValue();
    	if (selectedFill == "Fill") {
    		shape.setFill(getTopPaneColor());
    	}
    	else {
    		shape.setFill(Transparant);
    	}
    }
    // Organizes the current shape by setting its stroke color, adding it to 
    // the pane,and updating the list of drawn shapes
    void shapeOrganizer() {
    	currShape.setStroke(getTopPaneColor());
    	paneTop.getChildren().add(currShape);
    	drawnShapesList.add(currShape);
    }
    // Handles the selection of a shape based on the user's choice.
    // Creates the appropriate shape and organizes it.
    void handleSelectionOfShape() {
    	String selectedShape = shapeChoiceBox.getValue();
    	switch (selectedShape) {
            case "Line":
            	// Handle Line drawing logic
            	currShape = createLine(paneTop, paneTopFirstX, paneTopFirstY, paneTopSecondX, paneTopSecondY);
            	shapeOrganizer();
                break;
            case "Rectangle":
            	// Handle Rectangle drawing logic
            	currShape = createRectangle(paneTop, paneTopFirstX, paneTopFirstY, paneTopSecondX, paneTopSecondY);
            	shapeOrganizer();
                // Handle curve drawing logic
                break;
            case "Ellipse":
            	// Handle Ellipse drawing logic
            	currShape = createEllipse(paneTop, paneTopFirstX, paneTopFirstY, paneTopSecondX, paneTopSecondY);
            	shapeOrganizer();
                break;
        }
    }

}
