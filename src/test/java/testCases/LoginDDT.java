package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomaPage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import utilities.DataProviders;

public class LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email,String pwd,String exp)
	{
		logger.info("***login started ***");
		try
		{
			
		HomaPage hp=new HomaPage(driver);
		
		hp.Home();
		hp.Login();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.submit();
		MyAccount myac=new MyAccount(driver);
		boolean target=myac.is_MyAccount_Exists();
		//Assert.assertTrue(target);
		
		if(exp.equalsIgnoreCase("Valid"))
		{
		    if(target==true)
		    {
		        Assert.assertTrue(true);
		        myac.logout();
		    }
		    else
		    {
		        Assert.assertTrue(false);
		    }
		}
		else if(exp.equalsIgnoreCase("Invalid"))
		{
		    if(target==true)
		    {
		        myac.logout();
		        Assert.assertTrue(false);
		    }
		    else
		    {
		        Assert.assertTrue(true);
		    }
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***login finished ***");
	}

}
