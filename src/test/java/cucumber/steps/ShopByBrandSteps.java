package cucumber.steps;

import io.cucumber.java.en.*;
import pages.ShopByBrandPage;

public class ShopByBrandSteps {
	
	ShopByBrandPage smartByBrandPage = new ShopByBrandPage(Hooks.getPageDriver());
	
	@Then("user clicks on {string} link on ShopByBrand page")
	public void userClicksOnLink(String linkname) {
		switch(linkname) {
			case "AcePump":
				smartByBrandPage.clickAcePump();
				break;
		}
	}
	
}