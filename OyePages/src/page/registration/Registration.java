package page.registration;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xerces.util.URI.MalformedURIException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class Registration {
	
	WebDriver driver;
	String baseURL, nodeURL;
	
 @BeforeClass (enabled=true)
 public void normalTest() throws MalformedURLException, Exception {
	  
	 driver = new FirefoxDriver();
	 driver.get("http://www.oyepages.com/user/auth");
	 driver.manage().window().maximize();
}
 
 
 /*@BeforeClass(enabled=true)
 public void seleniumGridTest() throws MalformedURLException, Exception {
	  System.out.println("Selenium Grid Testing Started.....");
	  System.out.println();
	  
	 //Setting the type of OS and Browser we need for script execution
	 DesiredCapabilities capability =  DesiredCapabilities.firefox();
	// capability.setBrowserName("firefox");
	// capability.setPlatform(Platform.WINDOWS);
	 
	 //Set the node machine where our test will run means where the browser will open to test the application
	 driver = new RemoteWebDriver(new URL("http://172.25.33.103:5566/wd/hub"), capability);
	 Thread.sleep(500);
	 
	 driver.get("http://www.oyepages.com/user/auth");
	 driver.manage().window().maximize();
	 
}*/
	
 
 @Test(priority = 1, enabled=true)
 public void titleTest() {
	  
	  String title = driver.getTitle();
	 // Assert.assertEquals(title.contains("OyePages"), true, "Not navigate properly");
 }
 
  @Test(priority = 2, enabled=true)
  public void refreshTest() throws Exception {
	  
	  String title = driver.getTitle();
	//  driver.findElement(By.xpath(".//*[@id='yw2_button']")).click();
	 // driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/div[2]/form/div/div[2]/div[9]/div/a[1][@id='yw2_button']")).click();
	 // driver.findElement(By.xpath(".//*[@id='registration-form']/div/div[2]/div[10]/div/input")).click();
	  //driver.findElement(By.cssSelector("input[class='formWithValidateSubmit btn btn-info signup_button']")).click();;
	  
	  
	  String[] splStr = "Sumanta_Kumar_Behera_Kumar-Selenium-Automation".split("[_-]");
	  
	 String[] splStrOne = "Sumanta_Kumar_Behera_Kumar-Selenium-Automation".split("_", 2);
	  
	  for(int i=0; i<splStr.length; i++){
		  
		  System.out.println(splStr[i]);
	  }
	
	  
	  for(String eachString:splStrOne){
		  System.out.println(eachString);
	  }
	  
	  
	  String input = "Hi,X How-how are:any you?";
	  String[] parts = input.split("[\\W]");
	  for(String inputStr:parts){
		  System.out.println(inputStr);
	  }
	  
	//  Assert.assertEquals(title.contains("OyePages"), "OyePages", "Not navigate properly");
	  
  }
  
  
  

  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }

}
