package tests;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	
	public WebDriver driver;
	

	 /**
    * This is a method for start the browser defining the browser name
    // @param String
    *            browserName
	 * @throws Exception 
    **/
	
   public void startBrowserDefined(String browserName) throws Exception {
    InputStream input = new FileInputStream("src/test/java/resources/framework.properties");
	Properties prop = new Properties();
	prop.load(input);
	
   	String browser = browserName.toLowerCase();
       System.out.println("Testing in Browser: " + browser);
       if (browser == "firefox"){
       	System.setProperty("webdriver.gecko.driver",prop.getProperty("firefoxDriverPath"));
           driver = new FirefoxDriver();
           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
           driver.manage().window().maximize();
           System.out.println("Go to : "+prop.getProperty("loginURL"));
           driver.get(prop.getProperty("loginURL"));

       }
       else if (browser == "chrome"){

           System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriverPath"));
           driver = new ChromeDriver();
           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
           driver.manage().window().maximize();
           System.out.println("Go to : "+prop.getProperty("loginURL"));
           driver.get(prop.getProperty("loginURL"));
           
       }
       System.out.println("Browser initialized successfully :" + browser);
   }
   
  /**
    * This is a method for close the browser driver
    **/
   public void closeDriver() {
   	System.out.println("Closing the browser ... ");
       driver.quit();
       System.out.println("Browser closed successfully.");
   }

   /**
    * This is a method for make a pause of 5'
    **/
   public void waitDriver() throws InterruptedException {
       Thread.sleep(5000);
   }
   
    
   /**
    * This is a method for wait a element clickable
    **/
   public void waitElementIsClickable(WebElement element) {
   	WebDriverWait wait = new WebDriverWait(driver, 10); 
   	wait.until(ExpectedConditions.elementToBeClickable(element));
   }
   
   /**
    * This is a method for wait a element visible
    **/
   public void waitElementIsVisible(WebElement element) {
   	WebDriverWait wait = new WebDriverWait(driver, 10); 
   	wait.until(ExpectedConditions.visibilityOf(element));
   }
   
}
