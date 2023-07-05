package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {
	public static WebDriver driver;
	public TakeScreenShot(WebDriver driver) throws IOException {
		this.driver=driver;
	//	takeScreenShot(driver);
	}

	public String takeScreenShot(WebDriver driver) throws IOException {
		//Date d=new Date(); d.toString().replace(" ", "_").replace(".", "_")+
		String path2=System.getProperty("user.dir")+"\\ScreenShots\\" + "scn" + ".png";
		//String scn = null;
		File srcF=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destF=new File(path2);
		FileUtils.copyFile(srcF,  destF);
		return path2;
	}

}
