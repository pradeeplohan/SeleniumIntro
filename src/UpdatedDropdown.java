import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UpdatedDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
	WebDriver driver=new EdgeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	driver.manage().window().maximize();
	
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	
	
    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    driver.findElement(By.id("divpaxinfo")).click();
    //Click 4 times on plus icon for adult
    int i=1;
    while(i<=4) 
    {
    	driver.findElement(By.id("hrefIncAdt")).click();
    	i++;
    }
    
    driver.findElement(By.id("btnclosepaxoption")).click();
    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

    driver.quit();
    
	}

}
