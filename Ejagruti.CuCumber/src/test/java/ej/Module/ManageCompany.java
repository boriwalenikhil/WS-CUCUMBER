package ej.Module;

import java.sql.Driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import ej.ExtentReports.HTMLReportGenerator;

public class ManageCompany {
	// he line add kraychi logger4g maven chi
	final static Logger logger = Logger.getLogger(ManageCompany.class);
	static WebElement element;

	
	   @When ("^I click on manage company$") 

	public void ClickOnLink_ManageCompany() throws InterruptedException {
		try {
			System.out.println(" click method enter ");
			System.out.println(Login.driver);

			// Thread.sleep(5000);

			WebElement link_manageCompany = Login.driver.findElement(By.xpath("//a[@title='Manage Company']"));
			System.out.println(link_manageCompany);

			link_manageCompany.click();
			
			String message = "Status:PASS,Step Number:"+Config.counter+++",Step:I click on manage company"+"Exception:NA";

			logger.info(message);

			HTMLReportGenerator.StepDetails("Pass","User Click on Manage Company" , "Exception:NA", Config.TakeScreenShot("/Users/ameyaallampallewar/Documents/AutomationProject/Cucumberlog4goutput/ClickonManagecompany.png", Login.driver, System.currentTimeMillis()));
			
			
		} catch (Exception ex) {

			String message = "Status:FAIL,Step Number:"+Config.counter+++",Step:I click on manage company"+"Exception:"+ ex.getMessage();

			logger.error(message);

		}

	}

	   @And("^I click on New button$") 

	public void ClickOnNewbtn() throws InterruptedException {
		try {
			Login.driver.switchTo().frame("actionid");
			Thread.sleep(2000);
			WebElement btnNew = Login.driver.findElement(By.xpath("//span[@class='l-btn-text'][contains(.,'New')]"));
			btnNew.click();
			String message = "Status:PASS,Step Number:"+Config.counter+++",Step:I click on New button"+"Exception:NA";
			logger.info(message);

		} catch (Exception ex) {

			String message = "Status:FAIL,Step Number:"+Config.counter+++",Step:I click on new button as exception"+"Exception:"+ex.getMessage();
			logger.error(message);

		}

	}

	@When("^i enter company name as \"(.*)\"$")

	public void companyname(String cmpname) 
	{
		try 
		{
			element = Login.driver.findElement(By.xpath("//input[@name='name']"));
			element.sendKeys(cmpname);
			// LogerPrint krnya sathi folder madhe Log4g apn use krto..

			String message = "Status:PASS,Step Number:"+Config.counter+++",Step:I enter company name as " + cmpname + "exception:NA";
			logger.info(message);
		} 
		catch (Exception ex)
		{
			String message = "Status:FAIL,Step Number:"+Config.counter+++",Step:I enter company name as " + cmpname + "exception:"+ ex.getMessage();
			logger.error(message);
		}

	}

	@And("^i select company type as \"(.*)\"$")

	public void companytype(String cmptype) 
	{
		try
		{
			element = Login.driver.findElement(By.xpath("//select[contains(@id,'companytype')]"));
			Select s = new Select(element);
			s.selectByVisibleText(cmptype);
			String message = "Status:PASS,Step Number:"+Config.counter+++",Step:i select company type as" + cmptype + "exception:NA";
			
			logger.info(message);

		}
		catch (Exception ex) 
		{
			String message = "Status:FAIL,Step Number:"+Config.counter+++",Step:i select company type as " + cmptype + "exception:"+ ex.getMessage();
			logger.error(message);
		}
	}

	@And("^i select company subtype as \"(.*)\"$")

	public void companysubtype(String cmpsubtype) 
	{
		try 
		{
			element = Login.driver.findElement(By.xpath("//select[contains(@name,'subtype')]"));

			Select s1 = new Select(element);
			s1.selectByVisibleText(cmpsubtype);

			String message = "Status:pass,Step:i select company subtype as" + cmpsubtype + "exception:na";
			logger.info(message);

		}
		catch (Exception ex)
		{
			String message = "Status:pass,Step:i select company subtype as" + cmpsubtype + "exception:"
					+ ex.getMessage();
			logger.error(message);
		}
	}

	@And("^i select company address as \"(.*)\"$")

	public void companyaddress(String cmpaddress) {
		try {
			element = Login.driver
					.findElement(By.xpath("//textarea[contains(@class,'textbox-text validatebox-text')]"));
			element.sendKeys(cmpaddress);

			String message = "Status:pass,Step:i select company address as" + cmpaddress + "exception:na";
			logger.info(message);

		} catch (Exception ex) {
			String message = "Status:pass,Step:i select company subtype as" + cmpaddress + "exception:"
					+ ex.getMessage();
			logger.error(message);

		}
	}

