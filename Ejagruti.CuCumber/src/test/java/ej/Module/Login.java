package ej.Module;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.deps.com.thoughtworks.xstream.converters.ErrorReporter;
import ej.ExtentReports.HTMLReportGenerator;

public class Login {
	final static Logger logger = Logger.getLogger(ManageCompany.class);

	static WebElement element = null;
	public static WebDriver driver;

	@When("^user opens the \"(.*)\" browser$")

	public void OpenBrowser(String browsername) throws IOException, InterruptedException {
		try {

			// System.setProperty("webdriver.gecko.driver",
			// "/usr/local/Cellar/geckodriver/0.23.0/bin/geckodriver");
			System.setProperty("webdriver.chrome.driver",
					"/Users/ameyaallampallewar/Documents/AutomationProject/WS-CUCUMBER/Ejagruti.CuCumber/chromedriver");

			// driver = new FirefoxDriver();
			driver = new ChromeDriver();

			System.out.println(driver);

			String message = "Status:PASS,Step Number:" + Config.counter++ + ",Step:user opens the " + browsername
					+ "exception:NA";
			logger.info(message);
			Thread.sleep(10000);

			// ExtentReport method call to generate report With ScreenShot
			Thread.sleep(2000);
			HTMLReportGenerator.StepDetails("PASS", "user opens the" + browsername + "browser",
					"Browser name:" + browsername + ",exception:NA",
					Config.TakeScreenShot(
							"/Users/ameyaallampallewar/Documents/AutomationProject/Cucumberlog4goutput/OpenBrowser.png",
							driver, System.currentTimeMillis()));

		} catch (Exception ex) {

			String message = "Status:FAIL,Step Number:" + Config.counter++ + ",Step:user open the" + browsername
					+ "Exception:" + ex.getMessage();

			logger.error(message);
			Thread.sleep(10000);
			Thread.sleep(2000);

			HTMLReportGenerator.StepDetails("FAIL", "user opens the" + browsername + "browser",
					"Browser name:" + browsername + ",exception:" + ex.getMessage(),
					Config.TakeScreenShot(
							"/Users/ameyaallampallewar/Documents/AutomationProject/Cucumberlog4goutput/FailToOpenBrowser.png",
							driver, System.currentTimeMillis()));

		}

	}

	@And("^user enter the url \"(.*)\"$")
	public void Enterbaseurl(String baseurl) throws IOException {

		try {

			driver.get(baseurl);

			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

			String message = "Status:PASS,Step Number:" + Config.counter++ + ",Step:user enter the " + baseurl
					+ "exception:NA";

			logger.info(message);
			HTMLReportGenerator.StepDetails("PASS", "user enter the url" + baseurl + "url",
					"Url name:" + baseurl + ",exception:NA", "");

		} catch (Exception ex) {
			String message = "Status:FAIL,Step:user enter the url " + baseurl + "exception:" + ex.getMessage();
			logger.error(message);
			HTMLReportGenerator.StepDetails("FAIL", "user enter the url " + baseurl + "url",
					"Url name:" + baseurl + ",exception:" + ex.getMessage(),
					Config.TakeScreenShot(
							"/Users/ameyaallampallewar/Documents/AutomationProject/Cucumberlog4goutput/FailToenterbaseurl.png",
							driver, System.currentTimeMillis()));

		}

	}

	// 1. Scenario: Login Functionality for valid username and password

