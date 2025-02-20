//------------------------------------------------------------------------------//
//---------------------------------Q1.A-----------------------------------------//
//------------------------------------------------------------------------------//
// A generic cell class for use in a linked list.
public class Cell <E> {
	
	private E cellData;
	private Cell <E> nextCell;
	
	// Constructs a cell with the given data and no next cell.
	public Cell(E cellData) {
		this.cellData = cellData;
		this.nextCell = null;
	}
	
	// Constructs a cell with the given data and a reference to the next cell.
	public Cell(E cellData, Cell <E> nextCell) {
		this.cellData = cellData;
		this.nextCell = nextCell;
	}
	// Gets the data stored in this cell.
	public E getCellData() {
		return cellData;
	}
	// Sets the data stored in this cell.
	public void setCellData(E cellData) {
		this.cellData = cellData;
	}
	// Gets the next cell in the list.
	public Cell<E> getNextCell() {
		return nextCell;
	}
	
	// Sets the next cell in the list.
	public void setNextCell(Cell<E> nextCell) {
		this.nextCell = nextCell;
	}
	
}
