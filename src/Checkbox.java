import java.time.Duration;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Checkbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
	WebDriver driver=new EdgeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	driver.manage().window().maximize();
	
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	
	Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
	System.out.println(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
	driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();
	Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
	System.out.println(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
	
	//count of all check boxes 
	Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);
	System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

	driver.close();
	}

}
