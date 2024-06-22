package runner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"steps"},
		tags = "@ShopByBrand",
		plugin = {
				/* Below plugin for Cucumber report */
				"html:reports/automation-cucumber-report.html",
				/* Below plugin for Grasshopper Extent report */
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
		)
public class TestRunner extends AbstractTestNGCucumberTests {

	/* 
	 * Enable the below code for Parallel Execution
	 * 
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    */
	
}