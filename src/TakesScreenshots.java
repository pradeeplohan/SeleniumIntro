import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class TakesScreenshots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver = new EdgeDriver();
		driver.get("https://google.com");
		
		//Take a screenshot
		//For it we cast our webdriver into TakesScreenshot object and use method getScreenshotAs(OutputType.File)
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Now copy this screenshot file into our system using FileUtiles.copyFile(src, new File("path"))
		FileUtils.copyFile(src, new File("/Users/pardeeplohan/Documents/screenshot.png"));
		
		driver.close();

	}

}
