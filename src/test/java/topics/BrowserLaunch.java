package topics;

import java.nio.file.Paths;
import java.util.*;
import com.microsoft.playwright.*;

public class BrowserLaunch {
	
	Playwright playwright;
	Browser browser;
	BrowserContext browsercontext;
	Page page;
	List<String> arguments = new ArrayList<String>();
	
	public static void main(String[] args) {
		BrowserLaunch browserlaunch = new BrowserLaunch();
		browserlaunch.launchBrowserInMaximizeView();
		browserlaunch.closeExecution();
	}

	/* By default Playwright launches execution in headless mode */
	public void browserHeadless() {
		/* Create Session */
		playwright = Playwright.create();
		browser = playwright.chromium().launch();
		page = browser.newPage();
		page.navigate("https://google.com");
	}
	
	/* By default Playwright launches Incognito search engine browser in UI execution */
	public void browserUI() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
		page.navigate("https://google.com");
	}
	
	/* Launch chrome browser */
	public void launchChromeBrowser() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		page = browser.newPage();
		page.navigate("https://google.com");
	}
	
	/* Launch browser in maximize mode using screen sizes */
	public void launchBrowserInMaximizeViewUsingScreenSizes() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		browsercontext  = browser.newContext(new Browser.NewContextOptions().setViewportSize(1020, 500));
		page = browsercontext.newPage();
		page.navigate("https://google.com");
	}
	
	/* Launch browser in maximize mode fits the screen */
	public void launchBrowserInMaximizeView() {
		playwright = Playwright.create();
		
		arguments.add("--start-maximized");
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
		browsercontext  = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		page = browsercontext.newPage();
		page.navigate("https://google.com");
	}
	
	public void closeExecution() {
		page.close();
		browser.close();
		playwright.close();
	}
	
	
	/* below method is not working as expected */
	public void launchInNonIncognitoMode() {
		playwright = Playwright.create();
		
		arguments.add("--start-maximized");
		browsercontext = playwright.chromium().launchPersistentContext(Paths.get(""), new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setArgs(arguments));
		page = browsercontext.newPage();
		page.navigate("https://google.com");
		/* method is not working as expected */
	}
	
	/* below method is not working as expected */
	/* below method is not working as expected */
	public void launchInBrowserWithUserAppData() {
		playwright = Playwright.create();
		
		arguments.add("--start-maximized");
		browsercontext = playwright.chromium().launchPersistentContext(Paths.get("C:\\Users\\vkarthik1\\AppData\\Local\\Google\\Chrome\\User Data\\Default"), new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setChannel("chrome").setArgs(arguments));
		page = browsercontext.newPage();
		page.navigate("https://google.com");
	}	
	
}