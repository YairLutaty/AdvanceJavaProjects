//------------------------------------------------------------------------------//
//---------------------------------Q1.B-----------------------------------------//
//------------------------------------------------------------------------------//
// This class will create the warning for an empty list exception
public class EmptyListException extends Exception {
	
	public EmptyListException() {}
	
	public EmptyListException(String str) {
		super(str);
	}
}
