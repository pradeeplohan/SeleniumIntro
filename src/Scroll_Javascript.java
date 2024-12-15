import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Scroll_Javascript {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int sum = 0;
		
		//System.setProperty("webdriver.edge.driver", 
			//	"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver; //cast driver
		//scroll window
		js.executeScript("window.scrollBy(0,500)");
		
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(2000L));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.tableFixHead")));
		//scroll table
		js.executeScript("document.querySelector('div.tableFixHead').scrollTop=5000");
		
		//sum of values in table column
		List<WebElement> amount = driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]"));
		for(int i = 0; i<amount.size(); i++)
		{
			sum = sum + Integer.parseInt(amount.get(i).getText());
		}
		
		System.out.println(sum);
		String totalAmont = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
		Assert.assertEquals(sum, Integer.parseInt(totalAmont));
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/pardeeplohan/Documents/screenshot.png"));

	}

}
