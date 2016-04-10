package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import dataprovider.RunFrameworkConfigReader;
import pages.Bookingticket;
import pages.Loginpage;

public class TestBookingTicket {
	WebDriver driver;
	Bookingticket BT;
	Loginpage Log_int;
	RunFrameworkConfigReader readprop=new RunFrameworkConfigReader();
  @Test
  public void bookingTickettest() throws InterruptedException {
	
	  Log_int.login("pRASHANt","pei877");
	  System.out.println(driver.getTitle());
	  
	  BT.enterfromstation("JHANSI JN - JHS");
	  BT.enterTostation("H NIZAMUDDIN - NZM");
	
	  BT.enterDate();
	  BT.clickSubmit();
	  BT.clickClass();
	  BT.clickbooknow();
	  BT.passsengerDetails();
  }
  @Test(dependsOnMethods = { "bookingTickettest" })
  
  public void payementtest() {
      
	  BT.payment();
	  System.out.println("payment made");

  }
  @BeforeTest
  public void beforeTest() throws IOException {
	  readprop.RunFrameworkConfigReadermethod();
	  driver=readprop.getBrowser();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  Log_int=new Loginpage(driver);
	  BT=new Bookingticket(driver);
  }
  
}
