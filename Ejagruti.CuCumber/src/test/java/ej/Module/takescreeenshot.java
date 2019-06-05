package ej.Module;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

public class takescreeenshot {

	public static String TakeScreenShot(String ImagePath,WebDriver driver) throws IOException{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(ImagePath);
		FileUtils.copyFile(src, dest);
		String s = dest.toString();
		return s;
	}
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.23.0/bin/geckodriver");

		WebDriver driver=new FirefoxDriver();
		driver.get("http://192.168.0.222:90/finsys/login.html#");
		Thread.sleep(20000);
		TakeScreenShot("/Users/ameyaallampallewar/Desktop/Result/abc.png",driver);

		
	}

		
		
}


 



