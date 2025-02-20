import java.util.Scanner;
/**
 * This is the main function of the program
 * User us requested to enter 4 digits that follow the rules
 * And is received by all possible actions built for created rational numbers.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
			int numerator;
			int denominator;
			System.out.println("Hello!\nPlease enter required values in order to create 2 rational numbers"
			        + "\nFirst rational number values:"
			        + "\nFirst number will be the numerator and second the denominator"
			        + "\nYour numerator is:");
			numerator = scan.nextInt();
			System.out.println("Your denominator is:");
			denominator = scan.nextInt();
			// Signal for possible false value being enterd
			while (denominator == 0) {
			    System.out.println("Denominator can't be 0! Enter a valid value for your number denominator");
			    denominator = scan.nextInt();
			}

			// Creation of the first rational number from user input
			Rational rationalNum1 = new Rational(numerator, denominator);

			System.out.println("Now please enter the second number"
			        + "\nSecond ratio20nal number values:"
			        + "\nFirst number will be the numerator and second the denominator"
			        + "\nYour numerator is:");
			numerator = scan.nextInt();
			System.out.println("Your denominator is:");
			denominator = scan.nextInt();
			
			// Signal for possible false value being enterd
			while (denominator == 0) {
			    System.out.println("Denominator can't be 0! Enter a valid value for your number denominator");
			    denominator = scan.nextInt();
			}

			// Creation of the second rational number from user input
			Rational rationalNum2 = new Rational(numerator, denominator);

			System.out.println("Now we will do the calculation methods defined "
			        + "in Rational class on the numbers you created:");

			if (rationalNum1.greaterThan(rationalNum2)) {
			    System.out.printf("%s is greater than %s\n",rationalNum1, rationalNum2);
			} else {
			    System.out.printf("%s is NOT greater than %s\n",rationalNum1, rationalNum2);
			}

			if (rationalNum1.equals(rationalNum2)) {
			    System.out.printf("%s is equal to %s\n",rationalNum1, rationalNum2);
			} else {
				System.out.printf("%s is NOT equal to %s\n",rationalNum1, rationalNum2);
			}

			System.out.printf("%s + %s = %s\n",rationalNum1, rationalNum2, rationalNum1.plus(rationalNum2).reduce());
			System.out.printf("%s - %s = %s\n",rationalNum1, rationalNum2, rationalNum1.minus(rationalNum2).reduce());
			System.out.printf("%s * %s = %s\n",rationalNum1, rationalNum2, rationalNum1.multiply(rationalNum2).reduce());
			System.out.printf("%s / %s = %s\n",rationalNum1, rationalNum2, rationalNum1.divide(rationalNum2).reduce());
		}
    }
}
