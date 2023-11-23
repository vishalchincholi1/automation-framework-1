package pom;


import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import baseUtils.BrowserManager;
import selva.util.LoggerUtil;
import selva.util.PropertiesFileManager;
import selva.util.Reporter;




public class Prerak_Login {
	BrowserManager bm=new BrowserManager();
	
	
	static String locatorsPath=System.getProperty("user.dir")+"/src/test/resources/locators/";

	
	public Prerak_Login(WebDriver driver)
	{
		bm.driver=driver;
	}
	//..............load properties file
	
	static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
	}
	
	private static final Logger LOGGER = LoggerUtil.getLogger();
	PropertiesFileManager loader = PropertiesFileManager.getInstance();
	
	Properties loginlocators = loader.getProperties("login.properties");
	
	
	//............Pom elements fetched from properties file
	
    
    By username1=By.xpath(loginlocators.getProperty("username"));
    By password1=By.xpath(loginlocators.getProperty("password"));
    By loginbutton=By.xpath(loginlocators.getProperty("loginButton"));
    By welcomemessage=By.xpath(loginlocators.getProperty("msg"));
    By logoutButton=By.xpath(loginlocators.getProperty("logoutbtn"));

    
    
    //.........actions on webelements
    // Actions on web elements

    public void enterUsername(String userId) throws InterruptedException {
        LOGGER.info("Entering username: " + userId);
        Reporter.logStep(Status.INFO, "Entering username..");
        bm.driver.findElement(username1).sendKeys(userId);
    }

    public void enterPassword(String pass) throws InterruptedException {
        LOGGER.info("Entering password...");
        Reporter.logStep(Status.INFO, "Entering password..");
        bm.driver.findElement(password1).sendKeys(pass);
    }

    public void clickLoginButton() {
        LOGGER.info("Clicking on login button...");
        Reporter.logStep(Status.INFO, "Clicking on login button..");
        bm.driver.findElement(loginbutton).click();
    }
    public void clickLogout() {
    	LOGGER.info("Clicking Logout...");
    	Reporter.logStep(Status.INFO, "Clicking on Logout button..");
    	bm.driver.findElement(logoutButton).click();
    }
    
    // Test cases on login page include button and login functionality

    // Login test cases
    public void loginTestCases(String userId, String pass) {
        try {
            LOGGER.info("Executing prerak login LM_L_LP test");
            bm.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
          
            enterUsername(userId);
            enterPassword(pass);
            clickLoginButton(); 
                                  
            //System.out.println(bm.driver.findElement(welcomemessage).getText());
            
            Thread.sleep(1000);
            Assert.assertEquals(bm.driver.findElement(welcomemessage).getText(),"Welcome Varun,");
            clickLogout();
    
            LOGGER.info("Login test LM_L_LP executed successfully.");
        } catch (Exception e) {
            LoggerUtil.logException(e, "Exception occurred during LM_L_LP login test cases.");
        }
    }
    
   
    // Common login method for all usage
    public void commonLogin() {
        try {
            LOGGER.info("Executing common login...");
            bm.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            enterUsername(loginlocators.getProperty("uid"));
            enterPassword(loginlocators.getProperty("pwd"));
            clickLoginButton();

            LOGGER.info("Common login executed successfully.");
        } catch (Exception e) {
            LoggerUtil.logException(e, "Exception occurred during common login.");
        }


    }


}


