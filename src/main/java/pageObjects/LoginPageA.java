package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageA {
	public WebDriver driver;
	public LoginPageA(WebDriver driver) {
		this.driver=driver;
	}
	By userName=By.cssSelector("input[id='username']");
	By userPassword=By.cssSelector("input[id='password']");
	By loginButton=By.cssSelector("input[id='login']");
	
	public void enterUserName(String name) {
		driver.findElement(userName).sendKeys(name);
	}
public void enterUserPassword(String password) {
		driver.findElement(userPassword).sendKeys(password);
	}
public void clickOnLoginButton() {
	driver.findElement(loginButton).click();
	
}

}
