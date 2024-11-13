package Pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Dashboardpage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")
	WebElement OM_PIM;
	
	
	public Dashboardpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void TitleVerification()
	{
		String expectedtitle="OrangeHRM";
		String actualtitle=driver.getTitle();
		Assert.assertEquals(expectedtitle,actualtitle);
		System.out.println("Login Sucessfull");
		System.out.println("Verified Title : "+actualtitle);
		
	}
	
	
	public void PIMMenu()
	{
		OM_PIM.click();
	}
	
}