	private FluentWait<WebDriver> WebDriverWait(WebDriver driver2, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Given("^user is on the application login page$")

	public void isuserisonloginpagesuccefully() {
		try {

			String newUrl = driver.getCurrentUrl();

			if (newUrl.equalsIgnoreCase("http://192.168.0.222:90/finsys/index.php")) {
				System.out.println("Login Success");
			}
			String message = "Status:PASS,Step Number:" + Config.counter++
					+ ",Step:user is on the application login page " + "exception:NA";

			logger.info(message);
			HTMLReportGenerator.StepDetails("PASS", "user is on the application login page" + "exception:NA",
					"user is on the application login page", "");

		} catch (Exception ex) {

			String message = "Status:FAIL,Step Number:" + Config.counter++
					+ ",Step:user is on the application login page " + "exception:" + ex.getMessage();
			HTMLReportGenerator.StepDetails("Status:FAIl", "user is on the application login page",
					"exception:" + ex.getMessage(), "");
			logger.error(message);

		}
	}

	// Link ur cucumber feature file with function(step) using this syntax ex:
	// @When("^user enters \"(.*)\" as username$")

	@When("^user enters \"(.*)\" as username$")
	public void Enterusernametext(String username) {

		try {
			element = driver.findElement(By.xpath("//input[@placeholder='Username']"));

			element.sendKeys(username);
			String message = "Status:PASS,Step Number:" + Config.counter++ + ",Step:user enters user name " + username
					+ "exception:NA";
			logger.info(message);

			HTMLReportGenerator.StepDetails("PASS", "user enters user " + username + "name",
					"User name:" + username + ",exception:NA", "");

		} catch (Exception ex) {
			String message = "Status:FAIL,Step Number:" + Config.counter++ + ",Step:user enters user name " + username
					+ "exception:" + ex.getMessage();
			logger.error(message);
			HTMLReportGenerator.StepDetails("FAIL", "user enters user " + username + "name",
					"User name:" + username + ",exception:" + ex.getMessage(), "");

		}

	}

	@And("^user enters \"(.*)\" as password$")
	public void Enterpasswordtext(String password) {

		try {
			element = driver.findElement(By.xpath("//input[@placeholder='Password']"));
			element.sendKeys(password);
			String message = "Status:PASS,Step Number:" + Config.counter++ + ",Step:user enters password" + password
					+ "exception:NA";

			logger.info(message);
			HTMLReportGenerator.StepDetails("PASS", "user enters " + password + "password", "exception:NA", "");

		} catch (Exception ex) {
			String message = "Status:FAIL,Step Number:" + Config.counter++ + ",Step: user enters password " + password
					+ "exception:" + ex.getMessage();

			logger.error(message);
			HTMLReportGenerator.StepDetails("FAIL", "user enters " + password + "password",
					"exception:" + ex.getMessage(), "");

		}

	}

	@And("^user clicks on login button$")

	public void ClickOnLoginButton() {
		try {
			element = driver.findElement(By.xpath("//*[.='Login']"));
			element.click();
			String message = "Status:FAIL,Step Number:" + Config.counter++ + ",Step:user clicks on login button"
					+ "exception:NA";

			logger.info(message);
			HTMLReportGenerator.StepDetails("PASS", "user clicks on login button", "exception:NA", "");

		} catch (Exception ex) {
			String message = "Status:FAIL,Step Number:" + Config.counter++ + ",Step:user clicks on login button"
					+ "exception:" + ex.getMessage();
			logger.error(message);
			HTMLReportGenerator.StepDetails("FAIL", " user clicks on login button", "exception:" + ex.getMessage(), "");

		}

	}

	@Then("^user is on the application home page$")

	public void homepage() {
		try {

			String newUrl = driver.getCurrentUrl();

			if (newUrl.equalsIgnoreCase("http://192.168.0.222:90/finsys/index.php")) {
				System.out.println("Login Success homepage");
			}
			String message = "Status:PASS,Step Number:" + Config.counter++
					+ ",Step:user is on the application home page" + "exception:NA";

			HTMLReportGenerator.StepDetails("PASS", "Login Success homepage", "exception:NA", "");

			logger.info(message);

		} catch (Exception ex) {
			String message = "Status:FAIL,Step Number:" + Config.counter++
					+ ",Step:user is on the application home page" + "exception:" + ex.getMessage();

			logger.error(message);
			HTMLReportGenerator.StepDetails("FAIL", "Login Success homepage", "exception:" + ex.getMessage(), "");

		}

	}

	@And("^user gets the message starting with \"(.*)\" on the top$")

	public void messagebox(String Xpath) {
		try {
			WebElement Msgbox = driver.findElement(By.xpath("//span[contains(text(),'Welcome dummy[FM]')]"));
			System.out.println("Welcome message");
			String message = "Status:PASS,Step Number:" + Config.counter++ + ",Step:user gets the message starting with"
					+ Xpath + "exception:NA";

			logger.info(message);
			HTMLReportGenerator.StepDetails("PASS", "user gets the message starting with " + Xpath + "starting with",
					"exception:NA", "");

		} catch (Exception ex) {
			String message = "Status:FAIL,Step Number:" + Config.counter++ + ",Step:user gets the message starting with"
					+ Xpath + "exception:" + ex.getMessage();

			logger.error(message);
			HTMLReportGenerator.StepDetails("FAIL", "user gets the message starting with" + Xpath + "starting with",
					"exception:" + ex.getMessage(), "");

		}
	}

	@And("^user get the message starting with \"(.*)\" username$")

	public void Wrongmessagebox(String wrongmsg) {
		try {
			WebElement Wrongmessagebox = driver.findElement(By.xpath("//div[@id='error']"));
			System.out.println("Wrong");
			String message = "Status:PASS,Step Number:" + Config.counter++ + ",Step:user get the message starting with"
					+ wrongmsg + "exception:NA";

			logger.info(message);
			HTMLReportGenerator.StepDetails("PASS", "user get the message " + wrongmsg + "starting with",
					"exception:NA", "");

		} catch (Exception ex) {
			String message = "Status:FAIL,Step Number:" + Config.counter++ + ",Step:user get the message starting with:"
					+ wrongmsg + "exception:" + ex.getMessage();
			HTMLReportGenerator.StepDetails("FAIL", "user get the message" + wrongmsg + "starting with",
					"exception:" + ex.getMessage(), "");

			logger.error(message);

		}

	}

	// 2. Scenario: Login Functionality for valid username and invalid password

	@Then("^user is on the same login page$")

	public void checksameloginpage() {
		try {
			String newUrl = driver.getCurrentUrl();

			if (newUrl.equalsIgnoreCase("http://192.168.0.222:90/finsys/login.html#")) {
				System.out.println("same login page");
			}
			String message = "Status:PASS,Step Number:" + Config.counter++ + ",Step:user is on the same login page"
					+ "exception:NA";

			logger.info(message);
			HTMLReportGenerator.StepDetails("PASS", "user is on the same login page", "exception:NA", "");

		} catch (Exception ex) {
			String message = "Status:FAIL,Step Number:" + Config.counter++ + ",Step:user is on the same login page:"
					+ "exception:" + ex.getMessage();

			logger.error(message);
			HTMLReportGenerator.StepDetails("FAIL", "user is on the same login page", "exception:" + ex.getMessage(),
					"");

		}
	}

	@And("^user enters  \"(.*)\" invalid as password$")

	public void invalidPassword(String Xpath) {
		try {

			WebElement invalidpassword = driver.findElement(By.xpath("//div[@id='error']"));
			String storetext = invalidpassword.getText();
			storetext.contains("Please");
			System.out.println("Wrong");
			String message = "Status:PASS,Step Number:" + Config.counter++ + ",Step:user enters  invalid as password"
					+ Xpath + "exception:NA";

			logger.info(message);
			HTMLReportGenerator.StepDetails("PASS", "user enters" + Xpath + "invalid as password", "exception:NA", "");

		} catch (Exception ex) {

			String message = "Status:FAIL,Step Number:" + Config.counter++ + ",Step:user enters invalid as password:"
					+ Xpath + "exception:" + ex.getMessage();
			HTMLReportGenerator.StepDetails("FAIL", "user enters" + Xpath + "invalid as password",
					"exception:" + ex.getMessage(), "");

			logger.error(message);
		}
	}

	@When("^user enter \"(.*)\" as username$")

	public void invalidUsername(String Xpath) {
		try {
			WebElement invalidusername = driver.findElement(By.xpath("//div[@id='error']"));
			String invalidusernamestoretext = invalidusername.getText();
			invalidusernamestoretext.contains("Please");
			System.out.println("Wrong");
			String message = "Status:PASS,Step Number:" + Config.counter++ + ",Step:user enters  invalid as user name "
					+ Xpath + "exception:NA";

			logger.info(message);
			HTMLReportGenerator.StepDetails("PASS", "user enters " + Xpath + "invalid as user name", "exception:NA",
					"");

		} catch (Exception ex) {
			String message = "Status:FAIL,Step Number:" + Config.counter++ + ",Step:user enters invalid as user name:"
					+ Xpath + "exception:" + ex.getMessage();

			logger.error(message);
			HTMLReportGenerator.StepDetails("FAIL", "user enters " + Xpath + "invalid as user name",
					"exception:" + ex.getMessage(), "");

		}

	}

	// Scenario: Login Functionality for invalid username and valid password

	public static void main(String[] args) throws Exception {

		/*
		 * Login myobjlogin = new Login(); myobjlogin.OpenBrowser("firefox");
		 * Thread.sleep(2000);
		 * 
		 * myobjlogin.Enterbaseurl("http://192.168.0.222:90/finsys/login.html#");
		 * 
		 * myobjlogin.isuserisonloginpagesuccefully(
		 * "http://192.168.0.222:90/finsys/index.php");
		 * myobjlogin.Enterusernametext("dummyfm");
		 * myobjlogin.Enterpasswordtext("passw0rd"); myobjlogin.ClickOnLoginButton();
		 * myobjlogin.homepage("http://192.168.0.222:90/finsys/index.php");
		 */
		// jr suppose 2 rya frame vr cha object asel tr aplyla screen switch kravi lagte
		// using this command

		// myobjlogin.driver.switchTo().frame(0);

	}

}
