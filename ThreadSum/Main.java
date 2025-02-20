import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please select the size of array you would like to sum up!");
		int arraySize = scanner.nextInt();
		
		System.out.println("Please select the number of threads you would like to operate in this program!");
		int threadNum = scanner.nextInt();
		
		Manager m = new Manager(generateRandomIntegers(arraySize));
		ThreadSum[] threadArray = new ThreadSum[threadNum];
		
		for (int i = 0; i < threadNum ; i++) {
			threadArray[i] = new ThreadSum(m);
		}
		
		for (ThreadSum t : threadArray) {
            if (t != null) {
                t.start();
            }
        }
		System.out.println("List sum stored in the first slot of the array is:");
		System.out.println(m.getSum());	
	}
	
	public static ArrayList<Integer> generateRandomIntegers(int numberOfIntegers) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        int listSum = 0;

        for (int i = 0; i < numberOfIntegers; i++) {
            int randomNumber = 1 + random.nextInt(100); // Generates a random number between 1 and 100
            listSum += randomNumber;
            list.add(randomNumber);
        }
        System.out.println("Randomly created list of size " + numberOfIntegers + " is: ");
        System.out.println(list);
        System.out.println("List sum is : " + listSum);
        

        return list;
    }
}
