package pages;

public class ShoppingCartPage extends HomePage {

	private final String css_buttonProceedToCheckout = "button[data-role='proceed-to-checkout']";
	private final String xpath_labelOrderTotal = "//strong[contains(text(), 'Order Total')]";
	
	public void clickProceedToCheckOut() {
		waitForWebElement(xpath_labelOrderTotal);
		click(css_buttonProceedToCheckout);
	}
	
}