	@And("^i select company phone as \"(.*)\"$")

	public void companyphone(String cmpphone) {

		try {
			element = Login.driver.findElement(By.xpath("(//input[contains(@autocomplete,'off')])[1]"));
			element.sendKeys(cmpphone);
			String message = "Status:pass,Step:i select company phone as" + cmpphone + "exception:na";
			logger.info(message);

		} catch (Exception ex) {
			String message = "Status:pass,Step:i select company subtype as" + cmpphone + "exception:" + ex.getMessage();
			logger.error(message);

		}

	}

	@And("^i select company Email  as \"(.*)\"$")

	public void companyemail(String cmpemail) {

		try {
			element = Login.driver.findElement(By.xpath("//input[@name='email']"));
			element.sendKeys(cmpemail);
			String message = "Status:pass,Step:i select company Email  as" + cmpemail + "exception:na";
			logger.info(message);

		}

		catch (Exception ex) {
			String message = "Status:pass,Step:i select company subtype as" + cmpemail + "exception:" + ex.getMessage();
			logger.error(message);

		}
	}

	@And("^i select company pan details as \"(.*)\"$")

	public void companypandetail(String cmppandetail) {
		try {
			element = Login.driver.findElement(By.xpath("//input[@name='pan']"));
			element.sendKeys(cmppandetail);
			String message = "Status:pass,Step:i select company pan details as" + cmppandetail + "exception:na";
			logger.info(message);

		} catch (Exception ex) {
			String message = "Status:pass,Step:i select company subtype as" + cmppandetail + "exception:"
					+ ex.getMessage();
			logger.error(message);

		}
	}

	@And("^i select company Tin details as \"(.*)\"$")

	public void companyTin(String cmpTin) {
		try {
			element = Login.driver.findElement(By.xpath("//input[@name='tin']"));
			element.sendKeys(cmpTin);
			String message = "Status:pass,Step:i select company Tin details as" + cmpTin + "exception:na";
			logger.info(message);

		} catch (Exception ex) {

			String message = "Status:pass,Step:i select company subtype as" + cmpTin + "exception:" + ex.getMessage();
			logger.error(message);

		}

	}

	@And("^i select company mobile as \"(.*)\"$")

	public void companymobile(String cmpmobile) {
		try {
			element = Login.driver
					.findElement(By.xpath("(//input[contains(@class,'textbox-text validatebox-text')])[2]"));
			element.sendKeys(cmpmobile);
			String message = "Status:pass,Step:i select company mobile as" + cmpmobile + "exception:na";
			logger.info(message);

		} catch (Exception ex) {
			String message = "Status:pass,Step:i select company mobile as" + cmpmobile + "exception:" + ex.getMessage();
			logger.error(message);

		}

	}

	@And("^i select company country as \"(.*)\"$")

	public void companycouyntry(String CmpCountry) {

		try {
			element = Login.driver.findElement(By.xpath("//select[contains(@name,'countryname')]"));
			Select s3 = new Select(element);
			s3.selectByIndex(1);
			// s3.selectByVisibleText(CmpCountry);

			String message = "Status:pass,Step:i select company country as" + CmpCountry + "exception:na";
			logger.info(message);

		} catch (Exception ex) {
			String message = "Status:pass,Step:i select company country as" + CmpCountry + "exception:"
					+ ex.getMessage();
			logger.error(message);

		}
	}

	@And("^i select company state as \"(.*)\"$")
	public void companystate(String cmpestate) {
		try {
			element = Login.driver.findElement(By.xpath("//select[@name='state']"));
			Select s4 = new Select(element);

			s4.selectByVisibleText(cmpestate);
			String message = "Status:pass,Step:i select company state as" + cmpestate + "exception:na";
			logger.info(message);

		} catch (Exception ex) {
			String message = "Status:pass,Step:i select company state as" + cmpestate + "exception:" + ex.getMessage();
			logger.error(message);

		}

	}

	@And("^i select company city as \"(.*)\"$")

	public void companycity(String cmpcity) {

		try {
			element = Login.driver.findElement(By.xpath("//select[@id='citylist']"));
			Select s5 = new Select(element);
			s5.selectByVisibleText(cmpcity);
			String message = "Status:pass,Step:i select company city as" + cmpcity + "exception:na";
			logger.info(message);

		} catch (Exception ex) {
			String message = "Status:pass,Step:i select company city as" + cmpcity + "exception:" + ex.getMessage();

			logger.error(message);

		}

	}

	@And("^i select company website as \"(.*)\"$")

