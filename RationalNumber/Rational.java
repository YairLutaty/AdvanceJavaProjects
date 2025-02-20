/**
 * This class represents a rational number 
 * using its numerator and denominator.
 */
public class Rational {
	private int numerator;
	private int denominator;
	
	/**
	 * Constructor for objects of class Rational.
	 */
	public Rational(int numerator, int denominator) {
		if (denominator < 0) {
			throw new IllegalArgumentException("Denominator must be positive.");
		}
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	/**
	 * Get numerator
	 */
	public int getNumerator() {
        return numerator;
    }

	/**
	 * Get denominator
	 */
    public int getDenominator() {
        return denominator;
    }
    
    /**
     * This function is checking if given number is greater than current number
     */
	public boolean greaterThan(Rational num) {
		int numNumerator = num.getNumerator();
		int numDenominator = num.getDenominator();
		// if a/b > c/d, then ad > bc.
		if(this.getNumerator() * numDenominator > this.getDenominator() * numNumerator) {
			return true;
		}
		return false;	
	}
	
	/**
	 * This function is checking if given number is equal to current number
	 */
	public boolean equals(Rational num) {
		int numNumerator = num.getNumerator();
		int numDenominator = num.getDenominator();
		
		if(this.getNumerator() * numDenominator == this.getDenominator() * numNumerator) {
			return true;
		}
		return false;
	}
	
	/**
	 * This function is adding given value to current number
	 */
	public Rational plus(Rational num) {
		int numNumerator = (this.getNumerator() * num.getDenominator()) + 
				(this.getDenominator() * num.getNumerator());
		int numDenominator = num.getDenominator() * this.getDenominator();
		
		return new Rational(numNumerator, numDenominator);
	}
	
	/**
	 * This function is subtracting given value from current number
	 */
	public Rational minus(Rational num) {
		int numNumerator = (this.getNumerator() * num.getDenominator()) - 
				(this.getDenominator() * num.getNumerator());
		int numDenominator = num.getDenominator() * this.getDenominator();
		
		return new Rational(numNumerator, numDenominator);
	}
	
	/**
	 * This function is muultiplying by given value the current number
	 */
	public Rational multiply(Rational num) {
		int numNumerator = this.getNumerator() * num.getNumerator();
		int numDenominator = this.getDenominator() * num.getDenominator();
		
		return new Rational(numNumerator, numDenominator);
	}
	
	/**
	 * This function is dividing current number by given number
	 */
	public Rational divide(Rational num) {
		if(num.getNumerator() == 0 || num.getDenominator() == 0) { // Cant divide a number by 0
			throw new ArithmeticException("Denominator cannot be 0!!!");
		}
		int numNumerator = this.getNumerator() * num.getDenominator();
        int numDenominator = this.getDenominator() * num.getNumerator();
		
		return new Rational(numNumerator, numDenominator);
	}
	
	/**
	 * This is the toSting function for Rational class
	 */
	public String toString() {
		if(this.getDenominator() == 1) { // If the number is of "int" presentation - present it as it is. (4 instead of 4/1)
			return String.format("%d", this.getNumerator());
		}
		return String.format("%d/%d",
				this.getNumerator(), this.getDenominator());
	}
	
	/**
	 * This function is reducing current number representation to its minimal possible Rational presentation
	 */
	public Rational reduce() {
		int greatestCommonDivisor = gcd(this.getNumerator(), this.getDenominator());
		int numNumerator = this.getNumerator() / greatestCommonDivisor ;
		int numDenominator = this.getDenominator() / greatestCommonDivisor;
		return new Rational (numNumerator, numDenominator);
	}
	
	/**
	 * This functions finds the greatest common divider between two given numbers.
	 */
	public static int gcd(int x, int y) {
		if (y==0) {
			return x;
		}
		return gcd(y, x%y);
	}
	
}

