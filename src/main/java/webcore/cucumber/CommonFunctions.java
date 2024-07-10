package webcore.cucumber;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.imageio.ImageIO;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.microsoft.playwright.Page;

public class CommonFunctions extends WebInteractions {

	protected CommonFunctions(Page pageDriver) {
		super(pageDriver);
	}

	public static String getCurrentISTDate(String DateFormat) {
		SimpleDateFormat ISTDF = new SimpleDateFormat(DateFormat);
		TimeZone ISTTZ = TimeZone.getTimeZone("GMT+5:30");
		ISTDF.setTimeZone(ISTTZ);
		
		Date currentDate = new Date();
		return ISTDF.format(currentDate.getTime()).toString();
	}
	
	public static String getCurrentESTDate(String DateFormat) {
		SimpleDateFormat ETDF = new SimpleDateFormat(DateFormat);
		TimeZone ETTZ = TimeZone.getTimeZone("America/New_York");
		ETDF.setTimeZone(ETTZ);
		
		Date currentDate = new Date();	
		return ETDF.format(currentDate.getTime()).toString();
	}
	
	
	private String takeScreenshot(boolean fullImage) {
		long pathName = System.currentTimeMillis();
		String screenshotPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "Screenshots" + File.separator + "PageImage_" + pathName + ".png";
		getPageDriver().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)).setFullPage(fullImage));
		return screenshotPath;
	}
	
	public void capturePageScreenshot(String reportInformation, boolean fullPageScreenshot) {
		String imagePath =  takeScreenshot(fullPageScreenshot);
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, reportInformation, MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
	}
	
	/* Taking Screenshots using Java is not preferred */
	private String takeScreenshotUsingJava() {
		String screenshotPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "Screenshots";
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
	
	public void capturePageScreenshotUsingJava(String reportInformation) {
		String imagePath =  takeScreenshotUsingJava();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, reportInformation, MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
	}
	
}