package ej.Module;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;


import java.io.File;
import java.io.IOException;
public class Config {

	
	
	public static int counter = 1;
	
	
	public static String TakeScreenShot(String ImagePath,WebDriver driver,long ms) throws IOException{
		
		try {
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(ImagePath);
			FileUtils.copyFile(src, dest);
			
			
			String s = dest.toString();
		    System.out.println("Screenshot Taken!!!!");
			return s;

		}catch(Exception e) {
		    System.out.println("Exception while taking ScreenShot "+e.getMessage());

			
		}

	    return ImagePath;
	
		  
	}
		
	}
	

