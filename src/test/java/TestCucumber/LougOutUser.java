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

public class LougOutUser {

	WebDriver driver;
	
	@Given("connecter sur navig")
	public void connecter_sur_navig() {
	  
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}

	@Given("entree url par {string}")
	public void entree_url_par(String string) {
		driver.get(string);
	}

	@Then("verifier si la page {string} est visible")
	public void verifier_si_la_page_est_visible(String string) {
		WebElement bt_home = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
		String couleur_attendu = "rgba(255, 165, 0, 1)";
		String couleur_obtenu;
		couleur_obtenu = bt_home.getCssValue("color");
		Assert.assertEquals(couleur_attendu, couleur_obtenu);
	}

	@When("taper le bouton {string}")
	public void taper_le_bouton(String string) {
		WebElement bt_signup = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
		bt_signup.click();
	}

	@Then("verifier si la page {string} est apparente")
	public void verifier_si_la_page_est_apparente(String string) {
		String txt_acces_compte = "Login to your account";
		WebElement case_login_form = driver.findElement(By.xpath("//div[@class='login-form']"));
	   Assert.assertTrue(txt_acces_compte.contains("Login to your account"));
	}

	@When("faire entrer correctement l email {string} et le password {string}")
	public void faire_entrer_correctement_l_email_et_le_password(String string, String string2) {
		
		WebElement case_email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
		WebElement case_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		case_email.sendKeys(string);
		case_password.sendKeys(string2);
	}

	@When("taper le boutonn {string}")
	public void taper_le_boutonn(String string) {
		WebElement bt_log = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
	    bt_log.click();
	}

	@Then("verifier que la page {string} est visible")
	public void verifier_que_la_page_est_visible(String string) {
		String profil = " Logged in as wissem ben wissem ";
		WebElement case_header = driver.findElement(By.xpath("//header[@id='header']//li[1]//a[1]"));
		Assert.assertTrue(profil.contains("Logged in as wissem ben wissem"));
	}

	@When("cliquer sur  button {string}")
	public void cliquer_sur_button(String string) {
	    WebElement bt_logout = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
	    bt_logout.click();
	}
	

	@Then("verifier que l utilisateur se dirige vers la page de connexion")
	public void verifier_que_l_utilisateur_se_dirige_vers_la_page_de_connexion() {
	    
		String adresse_url = driver.getCurrentUrl();
		Assert.assertTrue(adresse_url.contains("https://automationexercise.com/login"));
		System.out.println("test est ok");
	}

		
}
