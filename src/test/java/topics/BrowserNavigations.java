package topics;

import java.util.ArrayList;
import java.util.List;
import com.microsoft.playwright.*;
import com.microsoft.playwright.Page.NavigateOptions;

public class BrowserNavigations {
	
	Playwright playwright;
	Browser browser;
	BrowserContext browsercontext;
	Page page;
	List<String> arguments = new ArrayList<String>();

	public static void main(String[] args) {
		
	}

	public void launchBrowserInMaximizeView() {
		playwright = Playwright.create();
		
		arguments.add("--start-maximized");
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
		browsercontext  = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		page = browsercontext.newPage();
		/* Default page reload timeout is 30 seconds */
		/* The below timeout is for page reload, it will wait till 60 seconds to load the page */
		page.navigate("https://google.com", new NavigateOptions().setTimeout(60*1000));
	}
	

	public void goBack() {
		page.goBack();
	}
	
	public void goForward() {
		page.goForward();
	}
	
	public void refreshPage() {
		page.reload();
	}
	
}