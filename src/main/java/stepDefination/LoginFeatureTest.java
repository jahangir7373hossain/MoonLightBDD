package stepDefination;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginFeatureTest extends DriverSetUp {

	
	List<WebElement> erroerList;

	@Given("^User open the application on browser$")
	public void user_open_the_application_on_browser() throws Throwable {

		setUpDriver();
	}

	@When("^User click on the log in feature$")
	public void user_click_on_the_log_in_feature() throws Throwable {
		driver.findElement(By.linkText("Signin")).click();
	}

	@When("^User enter the email \"([^\"]*)\"$")
	public void user_enter_the_email(String email) throws Throwable {
		driver.findElement(By.name("Email")).sendKeys(email);
	}

	@When("^User enter the password \"([^\"]*)\"$")
	public void user_enter_the_password(String password) throws Throwable {
		driver.findElement(By.name("Password")).sendKeys(password);
	}

	@Then("^User click on log in button$")
	public void user_click_on_log_in_button() throws Throwable {
		driver.findElement(By.name("submit")).click();
	}

	@Then("^Verify user loged in successfully$")
	public void verify_user_loged_in_successfully() throws Throwable {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Title is---> " + driver.getTitle());
		Assert.assertTrue(currentUrl.contains("profile"));
	}

	@Then("^Verify the error meaasge$")
	public void verify_the_error_meaasge() throws Throwable {
		erroerList = driver.findElements(By.id("error"));
		String errorMessage = erroerList.get(0).getText();
		Assert.assertEquals("* Email or Password is incorrect.", errorMessage);
	}

	@Then("^Veryfy the error of username and password$")
	public void veryfy_the_error_of_username_and_password() throws Throwable {
		erroerList = driver.findElements(By.id("error"));
		String EmailerrorMessage = erroerList.get(0).getText();
		String PasserrorMessage = erroerList.get(1).getText();
	    Assert.assertEquals("* Email can not be empty.", EmailerrorMessage);
	    Assert.assertEquals("* Password can not be empty.", PasserrorMessage);

	}

	@Then("^Driver quit$")
	public void driver_quit() throws Throwable {
		driver.quit();
	}

}
