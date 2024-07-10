package testCases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListeDeroulante {

	public static void main(String[] args) throws InterruptedException {
		// chemin chromedriver
		// System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		// remplacer par
		WebDriverManager.chromedriver().setup();
		// ouvrir chromeDriver
		WebDriver driver = new ChromeDriver();
		// maximaze
		driver.manage().window().maximize();
		// implicity wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// ouvrir URL
		String URL ="https://demoqa.com/select-menu";
		driver.navigate().to(URL);
		// declaration et identification
		WebElement ld_couleur = driver.findElement(By.id("oldSelectMenu"));
		// action: selection
		String couleur_1 = "White";
		Select select = new Select(ld_couleur);
		select.selectByVisibleText(couleur_1);
		// sleep 5s
		Thread.sleep(5000);
		// action selection
		select.selectByValue("1");
				

	}

}
