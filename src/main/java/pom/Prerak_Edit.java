package pom;

import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import baseUtils.BrowserManager;
import selva.util.LoggerUtil;
import selva.util.PropertiesFileManager;
import selva.util.Reporter;


public class Prerak_Edit {
	BrowserManager bm=new BrowserManager();
	static String locatorsPath=System.getProperty("user.dir")+"/src/test/resources/locators/";
	public static boolean PragatiMobilizer=false;

	public Prerak_Edit(WebDriver driver)
	{
		bm.driver=driver;
	}
	//..............load properties file
	
	static {
	
        PropertiesFileManager.getInstance().setPath(locatorsPath);
	}
	private static final Logger LOGGER = LoggerUtil.getLogger();
	PropertiesFileManager loader = PropertiesFileManager.getInstance();
	Properties PrerakHomeLocators = loader.getProperties("Prerak_Edit.properties");
	
	//............Pom elements fetched from properties file
	
	//home elements
	
	//By addLearner=By.xpath(PrerakHomeLocators.getProperty("addLearner"));
	
	//editProfileElements
	By sidebar=By.xpath(PrerakHomeLocators.getProperty("sidebar"));
	By profile=By.xpath(PrerakHomeLocators.getProperty("profile"));
	By editBasicDetails=By.xpath(PrerakHomeLocators.getProperty("editBasicDetails"));
	
	By basicDetailsMSG=By.xpath(PrerakHomeLocators.getProperty("basicDetailsMSG"));
	
	//By editProfilePhoto=By.xpath(PrerakHomeLocators.getProperty("editProfilePhoto"));
	By editName=By.xpath(PrerakHomeLocators.getProperty("editName"));
	By editContactDetails=By.xpath(PrerakHomeLocators.getProperty("editContactDetails"));
	By editAddressDetails=By.xpath(PrerakHomeLocators.getProperty("editAddressDetails"));
	By editPersonalDetails=By.xpath(PrerakHomeLocators.getProperty("editPersonalDetails"));
	By editReferenceDetails=By.xpath(PrerakHomeLocators.getProperty("editReferenceDetails"));
	By editOtherDetails=By.xpath(PrerakHomeLocators.getProperty("editOtherDetails"));
	
	//EditName
	By FirstName=By.xpath(PrerakHomeLocators.getProperty("FirstName"));
	By MiddleName=By.xpath(PrerakHomeLocators.getProperty("MiddleName"));
	By LastName=By.xpath(PrerakHomeLocators.getProperty("LastName"));
	By Year=By.xpath(PrerakHomeLocators.getProperty("Year"));
	By Month=By.xpath(PrerakHomeLocators.getProperty("Month"));
	By Day=By.xpath(PrerakHomeLocators.getProperty("Day"));
	By SaveEditName=By.xpath(PrerakHomeLocators.getProperty("SaveEditName"));
	
	//EditAddress
	
	By State=By.xpath(PrerakHomeLocators.getProperty("State"));
	By District=By.xpath(PrerakHomeLocators.getProperty("District"));
	By Block=By.xpath(PrerakHomeLocators.getProperty("Block"));
	By Village=By.xpath(PrerakHomeLocators.getProperty("Village"));
	By Grampanchayat=By.xpath(PrerakHomeLocators.getProperty("Grampanchayat"));
	By SaveEditAddress=By.xpath(PrerakHomeLocators.getProperty("SaveEditAddress"));
	
	
	 // Actions on web elements
	
	  
	  
	  
//	  public void clickAddLearner()
//	  {
//		  
//		  	LOGGER.info("Clicking Add Learner Button");
//	  		Reporter.logStep(Status.INFO, "Clicking Add Learner Button");
//	  		
//	  		bm.driver.findElement(addLearner).click();
//	  		
//	  }
	
	  
	  //Edit Actions
	  
	  public void clickSidebar()
	  {
		  bm.driver.findElement(sidebar).click();
		  	LOGGER.info("Clicking sidebar");
	  		Reporter.logStep(Status.INFO, "Clicking sidebar");

	  		
		  
	  }
	  public void clickProfile()
	  {
		  bm.driver.findElement(profile).click();
		  LOGGER.info("Clicking Profile");
	  		Reporter.logStep(Status.INFO, "Clicking Profile");

	  		
		  
		  
	  }
	  
