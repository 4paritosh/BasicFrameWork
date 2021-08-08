package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import data.df;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class loginTest {
	
	
	
	LoginPage lp = new LoginPage();
	df d = new df();
	SoftAssert softAssert = new SoftAssert();
	WebDriver driver;

	
  @Test
  public void loginWithWrongEmailAndPassword() throws IOException, InterruptedException {
	 
	  
	  	lp.login(d.WrongEmail, d.WrongPass);
		
	//	String expectedErr = "Please check your card number / username or password and try again.";
		String expectedErr2 = d.GlobalError;
		String actualErr = lp.readGlobalErr();
		System.out.println("Actual Error ="+actualErr);
		System.out.println("Expected Error ="+expectedErr2);
		
		
	//	softAssert.assertEquals(expectedErr,actualErr);
		softAssert.assertEquals(actualErr,expectedErr2);
		softAssert.assertAll();
		
		
  }
  
  @Test
  public void loginWithEmptyEmail() throws InterruptedException {
	  
	    lp.login("", d.WrongPass);

		String execptedErr = d.EmptyEmailErr;
		String actualErr = lp.readErr();
		System.out.println("Actual Error ="+actualErr);
		System.out.println("Expected Error ="+execptedErr);
		
		Assert.assertEquals(actualErr, execptedErr);
	    
  }

  @Test
  public void loginWithInvalidEmailAndPassword() throws IOException, InterruptedException {
		 
	        lp.login(d.EmailWithSpecialChar, d.WrongPass);
			String execptedErr = d.SpecialCharErr;
			String actualErr = lp.readErr();
			System.out.println("Actual Error ="+actualErr);
			System.out.println("Expected Error ="+execptedErr);
			
			Assert.assertEquals(actualErr, execptedErr);
	  
		
		
}
  
  @Test
  public void loginWithEmptyPassword() throws InterruptedException {
	    lp.login(d.WrongEmail, "");

		String execptedErr = d.EmptyPassErr;
		String actualErr = lp.readErr();
		System.out.println("Actual Error ="+actualErr);
		System.out.println("Expected Error ="+execptedErr);
		
		Assert.assertEquals(actualErr, execptedErr);
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  
	  lp.openbrowser();
	  lp.openScotiaLoginPage();
  }
  
  
  
  
  @AfterMethod
  public void afterMethod() {
	  
	  lp.closeBrowser();
  }
 
    
}
