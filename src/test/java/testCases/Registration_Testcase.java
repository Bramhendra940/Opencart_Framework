package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomaPage;
import pageObjects.RegisterPage;
//import testBase.BaseClass;

public class Registration_Testcase extends BaseClass {
	
	
	@Test(groups={"Regression","Master"})
	public void RegiStration()
	{
		
		logger.info("**Registration_Testcase started ****");
		try
		{
		HomaPage hp=new HomaPage(driver);
		logger.info("click on Homepage link");
		hp.Home();
		logger.info("click on Registration link");
		hp.Register();
		logger.info("***entering the deatils in registartion page");
		RegisterPage rp=new RegisterPage(driver);
		logger.info("***enter first name***");
		rp.setFirstName(randomString().toUpperCase());
		logger.info("***enter last name***");
		rp.setLastname(randomString().toUpperCase());
		logger.info("***enter email***");
		rp.setEmail(randomString()+"@gmail.com");
		rp.setTelephone(randomNumber());
		logger.info("***enter telephone number***");
		String pass=randomAlphaneumaric();
		logger.info("***enter password***");
		rp.setPassword(pass);
		logger.info("***enter confirm password***");
		rp.setConfirmPass(pass);
		rp.agreeCheck();
		logger.info("***click on continue button***");
		rp.continue_button();
		logger.info("***very the message using asserts***");
		String msg=rp.getConfirmationmsg();
		if(msg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			
			logger.error("**test failed**");
			logger.debug("debugging logs");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(msg,"Your Account Has Been Created");
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		logger.info("***Registration_Testcase finished***");
	}
	
	
	

}
