import java.util.LinkedList;
import java.util.Queue;

public class Airport {
	private String airportName = "";
	private int airportLanes = 0;
	private boolean[] clearLanes;
	private int clearLane;
	
	private Queue<Integer> flightsToDepart = new LinkedList<>();
	private Queue<Integer> flightsToArrive = new LinkedList<>();
	
	public Airport(String name, int lanes) {
		this.airportName = name;
		this.airportLanes = lanes;
		this.clearLanes = new boolean[airportLanes];
	}
	
	public synchronized int depart(int numOfFlight) {
		flightsToDepart.add(numOfFlight);
		
		while(checkForClearLane() == -1) {
			try {
				System.out.println("Flight: #" + flightsToDepart.peek() + " In hold for a free departing lane in airport: " + airportName);
				wait();
			} catch (InterruptedException e) {
				System.out.println("error 1.1! ");
			}
		}
		clearLane = checkForClearLane();
		clearLanes[clearLane] = true;
		
		int toDepart = flightsToDepart.remove();
		System.out.println("Flight: #" + toDepart + " Departing from airport: " + airportName + " In lane: " + clearLane);
		
		return clearLane;
	}
	
	
	public synchronized int land(int numOfFlight) {
		flightsToArrive.add(numOfFlight);
		while(checkForClearLane() == -1) {
			try {
				System.out.println("Flight: #" + flightsToArrive.peek() + " In hold for a free landing lane in airport: " + airportName);
				wait();
			} catch (InterruptedException e) {
				System.out.println("error 1.2! ");
			}
		}
		clearLane = checkForClearLane();
		clearLanes[clearLane] = true;
		
		int toLand = flightsToArrive.remove();
		System.out.println("Flight: #" + toLand + " Landing at airport: " + airportName + " In lane: " + clearLane);
		return clearLane;
	}
	
	public int checkForClearLane() {
		for(int i = 0 ; i < this.airportLanes ; i++) {
			if(clearLanes[i] == false)
				return i;
		}
		return -1;
	}
	
	public synchronized void freeRunaway(int lane ,int flightNumber) {
		clearLanes[lane] = false;
		System.out.println("Lane number: "+ lane + " In airport: " + airportName + " Is now clear!");
		notifyAll();
	}
}
