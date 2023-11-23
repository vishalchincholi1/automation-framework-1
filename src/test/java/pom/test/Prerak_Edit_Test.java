package pom.test;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseUtils.BrowserManager;
import io.qameta.allure.Description;
import pom.Ip_Login;
import pom.Prerak_Edit;
import selva.util.LoggerUtil;
import selva.util.ReadExcelData;
import selva.util.Reporter;
import selva.util.TakeScreenshot;

public class Prerak_Edit_Test {
	Logger logger = LoggerUtil.getLogger();

	BrowserManager bm = new BrowserManager();

	TakeScreenshot tss = new TakeScreenshot();


	static {
		ReadExcelData.getInstance().setPath(System.getProperty("user.dir") + "/src/test/resources/Test_data/");

	}
	@BeforeSuite
	public void generatereport() {
		logger.info("Generating test report");
		Reporter.setupReport("test_report");
	}

	@BeforeMethod
	public void setupopen() throws Exception {
		logger.info("Setting up the browser...");
		bm.browserrun();
		 
	}

	@SuppressWarnings("static-access")
	@AfterMethod
	public void setupclose(ITestResult result) throws Exception {
		if (result.FAILURE == result.getStatus()) {
			logger.warning("Test case failed. Capturing screenshot...");
			tss.screenshot(bm.driver, "Prerak_Edit_testcase");
		}
		Reporter.reportonTestResult(result, bm.driver);

		bm.driver.close();
	}
	
	@AfterClass
	public void reportFlush() {

		Reporter.flushReport();
	}
	
	//DataProvider below:
	
	@DataProvider(name = "editName")
	public Object[][] creator_tcdata1() throws Exception {
		logger.info("Fetching data from the data provider 'editName'");
		Object[][] testData = ReadExcelData.getExcelDataIn2DArray("Prerak_Edit.xlsx", "editName");
		return testData;
	}
	
	@DataProvider(name = "editAddress")
	public Object[][] creator_tcdata2() throws Exception {
		logger.info("Fetching data from the data provider 'editAddress'");
		Object[][] testData = ReadExcelData.getExcelDataIn2DArray("Prerak_Edit.xlsx", "editAddress");
		return testData;
	}

	
	
	
	
	
	@Description("Check PM_PPE_PP_PrerakProfileEdit")
	@Test(enabled=true, priority=0)
	public void PM_PPE_PP_PrerakHome(Method testmethodname)
	{
		LoggerUtil.startTimeMeasurement();
		logger.info("PM_PPE_PP_PrerakHome method");
		Reporter.createTest(testmethodname.getName());

		
		Ip_Login login = PageFactory.initElements(bm.driver, Ip_Login.class);
		
		Prerak_Edit slt = PageFactory.initElements(bm.driver, Prerak_Edit.class);
		
		Reporter.logStep(Status.INFO, "Steps performed according to test case");
		
		login.commonLogin();
		slt.PM_PPE_PP_PrerakProfileEdit();
	
		
		LoggerUtil.stopTimeMeasurement("Test case execution completed");
	}
	
	
	
	@Description("Check Edit Prerak Basic Details>Name,DOB")
	@Test(enabled=true,dataProvider="editName",priority=1)
	public void PM_PPE_PP_EditPrerakDetails_editName(String fname,String mname,String lname,String year,String month,String day,Method testmethodname)
	{
		LoggerUtil.startTimeMeasurement();
		logger.info("EditPrerakDetails_PM_PPE_PP_editName method");
		Reporter.createTest(testmethodname.getName());

		
		Ip_Login login = PageFactory.initElements(bm.driver, Ip_Login.class);

		
		Prerak_Edit slt = PageFactory.initElements(bm.driver, Prerak_Edit.class);
		
		Reporter.logStep(Status.INFO, "Steps performed according to test case");
		
		login.commonLogin();
		slt.PM_PPE_PP_editName(fname,mname,lname,year,month,day);
		
	
		
		LoggerUtil.stopTimeMeasurement("PM_PPE_PP_editName Test case execution completed");
	}
	
	
	@Description("Check Edit Prerak Basic Details>Edit Address")
	@Test(enabled=false,dataProvider="editAddress",priority=1)
	public void PM_PPE_PP_EditPrerakDetails_editAddress(String state,String district,String block,String village,String grampanchayat,Method testmethodname)
	{
		LoggerUtil.startTimeMeasurement();
		logger.info("EditPrerakDetails_PM_PPE_PP_editAddress method");
		Reporter.createTest(testmethodname.getName());

		
		Ip_Login login = PageFactory.initElements(bm.driver, Ip_Login.class);

		
		Prerak_Edit slt = PageFactory.initElements(bm.driver, Prerak_Edit.class);
		
		Reporter.logStep(Status.INFO, "Steps performed according to test case");
		
		login.commonLogin();
		slt.editAddress(state,district,block,village,grampanchayat);
		
	
		
		LoggerUtil.stopTimeMeasurement("Test case execution completed");
	}
	
	
	
	
}
