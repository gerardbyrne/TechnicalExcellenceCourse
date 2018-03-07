package gerry.shoppingcart;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ShoppingCartTests 
{
	@Test
	public void testCreateEmptyShoppingCart() 
	{
		ShoppingCart cart = new ShoppingCart();
		Assert.assertEquals(0, cart.getProductCount());
	}

	@Test
	public void testAddSingleProductToShoppingCart() 
	{
		ShoppingCart cart = new ShoppingCart();
		Product product = new Product("Single Journey Travel Insurance ", 1, 50.0);
		cart.addProduct(product);
		Assert.assertEquals(1, cart.getProductCount());
		Assert.assertEquals(50.0, cart.getTotalCartValue(), 0.00);
	}
	
	@Test
	public void addDifferentProductsToTheCart()
	{
		ShoppingCart cart = new ShoppingCart();
		Product productSingle = new Product("Single Journey Travel Insurance ", 1, 50.0);
		Product productFamily = new Product("Family Journey Travel Insurance ", 1, 100.0);
		cart.addProduct(productSingle);
		cart.addProduct(productFamily);
		Assert.assertEquals(2, cart.getProductCount());
		Assert.assertEquals(150.0, cart.getTotalCartValue(),0.0);
	}
	
	@Test
	public void testAddMultipleQuantityOfAProductAndApplyOfferToCart() 
	{
		BuyXItemGetYItemFreeOffer offer = new BuyXItemGetYItemFreeOffer(5,1);
		ShoppingCart cart = new ShoppingCart();
		cart.setOffer(offer);
		Product productSingle = new Product("Single Journey Travel Insurance ", 5, 250.0);
		cart.addProduct(productSingle);
		Assert.assertEquals(1, cart.getProductCount());
		Assert.assertEquals(200.0, cart.getTotalCartValue(),0.0);
	}

	@Test
	public void addDifferentProductsAndAppyOfferToTheCart()
	{
		BuyXItemGetYItemFreeOffer offer = new BuyXItemGetYItemFreeOffer(2,1);
		ShoppingCart cart = new ShoppingCart();
		cart.setOffer(offer);		
		Product productSingle = new Product("Single Journey Travel Insurance ", 3, 150.0);		
		cart.addProduct(productSingle);
		
		NoOffer nooffer = new NoOffer();
		cart.setOffer(nooffer);//No offer for the Family Policies		
		Product productFamily = new Product("Family Journey Travel Insurance ", 2, 200.0);
		cart.addProductNoOffer(productFamily);
		
		Assert.assertEquals(2, cart.getProductCount());
		Assert.assertEquals(300.0, cart.getTotalCartValue(),0.0);
	}
	
	@Test
	public void testApplyBuyOneGetFiftyPercentDiscountOnNextOfferToTheCart()
	 {
		DiscountOnNextItemOffer offer = new DiscountOnNextItemOffer(50.0);
		ShoppingCart cart = new ShoppingCart();
		cart.setOffer(offer);
		Product productSingle = new Product("Single Journey Travel Insurance ", 2, 100.0);

		cart.addProductDiscountOnNextItemOffer(productSingle);
		Assert.assertEquals(1, cart.getProductCount());
		Assert.assertEquals(75.0, cart.getProductByName("Single Journey Travel Insurance ").getTotalPrice(),0.0);
		Assert.assertEquals(75.0, cart.getTotalCartValue(),0.0);
	}

}