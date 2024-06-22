package steps;

import io.cucumber.java.en.And;
import pages.CheckOutPage;

public class CheckOutSteps {
	
	CheckOutPage checkOutPage = new CheckOutPage(); 

	@And("user enters email {string} firstname {string} lastname {string} in shipping address")
	public void enterEmailFirstAndLastNameInShippingAddress(String email, String firstName, String lastName) {
		checkOutPage.enterEmail(email);
		checkOutPage.enterFirstAndLastName(firstName, lastName);
	}
	
	@And("user enters street address {string} country {string} city {string} postalcode {string} phonenumber {string} in shipping address")
	public void enterCompleteShippingAddress(String address, String country, String city, String postalCode, String phoneNo) {
		checkOutPage.enterStreetAddress(address);
		checkOutPage.selectCountry(country);
		checkOutPage.enterCity(city);
		checkOutPage.enterPostalCode(postalCode);
	}
	
	@And("user enter credit card details {string} {string} {string} {string}")
	public void enterPaymentDetails(String ccNo, String expMonth, String expYear, String cvv) {
		checkOutPage.enterCreditCardDetails(ccNo, expMonth, expYear, cvv);
	}
	
}