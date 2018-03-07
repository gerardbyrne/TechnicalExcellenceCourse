package gerry.shoppingcart;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart 
{
	private ArrayList<Product> productList = new ArrayList<>();
	private double totalCartValue;
	private BuyXItemGetYItemFreeOffer offer;
	private NoOffer nooffer;
	private DiscountOnNextItemOffer discountonnextitemoffer;
	
	public int getProductCount() 
	{
		return productList.size();
	}

	public void addProduct(Product product) 
	{
		if(offer != null)
		{
			offer.applyOffer(product);//apply offer
		}
		productList.add(product);		
	}

	public void addProductNoOffer(Product product) 
	{
		if(nooffer != null)
		{
			nooffer.applyOffer(product);//apply offer
		}
		productList.add(product);		
	}
	
	public void addProductDiscountOnNextItemOffer(Product productSingle) 
	{
		if(offer != null)
		{
			offer.applyOffer(productSingle);//apply offer
		}
		productList.add(productSingle);			
	}
	
	public double getTotalCartValue() 
	{	
		if (productList.size() > 0) 
		{
			for (Product product : productList) 
			{
				totalCartValue = totalCartValue + product.getTotalPrice();
			}
		}
		return totalCartValue;
	}

	public void setOffer(BuyXItemGetYItemFreeOffer offer) 
	{
		this.offer = offer;	
	}

	public void setOffer(NoOffer nooffer) 
	{
		this.nooffer = nooffer;	
	}
	
	public void setOffer(DiscountOnNextItemOffer discountonnextitemoffer) 
	{
		this.discountonnextitemoffer = discountonnextitemoffer;	
	}
	
	public Product getProductByName(String name) 
	{
			if (productList.size() > 0) 
			{
				for (Product product : productList) 
				{
					if (product.getProductName().equals(name)) 
					{
						return product;
					}
				}
			}
			return null;
		}
}