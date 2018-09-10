package stepDefination;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class DriverSetUp {

	public WebDriver driver;

	public void setUpDriver() {
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://qa.elitecareer.net/");
	}

	public String randomlySelectFromDropDown(WebElement element) {
		String value = null;
		Select select = new Select(element);
		int maxIndex = select.getOptions().size() - 1;
		int randomIndex = getRandomNumber(1, maxIndex);
		select.selectByIndex(randomIndex);
		value = select.getFirstSelectedOption().getText();

		return value;
	}

	public static int getRandomNumber(int min, int max) {
		int randomNumber = 0;
		Random random = new Random();
		randomNumber = random.nextInt(max + 1 - min) + min;
		return randomNumber;

	}

	public static void getTextDropdown(WebElement element, int num) {
		Select select = new Select(element);
		for (int i = 0; i < num; i++) {
			String print = select.getOptions().get(i).getText();
			System.out.println("Drop down element-----> "+ print);

		}
	}
}
