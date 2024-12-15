import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class WebTableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//1. Click on webelemet for sorting the order
		driver.findElement(By.cssSelector("tr th")).click();
		
		//2. Capture all the sorted webelemnts in a list
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
		
		//3. Capture texts from the webelemnts list and stored in a new list which is original list
		List<String> originalList = elements.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//4. Perform sort on original list and stored in a new list which is sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		//5. Compare original list and sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		List<String> price;
		do
		{
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getVeggiePrice(s)).collect(Collectors.toList());
			price.forEach(p->System.out.println(p));
			if(price.size()<1)
			{
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		}while(price.size()<1);
			
		filterWebTable(driver);
		driver.close();
		

	}

	private static String getVeggiePrice(WebElement s) {
		// TODO Auto-generated method stub
		
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}
	
	public static void filterWebTable(WebDriver driver)
	{
		String veg = "Rice";
		driver.findElement(By.id("search-field")).sendKeys(veg);
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filterList = elements.stream().filter(s->s.getText().contains(veg)).collect(Collectors.toList());
		String expectedVeg = filterList.get(0).getText();
		Assert.assertEquals(veg, expectedVeg);
	}

}