	  public void click_editBasicDetails() throws InterruptedException
	  {
		  bm.driver.findElement(editBasicDetails).click();
	  		Thread.sleep(2000);	
		  LOGGER.info("Clicking editBasicDetails");
	  		Reporter.logStep(Status.INFO, "Clicking editBasicDetails");

	  		
	  		
		  
	  }
	  
//	  public void click_editProfilePhoto() throws InterruptedException
//	  {
//		  LOGGER.info("Clicking editProfilePhoto");
//	  		Reporter.logStep(Status.INFO, "Clicking editProfilePhoto");
//
//	  		bm.driver.findElement(editProfilePhoto).click();
//	  		Thread.sleep(3000);
//
//	  }
	  
	  public void click_editName() throws InterruptedException
	  {
		  LOGGER.info("Clicking editName");
	  		Reporter.logStep(Status.INFO, "Clicking editName");
	  		
	  		clickAndWait(bm.driver,editName,2);
	  		
	  		
	  }
	 	  
	  public void click_editContactDetails() throws InterruptedException
	  {
		  LOGGER.info("Clicking editContactDetails");
	  		Reporter.logStep(Status.INFO, "Clicking editContactDetails");
	  		
	  		
	  		clickAndWait(bm.driver,editContactDetails,2);
	  		

	  }
	 	  
	  public void click_editAddressDetails() throws InterruptedException
	  {
		  LOGGER.info("Clicking editAddressDetails");
	  		Reporter.logStep(Status.INFO, "Clicking editAddressDetails");
	  		
	  		clickAndWait(bm.driver,editAddressDetails,2);
	  		

	  }
	 	  
	  public void click_editPersonalDetails() throws InterruptedException
	  {
		  LOGGER.info("Clicking editPersonalDetails");
	  		Reporter.logStep(Status.INFO, "Clicking editPersonalDetails");
	  		
	  		clickAndWait(bm.driver,editPersonalDetails,2);
	  		

	  }
	 	  
	  public void click_editReferenceDetails() throws InterruptedException
	  {
		  LOGGER.info("Clicking editReferenceDetails");
	  		Reporter.logStep(Status.INFO, "Clicking editReferenceDetails");
	  		
	  		clickAndWait(bm.driver,editReferenceDetails,2);
	  		
	  }
	 	  
	  public void click_editOtherDetails() throws InterruptedException
	  {
		  LOGGER.info("Clicking editOtherDetails");
	  		Reporter.logStep(Status.INFO, "Clicking editOtherDetails");
	  		
	  		clickAndWait(bm.driver,editOtherDetails,2);
	  		
	  }
	
	  //editName Actions:
	  
	  
	  
	  public void enterFirstName(String fname)
	  {
		LOGGER.info("Entering First Name");
	  	Reporter.logStep(Status.INFO, "Entering First Name");
	  	//bm.driver.findElement(FirstName).sendKeys(fname);
	  	clickTypeAndWait(bm.driver,FirstName,fname,2);
	  	
	  		
	  }
	  
	  public void enterMiddleName(String mname)
	  {
		  LOGGER.info("Entering Middle Name");
		  	Reporter.logStep(Status.INFO, "Entering Middle Name");
//		  	bm.driver.findElement(MiddleName).sendKeys(mname);
		  	clickTypeAndWait(bm.driver,MiddleName,mname,2);
	  }
	  public void enterLastName(String lname)
	  {
		  LOGGER.info("Entering Last Name");
		  	Reporter.logStep(Status.INFO, "Entering Last Name");
//		  	bm.driver.findElement(LastName).sendKeys(lname);
		  	clickTypeAndWait(bm.driver,LastName,lname,2);
	  }
	  
	  public void selectYear(String year)
	  {
		  	LOGGER.info("Selecting Year");
		  	Reporter.logStep(Status.INFO, "Selecting Year");
		  	Select dropdown = new Select(bm.driver.findElement(By.xpath(PrerakHomeLocators.getProperty("Year"))));

	        // Select by visible text
	        dropdown.selectByVisibleText(year);
		  	
	  }	
	  public void selectMonth(String month)
	  {
		  	LOGGER.info("Selecting Month");
		  	Reporter.logStep(Status.INFO, "Selecting Month");
		  	Select dropdown = new Select(bm.driver.findElement(By.xpath(PrerakHomeLocators.getProperty("Month"))));

	        // Select by visible text
	        dropdown.selectByVisibleText(month);
		  	
	  }
	  
