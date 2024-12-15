import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Loctors_Practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String name = "Pardeep";
		
		System.setProperty("webdriver.edge.driver", "/Users/pardeeplohan/Documents/edgedriver/msedgedriver");
		WebDriver driver=new EdgeDriver();
		
		String password=getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		String s1=driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(s1, "You are successfully logged in.");
		System.out.println(s1);
		
		String s2=driver.findElement(By.tagName("h2")).getText();
		Assert.assertEquals(s2, "Hello "+name+",");
		System.out.println(s2);
		
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
		
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String temp1=driver.findElement(By.cssSelector("p.infoMsg")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] tempArr2=temp1.split("'");
		//0 -> Please use temporary password 
		//1 -> rahulshettyacademy' to Login.
		String password = tempArr2[1].split("'")[0];
		//0 -> rahulshettyacademy
		//1 ->  to Login.
		return password;
	}

}
