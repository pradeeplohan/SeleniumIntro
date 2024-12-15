import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Kart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] items= {"Cucumber", "Beetroot", "Brocolli"};
		
		System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver = new EdgeDriver();
		//Implicit Wait - use globally and applied on all steps
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000l));
		
		//Explicit Wait - Not use globally and applied on specific scenario
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		
		//driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		getItems(driver, items);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

	}

	private static void getItems(WebDriver driver, String[] items) {
		// TODO Auto-generated method stub
		int j = 0;
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for(int i =0; i<products.size();i++)
		{
			String name=products.get(i).getText();
			//Cucumber - 1 Kg
			String[] name1 = name.split(" ");
			// 0-> Cucumber
			System.out.println(name1[0]);
			String name2 =name1[0];
			
			List<String> items1=Arrays.asList(items);
			
			if(items1.contains(name2))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==items1.size())
					break;
			}
			
			
		}
		
	}

}
