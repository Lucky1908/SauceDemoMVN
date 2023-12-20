package testcases;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	Fillo fillo;
	Connection connection;
	
	@BeforeTest
	public void reportSetup() throws FilloException {
		extent=new ExtentReports("ExtentReport.html");
		fillo=new Fillo();
		connection=fillo.getConnection("Data.xlsx");
	}
	
	@BeforeMethod
	public void setup(Method method) throws FilloException {
		
		
		test=extent.startTest(method.getName());
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		extent.endTest(test);
		driver.quit();
		
	}
	
	@AfterTest
	public void reportClean() {
		extent.flush();
		extent.close();
	}


}
