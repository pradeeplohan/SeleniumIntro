import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", 
				"/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElement(By.xpath
				("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		String s = driver.findElement(By.xpath
				("//button[text()='Signup']/parent::div/parent::header/a[2]")).getText();
		System.out.println(s);
		Assert.assertEquals(s, "Free Access to InterviewQues/ResumeAssistance/Material");

	}

}
