package TestCucumber;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Recherche {

	WebDriver driver;
	
	@Given("ouvrir le navigateur chrome")
	public void ouvrir_le_navigateur_chrome() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  
	}

	@Given("saisir url de google")
	public void saisir_url_de_google() {
	    String URL = "https://www.google.com/";
	    driver.navigate().to(URL);
	    
	}

	@When("saisir le mot à rechercher")
	public void saisir_le_mot_à_rechercher() {
		WebElement bt_recherche = driver.findElement(By.id("APjFqb"));
		bt_recherche.sendKeys("tunisie");
	}

	@When("cliquer sur le key entrée")
	public void cliquer_sur_le_key_entrée() {
		WebElement bt_recherche = driver.findElement(By.id("APjFqb"));
		bt_recherche.sendKeys(Keys.ENTER);
	}

	@Then("verifier le contenu de url")
	public void verifier_le_contenu_de_url() {
		String adresse_url = driver.getCurrentUrl();
		Assert.assertTrue(adresse_url.contains("https://www.google.com/search?q=tunisie"));
		System.out.println("test est ok");
	}
}
