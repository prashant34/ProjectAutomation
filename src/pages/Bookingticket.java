package pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;;

public class Bookingticket {
	WebDriver driver;
	public Bookingticket(WebDriver driver)
	{
		this.driver=driver;
	}
	By fromstation=By.id("jpform:fromStation");
	By tostation=By.id("jpform:toStation");
	By tost= By.xpath(".//li[@class='ui-menu-item']/a");
	/*By dateclick=By.xpath("/html/body/div[3]/div[1]/div[4]/div/div[3]/div/form/table/tbody/tr[5]/td[2]/img");
	By actualdate=By.xpath("/html/body/div[5]/div[1]/table/tbody/tr[3]/td[7]/a");*/
	By date=By.id("jpform:journeyDateInputDate");
	By cal=By.xpath(".//*[@id='jpform']/following::input[@id='qbform:qbJrnyDateInputDate']/following::img[@class='ui-datepicker-trigger']");
	By submit=By.id("jpform:jpsubmit");
	By sleeper= By.id("cllink-12621-SL-3");
	By booknow=By.id("12621-SL-GN-5");
	By bn=By.xpath(".//*[@id='j_idt344_body']/table/tbody/tr[1]/td[2]/following::table[2]/following::tr[2]/td/a");
	By passname=By.xpath(".//input[@class='input-style1 psgn-name'][contains(@id,'addPassengerForm:psdetail:0')]");
	By age=By.id("addPassengerForm:psdetail:0:psgnAge");
	By gender=By.id("addPassengerForm:psdetail:0:psgnGender");
	By berthchoice=By.id("addPassengerForm:psdetail:0:berthChoice");
	By seniorcitizen =By.id("addPassengerForm:psdetail:0:concessionOpt");
	By nationality= By.id("addPassengerForm:psdetail:0:nationality");
	By send =By.id("validate");
	
	By debitcard=By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/form/table/tbody/tr[6]/td/div/div/table[1]/tbody/tr/td/div/div[2]/table/tbody/tr/td[1]/table/tbody/tr[3]/td");
	By axis =By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/form/table/tbody/tr[6]/td/div/div/table[1]/tbody/tr/td/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[4]/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input");
	By makepay =By.id("validate");
	
	public void enterfromstation(String Fstation)
	{
		driver.findElement(fromstation).sendKeys(Fstation);
	}
	
	public void enterTostation(String Tostation)
	{
		driver.findElement(tostation).sendKeys(Tostation);
		List<WebElement> st= driver.findElements(tost);
		for(WebElement web:st)
		{
			if(web.getText().equals("H NIZAMUDDIN - NZM"))
			{
				web.click();
				return;
			}
		}
	}
	
	/*public void clickCalender()
	{
		WebElement element = driver.findElement(dateclick);
		Actions actions = new Actions(driver);

		actions.moveToElement(element).click().perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement w=wait.until(ExpectedConditions.elementToBeClickable(dateclick));
		w.click();
		
	}
	public void clickdate()
	{
		driver.findElement(cal).click();
	
	}*/
	public void enterDate() throws InterruptedException
	{
		driver.findElement(date).sendKeys("15-4-2016");
		/*System.out.println("testing");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement wD=driver.findElement(cal);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cal));
		String it= wD.getAttribute("class");
		
		System.out.println(it);
		wD.click();
		System.out.println("testing11");*/
	
	}
	public void clickSubmit()
	{
		driver.findElement(submit).click();
	
	}

	public void clickClass()
	{
		driver.findElement(sleeper).click();
	
	}
	public void clickbooknow()
	{
		List<WebElement> element=driver.findElements(bn);
		for (WebElement webElement : element) {
			String i=webElement.getAttribute("href");
            System.out.println(i);
            if(i.contains("25-3-2016"))
            {
            	webElement.click();
            	return;
            }
            
 
        }
		
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement w=wait.until(ExpectedConditions.visibilityOfElementLocated(bn));
		Boolean b = w.isEnabled();
		System.out.print(b);
		w.click();*/
		
	
	}
	public void passsengerDetails() throws InterruptedException
	{
		driver.findElement(passname).sendKeys("prashant");
		driver.findElement(age).sendKeys("70");
		WebElement element = driver.findElement(gender);
		Select oSelect = new Select(element);
		oSelect.selectByVisibleText("Male");
		
		WebElement element1 = driver.findElement(berthchoice);
		Select oSelect1 = new Select(element1);
		oSelect1.selectByVisibleText("MIDDLE");
        WebElement chkbox = driver.findElement(seniorcitizen);
        chkbox.click();
        WebElement element3 = driver.findElement(nationality);
		Select oSelect2 = new Select(element3);
		oSelect2.selectByVisibleText("India");
		Thread.sleep(15000);
        driver.findElement(send).click();
        System.out.println("clicked next");
        Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		System.out.println("Alert text is " + alertText);
		simpleAlert.accept();
	}
	
	public void payment()
	{
		driver.findElement(debitcard).click();
		WebElement rb = driver.findElement(axis);
        rb.click();
        driver.findElement(makepay).click();
	}

}

