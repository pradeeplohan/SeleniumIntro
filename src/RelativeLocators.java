import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//above()
		WebElement aboveElement = driver.findElement(By.name("name"));
		String nameLabel = driver.findElement(with(By.tagName("label")).above(aboveElement)).getText();
		System.out.println(nameLabel);
		
		//below()
		WebElement belowElement = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(belowElement)).click();
		
		//toLeftOf()
		WebElement leftElement = driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(leftElement)).click();
		
		//toRightOf()
		WebElement rightElement = driver.findElement(By.id("inlineRadio1"));
		String student = driver.findElement(with(By.tagName("label")).toRightOf(rightElement)).getText();
		System.out.println(student);
		
		//driver.close();

	}

}
