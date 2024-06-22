package pages;

import constants.PageConstants;

public class ShopByBrandPage extends HomePage {

	private final String xpath_linkAcePump = "//a[@title='Ace Pump']";
	
	public void clickAcePump() {
		click(xpath_linkAcePump);
		softValidateWithPageScreenshot(PageConstants.ACE_PUMP_PAGE_TITLE, getPageTitle(), "Ace Pump Page Title Validation", false);
	}
	
}