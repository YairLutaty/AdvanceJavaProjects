# Multithreaded Array Sum Project

This Java program demonstrates multithreading by dividing the task of summing an array among multiple threads. The program:
- Generates a list of random integers.
- Uses multiple threads to sum pairs of numbers in the array.
- Stores the sum back into the list, repeating the process until only one value remains.

How It Works

* Main.java → Handles user input, generates a random list of numbers, and starts multiple threads.

* Manager.java → Manages synchronized access to the list, allowing threads to sum and reduce the array.

* ThreadSum.java → Implements a thread that fetches two numbers, sums them, and updates the list.

Features
- User chooses the array size and number of threads
- Random integer list generation
- Threads operate concurrently to sum elements
- Synchronization ensures safe access to shared data
- Program terminates when only one sum remains

Usage
1. Enter array size (e.g., 10 numbers).
2. Enter number of threads (e.g., 3 threads).
3. The program will:

   3.1. Generate a random list.

   3.2. Sum the numbers in pairs using multiple threads.

   3.3. Display the final sum once the process completes.
