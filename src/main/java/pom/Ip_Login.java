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



public class Ip_Login {
	BrowserManager bm=new BrowserManager();
	
	
	static String locatorsPath=System.getProperty("user.dir")+"/src/test/resources/locators/";

	
	public Ip_Login(WebDriver driver)
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
    By welcomemessage=By.xpath(loginlocators.getProperty("ipmsg"));
    By iplogoutmenu=By.xpath(loginlocators.getProperty("iplogoutmenu"));
    By iplogoutbutton=By.xpath(loginlocators.getProperty("iplogoutbutton"));
    
    
    
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
    public void clickLogout() throws InterruptedException {
    	LOGGER.info("Clicking Logout...");
    	Reporter.logStep(Status.INFO, "Clicking Logout...");
    	
    	bm.driver.findElement(iplogoutmenu).click();
    	//Thread.sleep(500);
    	bm.driver.findElement(iplogoutbutton).click();
    	

    }
    
    // Test cases on login page include button and login functionality

    // Login test cases
    public void loginTestCases(String userId, String pass) {
        try {
            LOGGER.info("Executing login test cases...");
            bm.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
          
            enterUsername(userId);
            enterPassword(pass);
            clickLoginButton(); 
            //Thread.sleep(500);
                        
            Assert.assertEquals(bm.driver.findElement(welcomemessage).getText(),"Home");
            clickLogout();
    
            LOGGER.info("IP Login test cases executed successfully.");
            Reporter.logStep(Status.INFO, "IP Login test cases executed successfully.");
        } catch (Exception e) {
            LoggerUtil.logException(e, "Exception occurred during IP login test case.");
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


