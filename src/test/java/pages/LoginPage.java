package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

public WebDriver driver;
	
	@FindBy (name = "username")
	WebElement usernameField;
	
	@FindBy (name = "password")
	WebElement passwordField;
	
	@FindBy(xpath = ".//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(css = ".oxd-userdropdown-tab")
	WebElement userDropdown;
	
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public WebElement getUsernameField() {
		return usernameField;
	}
	
	public WebElement getPasswordField() {
		return passwordField;
	}
	
	public WebElement getUserDropdown() {
		return userDropdown;
	}
	
	public void insertUsername(String username) {
		usernameField.clear();
		usernameField.sendKeys(username);
	}
	
	public void insertPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}

}
