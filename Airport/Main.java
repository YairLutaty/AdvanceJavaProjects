import java.util.Random;
public class Main {
	public static void main (String[] args){
		
		Airport BCN = new Airport("Barcelona", 3);
		Airport BER = new Airport("Berlin", 3);
		
		Flight flight;
		Random rand = new Random();
		
		// create and start 10 flight randomly between the airports
		for (int i = 0 ; i < 10 ; i++)
		{
			if ( rand.nextInt(100) > 50){
				flight = new Flight(rand.nextInt(1000),BCN,BER);
			}
			else {
				flight = new Flight(rand.nextInt(1000),BER,BCN);
			}
			flight.start();
		}
	}
}
