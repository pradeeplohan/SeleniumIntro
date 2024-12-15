import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ScopeOfDriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//find all the links count on the webpage -> for the links we have 'a' tag
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//find all links on footer of webpage -> scope of driver (limiting webdriver scope)
		WebElement footerDriver = driver.findElement(By.id("gf-BIG")); //sub driver
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//find all links in first column of footer
		WebElement firstCol = driver.findElement(By.xpath("//tbody/tr/td[1]/ul"));
		int count = firstCol.findElements(By.tagName("a")).size();
		System.out.println(count);
		//open all the links of first column footer
		for(int i = 1; i<count; i++)
		{
			String openLink = Keys.chord(Keys.COMMAND, Keys.ENTER);
			firstCol.findElements(By.tagName("a")).get(i).sendKeys(openLink);
			Thread.sleep(5000L);
			
		}
		
		//get the title of every tab
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			String windowid = it.next();
			driver.switchTo().window(windowid);
			System.out.println(driver.getTitle());
			
		}
		
		driver.close();

	}

}
