import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String month = "5";
		String day = "7";
		String year = "2028";
		String[] reqDate = {month, day, year};
		
		System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("div.react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector("span.react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.cssSelector("span.react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.xpath("//button[@class='react-calendar__tile react-calendar__year-view__months__month']")).get(4).click();
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
		
		List<WebElement> actDate = driver.findElements(By.xpath("//input[contains(@class,'react-date-picker__inputGroup__input')]"));
		for(int i = 0; i<actDate.size(); i++)
		{
			System.out.println(actDate.get(i).getAttribute("value"));
			Assert.assertEquals(actDate.get(i).getAttribute("value"), reqDate[i]);
		}
		
		driver.close();

	}

}
