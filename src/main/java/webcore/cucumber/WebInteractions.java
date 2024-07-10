package webcore.cucumber;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import com.microsoft.playwright.*;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Page.*;
import com.microsoft.playwright.options.*;

public class WebInteractions extends ExtentReportLogger {
	
	private Page page;
	
	protected WebInteractions(Page pageDriver){
		this.page = pageDriver;
	}
	
	protected Page getPageDriver() {
		return page;
	}
	
	protected void click(String elementLocator) {
		try{
			page.locator(elementLocator).click();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	/*
	 * Click on the element when other element is overlaid.
	 * Sometimes hover on element leads to click interruption of other element.
	 */
	protected void forceClick(String elementLocator) {
		try{
			page.locator(elementLocator).click(new ClickOptions().setForce(true));
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	/*
	 * Stimulate the element Click by any means possible.
	 * This triggers as HTMLElement.click()
	 */
	protected void mandatoryClick(String elementLocator) {
		try{
			page.locator(elementLocator).dispatchEvent("click");
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void rightClick(String elementLocator) {
		try{
			page.locator(elementLocator).click(new ClickOptions().setButton(MouseButton.RIGHT));
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
	
	/* 
	 * The below methods only work on web elements having tag 'label'.
	 * Parameter - label inner text 
	 */
	protected void checkLabel(String elementText) {
		try{
			page.getByLabel(elementText).check();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void check(String elementText) {
		try{
			page.locator(elementText).check();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	/* 
	 * The below methods only work on web elements having tag 'label'.
	 * Parameter - label inner text 
	 */
	protected void uncheckLabel(String elementText) {
		try{
			page.getByLabel(elementText).uncheck();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void uncheck(String elementText) {
		try{
			page.locator(elementText).uncheck();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	/*
	 * Fill validates action ability check on web element
	 */
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
	
	/* 
	 * TextContent will return the complete text content including the hidden text of web element 
	 */
	protected String getCompleteText(String elementLocator) {
		String result = "";
		try {
			result = page.locator(elementLocator).textContent();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
		return result;
	}
	
	/* 
	 * InnerText will only return the visible text content of web element. Excludes the hidden text 
	 */
	protected String getVisibleText(String elementLocator) {
		String result = "";
		try {
			result = page.locator(elementLocator).innerText();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
		return result;
	}
	
	protected String getAttributeValue(String elementLocator, String attributeName) {
		String result = "";
		try {
			result = page.locator(elementLocator).getAttribute(attributeName);
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
		try {
			page.navigate(URL, new NavigateOptions().setTimeout(timeoutSeconds*1000));
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	/*
	 * Method provides all the web elements with element locator.
	 */
	public Locator getLocatorOfMultipleWebElements(String elementLocator) {
		Locator webelements = null;
		try {
			webelements = page.locator(elementLocator);
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		} 
		return webelements;
	}
	
	/*
	 * Method provides all the web elements with element locator.
	 * This should not be preferred.
	 */
	public List<ElementHandle> getMultipleWebElements(String elementLocator) {
		List<ElementHandle> webelements = new ArrayList<ElementHandle>();
		try {
			webelements = page.querySelectorAll(elementLocator);
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		} 
		return webelements;
	}
	
	/* Index value starts from '0' */
	public Locator getNthIndexLocator(Locator webelements, int index) {
		Locator webelement = null;
		try {
			webelement = webelements.nth(index);
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
		return webelement;
	}
	
	protected void validatePageTitle(String pageUniqueElementLocator, String expectedTitle) {
		waitForWebElement(pageUniqueElementLocator);
		String result = "";
		try {
			result = page.title();
			softValidate(expectedTitle, result, "Page Title Validation");
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}

	/*
	 * OnDialog accepts lambda expression, JavaScript dialogs
	 */
	protected void clickOnAlert() {
		try {
			page.onDialog(dialog -> {
				dialog.accept();
			});
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	/*
	 * OnDialog accepts lambda expression, JavaScript dialogs
	 */
	String outmessage;
	protected String getAlertMessageAndClickOk() {
		try {
			page.onDialog(dialog -> {
				outmessage = dialog.message();
				dialog.accept();
			});
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
		return outmessage;
	}
	
	private FrameLocator getFrameLocator(String iFrameLocator) {
		FrameLocator iframe = null;
		try {
			iframe = page.frameLocator(iFrameLocator);
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
		return iframe;
	}
	
	protected void clickElementInsideiFrame(String iFrameLocator, String elementLocator) {
		try {
			getFrameLocator(iFrameLocator).locator(elementLocator).click();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected void enterTextOnElementInsideiFrame(String iFrameLocator, String elementLocator, String textValue) {
		try {
			getFrameLocator(iFrameLocator).locator(elementLocator).fill(textValue);
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
	protected String getElementTextInsideiFrame(String iFrameLocator, String elementLocator) {
		String outtext = "";
		try {
			outtext = getFrameLocator(iFrameLocator).locator(elementLocator).textContent();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
		return outtext;
	}
	
	/* 
	 * Provide element locator which caused new window to open after clicked.
	 * WaitForpopUp waits till new window/tab is opened.
	 * By using newWindowPage Page object, we should control the elements in newly opened tab/window.
	 */
	protected Page getNewWindowHandle(String elementLocator) {
		Page newWindowPage = null;
		try {
			newWindowPage = page.waitForPopup(() -> {
				page.locator(elementLocator).click();
			});
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
		return newWindowPage;
	}
	
	
	protected void pauseTestExecution() {
		try {
			page.pause();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
}