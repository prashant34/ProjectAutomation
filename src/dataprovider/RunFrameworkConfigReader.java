package dataprovider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;




public class RunFrameworkConfigReader {
	
	Properties pfile=new Properties();
	
	WebDriver driver=null;
	public void RunFrameworkConfigReadermethod() throws IOException 
	{
		/*this.filename=Filepath;*/
		String filename="D:\\SELENIUMproject\\Git\\ProjectAutomation\\ProjectAutomation\\Framework.properties";
		FileReader Fr= new FileReader(filename);
		BufferedReader br= new BufferedReader(Fr);
		pfile.load(br);
		br.close();
	}
	public WebDriver getBrowser() {
		String browsername=pfile.getProperty("browsertype");
		System.out.println(browsername);
		System.out.println(pfile.getProperty("URL"));
		if(browsername.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();	 
		}
		/*else if (browsername.equalsIgnoreCase("ie")) { 
			System.setProperty("webdriver.ie.driver", prop.getProperty("iePath"));
			driver = new InternetExplorerDriver();
		} 

		else if (browsername.equalsIgnoreCase("Chrome")) { 	 
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));
			driver = new ChromeDriver();
		} */
		driver.manage().window().maximize();
		driver.get(pfile.getProperty("URL"));
 
 
		return driver;
		
	}
	public String testDatasheet() {
		String dataSheet=pfile.getProperty("testData");
		return dataSheet;
	}
}


