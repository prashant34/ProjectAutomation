package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Loginpage {
	
	
	WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	/*@FindBy(id="usernameId")
	WebElement username;
	
	@FindBy(how=How.CLASS_NAME,using= "loginPassword") 
	WebElement password;
	
	@FindBy(id="loginbutton")
	WebElement submit;
	
	@FindBy(how=How.CLASS_NAME,using= "loginCaptcha")
	WebElement captcha;*/
	By username=By.id("usernameId");
	By password=By.className("loginPassword");
	By submit=By.id("loginbutton");
	
/*	public void userid(String uid)
	{
		driver.findElement(username).sendKeys(uid);
	}
	public void userid(String uid)
	{
		driver.findElement(password).sendKeys(uid);
	}*/
	public void login(String uid,String pas) throws InterruptedException
	{
		driver.findElement(username).sendKeys(uid);
		driver.findElement(password).sendKeys(pas);
		Thread.sleep(10000);
		driver.findElement(submit).click();
	}

}
