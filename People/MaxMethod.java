//------------------------------------------------------------------------------//
//---------------------------------Q1.4-----------------------------------------//
//------------------------------------------------------------------------------//
// A utility class for finding the maximum value in a linked list of elements that
// must implement the Comparable interface.
public class MaxMethod{
	// This function Finds the maximum value in the linked list.
	public static <E extends Comparable<E>> E max(LinkedList<E> ls) throws EmptyListException{
		// Check that the list is not empty
		if (ls.getHead() == null) {
			throw new EmptyListException("Linked list is empty."); 
		}
		E max = ls.getHead().getCellData();
		
		// Ensure that the elements in the linked list are comparable
		if(!(max instanceof Comparable)) {
			throw new IllegalArgumentException("Linked list arguments dont implement Comparable!");
		}
		Cell<E> currentCell = ls.getHead().getNextCell();
		while (currentCell != null) {
	           if (currentCell.getCellData().compareTo(max) > 0) {
	               max = currentCell.getCellData();
	           }
	           currentCell = currentCell.getNextCell();
	       }
		return max;
	}

}
