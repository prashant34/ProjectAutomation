package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import pages.Loginpage;
import utilities.ReadExcelFile;

public class TestLoginPage {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void loginTest(String uname, String pass) throws InterruptedException {
	/*  Loginpage Log_in=PageFactory.initElements(driver, Loginpage.class);*/
	  Loginpage Log_in=new Loginpage(driver);
	  
	  Log_in.login(uname,pass);
	  System.out.println(driver.getTitle());
	  
  }

  @DataProvider(name="dp")
  public Object[][] dp() {

	  /* return new Object[][] {
       { "pRASHANt1", "pei8771" },
       { "b", "b" },

    };*/
 ReadExcelFile rd=new ReadExcelFile("D:\\SELENIUMproject\\Git\\ProjectAutomation\\ProjectAutomation\\TestData\\TestData.xlsx");
 int rowno=rd.getRowcount(0);
    Object[][] data=new Object[rowno][2];
    for(int i=0;i<rowno;i++)
    {
    	data[i][0]=rd.getdata(0, i, 0);
    	data[i][1]=rd.getdata(0, i, 1);

   
    }
    
	return data;
    
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("https://www.irctc.co.in");
	  
  }

  @AfterTest
  public void tearDown() {
	  driver.quit();
  }

}
