package pages;

import com.microsoft.playwright.Page;
import webcore.cucumber.CommonFunctions;

public class HomePage extends CommonFunctions {

	public HomePage(Page pageDriver) {
		super(pageDriver);
	}
	
	private final String xpath_linkShopByBrand = "//span[contains(text(), 'Shop By Brand')]";
	
	public void clickShopByBrand() {
		waitForWebElement(xpath_linkShopByBrand);
		mandatoryClick(xpath_linkShopByBrand);
	}
	
}