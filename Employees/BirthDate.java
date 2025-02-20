import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/**
 * This class 
 */
public class BirthDate {

	private final int year;
	private final int month;
	private final int day;
	private final ArrayList<Integer> shorthMonths = new ArrayList<>(Arrays.asList(2, 4, 6, 9, 11));

	public BirthDate(int year, int month, int day) {
		Calendar thisDate = Calendar.getInstance();
		// Simple check for date being valid.
		if(day <= 0 || day>=32 || month <= 0 || month >=13
				|| year > thisDate.get(Calendar.YEAR))
			throw new IllegalArgumentException("Illegal date was enterd!");
		// Specific check for shorter months if date is valid.
		if(shorthMonths.contains(month) && day == 31) {
			throw new IllegalArgumentException("Illegal date was enterd!");
		}
		// More specific check for the month of February  - the odd month. 
		if(month == 2){
			if (day == 30 || (day == 29 && year%4 != 0)) {
				throw new IllegalArgumentException("Illegal date was enterd!");
			}
		}
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public String toString() {
		return String.format("%04d.%02d.%02d", year, month, day);
	}
}
