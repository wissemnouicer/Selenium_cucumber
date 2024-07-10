package TestCucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
	
	
	WebDriver driver;
	@Given("ouvrir chrome")
	public void ouvrir_chrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("ouvrir url Facebook {string}")
	public void ouvrir_url_facebook(String string) {
	    driver.get(string);
	}

	@When("cliquer sur le bouton Creer nouveau compte")
	public void cliquer_sur_le_bouton_creer_nouveau_compte() {
		WebElement bt_CNV = driver.findElement(By.xpath("//a[text()='Créer nouveau compte']"));
	    Actions action = new Actions(driver);
	    action.click(bt_CNV).perform();
	}

	@When("remplir les champs Prenom {string} et nom de la famille {string}")
	public void remplir_les_champs_prenom_et_nom_de_la_famille(String string, String string2) {
		WebElement prenom = driver.findElement(By.xpath("//input[@name='firstname']"));
		prenom.sendKeys(string);
		WebElement nom_famille = driver.findElement(By.xpath("//input[@name='lastname']"));
		nom_famille.sendKeys(string2);
		
	}

	@When("remplir les champs Nr mobile {string} et mot de passe {string}")
	public void remplir_les_champs_nr_mobile_et_mot_de_passe(String string, String string2) {
		WebElement nr_mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		nr_mobile.sendKeys(string);
		WebElement mot_passe = driver.findElement(By.id("password_step_input"));
		mot_passe.sendKeys(string2);
		
	}

	@When("selectionner la date de naissance {string} et le genre")
	public void selectionner_la_date_de_naissance_et_le_genre(String string) {
		WebElement ld_jour = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		String day = "10";
		Select select_jour = new Select(ld_jour);
		select_jour.selectByValue(day);
		WebElement ld_mois = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		String mois = "10";
		Select select_mois = new Select(ld_mois);
		select_mois.selectByValue(mois);
		WebElement ld_year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		String année = "2009";
		Select select_year = new Select(ld_year);
		select_year.selectByValue(année);
		
		
		WebElement bt_genre = driver.findElement(By.xpath("//label[text()='Homme']"));
		Actions action = new Actions(driver);
		action.click(bt_genre).perform();
		
	}

	@Then("cliquer sur le bouton s inscrire")
	public void cliquer_sur_le_bouton_s_inscrire() {
		
		WebElement bt_submit = driver.findElement(By.xpath("//button[@name='websubmit']"));
		Actions action = new Actions (driver);
		action.click(bt_submit).perform();
	}
}
