package TestCucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class AuthentificationOrangeHRM {
	
	WebDriver driver;
	
	@Given("Accéder au navigateur Chrome")
	public void accéder_au_navigateur_chrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("saisir url de Orange HRM {string}")
	public void saisir_url_de_orange_hrm(String string) {
	    driver.get(string);
	}

	@When("saisir user name {string} et le password {string}")
	public void saisir_user_name_et_le_password(String string, String string2) {
	WebElement txt_username = driver.findElement(By.xpath("//input[@name='username' and @placeholder='Username']")); 
	WebElement txt_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
	txt_username.sendKeys(string);
	txt_password.sendKeys(string2);
	}
	
	@When("cliquer sur le bouton Login")
	public void cliquer_sur_le_bouton_login() {
    WebElement bt_login = driver.findElement(By.xpath("//button[@type='submit']"));
	bt_login.click();
		
	}

	@Then("verifier le contenu du dashboard {string}")
	public void verifier_le_contenu_du_dashboard(String string) {
	String resultat_obtenu;
	WebElement txt_result = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name'])"));
	resultat_obtenu = txt_result.getText();
	Assert.assertTrue(resultat_obtenu.equals(string));

	}
}
