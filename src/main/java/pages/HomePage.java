package pages;

import webcore.Interactions;

public class HomePage extends Interactions {

	private final String xpath_linkShopByBrand = "//span[contains(text(), 'Shop By Brand')]";
	
	public void clickShopByBrand() {
		waitForWebElement(xpath_linkShopByBrand);
		capturePageScreenshotUsingJava("Home Page");
		forceClick(xpath_linkShopByBrand);
	}
	
}