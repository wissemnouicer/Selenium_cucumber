package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsName {

	public static void main(String[] args) {
		// // remplacer par
		WebDriverManager.chromedriver().setup();
		// ouvrir chromeDriver
		WebDriver driver = new ChromeDriver();
		// maximaze
		driver.manage().window().maximize();
		// implicity wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// ouvrir URL
		String URL = "https://www2.ulb.ac.be/demo/format-ulb/index-74.html";
		driver.navigate().to(URL);

		/*// méthode 1:
		// declaration et identification
		WebElement case_français = driver.findElements(By.name("langue")).get(0);
		WebElement case_anglais = driver.findElements(By.name("langue")).get(2);
		WebElement case_other = driver.findElements(By.name("langue")).get(3);
		case_français.click();
		case_anglais.click();
		case_other.click();
		*/
		
		// méthode 2:
		List<WebElement> case_langue = driver.findElements(By.name("langue"));
		case_langue.get(0).click();
		case_langue.get(2).click();
		case_langue.get(3).click();
		
	}

}
