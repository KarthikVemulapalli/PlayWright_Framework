package cucumber.steps;

import io.cucumber.java.en.And;
import pages.ProductPage;

public class ProductSteps {
	
	ProductPage productPage = new ProductPage(Hooks.getPageDriver());
	
	@And("user selects the product {string}")
	public void clicksOnProduct(String productName) {
		productPage.clickProduct(productName);
	}
	
	@And("user enters product quantity {string} and add to cart")
	public void enterProductQuantityAndAddToCart(String prodQty) {
		productPage.enterOrderQuantity(prodQty);
		productPage.clickAddToCart();
	}
	
}