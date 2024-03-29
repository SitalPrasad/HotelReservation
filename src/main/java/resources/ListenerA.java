package resources;
import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseClassA;

public class ListenerA extends BaseClassA implements ITestListener {
public  ExtentReports extent=new ExtentReports();
public ExtentSparkReporter reporter=
new ExtentSparkReporter("C:\\Users\\sital\\eclipse-workspace\\Practice1\\EXTENTA\\"+"extent.html");
public ExtentTest test;
public String path;
	
 public  ListenerA() throws IOException {
		super();
		
	}

	
	public void onTestFailure(ITestResult result) { 
		
		try {
			path=takeScreenShot(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.attachReporter(reporter);
		test=extent.createTest(result.getName());
		test.fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		test.addScreenCaptureFromPath(path);
		extent.flush();
		
		
		
}

	
}