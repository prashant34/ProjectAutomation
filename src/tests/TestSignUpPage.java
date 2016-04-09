package tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import pages.SignUpPage;

public class TestSignUpPage {
	WebDriver driver;
	SignUpPage reg;
  @Test
  public void userNameAvailability() throws InterruptedException {
	  reg.enterusername("pavnish123");
	  reg.checkAvailability();
	  System.out.println("test123");
	  String message=reg.validationmessage(By.xpath(".//*[@id='userRegistrationForm:useravail']"));
	  System.out.println(message);
	  Assert.assertEquals("User Id is Available..Please go ahead with the Registration Process...", message);
  }
    
  @Test(dependsOnMethods = { "userNameAvailability" })
  public void testregistration() throws InterruptedException {
	  reg.enterSignUpDetails();
	  System.out.println("test complete");
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.irctc.co.in");
	  driver.findElement(By.xpath(".//a[text()='Sign up']")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  reg=new SignUpPage(driver);
  }

}
