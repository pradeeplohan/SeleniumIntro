import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver = new EdgeDriver();
		driver.get("https://amazon.com");
		
		Actions a = new Actions(driver);
		//Move to specific element
		WebElement move = driver.findElement(By.cssSelector("span[id='nav-link-accountList-nav-line-1']"));
		a.moveToElement(move).build().perform();
		
		//Enter "HELLO" in search box and select whole text using double click
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//right click using context click
		a.moveToElement(searchBox).contextClick().build().perform();

	}

}
