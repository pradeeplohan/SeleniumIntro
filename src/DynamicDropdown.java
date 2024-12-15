import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
	WebDriver driver=new EdgeDriver();
	
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
//	driver.manage().window().maximize();
	
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	driver.findElement(By.xpath("//a[@value='DEL']")).click();
	System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getText());
	Thread.sleep(2000);
	//Dynamic dropdown with index -> (x-path)[index]
	//driver.findElement(By.xpath("(//a[@value='PNQ'])[2]")).click(); 
	
	//Dynamic dropdown with Parent child relationship x-path -> Parent_x-path child_x-path
	driver.findElement(By.xpath
			("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
	System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getText());
	Thread.sleep(1000);
	driver.findElement(By.xpath("a[@class='ui-state-default ui-state-highlight ui-state-active']")).click();

	}

}
