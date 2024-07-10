package TestCucumber;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class authentificationOutline {

	WebDriver driver;
	
	@Given("ouvrir le navig")
	public void ouvrir_le_navig() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("saisir l url suivant {string}")
	public void saisir_l_url_suivant(String string) {
	    driver.get(string);
	}

	@When("ecrire username {string} et le mt de passe {string}")
	public void ecrire_username_et_le_mt_de_passe(String string, String string2) {
		WebElement txt_username = driver.findElement(By.xpath("//input[@name='username' and @placeholder='Username']")); 
		WebElement txt_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		txt_username.sendKeys(string);
		txt_password.sendKeys(string2);
	}

	@When("presser sur le bt login")
	public void presser_sur_le_bt_login() {
		WebElement bt_login = driver.findElement(By.xpath("//button[@type='submit']"));
		bt_login.click();
	}

	@Then("verifier le resultat affichee {string}")
	public void verifier_le_resultat_affichee(String string) {
	    String CurrentUrl = driver.getCurrentUrl();
	    if (CurrentUrl.contains("dashboard")) {
	    	String resultat_obtenu;
	    	WebElement resultat_user = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
	    	resultat_obtenu = resultat_user.getText();
	    	Assert.assertTrue(resultat_obtenu.equals(string));
	    }
	    else {
	    	String resultat_obtenu;
	    	WebElement resultat_erreur = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
	    	resultat_obtenu = resultat_erreur.getText();
	    	Assert.assertEquals(resultat_obtenu, string);
	    	
	    }
	
	}
	

}
