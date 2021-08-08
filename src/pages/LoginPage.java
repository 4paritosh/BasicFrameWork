package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public void openbrowser() throws IOException {
		 FileInputStream fi = new FileInputStream("/Users/paritosh/Desktop/Testing/prop.properties");
			Properties f = new Properties();
			f.load(fi);

			String browser = f.getProperty("browser"); // we can read this name from external files like excel or property 
			
			System.out.println(browser);
	      
	      if(browser.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/paritosh/Desktop/Selenium jars/geckodriver");
			driver = new FirefoxDriver();
	      }else{
			System.setProperty("webdriver.chrome.driver", "/Users/paritosh/Desktop/Selenium jars/chromedriver");
			driver = new ChromeDriver();
	      }
	      
	  driver.manage().deleteAllCookies(); 

	 
	}
	
	public void openScotiaLoginPage() {
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=pZh3EeTLuOE&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJvYXV0aF9rZXkiOiJwWmgzRWVUTHVPRSIsImNvbnNlbnRfcmVxdWlyZWQiOmZhbHNlLCJyZWRpcmVjdF91cmkiOiJodHRwczpcL1wvd3d3LnNjb3RpYW9ubGluZS5zY290aWFiYW5rLmNvbVwvb25saW5lXC9sYW5kaW5nXC9vYXV0aGxhbmRpbmcuYm5zIiwiZXhwIjoxNjI0MjI5NTA0LCJpYXQiOjE2MjQyMjgzMDQsImp0aSI6IjBhOGEwNDRhLTYwZWUtNDliNC05OGE0LWJlMWI4YmM3MDY4ZCIsImNsaWVudF9pZCI6IjhlZTkwYzM5LTFjNTItNGZmNC04YWU2LWE3YjU0YzUzOTkzMyIsImNsaWVudF9tZXRhZGF0YSI6eyJDaGFubmVsSUQiOiJTT0wiLCJBcHBsaWNhdGlvbkNvZGUiOiJINyJ9LCJpc3N1ZXIiOiJodHRwczpcL1wvcGFzc3BvcnQuc2NvdGlhYmFuay5jb20ifQ.UVptBf1IbmRs9HOY-xOoJXpnP67xpJ2Bl1yBLQdxUU5e6wUCknTgK5eSu6Vsi0MnInBWu2eMSYTPEwpaYycQnIkAeo9g5lORa8mv61uhTzpLLnREItzvukaBDcVZk7pH-3KJ6R0cZnyEh2cb5LihiU7U1IXpkgYnEaM-9tVhr2io_omD323xZkvrQFqKkwE8bC82YLnuFQHsOR6-58dsb5430c3XDi03GXSAuLutCBU8hix2QM978A3ATMXJoCqxzXKEzkKwkVbCVO1NK4juJi7OAH-wYP1-bLC04JhoHl-8vvo2TSRVo4KJuyJoS08bs8eugO76QDWFDkfLzxc8Dw&preferred_environment=");
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void login(String email, String password) throws InterruptedException {
		 driver.findElement(By.id("usernameInput-input")).sendKeys(email); 		
			driver.findElement(By.name("password")).sendKeys(password); 	
			driver.findElement(By.id("signIn")).click(); 		
			Thread.sleep(3000);  
	 }
	 
	 public String readGlobalErr() {
		 String actualErr = driver.findElement(By.id("globalError")).getText(); 		
			
			return actualErr;
		 
	 }
	 
	 public String readErr() {
		 String actualErr = driver.findElement(By.className("Error__text")).getText(); 		
				
			return actualErr;
	 }
	 

	

}
