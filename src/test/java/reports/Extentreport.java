package reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extentreport {
	
	ExtentHtmlReporter htmlreport;
	ExtentReports extent;
	WebDriver driver=null;
	ExtentTest test;
	
	@BeforeSuite
	public void ExtentSetup() {
		htmlreport =  new ExtentHtmlReporter("report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
	}
	
	@BeforeTest
	public void DriverSetup() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void Test1() {
		test = extent.createTest("Test1", "first");
		driver.get("https://google.com");
		test.log(Status.INFO, "Navigating to url");
		test.pass("Success");
	}
	
	@AfterTest
	public void driverclose() {
		driver.close();
		driver.quit();
	}
	
	@AfterSuite
	public void teardown() {
		extent.flush();
	}
	
}
