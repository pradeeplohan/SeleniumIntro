import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;

public class myclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello world");
		//Invoking Chrome browser
		// ChromeDriver driver=new ChromeDriver(); -> WebDriver methods + class methods 
		//(may be not use in another class)
		
		//chromedriver -> execute Chrome browser
		//System.setProperty("webdriver.chrome.driver", "/Users/pardeeplohan/Documents/chromedriver/chromedriver");
		//WebDriver driver=new ChromeDriver();
		
		//For Edge browser set property for webdriver.edge.driver
		System.setProperty("webdriver.edge.driver","/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();
		
		//For Firefox browser set property for webdriver.gecko.driver
		//WebDriver driver=new FirefoxDriver();
		
		
		
	}

}
