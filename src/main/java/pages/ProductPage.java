package pages;

public class ProductPage extends HomePage {
	
	private final String css_textboxOrderQuantity = "input#qty";
	private final String css_buttonAddToCart = "button#product-addtocart-button";

	public void clickProduct(String productName) {
		click("//a[contains(text(),'"+productName+"')]");
	}
	
	public void enterOrderQuantity(String orderQty) {
		enterText(css_textboxOrderQuantity, orderQty);
		capturePageScreenshot("Order Quantity Page", true);
	}
	
	public void clickAddToCart() {
		click(css_buttonAddToCart);
	}
	
}