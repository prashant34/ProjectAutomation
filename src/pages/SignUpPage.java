package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
	
	WebDriver driver;
	public SignUpPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By message=By.xpath(".//*[@id='userRegistrationForm:useravail']");
	By signup= By.xpath(".//a[text()='Sign up']");
	By username= By.xpath(".//input[@name='userRegistrationForm:userName']");
	By chkavail=By.xpath(".//a[@id='userRegistrationForm:checkavail']");
	By secquest=By.xpath(".//select[@name='userRegistrationForm:securityQ']");
	By ans=By.xpath(".//input[@name='userRegistrationForm:securityAnswer']");
	By firstname=By.xpath(".//input[@name='userRegistrationForm:firstName']");
	By lastName=By.xpath(" .//input[@name='userRegistrationForm:lastName']");
	By gender=By.xpath(".//input[@id='userRegistrationForm:gender:0']");
	By maritalStatus=By.xpath(".//*[@id='userRegistrationForm:maritalStatus:0']");
	By day=By.xpath(".//select[@name='userRegistrationForm:dobDay']");
	By month=By.xpath(".//select[@name='userRegistrationForm:dobMonth']");
	By year=By.xpath(".//select[@name='userRegistrationForm:dateOfBirth']");
	By occup=By.xpath(" .//select[@name='userRegistrationForm:occupation']");
	By adharcard=By.xpath(".//*[@id='userRegistrationForm:uidno']");
	By email=By.xpath(".//input[@name='userRegistrationForm:email']");
	By mobile=By.xpath(".//input[@name='userRegistrationForm:mobile']");
	By nation= By.xpath(".//select[@name='userRegistrationForm:nationalityId']");
	By addLine1=By.xpath(".//input[@id='userRegistrationForm:address']");
	By postoffice=By.xpath(".//*[@id='userRegistrationForm:postofficeName']");
	By country=By.xpath(".//select[@name='userRegistrationForm:countries']");
	By city=By.xpath(".//select[@name='userRegistrationForm:cityName']");
	By pincode=By.xpath(".//*[@id='userRegistrationForm:pincode']");
	By text=By.xpath(".//*[@id='userRegistrationForm:j_idt152_body']/table/tbody/tr[3]/td/table/tbody/tr[15]/td[1]/label");
	By state=By.xpath(".//*[@id='userRegistrationForm:statesName']");
	By phone=By.xpath(".//input[@name='userRegistrationForm:landline']");
	By copyres=By.xpath(".//input[@id='userRegistrationForm:resAndOff:0']");
	By newsRadio=By.xpath(".//input[@name='userRegistrationForm:newsletter'][@value='Y']");
	By speRadio=By.xpath(".//*[@name='userRegistrationForm:commercialpromo'][@value='N']");
	By submit=By.xpath(".//a[@id='userRegistrationForm:j_idt486']");
	By pass=By.xpath(".//input[@id='userRegistrationForm:password']");
	By Cpass=By.xpath(".//input[@id='userRegistrationForm:confpasword']");
	
public void selectdropdown(By locator,String value)
{
	WebElement element1 = driver.findElement(locator);
	Select oSelect1 = new Select(element1);
	oSelect1.selectByVisibleText(value);
}
public void clickRadioButton(By locator1)
{
	WebElement rd = driver.findElement(locator1);
    rd.click();
}
public void enterusername(String uname)
{
	driver.findElement(username).sendKeys(uname);
}
public void checkAvailability()
{
	driver.findElement(chkavail).click();
}

public String validationmessage(By loc) throws InterruptedException
{
	System.out.println("123test123");
	Thread.sleep(10000);
	String mes=driver.findElement(loc).getText();
	System.out.println("test123");
	return mes;
}

public void enterSignUpDetails() throws InterruptedException
{
	driver.findElement(pass).sendKeys("Prashant123");
	driver.findElement(Cpass).sendKeys("Prashant123");
	selectdropdown(secquest,"Who was your Childhood hero?");
	driver.findElement(ans).sendKeys("superman");
	driver.findElement(firstname).sendKeys("Pavnish");
	driver.findElement(lastName).sendKeys("rajpoot");
	clickRadioButton(gender);
	clickRadioButton(maritalStatus);
	selectdropdown(day,"05");
	selectdropdown(month,"DEC");
	selectdropdown(year,"1994");
	selectdropdown(occup,"Others");
	driver.findElement(adharcard).sendKeys("1234566");
	driver.findElement(email).sendKeys("prashantengg007@gmail.com");
	driver.findElement(mobile).sendKeys("1853622350");
	selectdropdown(nation,"India");
	driver.findElement(addLine1).sendKeys("Noida");
	selectdropdown(country,"India");
	driver.findElement(pincode).sendKeys("201301");
	driver.findElement(text).click();
	String st=driver.findElement(state).getText();
	System.out.println(st);
	selectdropdown(city,"Ghaziabad");
	selectdropdown(postoffice,"Noida Sector 27 S.O");
	driver.findElement(phone).sendKeys("2581473");
	clickRadioButton(copyres);
	clickRadioButton(newsRadio);
	clickRadioButton(speRadio);
	Thread.sleep(10000);
	driver.findElement(submit).click();
}
}