package frameworkSetup;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.microsoft.playwright.*;;

public class ReportValidationsSetup {
	
	protected Page page = PlaywrightSetup.getPageDriver();
	
	public void softValidateWithPageScreenshot(String expectedResult, String actualResult, String reportInformation, boolean fullPageScreenshot) {
		if(expectedResult.equals(actualResult)) {
			ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, reportInformation+": Expected '"+expectedResult+"' matches Actual '"+actualResult+"'", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(fullPageScreenshot)).build());
		} else {
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, reportInformation+": Expected '"+expectedResult+"' not matches Actual '"+actualResult+"'", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(fullPageScreenshot)).build());
		}
	}
	
	public void softValidate(String expectedResult, String actualResult, String reportInformation) {
		if(expectedResult.equals(actualResult)) {
			ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, reportInformation+": Expected '"+expectedResult+"' matches Actual '"+actualResult+"'");
		} else {
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, reportInformation+": Expected '"+expectedResult+"' not matches Actual '"+actualResult+"'");
		}
	}
	
	public void capturePageScreenshot(String reportInformation, boolean fullPageScreenshot) {
		String imagePath =  takeScreenshot(fullPageScreenshot);
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, reportInformation, MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
	}
	
	public void capturePageScreenshotUsingJava(String reportInformation) {
		String imagePath =  takeScreenshotUsingJava();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, reportInformation, MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
	}
	
	private String takeScreenshot(boolean fullImage) {
		String screenshotPath = System.getProperty("user.dir") + "/reports/screenshots/PageImage_" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)).setFullPage(fullImage));
		return screenshotPath;
	}
	
	private String takeScreenshotUsingJava() {
		String screenshotPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "screenshots";
		try {
			Robot robot = new Robot();
			Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage image = robot.createScreenCapture(rectangle);
			File folderCreation = new File(screenshotPath);
			folderCreation.mkdir();
			screenshotPath = screenshotPath + File.separator + "JavaImage_" + System.currentTimeMillis() + ".png";
			ImageIO.write(image, "png", new File(screenshotPath));
		} catch(Exception e) {
			e.getMessage();
		}
		return screenshotPath;
	}
	
}