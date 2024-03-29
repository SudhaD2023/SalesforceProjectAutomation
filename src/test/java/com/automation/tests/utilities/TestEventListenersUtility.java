package com.automation.tests.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.tests.base.BaseTest;

public class TestEventListenersUtility extends BaseTest implements ITestListener{
     public static ExtentReportsUtility extentUtilityObject;
	@Override
	public void onTestStart(ITestResult result) {
		extentUtilityObject.startSingleTestReport(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentUtilityObject.logTestPassed(result.getMethod().getMethodName()+" is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	    extentUtilityObject.logTestFailed(result.getMethod().getMethodName()+" is failed");
	    String filename=new SimpleDateFormat("yyyy_MM_dd_HH_mm_SS").format(new Date());
	    System.out.println("filename="+filename);
	    String path=constants.SCREENSHOTS_DIRECTORY_PATH+filename+".png";
	    takescreenshot(path);
	    extentUtilityObject.logTestWithScreenshot("./screenshots/"+filename+".png");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		extentUtilityObject=ExtentReportsUtility.getInstance();
		extentUtilityObject.startExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extentUtilityObject.endReport();
	}

}
