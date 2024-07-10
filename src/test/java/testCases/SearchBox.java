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

public class SearchBox {

	public static void main(String[] args) {
		
		// ouvrir chromeDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// maximaze de la page actuelle
		driver.manage().window().maximize();
		// implicity wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// ouvrir URL
		String URL = "https://www.google.com/";
		driver.navigate().to(URL);
		
		// declaration et identification
		WebElement bt_recherche = driver.findElement(By.id("APjFqb"));
		bt_recherche.sendKeys("tunisie");
		bt_recherche.sendKeys(Keys.ENTER);
		
		// récupération de l'URL de la page actuelle
		String adresse_url;
		adresse_url = driver.getCurrentUrl();

		/*// verification
		Assert.assertTrue(adresse_url.contains("https://www.google.com/search?q=tunisie"));
		*///System.out.println("test est ok");
		
		// 2ème méthode: verification par la condition if
		if (adresse_url.contains("https://www.google.com/search?q=tunisie")) {
			System.out.println("l'URL est correcte");
		} else {
			System.out.println("l'URL est incorrecte");
		}	
		Assert.assertTrue(adresse_url.contains("https://www.google.com/search?q=tunisie"));
		
		
	}

}
