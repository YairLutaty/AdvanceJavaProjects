import java.util.TreeMap;

public class Dictionary {
	
	private TreeMap<String,String> wordsAndMeaning; // TreeMap to store words and their meanings
	
	public Dictionary() {
		wordsAndMeaning = new TreeMap<>();  // Initialize the TreeMap
	}
	
	// Method to add a word and its meaning to the dictionary
	public void addWord(String word, String meaning) {
		if (wordExistence(word)) { // If the word already exists, do nothing
			return;
		}
		else { // Add the word and meaning, converting the word to lowercase
			wordsAndMeaning.put(word.toLowerCase(), meaning);
		}
    }

	// Method to get the meaning of a word
    public String getMeaning(String word) {
        return wordsAndMeaning.get(word.toLowerCase()); // Retrieve the meaning of the word, converting to lowercase
    }

    // Method to remove a word from the dictionary
    public void removeWord(String word) {
    	wordsAndMeaning.remove(word.toLowerCase()); // Remove the word, converting to lowercase
    }
    
    // Method to check if a word exists in the dictionary
    public boolean wordExistence(String word) {
    	if(wordsAndMeaning.containsKey(word)) // Check existence of the word, converting to lowercase
    		return true;
    	return false;
    }
    
    // Method to get the next word in the dictionary
    public String nextWord(String word) {
    	String next = wordsAndMeaning.higherKey(word); // Get the next word, converting to lowercase
    	return next;
    }
    
    // Method to get the previous word in the dictionary
    public String previousWord(String word) {
    	String previous = wordsAndMeaning.lowerKey(word); // Get the previous word, converting to lowercase
    	return previous;
    }
}
