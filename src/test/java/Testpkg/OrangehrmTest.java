package Testpkg;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pagepkg.Dashboardpage;
import Pagepkg.Leavepage;
import Pagepkg.Loginpage;
import Pagepkg.PIMpage;
import Utilities.Excelutils;


public class OrangehrmTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void Setup() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	

	@Test(priority=1)
	public void LoginTest() throws InterruptedException
	{
		Loginpage ob=new Loginpage(driver);
		String x1="C:\\Users\\sandh\\Downloads\\OrangeHRM_Login Credentials.xlsx";
		String Sheet="Sheet1";
		
		int rowCount=Excelutils.getRowCount(x1,Sheet);
		for(int i=1;i<=rowCount;i++)
		{
			String username=Excelutils.getCellValue(x1, Sheet, i, 0);
			System.out.println("Username------"+username);
			String password=Excelutils.getCellValue(x1, Sheet, i, 1);
			System.out.println("Password------"+password);
			ob.Setvalues(username, password);
			Thread.sleep(2000);
			ob.LoginButton();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.navigate().refresh();
		}
	}
	
	@Test(priority=2)
	public void DashboardTest() throws InterruptedException
	{
		Dashboardpage ob1=new Dashboardpage(driver);
		ob1.TitleVerification();
		ob1.PIMMenu();
		Thread.sleep(2000);
	}
	
	
	@Test(priority=3)
	public void PIMTest() throws InterruptedException, AWTException, IOException 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		PIMpage ob2=new PIMpage(driver);
		ob2.Add_Employee_Option();
		Thread.sleep(2000);
		ob2.EmployeeDetails();
		Thread.sleep(2000);
		ob2.PhotoUpload();
		ob2.SaveButton();
		Thread.sleep(2000);
		ob2.Employee_List_Option();
		driver.navigate().refresh();
		ob2.SearchEmployee();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1000)");
		ob2.EmployeeRecord();
		Thread.sleep(2000);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(".//Screenshot/EmployeeInfo.png"));
		Thread.sleep(4000);
		ob2.LeaveMenu();
		Thread.sleep(2000);
	}
	
	@Test(priority=4)
	public void LeaveTest() throws InterruptedException
	{
		Leavepage ob3=new Leavepage(driver);
		ob3.Apply_Option();
		Thread.sleep(2000);
		ob3.LeaveTypeSelection();
		Thread.sleep(2000);
		ob3.DateSelection();
		Thread.sleep(2000);
		ob3.ApplyLeave();
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
	
}
	


