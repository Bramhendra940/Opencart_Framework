package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
	WebDriver driver;

	public  RegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(name="firstname")WebElement FirstName;
	@FindBy(name="lastname")WebElement LastName;
	@FindBy(name="email")WebElement email;
	@FindBy(name="telephone")WebElement Telephone;
	@FindBy(id="input-password") WebElement password;
	@FindBy(id="input-confirm")WebElement conf_password;
	@FindBy(name="agree") WebElement chckbox;
	@FindBy(xpath="//*[@value='Continue']")WebElement conti;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")WebElement msgConfirmation;
	
	public void setFirstName(String fname) {
		FirstName.sendKeys(fname);
		
	}
	public void setLastname(String lname)
	{
		LastName.sendKeys(lname);
	}
	public void setEmail(String eml)
	{
		email.sendKeys(eml);
	}
	public void setTelephone(String tel)
	{
		Telephone.sendKeys(tel);
	}
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void setConfirmPass(String con_pwd)
	{
		conf_password.sendKeys(con_pwd);
	}
	public void agreeCheck()
	{
		chckbox.click();
	}
	public void continue_button()
	{
		conti.click();
	}
	public String getConfirmationmsg()
	{
		try
		{
			return(msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}
