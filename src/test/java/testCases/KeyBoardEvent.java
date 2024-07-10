package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardEvent {

	public static void main(String[] args) {
		// remplacer par
		WebDriverManager.chromedriver().setup();
		// ouvrir chromeDriver
		WebDriver driver = new ChromeDriver();
		// maximaze
		driver.manage().window().maximize();
		// implicity wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// ouvrir URL
		String URL = "https://demoqa.com/text-box";
		driver.navigate().to(URL);
		
		//données
		String name = "mohamed";
		String mail = "mohamed.test@gmail.com";
		String adresse = "125 avenue de paris";
		
		//declaration et identificaiton
		WebElement txt_name = driver.findElement(By.id("userName"));
		WebElement txt_mail = driver.findElement(By.id("userEmail"));
		WebElement txt_current_adress = driver.findElement(By.id("currentAddress"));
		WebElement txt_permanat_adress = driver.findElement(By.id("permanentAddress"));
		WebElement bt_submit = driver.findElement(By.id("submit"));
		
		//action
		
		 txt_name.sendKeys(name);
		 txt_mail.sendKeys(mail);
		 txt_current_adress.sendKeys(adresse);
		 Actions action = new Actions(driver);
		 action.keyDown(txt_current_adress, Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();
		 action.keyDown(txt_permanat_adress, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		 bt_submit.click();
		 
		 //verification
		 WebElement txt_msg_obtenu = driver.findElements(By.id("permanentAddress")).get(1);
		 String resultat_obtenu = txt_msg_obtenu.getText();
		 Assert.assertTrue(resultat_obtenu.contains(adresse));
		 System.out.println("Test Ok");
	}

}
