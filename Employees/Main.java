import java.util.ArrayList;

/**
 * This is the main class of the program, creating an instance of every possible employee
 * And printing them back to the user in a loop.
 */
public class Main {

    public static void main(String[] args) {

    	 ArrayList<Employee> employees = new ArrayList<>();
    	 SalariedEmployee salariedEmployee = new SalariedEmployee("Lebron", "James", "123-45-6789", 1000, 1987, 11 ,5);
         HourlyEmployee hourlyEmployee = new HourlyEmployee("Israel", "Israeli", "987-65-4321", 20.8, 50, 1999, 3, 5);
         CommissionEmployee commissionEmployee = new CommissionEmployee("Rhea", "Ripley", "999-88-7777", 2500, 0.15, 1976, 2, 29);
         BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("James", "Earl-Joens", "100-99-9873", 750, 0.14, 500, 2000, 9, 18);
    	 PieceWorker pieceworker = new PieceWorker("Lamine", "Yamal", "100-00-0000", 5, 50, 2007, 7, 13);
         
         employees.add(salariedEmployee);
         employees.add(hourlyEmployee);
         employees.add(commissionEmployee);
         employees.add(basePlusCommissionEmployee);
         employees.add(pieceworker);

        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i) + "\n");
        }

    }
}