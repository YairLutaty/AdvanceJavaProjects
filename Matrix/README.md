# Matrix Project

This JavaFX application generates a grid-based matrix on a canvas and randomly fills 10% of the cells each time a button is pressed. It provides a simple visualization of structured grids and random selection.

How It Works
* Matrix.java → The main JavaFX application that loads the UI from Matrix.fxml.

* MatrixController.java → Handles user interactions, draws the grid, and randomly paints cells.

* Matrix.fxml → Defines the graphical user interface layout with a Canvas and a Button.

Features
- Dynamically draws a grid based on the canvas size.
- 10×10 pixel cells create a structured matrix.
- Randomly fills 10% of the grid cells on each button press.
- Avoids duplicate selections for painted cells.
- Easy reset and re-randomization with each press.

Usage
1. Press the button to generate a grid on the canvas.
2. The program randomly fills 10% of the grid cells with color.
3. Pressing the button again resets and regenerates a new random selection.