	public void companywebsite(String cmpwebsite) {
		try {
			element = Login.driver.findElement(By.xpath("//input[@name='website']"));
			element.sendKeys(cmpwebsite);
			String message = "Status:pass,Step:i select company website as" + cmpwebsite + "exception:na";
			logger.info(message);

		} catch (Exception ex) {
			String message = "Status:pass,Step:i select company website as" + cmpwebsite + "exception:"
					+ ex.getMessage();
			logger.error(message);

		}
	}

	@And("^i select company total employee as \"(.*)\"$")

	public void companytotalemp(String cmptotalem) {
		try {
			element = Login.driver.findElement(By.xpath(
					"(//input[contains(@style,'margin-left: 0px; margin-right: 0px; padding-top: 2px; padding-bottom: 2px; width: 240px; ime-mode: disabled;')])[3]"));
			element.sendKeys(cmptotalem);
			String message = "Status:pass,Step:i select company total employee as" + cmptotalem + "exception:na";
			logger.info(message);

		} catch (Exception ex) {
			String message = "Status:pass,Step:i select company website as" + cmptotalem + "exception:"
					+ ex.getMessage();
			logger.error(message);

		}

	}

	@And("^i click on Save button$")

	public void clickSavebtnAction() throws InterruptedException {
		try 
		{
			WebElement click = Login.driver
					.findElement(By.xpath("//span[@class='l-btn-left l-btn-icon-left'][contains(.,'Save')]"));
			
			Thread.sleep(5000);
			click.click();
		} 
		
		catch (Exception ex)
		{
			String message = "Status:pass,Step:i click on Save button exception:" + ex.getMessage();
			logger.error(message);
		}
	}

	public void clickCancelbtnAction(String xpath) throws InterruptedException 
	{
		try 
		{
			WebElement click = Login.driver.findElement(By.xpath("//span[@class='l-btn-text'][contains(.,'Cancel')]"));
			Thread.sleep(5000);
			click.click();
		} 
		
		catch (Exception ex) 
		{
			String message = "Status:pass,Step:i click on Save button exception:" + ex.getMessage();
			logger.error(message);
		}
	}

	// Scenario: Create Company with blank inputs

	/*
	 * When i enter company name as nothing And i select company type as nothing And
	 * i select company subtype as nothing And i select company address as nothing
	 * And i select company phone as nothing And i select company Email as nothing
	 * And i select company pan details as nothing And i select company Tin details
	 * as nothing And i select company mobile as nothing And i select company state
	 * as nothing And i select company city as nothing And i select company website
	 * as nothing And i select company total employee as nothing
	 * 
	 * And i click on Save button Then I should see Please enter all filed data.
	 * 
	 */

	public void clickSavebtnActionwithblankinputs() throws InterruptedException {

		WebElement click = Login.driver
				.findElement(By.xpath("//span[@class='l-btn-left l-btn-icon-left'][contains(.,'Save')]"));
		Thread.sleep(10000);
		click.click();

	}
	@Before
    public void beforeScenario(Scenario scenario){
        System.out.println("************This will run before the Scenario****************");
        System.out.println("Starting - " + scenario.getName());
        
    }	
	@After
    public void afterScenario(){
        System.out.println("*********This will run after the Scenario*********");
    }
	public static void main(String[] args) throws Exception {

	/*	Login lg = new Login();
		Thread.sleep(5000);

		lg.OpenBrowser("firefox");
		lg.Enterbaseurl("http://192.168.0.222:90/finsys/login.html#");
		lg.Enterusernametext("dummyfm");
		lg.Enterpasswordtext("passw0rd");
		lg.ClickOnLoginButton();
		// lg.homepage("http://192.168.0.222:90/finsys/index.php");
		// Thread.sleep(5000);

		ManageCompany Mc = new ManageCompany();
		Mc.ClickOnLink_ManageCompany();
		Mc.ClickOnNewbtn();
		Thread.sleep(1000);

		Mc.companyname("Dhanucompany");
		Mc.companytype("IT");
		Thread.sleep(2000);

		Mc.companysubtype("Support");
		Mc.companyaddress("Shree Nagar");
		Thread.sleep(1000);

		Mc.companyphone("8275284217");
		Thread.sleep(500);

		Mc.companyemail("boriwale.n@gmail.com");
		Mc.companypandetail("APCPB121212");
		Mc.companyTin("1234567890");
		Thread.sleep(1000);

		Mc.companymobile("8275284217");
		Mc.companycouyntry("INDIA");
		Mc.companystate("MAHARASHTRA");
		Thread.sleep(1000);

		Mc.companycity("NANDED");
		Thread.sleep(1000);

		Mc.companywebsite("www.mobiextend.com");
		Thread.sleep(1000);

		Mc.companytotalemp("20");
		Mc.clickSavebtnAction();
*/
	}

}
