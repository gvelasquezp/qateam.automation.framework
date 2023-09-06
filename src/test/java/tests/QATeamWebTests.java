package tests;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class QATeamWebTests extends BaseTest{
	
	String username;
	String password;
	private LoginPage loginPage;
	
	@Given("User open the Orange HRM Login page")
	public void user_open_the_orange_hrm_login_page() throws Exception {

		System.out.println("Initializing the browser to run the test.");
	    startBrowserDefined("chrome");
	    
	    InputStream input = new FileInputStream("src/test/java/resources/framework.properties");
		Properties prop = new Properties();
	    prop.load(input);
	    password = prop.getProperty("password");
	    username = prop.getProperty("username");
	    	    
	}
	
	@Given("User enter the username")
	public void user_enter_the_username(){
		
		loginPage = new LoginPage(driver);
		waitElementIsVisible(loginPage.getSubmitButton());
		loginPage.insertUsername(username);
		
	}

	@Given("User enter the password")
	public void user_enter_the_password(){
		
		loginPage.insertPassword(password);
		
	}

	@When("User click the login button")
	public void user_click_the_login_button(){
		
		waitElementIsClickable(loginPage.getSubmitButton());
		loginPage.getSubmitButton().click();
				
	}

	@Then("User is logged in the page")
	public void user_is_logged_in_the_page() throws InterruptedException {
		
		waitElementIsVisible(loginPage.getUserDropdown());
		Assert.assertTrue(loginPage.getUserDropdown().isDisplayed());
		System.out.println("User successfully logged");
		Thread.sleep(3000);
		closeDriver();
	}

}
