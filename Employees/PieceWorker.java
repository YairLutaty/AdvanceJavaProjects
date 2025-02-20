
/**
 * This class is of new kind of employee PieceWorker.
 * Setting its attributes and representation.
 */
public class PieceWorker extends Employee{

	private double pricePerItem; // price of each item produced 
	private double numOfItems; // number of items produced

	// constructor
	public PieceWorker(String firstName, String lastName,
			String socialSecurityNumber, double numOfItems, double pricePerItem
			, int year, int month, int day)
	{
		super(firstName, lastName, socialSecurityNumber, year, month, day);

		if (pricePerItem < 0.0) // validate price of items
			throw new IllegalArgumentException(
					"price for an item must be >= 0.0");

		if (numOfItems < 0.0) // validate number of items
			throw new IllegalArgumentException(
					"number of items must be >= 0.0");

		this.pricePerItem = pricePerItem;
		this.numOfItems = numOfItems;
	}

	// set PricePerItem
	public void setPricePerItem(double pricePerItem)
	{
		if (pricePerItem < 0.0) // validate price of each item
			throw new IllegalArgumentException(
					"Item price must be >= 0.0");

		this.pricePerItem = pricePerItem;
	}

	// return PricePerItem
	public double getPricePerItem()
	{
		return pricePerItem;
	}

	// set hours worked
	public void setNumOfItems(double numOfItems)
	{
		if (numOfItems < 0.0) // validate number of items produced
			throw new IllegalArgumentException(
					"number of items produced must be >= 0.0");

		this.numOfItems = numOfItems;
	}

	// return numOfItems
	public double getNumOfItems()
	{
		return numOfItems;
	}

	// calculate earnings; override abstract method earnings in Employee
	@Override
	public double earnings()
	{
		return getNumOfItems() * getPricePerItem();
	} 

	// return String representation of HourlyEmployee object
	@Override
	public String toString()
	{
		return String.format("hourly employee: %s%n%s: %,.2f NIS; %s: %,.2f",
				super.toString(), "price of each item: ", getPricePerItem(),
				"number of items to produce: ", getNumOfItems());
	}

}
