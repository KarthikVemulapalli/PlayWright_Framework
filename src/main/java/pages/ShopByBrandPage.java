package pages;

import com.microsoft.playwright.Page;

import constants.PageConstants;

public class ShopByBrandPage extends HomePage {

	public ShopByBrandPage(Page pageDriver) {
		super(pageDriver);
	}
	
	private final String xpath_linkAcePump = "//a[@title='Ace Pump']";
	
	public void clickAcePump() {
		click(xpath_linkAcePump);
		softValidate(PageConstants.ACE_PUMP_PAGE_TITLE, getPageTitle(), "Ace Pump Page Title Validation");
	}
	
}