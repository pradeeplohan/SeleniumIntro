import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		Set<String> windows = driver.getWindowHandles(); //[parentid, childid]
		Iterator<String> it = windows.iterator();
		String parentId = it.next(); //parentid
		String childId = it.next(); //childid
		driver.switchTo().window(childId);
		String para = driver.findElement(By.cssSelector("p.im-para.red")).getText();
		System.out.println(para);
		String email = para.split("with")[0].split("at")[1].trim();
		System.out.println(email);
		driver.close();
		driver.switchTo().window(parentId);
		driver.findElement(By.cssSelector("input#username")).sendKeys(email);

	}

}
