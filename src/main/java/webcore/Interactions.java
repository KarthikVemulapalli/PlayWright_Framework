package webcore;

import org.testng.Assert;
import com.microsoft.playwright.options.SelectOption;
import frameworkSetup.ReportValidationsSetup;

public class Interactions extends ReportValidationsSetup {
	
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
	
	protected boolean isElementPresent(String elementLocator) {
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
	
	protected void validatePageTitle(String pageUniqueElementLocator, String expectedTitle) {
		page.locator(pageUniqueElementLocator).waitFor();
		String result = "";
		try {
			result = page.title();
			softValidate(expectedTitle, result, "Page Title Validation");
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
	
	protected void selectDropdownByValue(String elementLocator, String dropdownValue) {
		try {
			page.locator(elementLocator).selectOption(dropdownValue);
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
	
	protected void pauseExecution() {
		try {
			page.pause();
		} catch(Throwable exception) {
			Assert.fail(exception.getMessage());
		}
	}
	
}