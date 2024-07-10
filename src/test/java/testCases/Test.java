package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// chemin chromedriver
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		// ouvrir chrome
		WebDriver driver= new ChromeDriver();
		// maximize window
		driver.manage().window().maximize();
		// ouvrir URL
		driver.get("https://demoqa.com/buttons");
		// sleep 5s
		Thread.sleep(5000);
		
		// declaration
		WebElement bt_clickme;
		// identification
		bt_clickme = driver.findElement(By.xpath("//button[text()='Click Me']"));
	    // action
		bt_clickme.click();
		
				
		// fermeture chrome
		driver.close();
	}

}
