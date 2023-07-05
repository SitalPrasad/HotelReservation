package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassA {
	public static WebDriver driver;
	public  Properties config;
	public FileInputStream fis;
	public Logger log;
	public BaseClassA() throws IOException {
		config=new Properties();
		File f=new File("C:\\Users\\sital\\eclipse-workspace\\Practice1\\src\\main\\java\\resources\\configA.properties");
		System.out.println("hi");
		fis=new FileInputStream(f);
		config.load(fis);
		
	}
	
	@BeforeTest
	public void setUp() {
		 log=Logger.getLogger("Hello"); PropertyConfigurator.configure("log4j.properties");
		if(config.getProperty("browser").equals("chrome")) {
			log.info("hhhhhhh");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(config.getProperty("browser").equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if(config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
	}//setUp
	public boolean isElementPresent() {
	try {
		driver.findElement(By.cssSelector(""));
		return true;
	}catch(Throwable t) {
		return false;
	}
	}//isE..
	
	public String takeScreenShot(WebDriver driver) throws IOException {
		String path="C:\\Users\\sital\\eclipse-workspace\\Practice1\\SCREENA\\"+"ss"+".png";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
