package Pagepkg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMpage {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]")
	WebElement OM_AddEmployee;
	@FindBy(name="firstName")
	WebElement OM_Employee_FirstName;
	@FindBy(name="middleName")
	WebElement OM_Employee_MiddleName;
	@FindBy(name="lastName")
	WebElement OM_Employee_LastName;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
	WebElement OM_EmployeeId;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")
	WebElement OM_Toggle;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")
	WebElement OM_UserName;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input")
	WebElement OM_Password;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input")
	WebElement OM_CnfmPassword;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[1]/div[2]/div/label/span")
	WebElement OM_Status_Enabled;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/div/button/i")
	WebElement OM_PicUpload;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
	WebElement OM_Save;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a")
	WebElement OM_EmployeeList;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
	WebElement OM_EmployeeName;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")
	WebElement OM_EmployeeID;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
	WebElement OM_SearchButton;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[9]/div/button/i")
	WebElement OM_EditRecord;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")
	WebElement OM_Leave;
	
	public PIMpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		
	public void Add_Employee_Option()
	{
		OM_AddEmployee.click();
	}
	
	public void EmployeeDetails()
	{
		OM_Employee_FirstName.sendKeys("Soa");
		OM_Employee_MiddleName.sendKeys("Kol");
		OM_Employee_LastName.sendKeys("Mon");
		OM_EmployeeId.sendKeys("11");
		OM_Toggle.click();
		OM_UserName.sendKeys("SaolMn");
		OM_Password.sendKeys("qazwsx1");
		OM_CnfmPassword.sendKeys("qazwsx1");
		OM_Status_Enabled.isSelected();
	}
	
	public void PhotoUpload() throws AWTException
	{
		OM_PicUpload.click();
		PicUpload("C:\\Users\\sandh\\OneDrive\\Desktop\\Dp.jpeg");
	}

	public void PicUpload(String p) throws AWTException 
	{
		StringSelection PhotoSelect=new StringSelection(p);									
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(PhotoSelect, null);		
		
		Robot robot=new Robot();																
		robot.delay(3000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);													
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void SaveButton()
	{
		OM_Save.click();
	}
	
	public void Employee_List_Option()
	{
		OM_EmployeeList.click();
	}
	
	public void SearchEmployee() throws InterruptedException
	{
		OM_EmployeeName.sendKeys("Soa Kol Mon");
		Thread.sleep(2000);
		OM_SearchButton.click();
	}
	
	public void EmployeeRecord() throws IOException
	{
		OM_EditRecord.click();
	}
	
	public void LeaveMenu()
	{
		OM_Leave.click();
	}
	
	

}
