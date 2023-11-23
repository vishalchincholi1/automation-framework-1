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
import selva.util.LoggerUtil;
import selva.util.ReadExcelData;
import selva.util.Reporter;
import selva.util.TakeScreenshot;

public class Ip_Login_Test {

	Logger logger = LoggerUtil.getLogger();

	BrowserManager bm = new BrowserManager();

	TakeScreenshot tss = new TakeScreenshot();


	static {
		ReadExcelData.getInstance().setPath(System.getProperty("user.dir") + "/src/test/resources/Test_data/");

	}

	@BeforeSuite
	public void generatereport() {
		logger.info("Generating Test Report");
		Reporter.setupReport("Test_Report");
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
			logger.warning("Test LM_L_LIP failed. Capturing Screenshot...");
			tss.screenshot(bm.driver, "ip login test case");
		}
		Reporter.reportonTestResult(result, bm.driver);

		bm.driver.close();
	}

	@AfterClass
	public void reportFlush() {

		Reporter.flushReport();
	}

	@DataProvider(name = "EG_login")
	public Object[][] creator_tcdata() throws Exception {
		logger.info("Fetching data from the data provider 'EG_login'");
		Object[][] testData = ReadExcelData.getExcelDataIn2DArray("loginData.xlsx", "ipLoginData");
		return testData;
	}

	@Description("Verify login funtionality of IP")
	@Test(enabled=true, dataProvider = "EG_login")
	public void LM_L_LIP(String userId, String pwd, Method testmethodname) {
		LoggerUtil.startTimeMeasurement();
		logger.info("Executing LM_L_LIP Test Cases");
		Reporter.createTest(testmethodname.getName());
		Ip_Login slt = PageFactory.initElements(bm.driver, Ip_Login.class);
		Reporter.logStep(Status.INFO, "Steps performed according to LM_L_LIP Test Cases");
		slt.loginTestCases(userId, pwd);
		LoggerUtil.stopTimeMeasurement("LM_L_LIP Test Cases Execution Completed");
	}
	
	
	
	
	

}
