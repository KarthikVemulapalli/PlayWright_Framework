package steps;

import io.cucumber.java.en.*;
import pages.ShoppingCartPage;

public class ShoppingCartSteps {

	ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
	
	@And("user clicks on ProceedToCheckout link")
	public void enterProductQuantityAndAddToCart() {
		shoppingCartPage.clickProceedToCheckOut();
	}
	
}