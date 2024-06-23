package topics;

import java.util.ArrayList;
import java.util.List;
import com.microsoft.playwright.Page.*;
import com.microsoft.playwright.*;

public class TimeOuts {

	Playwright playwright;
	Browser browser;
	BrowserContext browsercontext;
	Page page;
	List<String> arguments = new ArrayList<String>();
	
	public static void main(String[] args) {
		TimeOuts tobj = new TimeOuts();
		tobj.launchBrowserInMaximizeView();
		tobj.webelementTimeOut();
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
	
	public void webelementTimeOut() {
		/* Default timeout is 30 seconds */
		/* If any element does not found in 45 seconds it will throw error */
		page.setDefaultTimeout(45*1000);
	}
	
	public void goBackWithTimeOut() {
		page.goBack(new GoBackOptions().setTimeout(45*1000));
	}
	
	public void goForwardWithTimeOut() {
		page.goForward(new GoForwardOptions().setTimeout(45*1000));
	}
	
}