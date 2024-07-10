package webcore.cucumber;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentReportLogger {
	
	public void softValidate(String expectedResult, String actualResult, String reportInformation) {
		if(expectedResult.equals(actualResult)) {
			ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, reportInformation+": Expected '"+expectedResult+"' matches Actual '"+actualResult+"'");
		} else {
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, reportInformation+": Expected '"+expectedResult+"' not matches Actual '"+actualResult+"'");
		}
	}
	
	public void logReportInfo(String reportInformation) {
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, reportInformation);
	}
	
	public void logReportInfoWithColour(String reportInformation) {
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MarkupHelper.createLabel(reportInformation, ExtentColor.WHITE));
	}
	
}