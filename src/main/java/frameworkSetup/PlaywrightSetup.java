package frameworkSetup;

import java.io.*;
import java.util.*;
import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class PlaywrightSetup {

	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties property;

	private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
	private static ArrayList<String> browserCapabilityArguments = new ArrayList<>();

	private static Playwright getPlaywright() {
		return tlPlaywright.get();
	}

	private static Browser getBrowser() {
		return tlBrowser.get();
	}

	private static BrowserContext getBrowserContext() {
		return tlBrowserContext.get();
	}

	public static Page getPageDriver() {
		return tlPage.get();
	}

	public Page initializeBrowser(Properties prop) {
		tlPlaywright.set(Playwright.create());
		
		String browserName = prop.getProperty("browser").trim();
		/* Arguments to maximize the screen */
		browserCapabilityArguments.add("--start-maximized");

		switch (browserName.toLowerCase()) {
			case "chromium":
				tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(browserCapabilityArguments)));
				tlBrowserContext.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(null)));
				break;
			case "firefox":
				tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(browserCapabilityArguments)));
				tlBrowserContext.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(null)));
				break;
			case "safari":
				tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(browserCapabilityArguments)));
				tlBrowserContext.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(null)));
				break;
			case "chrome":
				tlBrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(browserCapabilityArguments)));
				tlBrowserContext.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(null)));
				break;
			case "edge":
				tlBrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(false).setArgs(browserCapabilityArguments)));
				tlBrowserContext.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(null)));
				break;
			case "headless":
				tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(true)));
				tlBrowserContext.set(getBrowser().newContext());
				break;
			default:
				tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(true)));
				tlBrowserContext.set(getBrowser().newContext());
				break;
		}
		tlPage.set(getBrowserContext().newPage());
		getPageDriver().setDefaultTimeout(60*1000);
		return getPageDriver();
	}
	
	public void closeBrowser() {
		getBrowserContext().close();
		getBrowser().close();
		getPageDriver().close();
	}
	
	public void quitPlaywright() {
		getPlaywright().close();
	}

	public Properties initializePropertyFile() {
		try {
			FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config/config.properties");
			property = new Properties();
			property.load(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return property;
	}
	
}