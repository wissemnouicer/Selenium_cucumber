package testCases;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;


public class DoubleClick {

	public static void main(String[] args) {
		// chemin chromedriver
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		// ouvrir chrome
		WebDriver driver = new ChromeDriver();
		// maximaze
		driver.manage().window().maximize();
		// ouvrir URL
		driver.get("https://demoqa.com/buttons");
		
		// declaration
		WebElement bt_doubleClick;
		// identification
		bt_doubleClick = driver.findElement(By.id("doubleClickBtn"));
		//actions
		Actions action= new Actions(driver);
		action.doubleClick(bt_doubleClick).perform();
		
		// verification
		String msg_attendu ="You have done a double click";
		String msg_obtenu;
	    WebElement txt_resultat;
	    txt_resultat = driver.findElement(By.id("doubleClickMessage"));
	    msg_obtenu = txt_resultat.getText();
	    Assert.assertEquals(msg_attendu, msg_obtenu);
	    System.out.println("test ok");
	    
	}

}
