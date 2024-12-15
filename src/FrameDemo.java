import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(2000));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		//driver.findElement(By.xpath("//h5[text()='High Tatras']")).click();
		WebElement sourceElement1 = driver.findElement(By.xpath("//h5[text()='High Tatras']"));
		WebElement sourceElement2 = driver.findElement(By.xpath("//h5[text()='High Tatras 2']"));
		WebElement TargetElement = driver.findElement(By.cssSelector("div#trash"));
		Actions a=new Actions(driver);
		a.dragAndDrop(sourceElement1, TargetElement).build().perform();
		a.dragAndDrop(sourceElement2, TargetElement).build().perform();
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("li#menu-item-53896")).click();
		

	}

}
