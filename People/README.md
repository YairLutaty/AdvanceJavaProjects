# Linked List & Data Structures Of People Project

This Java project implements a generic linked list and demonstrates various data structure operations, including:

* Adding and removing elements from a linked list.
* Reversing a linked list using a stack.
* Finding the maximum value in a list of comparable elements.
* Handling exceptions when performing operations on an empty list.

How It Works

* Cell.java → Represents a node (cell) in the linked list, storing data and a reference to the next node.

* LinkedList.java → Implements a generic linked list with add, remove, and toString methods.

* EmptyListException.java → Custom exception class for handling empty list operations.

* MaxMethod.java → Utility class for finding the maximum value in a list of Comparable elements.

* Person.java → A Comparable class used to test the MaxMethod.

* Main.java → Demonstrates:
  * Reversing a linked list using a stack.
  * Finding the max value in a list of Person objects.
  * Handling exceptions when attempting invalid operations.

Features
- Generic linked list implementation
- Custom exception handling for empty lists
- Stack-based linked list reversal
- Finding the maximum element in a list of comparable objects
- Demonstrates OOP principles like encapsulation and generics

Example Usage
1. User enters 6 strings, which are stored in a linked list and displayed.
2. The list is reversed using a stack and printed.
3. A list of Person objects is created, and the oldest person is found using MaxMethod.max().
