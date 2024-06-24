package steps;

import java.nio.file.Paths;
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
	
	@AfterStep
	public void takeApplicationScreenshot(Scenario scenario) {
		scenario.attach(takeScreenshot(), "image/png", "Page Screenshot");
	}
	
	public static Page getPageDriver() {
		return pageDriver;
	}
	
	public static String getConfigProperty(String key) {
		return property.getProperty(key);
	}
	
	private byte[] takeScreenshot() {
		String fileName = "PageImage_"+System.currentTimeMillis();
		byte[] screenshot = pageDriver.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./reports/Screenshots/"+fileName+".png")).setFullPage(false));
		return screenshot;
	}
	
}