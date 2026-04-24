package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomaPage extends BasePage {
	
	WebDriver driver;
	public HomaPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[normalize-space()='My Account']") WebElement Homelink;
	@FindBy(xpath="//*[normalize-space()='Register']")WebElement RegLink;
	@FindBy(xpath="//*[normalize-space()='Login']")WebElement loginlink;
	
	public void Home()
	{
		Homelink.click();
	}
	public void Register()
	{
		RegLink.click();
	}
	public void Login()
	{
		loginlink.click();
	}

}
