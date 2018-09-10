package stepDefination;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RegistrationTest extends DriverSetUp {

	List<WebElement> errorList;

	@Given("^User open the url on browser$")
	public void user_open_the_url_on_browser() throws Throwable {
		setUpDriver();
	}

	@Then("^user click on registration feature$")
	public void user_click_on_registration_feature() throws Throwable {
		driver.findElement(By.linkText("Register")).click();
	}

	@Then("^user enters the \"([^\"]*)\"$")
	public void user_enters_the(String First_name) throws Throwable {
		driver.findElement(By.name("FirstName")).sendKeys(First_name);
	}

	@Then("^user enters the Last name as \"([^\"]*)\"$")
	public void user_enters_the_Last_name_as(String LastName) throws Throwable {
		driver.findElement(By.name("LastName")).sendKeys(LastName);
	}

	@Then("^select the user type$")
	public void select_the_user_type() throws Throwable {
		WebElement dropDownElement = driver.findElement(By.name("UserType"));
		String getText = randomlySelectFromDropDown(dropDownElement);
		System.out.println("Text of drop down element----> " + getText);
	}

	@Then("^user click on submit button$")
	public void user_click_on_submit_button() throws Throwable {
		driver.findElement(By.name("submit")).click();

	}

	@Then("^verify the message$")
	public void verify_the_message() throws Throwable {
		errorList = driver.findElements(By.id("error"));
		String message = errorList.get(0).getText();
		Assert.assertEquals("*", message);
	}

	@Then("^verify the message for last name$")
	public void verify_the_message_for_last_name() throws Throwable {
		errorList = driver.findElements(By.id("error"));
		String message = errorList.get(1).getText();
		Assert.assertEquals("*", message);

	}

	@Then("^verify the error messages$")
	public void verify_the_error_messages() throws Throwable {
		errorList = driver.findElements(By.id("error"));
		String Errormessage = errorList.get(0).getText();
		if (Errormessage.equalsIgnoreCase("* FirstName can not be empty.")) {
			Assert.assertEquals("* FirstName can not be empty.", Errormessage);
		}else if(Errormessage.equalsIgnoreCase("* FirstName can not be greater than 30 character.")) {
			Assert.assertEquals(Errormessage, "* FirstName can not be greater than 30 character.");
		}

	}

	@Then("^verify the error message for last name$")
	public void verify_the_error_message_for_last_name() throws Throwable {
		errorList = driver.findElements(By.id("error"));
		String Errormessage = errorList.get(1).getText();

		if (Errormessage.equalsIgnoreCase("* LastName can not be empty")) {
			Assert.assertEquals("* LastName can not be empty.", Errormessage);
		} else if (Errormessage.equalsIgnoreCase("* LastName can not be greater than 30 character.")) {

			Assert.assertEquals("* LastName can not be greater than 30 character.", Errormessage);
		}
	}

	@Then("^vrify the user type drop down element$")
	public void vrify_the_user_type_drop_down_element() throws Throwable {
		WebElement dropDownElement = driver.findElement(By.name("UserType"));
		getTextDropdown(dropDownElement, 2);
	}

	@Then("^close the window$")
	public void close_the_window() throws Throwable {
		driver.quit();
	}

}
