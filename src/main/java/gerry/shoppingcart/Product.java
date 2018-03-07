package gerry.shoppingcart;

public class Product 
{
	// Create three properties (variables)
		private String productName;
		private int quantity;
		private double totalPrice;
		
		// Create a new constructor for the class. This constructor
		// accepts three parameters - a String followed by an int, 
		// followed by a double.
		// This constructor over writes the default constructor


	public Product(String productName, int quantity, double totalPrice)  
	{
		this.productName = productName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	// Create a getter for the productName property
		public String getProductName() 
		{
			return productName;
		}
		
		// Create a setter for the productName property
		public void setProductName(String productName) 
		{
			this.productName = productName;
		}
	 
		// Create a getter for the quantity property
		public int getQuantity() 
		{
			return quantity;
		}
	 
		// Create a setter for the quantity property
		public void setQuantity(int quantity) 
		{
			this.quantity = quantity;
		}
	 
		// Create a getter for the totalPrice property
		public double getTotalPrice() 
		{
			return totalPrice;
		}
	 
		// Create a setter for the totalPrice property
		public void setTotalPrice(double totalPrice) 
		{
			this.totalPrice = totalPrice;
		}
}