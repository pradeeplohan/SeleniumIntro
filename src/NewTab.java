import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class NewTab {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		String courseTab = newTab(driver);
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys(courseTab);
		
		//screenshot of web element
		//File src = name.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File ("/Users/pardeeplohan/Documents/logo.png"));
		
		//Get Height and width of name textbox
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		String emailWindow = newWindow(driver);
		driver.findElement(By.name("email")).sendKeys(emailWindow);

	}

	private static String newWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		
		//open a new window
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		//switch to new tab using windowhandles method
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> it = windowIds.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		
		driver.get("https://rahulshettyacademy.com/contact-us");
		String email = driver.findElement(By.xpath("//li[text()='contact@rahulshettyacademy.com']"))
				.getText().split("MAIL")[1].trim();
	
		driver.close();
		
		driver.switchTo().window(parentId);
		return email;
		
		
	}

	private static String newTab(WebDriver driver) {
		// TODO Auto-generated method stub
		
		//open a new tab
		driver.switchTo().newWindow(WindowType.TAB);
		
		//switch to new tab using windowhandles method
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> it = windowIds.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.xpath("//h2/a")).get(0).getText();
		driver.close();
		
		driver.switchTo().window(parentId);
		return courseName;
		
		
	}

}
