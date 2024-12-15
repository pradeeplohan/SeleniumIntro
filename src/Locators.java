import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver","/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Wait few seconds until elements are not appearing
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("pardeep");
		driver.findElement(By.name("inputPassword")).sendKeys("lohan");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); 
		//Css selector - a) Class -> tagname.classname
		//				 b) id -> tagname#id
		//               c) genric css path -> tagname[attribute='value']
		// 				 d) using index -> tagname[attribute='value']:nth-child(index)
		//				 e) Parent tag to child tag -> parenttagName childtagName
		//				 f) Using partial value of attribute -> tagname[attribute*='partial value']
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000); //Elements are not stable when changing the state on the page
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Lohan");
		//Xpath selector - a) genric x path -> //tagname[@attribute='value']
//		b) using index -> //tagname[@attribute='value'][index]
//		c) Parent tag to child tag -> //parenttagName/childtagName[index]
//		d) Using partial value of attribute -> //tagname[contains(@attribute,'partial value')]
// 		e) Using Parent X-path to child tags -> //tagname[@attribute='value']/child tagname[index]
//      f) Using text -> //tagname[text()='Text']		
		
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("pardeep@lohan.com");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("lohan@pardeep.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9850935402");
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder*='User']")).sendKeys("Pardeep");
		driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input#chkboxTwo")).click();
		driver.findElement(By.cssSelector("button[class='submit signInBtn']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText());
		
	}
// Locators - Use to find the elements on the webpage to performs actions.
	// There are total 8 locators - 1. ID, 2. Class name, 3. Name, 4. X-path
	// 5. CSS Selector, 6. Link Text, 7. Partial Link text, 8. Tag name
}
