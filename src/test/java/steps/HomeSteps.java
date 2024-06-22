package steps;

import java.io.IOException;

import io.cucumber.java.en.*;
import pages.HomePage;

public class HomeSteps {
	
	HomePage homePage = new HomePage();
	
	@Given("user launches application url")
	public void userLaunchesApplicationURL () throws IOException {
		Hooks.launchURL(Hooks.getConfigProperty("url"));
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