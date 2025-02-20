# Shape Drawer Project

This JavaFX application allows users to draw shapes (Lines, Rectangles, and Ellipses) on a canvas using mouse gestures. Users can pick colors, toggle shape fill, and use Undo or Clear functionality.

How It Works

* ShapesDrawer.java → Loads the JavaFX UI and starts the application.

* ShapesDrawerController.java → Handles user interactions, including shape selection, mouse actions, color picking, and undo/clear functions.

* ShapesDrawerController.fxml → Defines the graphical user interface with a canvas, shape selection, color picker, and buttons.

Features
- Draw shapes (Line, Rectangle, Ellipse) by clicking & dragging
- Choose stroke color and fill options
- Undo last shape and clear the canvas
- Interactive JavaFX-based UI

How to Use
1. Select a shape (Line, Rectangle, or Ellipse).
2. Choose a color using the color picker.
3. Click and drag on the canvas to draw the shape.
4. Use the Undo button to remove the last shape.
5. Use the Clear button to remove all shapes.

Example Usage
1. Draw a red ellipse: Select "Ellipse", pick red, click and drag to draw.
2. Draw a blue rectangle without fill: Select "Rectangle", pick blue, set "Don't fill", then draw.
3. Undo the last shape: Click Undo.
4. Clear all shapes: Click Clear.
