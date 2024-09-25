package pages;

import com.microsoft.playwright.Page;

public class CheckOutPage extends HomePage {
	
	public CheckOutPage(Page pageDriver) {
		super(pageDriver);
	}

	private final String css_textboxEmailAddress = "input[data-bind*='hasFocus: emailFocused']";
	private final String xpath_textboxFirstName = "(//input[@name='firstname'])[1]";
	private final String xpath_textboxLastName = "(//input[@name='lastname'])[1]";
	private final String xpath_textboxStreetAddress = "(//input[@name='street[0]'])[1]";
	private final String xpath_dropdownCountry = "(//select[@name='country_id'])[1]";
	private final String xpath_titleShippingAddress = "//*[contains(text(),'Shipping Address')]";
	private final String xpath_dropdownState = "(//select[@name='region_id'])[1]";
	private final String xpath_textboxCity = "(//input[@name='city'])[1]";
	private final String xpath_textboxPostalCode = "(//input[@name='postcode'])[1]";
	private final String xpath_textboxPhoneNumber = "(//input[@name='telephone'])[2]";
	private final String css_textboxCreditCard = "input[title='Credit Card Number']";
	private final String css_dropdownMonth = "select#authnetcim-cc-exp-month";
	private final String css_dropdownYear = "select#authnetcim-cc-exp-year";
	private final String css_textboxCVV = "input#authnetcim-cc-cid";
	private final String css_buttonPlaceOrder = "button[title='Place Order']";
	
	public void enterEmail(String email) {
		waitForWebElement(xpath_titleShippingAddress);
		enterText(css_textboxEmailAddress, email);
	}
	
	public void enterFirstAndLastName(String firstName, String lastName) {
		enterText(xpath_textboxFirstName, firstName);
		enterText(xpath_textboxLastName, lastName);
	}
	
	public void enterStreetAddress(String streetAddress) {
		enterText(xpath_textboxStreetAddress, streetAddress);
	}
	
	public void selectCountry(String country) {
		selectDropdownByValue(xpath_dropdownCountry, country);
	}
	
	public void selectState(String state) {
		selectDropdownByValue(xpath_dropdownState, state);
	}
	
	public void enterCity(String city) {
		enterText(xpath_textboxCity, city);
	}
	
	public void enterPostalCode(String postalCode) {
		enterText(xpath_textboxPostalCode, postalCode);
	}
	
	public void enterPhoneNumber(String phoneNo) {
		enterText(xpath_textboxPhoneNumber, phoneNo);
	}

	public void enterCreditCardDetails(String ccNo, String expMonth, String expYear, String cvv) {
		enterText(css_textboxCreditCard, ccNo);
		selectDropdownByValue(css_dropdownMonth, expMonth);
		selectDropdownByValue(css_dropdownYear, expYear);
		enterText(css_textboxCVV, cvv);
		waitForWebElement(css_buttonPlaceOrder);
	}
	
}