
public class ThreadSum extends Thread {
	
	private Manager m;
	
	public ThreadSum(Manager m) {
		this.m = m;
	}
	
	public void run() {
		super.run();
		int a = m.allocateTwoSlots();
		while(a != -1) {
			a = m.allocateTwoSlots();

		}
	}
}
