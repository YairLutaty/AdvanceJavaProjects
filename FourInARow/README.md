# Four In A Row Project

This JavaFX application is a digital version of the classic "Four in a Row" (Connect Four) game. Two players take turns dropping tokens into a 7x6 grid, aiming to connect four of their tokens horizontally, vertically, or diagonally before their opponent.

How It Works

* FourInARow.java → Initializes and launches the JavaFX graphical user interface (GUI).
* FourInARowController.java → Manages user interactions, button presses, and updating the game board.
* FourInARowGameLogic.java → Implements the game rules, player turns, win conditions, and board state management.
* FourInARowController.fxml → Defines the UI layout, including the game board and buttons.

Features
- Two-player mode (Red vs. Blue)
- Interactive JavaFX-based UI
- Win detection for horizontal, vertical, and diagonal matches
- Reset button to restart the game
- Alerts for invalid moves (e.g., full columns)

How to Play
1. Players click the column buttons (1-7) to drop their token.
2. The game alternates turns between Red (Player 1) and Blue (Player 2).
3. A player wins if they connect four tokens in a row.
4. If a player wins, an alert appears, and the game automatically resets.
5. Click the "Clear" button to manually reset the board.
