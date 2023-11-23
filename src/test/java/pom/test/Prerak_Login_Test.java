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
import pom.Prerak_Login;
import selva.util.LoggerUtil;
import selva.util.ReadExcelData;
import selva.util.Reporter;
import selva.util.TakeScreenshot;

public class Prerak_Login_Test {

	Logger logger = LoggerUtil.getLogger();

	BrowserManager bm = new BrowserManager();

	TakeScreenshot tss = new TakeScreenshot();


	static {
		ReadExcelData.getInstance().setPath(System.getProperty("user.dir") + "/src/test/resources/Test_data/");

	}

	@BeforeSuite
	public void generatereport() {
		logger.info("Generating test report");
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
			logger.warning("Test LM_L_LP failed. Capturing screenshot...");
			tss.screenshot(bm.driver, "Prerak login Test LM_L_LP");
		}
		Reporter.reportonTestResult(result, bm.driver);

		bm.driver.close();
	}

	@AfterClass
	public void reportFlush() {

		Reporter.flushReport();
	}

	@DataProvider(name = "prerak_login")
	public Object[][] creator_tcdata() throws Exception {
		logger.info("Fetching data from the data provider 'prerak_login'");
		Object[][] testData = ReadExcelData.getExcelDataIn2DArray("loginData.xlsx", "prerakLoginData");
		return testData;
	}

	@Description("Verify login funtionality of prerak")
	@Test(enabled=true, dataProvider = "prerak_login")
	public void LM_L_LP(String userId, String pwd, Method testmethodname) {
		LoggerUtil.startTimeMeasurement();
		logger.info("Executing LM_L_LP method");
		Reporter.createTest(testmethodname.getName());
		Prerak_Login slt = PageFactory.initElements(bm.driver, Prerak_Login.class);
		Reporter.logStep(Status.INFO, "Steps performed according to LM_L_LP test");
		slt.loginTestCases(userId, pwd);
		LoggerUtil.stopTimeMeasurement("Test execution of LM_L_LP completed");
	}
	
	
	
	
	

}
