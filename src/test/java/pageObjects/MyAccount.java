package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {
	
	WebDriver driver;
	
	public MyAccount(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//h2[text()='My Account']") WebElement account;
	@FindBy(xpath="(//a[text()='Logout'])[2]") WebElement logout_link;
	
	public boolean is_MyAccount_Exists()
	
	{
		try
		{
		return(account.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void logout()
	{
		logout_link.click();
	}

}
