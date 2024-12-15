import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EdgeOptions option = new EdgeOptions();
		//bypass the SSL certificate 
		option.setAcceptInsecureCerts(true); 
		
		//add extension
		//option.addExtensions(new File("/Users/pardeeplohan/Downloads/Solo"));

		//add capability - exp. proxy
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("myhttpproxy:2333");
		option.setCapability("proxy", proxy);
		
		//block pop up windows - exp. allow location etc.
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		//set download directory for any downloading file
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		option.setExperimentalOption("prefs", prefs);
		
		System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver = new EdgeDriver(option);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		driver.close();

	}

}
