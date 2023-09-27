package com.IB.genericUtils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImpleClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		//actual test scripts execution starts from here
		
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName+"---> Execution starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"---passed");
		Reporter.log(MethodName+"---> TestScript Executed successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		try {
			String FailedScript = WebDriverUtility_Test.takesScreenShot(BaseClass.sdriver,MethodName);
			test.addScreenCaptureFromPath(FailedScript);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, MethodName+"--- Failed");
		Reporter.log(MethodName+"----> Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, MethodName+"--- Skipped");
		Reporter.log(MethodName+"----> Skipped");
	}

	@Override
	public void onStart(ITestContext context) 
	{
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./Extentreport/report.html");
		
		htmlReport.config().setDocumentTitle("SDET-51");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Food_Ordering");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("OS", "windows-11");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-Url", "http\\://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");
		report.setSystemInfo("Reporter_Name", "Monisha");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
