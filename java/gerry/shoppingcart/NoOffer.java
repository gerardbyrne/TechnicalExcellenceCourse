package gerry.shoppingcart;

public class NoOffer 
{
	public void applyOffer(Product product) 
	{
		product.setTotalPrice(product.getTotalPrice());	
	}
}