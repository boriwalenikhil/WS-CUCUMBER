package ej.Module;

import java.io.IOException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import ej.ExtentReports.HTMLReportGenerator;

public class cucumberHookExtentreport {

	public boolean isFirstScenario = true;
	
	@Before
	
	public void beforeScenario(Scenario obj)throws IOException{
		HTMLReportGenerator.TestSuiteStart("/Users/ameyaallampallewar/Documents/AutomationProject/Cucumberlog4goutput/report.html","ExtentReport");

		System.out.println("This will run before scenario");
		
		
		HTMLReportGenerator.TestCaseStart(obj.getName(),obj.getId()+" "+obj.getStatus()+" "+obj.getSourceTagNames().toString());
		
		
		
	}
	
	@After
	public void afterScenario() throws IOException {
		

		System.out.println("This will run before scenario");
		Config.counter = 0;
		
        Config.TakeScreenShot("/Users/ameyaallampallewar/Documents/AutomationProject/Cucumberlog4goutput/Pass.png",Login.driver,
        		System.currentTimeMillis());
        HTMLReportGenerator.TestCaseEnd();
		HTMLReportGenerator.TestSuiteEnd();
	}
	
}
