//------------------------------------------------------------------------------//
//---------------------------------Q1.B-----------------------------------------//
//------------------------------------------------------------------------------//
// A generic linked list implementation.
public class LinkedList <E>{
	
	private Cell <E> head;
	private Cell <E> tail;
	
	// Constructs an empty linked list.
	public LinkedList () {
		this.head = null;
		this.tail = null;
	}
	
	// Gets the head of the list
	public Cell<E> getHead() {
		return this.head;
	}
	
	// Gets the tail of the list
	public Cell<E> getTail() {
		return this.tail;
	}
	
	// Adds a new cell with the given data to the end of the list.
	public void add(E cellData) {
		if(head == null) { // case empty list
			Cell<E> newCell = new Cell<E>(cellData);
			this.tail = newCell;
			this.head = newCell;
		}
		else {
			Cell <E> newCell = new Cell<E>(cellData);
			tail.setNextCell(newCell);
			tail = newCell;
		}
	}
	
	// Removes and returns the data from the head of the list.
	public E remove() throws EmptyListException{
		if(head == null) {
			throw new EmptyListException("List is empty, cant remove head");
		}
		
		E deletedCellData = this.head.getCellData();
		if (this.head == this.tail) { // case that there is only one cell in list
			this.tail = null;
			this.head = null;
			return deletedCellData;
		}
		Cell <E> nextHead = this.head.getNextCell();
		this.head = nextHead;
		return deletedCellData;
	}
	
	// Returns a string representation of the linked list.
	public String toString() {
		String str = "";
		if (head == null) {
			str = "List is empty";
		}
		else {
			Cell<E> curCell = this.head;
			int i = 0;
			while (curCell != null) {
				i++;
				str += i + "." + curCell.getCellData() + "    ";
				if (i % 5 == 0) // for a more "friendly" presentation with big numbers
					str += "\n";
				curCell = curCell.getNextCell();
				
			}
		}
		return str;
	}
}
