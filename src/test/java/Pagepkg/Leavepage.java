package Pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Leavepage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/a")
	WebElement OM_Apply;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i")
	WebElement OM_LeaveType;
	@FindBy(xpath="//*[contains(text(),'CAN')]")
	WebElement OM_LeaveTypeOption;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/input")
	WebElement OM_FromDate;
	@FindBy(xpath="//button[@type='submit']")
	WebElement OM_ApplyButton;

	
	public Leavepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Apply_Option()
	{                                    
		OM_Apply.click();
	}
	
	public void LeaveTypeSelection() throws InterruptedException
	{
		OM_LeaveType.click();
		Thread.sleep(2000);
		OM_LeaveTypeOption.click();
	}
	
	public void DateSelection() throws InterruptedException
	{
		OM_FromDate.sendKeys("2024-11-18");
	}
	
	public void ApplyLeave()
	{
		OM_ApplyButton.click();
	}
	

}
