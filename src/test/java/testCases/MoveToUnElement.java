package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToUnElement {

	public static void main(String[] args) {
		//  appel WebdriverManager
		WebDriverManager.edgedriver().setup();
		// ouverture Edge
	    WebDriver driver = new EdgeDriver();
	    // maximaze
	    driver.manage().window().maximize();
	    // implicity wait
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    // ouvrir URL
	    String URL = "https://demoqa.com/menu#";
	    driver.get(URL);
	    // declaration et verification
	    WebElement bt_menu2 = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
	    // action
	    Actions action = new Actions(driver);
	    action.moveToElement(bt_menu2).perform();
	    WebElement bt_menu21 = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
	    action.moveToElement(bt_menu21).perform();
	    WebElement bt_211 = driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"));
	    action.moveToElement(bt_211).perform();
	    
	}

}
