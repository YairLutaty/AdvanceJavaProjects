// Fig. 10.4: Employee.java
// Employee abstract superclass.
import java.util.Calendar;

public abstract class Employee {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private final BirthDate birthDate;

	//constructor
	public Employee(String firstName, String lastName,
			String socialSecurityNumber, int birthYear, int birthMonth, int birthDay)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.birthDate = new BirthDate(birthYear, birthMonth, birthDay);
	}
	// return first name
	public String getFirstName()
	{
		return firstName;
	}

	// return last name
	public String getLastName()
	{
		return lastName;
	}

	// return social security number
	public String getSocialSecurityNumber()
	{
		return socialSecurityNumber;
	}
	
	// return date of birth
	public BirthDate getBirthDate() {
		return birthDate;
	}
	
	public int BirthDateMonth() {
		return birthDate.getMonth();
	}

	// return String representation of Employee object
	@Override
	public String toString()
	{
		double employeeSalary = earnings();
		String addedString = "";
		int employeeMonthOfBirth = BirthDateMonth();
		int thisMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
		if(thisMonth == employeeMonthOfBirth) {
			addedString = "birth date: " + getBirthDate().toString() + 
					"  salary :" + (employeeSalary + 200) + 
					" NIS\nThis employee had a birthday this month and got a 200 NIS bonus!";
		}
		else {
			addedString = "birth date: " + getBirthDate().toString() + 
					"  salary :" + employeeSalary + " NIS";
		}
		return String.format("%s %s%nsocial security number: %s %s",
				getFirstName(), getLastName(), getSocialSecurityNumber(),addedString);
	}
	// abstract method must be overridden by concrete subclasses
	public abstract double earnings(); // no implementation here
} // end abstract class Employee