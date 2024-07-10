package cucumber.steps;

import java.io.IOException;

import io.cucumber.java.en.*;
import pages.HomePage;

public class HomeSteps {
	
	HomePage homePage = new HomePage(Hooks.getPageDriver());
	
	@Given("user launches application url")
	public void userLaunchesApplicationURL () throws IOException {
		homePage.navigateToURLWithMaxLoadingTime(Hooks.getConfigProperty("url"), 60);
	}
	
	@When("user clicks on {string} link on home page")
	public void userClicksOnShopByBrandLink(String linkname) {
		switch(linkname) {
			case "ShopByBrand":
				homePage.clickShopByBrand();
				break;
		}
	}
	
}