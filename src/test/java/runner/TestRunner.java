package runner;
import java.io.File;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentCucumberFormatter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\Jahangir Hossain\\eclipse-workspace\\MoonLightBDD\\src\\test\\java\\features",
		glue= {"stepDefination"},
		plugin={"com.cucumber.listener.ExtentCucumberFormatter"},		
		dryRun = false,
		monochrome=true,
		strict=true
		)

public class TestRunner {
	@BeforeClass
	public static void setUp() {
		ExtentCucumberFormatter.initiateExtentCucumberFormatter();       
        ExtentCucumberFormatter.loadConfig(new File("./Reports/automation.html"));
	}


	
}
