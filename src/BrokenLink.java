import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		SoftAssert soft = new SoftAssert();
		
		List<WebElement> urls = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(int i = 0; i < urls.size(); i++)
		{
			String url = urls.get(i).getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode  = conn.getResponseCode();
			//System.out.println(respCode);
			soft.assertTrue(respCode<400, "This link is broken with text "+ "\""+urls.get(i).getText()+"\"" +" with response code "+respCode);
			
		}
		soft.assertAll();
		driver.close();
	}

}
