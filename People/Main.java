import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[]args){
		
		Scanner scan = new Scanner(System.in);
		//------------------------------------------------------------------------------//
		//---------------------------------Q1.C-----------------------------------------//
		//------------------------------------------------------------------------------//
		System.out.println("Please enter 6 inputs to create a Linked List");
		LinkedList<String> inputList1 = new LinkedList<String>();
		
		// Inserting the items to the linked list
		for(int i = 0; i < 6; i++) {
			inputList1.add(scan.nextLine());
		}
		
		System.out.println(inputList1); // printing the linked list in order
		
		LinkedList<String> inputList2 = new LinkedList<String>();
		Stack<String> st = new Stack<String>();
		
		for(int i = 0 ; i < 6 ; i++) {
			try {
				st.push(inputList1.remove()); // inserting the items to stack
			} catch (EmptyListException e) {
				// if the list was too short - this will present a warning to user
				e.printStackTrace();
			}
		}
		
		while(!st.isEmpty()) {
			inputList2.add(st.pop()); // adding the items in reverse using stack
		}
		
		
		System.out.println(inputList2); // printing the linked list in reverse order
		//------------------------------------------------------------------------------//
		//---------------------------------Q1.E-----------------------------------------//
		//------------------------------------------------------------------------------//
		LinkedList<Person> inputList3 = new LinkedList<Person>();
		Person p1 = new Person("Bubbba Ray-Dudley",111111111,1998);
		Person p2 = new Person("Jamie Lannister",222222222,1987);
		Person p3 = new Person("Yossi Yossi",333333333,1960);
		Person p4 = new Person("Donny Darko",555555555,1970);
		inputList3.add(p1);
		inputList3.add(p2);
		inputList3.add(p3);
		inputList3.add(p4);
		
		Person maxPerson;
		try {
			maxPerson = MaxMethod.max(inputList3);
			System.out.println(maxPerson);
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
		//------------------------------------------------------------------------------//
		//---------------------------------Q1.E-----------------------------------------//
		//------------------------------------------------------------------------------//
		
	}
}
