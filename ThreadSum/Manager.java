import java.util.ArrayList;

public class Manager {
	
	private ArrayList<Integer> array = new ArrayList<Integer>();
	public int sum = 0;
	private int num1 = 0;
	private int num2 = 0;
	boolean finalStage = false;

	
	public Manager(ArrayList<Integer> array) {
		this.array = array;
	}
	
	public synchronized int allocateTwoSlots() {
		if (finalStage) {
			return -1;
		}
		else {
			num1 = array.remove(0);
			num2 = array.remove(0);
			sum = num1 + num2;
			
			array.add(sum);
			notifyAll();
			
			if(array.size() == 1) {
				finalStage = true;
			}
			return sum;
		}
	}
	
	public synchronized int getSum() {
		while(!finalStage) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return array.get(0);
	}

}
