import java.util.Random;

public class Flight extends Thread {
	int flightNumber = 0;
	Airport airportDepartingFrom;
	Airport airportArrivingTo;
	
	public Flight(int num, Airport departingAirport, Airport arrivingAirport) {
		this.flightNumber = num;
		this.airportDepartingFrom = departingAirport;
		this.airportArrivingTo = arrivingAirport;
	}
	
	public void run() {
		
		int laneToDepartFrom = airportDepartingFrom.depart(flightNumber);
		
		clearingLaneTime();
		
		airportDepartingFrom.freeRunaway(laneToDepartFrom, flightNumber);
		
		flightInTransition();
		
		int laneToLandAt = airportArrivingTo.land(flightNumber);
		
		clearingLaneTime();
		
		airportArrivingTo.freeRunaway(laneToLandAt, flightNumber);
	}
	
	private void flightInTransition() {
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("error 2.1! ");
		}
	}
	
	private void clearingLaneTime() {
		Random rand = new Random();
		int i = (2 + rand.nextInt(3))*1000;
		try {
			sleep(i);
		} catch (InterruptedException e) {
			System.out.println("error 2.2! ");
		}
		
		
	}
}
