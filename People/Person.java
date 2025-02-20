
public class Person implements Comparable<Person> {
	
	private String name;
	private int id;
	private int yearOfBirth;
	
	public Person() {
		this.name = "Israel Israeli";
		this.id = 123456789;
		this.yearOfBirth = 2000;
	}
	
	public Person(String name, int id, int yearOfBirth) {
		this.name = name;
		this.id = id;
		this.yearOfBirth = yearOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	@Override
	public int compareTo(Person p) {
		return p.yearOfBirth - this.yearOfBirth;
	}
	
	public String toString() {
		String str = "";
		str += "Person name is : " + this.name + "\t";
		str += "Person id is : " + this.id + "\t";
		str += "Person year of birth is : " + this.yearOfBirth;
		
		return str;
		
	}
}