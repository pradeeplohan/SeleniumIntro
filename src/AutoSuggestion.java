import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AutoSuggestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
	WebDriver driver=new EdgeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	driver.manage().window().maximize();
	
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	
	driver.findElement(By.id("autosuggest")).sendKeys("ind");
	
	//find all the web elements
	List<WebElement> options = driver.findElements(By.cssSelector("a.ui-corner-all"));
	for(WebElement option:options)
	{
		if(option.getText().equalsIgnoreCase("India"))
		{
			option.click();
			break;
		}
	}

	}

}