	  public void selectDay(String day)
	  {
		  	LOGGER.info("Selecting Day");
		  	Reporter.logStep(Status.INFO, "Selecting Day");
		  	Select dropdown = new Select(bm.driver.findElement(By.xpath(PrerakHomeLocators.getProperty("Day"))));

	        // Select by visible text
	        dropdown.selectByVisibleText(day);
	  }
	  
	  public void clickSave()
	  {
		  	
//	    	bm.driver.findElement(SaveEditName).click();
		  
		  
		  	JavascriptExecutor js = (JavascriptExecutor) bm.driver;
			
			WebElement Element = bm.driver.findElement(SaveEditName);

			js.executeScript("arguments[0].scrollIntoView(true);",Element);
			
			clickAndWait(bm.driver,SaveEditName,2);
			
	    	LOGGER.info("Clicking Save");
		  	Reporter.logStep(Status.INFO, "Clicking Save");

		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  public static void clickAndWait(WebDriver driver,By locator,int timeoutInSeconds) {
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		  element.click();
		  
		  }
	  
	  public static void clickTypeAndWait(WebDriver driver,By locator,String keys,int timeoutInSeconds) {
		 
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		  element.click();
		  element.sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
		  element.sendKeys(keys);
		  
		  }
	  
	  
	  

	
	  
	  public void enterGrampanchayat(String grampanchayat2) {
		  LOGGER.info("Entering Grampanchayat");
		  	Reporter.logStep(Status.INFO, "Entering Grampanchayat");
		  
		  clickTypeAndWait(bm.driver,Grampanchayat,grampanchayat2,2);
			
		}


		public void selectVillage(String village2) {
				LOGGER.info("Selecting Village");
			  	Reporter.logStep(Status.INFO, "Selecting Village");
			
			  	WebElement village=bm.driver.findElement(Village);
				Select dropdown = new Select(village);
				WebDriverWait wait = new WebDriverWait(bm.driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.visibilityOf(village));
	            dropdown.selectByValue(village2);
			
		}


		public void selectBlock(String block2) {
				LOGGER.info("Selecting Block");
			  	Reporter.logStep(Status.INFO, "Selecting Block");
			  	WebElement block=bm.driver.findElement(Block);
				Select dropdown = new Select(block);
				WebDriverWait wait = new WebDriverWait(bm.driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.visibilityOf(block));
	        dropdown.selectByValue(block2);
			
		}


		public void selectDistrict(String district2) {
			 	LOGGER.info("Selecting District");
			  	Reporter.logStep(Status.INFO, "Selecting District"
			  			+ "");
			  	
			  	
			  	WebElement dist=bm.driver.findElement(District);
				Select dropdown = new Select(dist);
				WebDriverWait wait = new WebDriverWait(bm.driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.visibilityOf(dist));
	        dropdown.selectByValue(district2);
			
		}


		public void selectState(String state2) {
			 LOGGER.info("Selecting State");
			  	Reporter.logStep(Status.INFO, "Selecting State");
			  	
			  	WebElement state=bm.driver.findElement(State);
			  	
			  	Select dropdown = new Select(state);
			  	
			  	WebDriverWait wait = new WebDriverWait(bm.driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.visibilityOf(state));
	            
	            // Select by visible text
	            dropdown.selectByValue(state2);
	      
			LOGGER.info("State Selected");
		}
		public void clickSaveAddress() {
			 LOGGER.info("Clicking Save");
			  	Reporter.logStep(Status.INFO, "Clicking Save");
			  	
				  
			  	JavascriptExecutor js = (JavascriptExecutor) bm.driver;
				
				WebElement Element = bm.driver.findElement(SaveEditAddress);

				js.executeScript("arguments[0].scrollIntoView(true);",Element);
			  	
			  	
			  	clickAndWait(bm.driver,SaveEditAddress,2);
			  	
		}
	  
	  
	  
	  
	  
	  
	  

	 
	 //Prerak Profile TC:
	 public void PM_PPE_PP_PrerakProfileEdit() {
	        try {
	            LOGGER.info("Executing PM_PPE_PP_PrerakProfileEdit test cases...");
	            bm.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	            	
	          clickSidebar();
	          Thread.sleep(1000);
	          clickProfile();
	          Thread.sleep(1000);

	     
	          click_editBasicDetails();
	          Thread.sleep(1000);

	          Assert.assertEquals(bm.driver.findElement(basicDetailsMSG).getText(),"Basic Details");

//	     	  click_editProfilePhoto();
//	     	  bm.driver.navigate().back();

	     	  click_editName();
	     	  
	     	  bm.driver.navigate().back();
	          Thread.sleep(1000);


	     	 	  
	     	  click_editContactDetails();
	     	  bm.driver.navigate().back();
	          Thread.sleep(1000);


	     	 	  
	     	  click_editAddressDetails();
	     	  bm.driver.navigate().back();
	          Thread.sleep(1000);


	     	 	  
	     	  click_editPersonalDetails();
	     	 bm.driver.navigate().back();
	          Thread.sleep(1000);

 	 	  
	     	  click_editReferenceDetails();
	     	 bm.driver.navigate().back();
	          Thread.sleep(1000);


	     	  click_editOtherDetails();
	     	 bm.driver.navigate().back();
	          Thread.sleep(1000);

	            LOGGER.info("PM_PPE_PP_PrerakProfileEdit executed successfully.");
	        } catch (Exception e) {
	            LoggerUtil.logException(e, "Exception occurred during PM_PPE_PP_PrerakProfileEdit test cases.");
	        }
	    }
	 
	 public void PM_PPE_PP_editName(String fname,String mname,String lname,String year,String month,String day)
	 {
		 
		 try {
	            LOGGER.info("Executing PM_PPE_PP_editName test cases...");
	            bm.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	            	
	              Thread.sleep(1000); 
	              clickSidebar();
		          Thread.sleep(1000);
		          
		          clickProfile();
		          Thread.sleep(1000);

		     
		          click_editBasicDetails();
		          Thread.sleep(1000);
		          
		          click_editName();
		          Thread.sleep(1000);
		          
		          
		          enterFirstName(fname);
		          Thread.sleep(1000);
		    	  
		          enterMiddleName(mname);
		          Thread.sleep(1000);
		    	  enterLastName(lname);
		    	  Thread.sleep(1000);
		    	  selectYear(year);
		    	  Thread.sleep(1000);
		    	  selectMonth(month);
		    	  Thread.sleep(1000);
		    	  
		    	  selectDay(day);
		    	  Thread.sleep(1000);
		    	  
		    	  clickSave();
		    	  Thread.sleep(1000);
		          

		          

	           
	            LOGGER.info("PM_PPE_PP_editName Test executed successfully.");
	        } catch (Exception e) {
	            LoggerUtil.logException(e, "Exception occurred during PM_PPE_PP editName test cases.");
	        }
		 
		 
		 
	 }

	 
	 
	 
	 public void editAddress(String state,String district,String block,String village,String grampanchayat)
	 {
		 
		 try {
	            LOGGER.info("Executing editAddress test cases...");
	            bm.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	            	
	              Thread.sleep(2000); 
	              clickSidebar();
		          Thread.sleep(3000);
		          
		          clickProfile();
		          Thread.sleep(3000);

		     
		          click_editBasicDetails();
		          Thread.sleep(1000);
		          
		          click_editAddressDetails();
		          
		          Thread.sleep(1000);
		          
		          
		          selectState(state);
		          Thread.sleep(3000);
		    	  
		          selectDistrict(district);
		          Thread.sleep(1000);
		          
		          selectBlock(block);
		    	  Thread.sleep(1000);
		    	  
		    	  selectVillage(village);
		    	  Thread.sleep(1000);
		    	  
		    	  enterGrampanchayat(grampanchayat);
		    	  Thread.sleep(1000);
		    	  
		    	  
		    	  clickSaveAddress();
		    	  Thread.sleep(1000);
		          

		          

	           
	            LOGGER.info("editAddress executed successfully.");
	        } catch (Exception e) {
	            LoggerUtil.logException(e, "Exception occurred during editAddress test cases.");
	        }
		 
		 
		 
	 }




	

	


	
}
