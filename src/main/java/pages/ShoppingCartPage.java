package pages;

import com.microsoft.playwright.Page;

public class ShoppingCartPage extends HomePage {

	public ShoppingCartPage(Page pageDriver) {
		super(pageDriver);
	}
	
	private final String css_buttonProceedToCheckout = "button[data-role='proceed-to-checkout']";
	private final String xpath_labelOrderTotal = "//strong[contains(text(), 'Order Total')]";
	
	public void clickProceedToCheckOut() {
		waitForWebElement(xpath_labelOrderTotal);
		click(css_buttonProceedToCheckout);
	}
	
}