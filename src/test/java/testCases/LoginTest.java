package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomaPage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;

public class LoginTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void verify_Login() throws InterruptedException
	{
		logger.info("***login started ***");
		try
		{
			
		HomaPage hp=new HomaPage(driver);
		
		hp.Home();
		hp.Login();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.submit();
		MyAccount myac=new MyAccount(driver);
		boolean target=myac.is_MyAccount_Exists();
		Assert.assertTrue(target);
	
		
		
	}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***Login Finished***");

}
}