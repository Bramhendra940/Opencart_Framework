package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(name="email")WebElement email;
	@FindBy(name="password")WebElement password;
	@FindBy(xpath="//*[@type='submit']") WebElement btn_submit;
	
	public void setEmail(String Email)
	{
		email.sendKeys(Email);
	}
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void submit()
	{
		btn_submit.click();
	}

}
