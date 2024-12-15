import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DeleteCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver = new EdgeDriver();
		//maximize browser
		driver.manage().window().maximize();
		
		//Delete all cookies
		driver.manage().deleteAllCookies();
		
		//Delete a cookie name sessionkey
		//driver.manage().deleteCookieNamed("seesionkey");
		
		//Add a cookie
		//driver.manage().addCookie(null);
		
		driver.get("https://google.com");
		
		driver.close();

	}

}
