package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClassA;
import pageObjects.LoginPageA;

public class loginTest extends BaseClassA{
	public loginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
    @Test(dataProvider="getData")
	public void doLogin(String name, String password) {
     driver.get(config.getProperty("url"));
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     
     LoginPageA login =new LoginPageA(driver);
     login.enterUserName(name);
     login.enterUserPassword(password);
     login.clickOnLoginButton();
     
     Assert.assertEquals(isElementPresent(), true);
	
	
	}
    @DataProvider
    public Object[][] getData() throws IOException{
    	FileInputStream  f=new FileInputStream("C:\\Users\\sital\\eclipse-workspace\\Practice1\\src\\main\\java\\resources\\testData.xlsx");
    	XSSFWorkbook wb=new XSSFWorkbook(f);
    	XSSFSheet sheet=wb.getSheetAt(0);
    	XSSFRow row=sheet.getRow(0);
    	XSSFCell cell;
    	int rows=sheet.getPhysicalNumberOfRows();
    	int cols=row.getLastCellNum();
    	Object[][] data=new Object[rows-1][cols];
    	for(int i=0; i<rows-1;i++) {
    		
    		row=sheet.getRow(i+1);
    		for(int j=0; j<cols;j++) {
    			cell=row.getCell(j);
    			data[i][j]=cell.getStringCellValue();
    		}
    	}
    	return data;
    }

}
