package webcore;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.NavigateOptions;
import com.microsoft.playwright.options.SelectOption;

public class Interactions extends ExtentReportLogger {
	
	protected Interactions(Page pageDriver){
		super(pageDriver);
	}
	
	protected void click(String elementLocator) {
		try{
			page.locator(elementLocator).click();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void forceClick(String elementLocator) {
		try{
			page.locator(elementLocator).dispatchEvent("click");
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void checkLabel(String elementText) {
		try{
			page.getByLabel(elementText).check();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void uncheckLabel(String elementText) {
		try{
			page.getByLabel(elementText).uncheck();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void enterText(String elementLocator, String textValue) {
		try {
			page.locator(elementLocator).fill(textValue);
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void enterTextSequentially(String elementLocator, String textValue) {
		try {
			page.locator(elementLocator).pressSequentially(textValue);
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected String getText(String elementLocator) {
		String result = "";
		try {
			result = page.locator(elementLocator).textContent();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
		return result;
	}
	
	protected void mouseHover(String elementLocator) {
		try {
			page.locator(elementLocator).hover();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected boolean isWebElementVisible(String elementLocator) {
		boolean result = false;
		try {
			result = page.locator(elementLocator).isVisible();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
		return result;
	}
	
	protected String getPageTitle() {
		String result = "";
		try {
			result = page.title();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
		return result;
	}
	
	protected void waitForWebElement(String elementLocator) {
		try {
			page.locator(elementLocator).waitFor();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void validatePageTitle(String pageUniqueElementLocator, String expectedTitle, boolean screenshot) {
		page.locator(pageUniqueElementLocator).waitFor();
		String result = "";
		try {
			result = page.title();
			if(screenshot) {
				softValidateWithPageScreenshot(expectedTitle, result, "Page Title Validation", false);
			} else {
				softValidate(expectedTitle, result, "Page Title Validation");
			}
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void selectDropdownByValue(String elementLocator, String dropdownValue) {
		try {
			page.locator(elementLocator).selectOption(dropdownValue);
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void selectDropdownByVisibleText(String elementLocator, String dropdownTextValue) {
		try {
			page.locator(elementLocator).selectOption(new SelectOption().setLabel(dropdownTextValue));
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void selectDropdownByIndex(String elementLocator, int dropdownIndexValue) {
		try {
			page.locator(elementLocator).selectOption(new SelectOption().setIndex(dropdownIndexValue));
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void doubleClick(String elementLocator) {
		try{
			page.locator(elementLocator).dblclick();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void scrollToViewWebElement(String elementLocator) {
		try {
			page.locator(elementLocator).scrollIntoViewIfNeeded();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void pageGoBack() {
		try {
			page.goBack();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void pageGoForward() {
		try {
			page.goForward();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void setWebElementDefaultTimeOut(int timeout) {
		try {
			page.setDefaultTimeout(timeout);
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected int getTotalWebElementsCount(String elementLocator) {
		int count = 0;
		try {
			count = page.locator(elementLocator).count();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
		return count;
	}
	
	public void navigateToURL(String URL) {
		try {
			page.navigate(URL);
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	public void navigateToURLWithMaxLoadingTime(String URL, int timeoutSeconds) {
		NavigateOptions options = new NavigateOptions();
		try {
			page.navigate(URL, options.setTimeout(timeoutSeconds*1000));
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	public List<ElementHandle> getMultipleWebElements(String elementLocator) {
		List<ElementHandle> webelements = new ArrayList<ElementHandle>();
		try {
			webelements = page.querySelectorAll(elementLocator);
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		} 
		return webelements;
	}
	
	protected void pauseTestExecution() {
		try {
			page.pause();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
}