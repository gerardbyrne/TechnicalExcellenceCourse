package gerry.shoppingcart;

public class BuyXItemGetYItemFreeOffer 
{
	private int XItem;
	private int YItem;
	
	public BuyXItemGetYItemFreeOffer(int xItem, int yItem) 
	{
		this.XItem = xItem;
		this.YItem = yItem;
	}
	
	public void applyOffer(Product product) 
	{
		if (product.getQuantity() >= XItem) 
		{
			double freeItems = (product.getQuantity() / XItem) * YItem;
			double unitPrice = product.getTotalPrice() / product.getQuantity();
			double customerPrice = (product.getQuantity() - freeItems) * unitPrice;
			product.setTotalPrice(customerPrice);
		}
	}
	
	// Getters and setters can be added as required
}