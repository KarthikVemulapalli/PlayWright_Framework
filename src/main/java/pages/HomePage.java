package pages;

import com.microsoft.playwright.Page;
import webcore.Interactions;

public class HomePage extends Interactions {

	public HomePage(Page pageDriver) {
		super(pageDriver);
	}
	
	private final String xpath_linkShopByBrand = "//span[contains(text(), 'Shop By Brand')]";
	
	public void clickShopByBrand() {
		waitForWebElement(xpath_linkShopByBrand);
		mandatoryClick(xpath_linkShopByBrand);
	}
	
}