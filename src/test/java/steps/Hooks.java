package steps;

import java.util.Properties;
import com.microsoft.playwright.Page;
import frameworkSetup.PlaywrightSetup;
import io.cucumber.java.*;

public class Hooks {

	private PlaywrightSetup playwrightSetup;
	private static Properties property;
	private static Page pageDriver;
	
	@Before
	public void initialPlaywrightSetUp() {
		playwrightSetup = new PlaywrightSetup();
		property = playwrightSetup.initializePropertyFile();
		pageDriver = playwrightSetup.initializeBrowser(property);
	}
	
	@After
	public void finalPlaywrightTearDown(Scenario scenario) {
		playwrightSetup.closeBrowser();
		playwrightSetup.quitPlaywright();
	}
	
	
	public static Page getPageDriver() {
		return pageDriver;
	}
	
	public static String getConfigProperty(String key) {
		return property.getProperty(key);
	}
	
}