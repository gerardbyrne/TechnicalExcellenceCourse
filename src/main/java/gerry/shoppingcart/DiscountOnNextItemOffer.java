package gerry.shoppingcart;

import java.io.Console;

public class DiscountOnNextItemOffer 
{
	private double discountPercentage;
	
	public DiscountOnNextItemOffer(double discountPercentage) 
	{
		this.discountPercentage = discountPercentage;
	}

	public void applyOffer(Product product) 
	{
		int totalQuantity = product.getQuantity();
		double unitPrice = product.getTotalPrice() / product.getQuantity();
		while (totalQuantity > 1) 
		{
			double price = product.getTotalPrice();
			product.setTotalPrice(price - (unitPrice / (100/discountPercentage)));
			totalQuantity = totalQuantity - 2;
		}			
	}

	// Getters and setters can be added as required

}
