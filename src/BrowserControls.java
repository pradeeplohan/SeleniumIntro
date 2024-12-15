import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserControls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.setProperty("webdriver.edge.driver", 
		//		"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.navigate().to("https://paytm.com");
		driver.navigate().back();
		driver.navigate().forward();
	}

}
