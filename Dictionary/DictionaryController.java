import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DictionaryController {

    @FXML
    private Button AddButton;

    @FXML
    private Button ChangeButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private TextField ExpressionMeaningTextField;

    @FXML
    private TextField ExpressionTextField;

    @FXML
    private Button NextWordButton;

    @FXML
    private Button PreviousWordButton;

    @FXML
    private Button SearchButon;
    
    @FXML
    private Label LableReturn; // Label for displaying messages to the user
    
    private String wordEnterd;
    private String meaningEnterd;
    private Dictionary dictionary;
    
    public void initialize() {
    	updateStrings(); // Initialize input strings
    	clearTextFields(); // Clear text fields
    	dictionary = new Dictionary(); // Initialize the dictionary
    }
    
    @FXML
    // Logic for adding a word
    void AddPressed(ActionEvent event) {
    	if(handleNullWordOrMeaning())// Check if word or meaning is empty
    		return;
    	
    	if(!dictionary.wordExistence(wordEnterd)) { // If the word does not exist, add it to the dictionary
    		dictionary.addWord(wordEnterd, meaningEnterd);
    		LableReturn.setText("The word: '" + wordEnterd + "' has been added to the dictionary.");
    	}
    	
    	else { // If the word already exists, display a message
    		LableReturn.setText("The word: '" + wordEnterd + "' already exists in the dictionary."
    				+ "\nNo word was added.");
    	}
    	
    	clearTextFields();
    }
    
    @FXML
    // Logic for searching a word
    void SearchPressed(ActionEvent event) { 
    	if(handleNullWord()) // Check if word is empty
    		return;
    	
    	if(dictionary.wordExistence(wordEnterd)) { // If the word exists, display its meaning
    		this.meaningEnterd = dictionary.getMeaning(wordEnterd);
    		LableReturn.setText("The meaning of the word '" + wordEnterd + "' is: \n"+this.meaningEnterd + ".");
    	}
    	
    	else { // If the word does not exist, display a message
    		LableReturn.setText("The word: '" + wordEnterd + "' not in the dictionary.");
    	}
    	
    	clearTextFields();
    }
    
    @FXML
    // Logic for deleting a word
    void DeletePresed(ActionEvent event) {
    	if(handleNullWord()) // Check if word is empty
    		return;
    	
    	if(dictionary.wordExistence(wordEnterd)) { // If the word exists, delete it
    		dictionary.removeWord(wordEnterd);
    		LableReturn.setText("The word: '" + wordEnterd + "' has been removed from the dictionary");
    	}
    	
    	else { // If the word does not exist, display a message
    		LableReturn.setText("The word: '" + wordEnterd + "' not in the dictionary."
    				+ "\nNo word was removed.");
    	}
    	
    	clearTextFields();
    }
    @FXML
    // Logic for changing the meaning of a word
    void ChangePressed(ActionEvent event) {
    	if(handleNullWordOrMeaning()) // Check if word or meaning is empty
    		return;
    	
    	if(dictionary.wordExistence(wordEnterd)) { // If the word exists, update its meaning
    		dictionary.removeWord(wordEnterd); // Remove the existing word
    		dictionary.addWord(wordEnterd, meaningEnterd); // Add the word with new meaning
    		LableReturn.setText("The word: '" + wordEnterd + "' meaning has been changed."
    				+ "\nThe new meaning is: \n" + meaningEnterd + ".");
    	}
    	
    	else { // If the word does not exist, display a message
    		LableReturn.setText("The word: '" + wordEnterd + "' not in the dictionary."
    				+ "\nNo changes were made.");
    	}
    	
    	clearTextFields();
    	
    }
    
    // Update the wordEnterd and meaningEnterd strings from the text fields
    private void updateStrings(){
    	this.wordEnterd = ExpressionTextField.getText();
    	this.meaningEnterd = ExpressionMeaningTextField.getText();
    	return;
    }
    
    // Check if the word is empty
    private boolean handleNullWord() {
    	updateStrings(); // Update strings from text fields
    	if(wordEnterd.isEmpty()) { // Check if word is empty
    		LableReturn.setText("You have enterd an empty expression, \nNo action was taken!");
    		return true;
    	}
    	return false;
    }
    
    // Check if the word or meaning is empty
    private boolean handleNullWordOrMeaning() {
    	updateStrings(); // Update strings from text fields
    	if(wordEnterd.isEmpty() || meaningEnterd.isEmpty()) { // Check if word or meaning is empty
    		LableReturn.setText("You have enterd an empty expression or meaning,\nNo action was taken!");
    		return true;
    	}
    	return false;
    }
    
    // Clear the text fields
    private void clearTextFields() {
    	ExpressionMeaningTextField.clear();
    	ExpressionTextField.clear();
    	
    }
    
    // Check if the word exists in the dictionary
    private boolean wordVerification(String word) {
    	if(dictionary.wordExistence(word)) // Check if word exists
    		return true;
    	LableReturn.setText("The word '" + wordEnterd + "' is not in dictionary. ");
    	return false;
    }
    
    @FXML
    // Logic for navigating to the next word
    void NextWordPressed(ActionEvent event) {
    	handleNullWord(); // Check if word is empty
    	if (!wordVerification(wordEnterd)) // Verify if word exists in the dictionary
    		return;
    	
    	String word = dictionary.nextWord(wordEnterd); // Get the next word
    	String meaning = "";
    	if(word == null) { // If there is no next word, display a message
    		LableReturn.setText("The word '" + wordEnterd + "' is the last word in dictionary. "
    				+ "\nNo word is afterwards.");
    	}
    	else { // If there is a next word, display it and its meaning
    		meaning = dictionary.getMeaning(word);
    		LableReturn.setText("The word '" + word + "' is the word after '" + wordEnterd + "' in dictionary. "
    				+ "\nAnd the meaning is: \n" + meaning + ".");
    	}
    	clearTextFields();
    }

    @FXML
    // Logic for navigating to the previous word
    void PreviousWordPressed(ActionEvent event) {
    	handleNullWord(); // Check if word is empty
    	if (!wordVerification(wordEnterd))  // Verify if word exists in the dictionary
    		return;
    	
    	String word = dictionary.previousWord(wordEnterd); // Get the previous word
    	String meaning = "";
    	if(word == null) { // If there is no previous word, display a message
    		LableReturn.setText("The word '" + wordEnterd + "' is the first word in dictionary. "
    				+ "\nNo word is before it.");
    	}
    	else { // If there is a previous word, display it and its meaning
    		meaning = dictionary.getMeaning(word);
    		LableReturn.setText("The word '" + word + "' is the word before '" + wordEnterd + "' in dictionary. "
    				+ "\nAnd the meaning is: \n" + meaning + ".");
    	}
    	clearTextFields();
    }

}
