package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClassA;

public class Utils {
	public static WebDriver driver;
	public Utils(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isElementPresent() {
		
		try {
			driver.findElement(By.cssSelector("input[id='login']"));
			return true;
		}catch(Throwable t) {
			return false;
		}
	}

}
