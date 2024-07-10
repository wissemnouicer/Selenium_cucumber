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

public class LoginUser {

	
	WebDriver driver;
	
	@Given("naviguer au browser")
	public void naviguer_au_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("ecrire url suivant {string}")
	public void ecrire_url_suivant(String string) {
		driver.get(string);
	}


	@When("cliquer sur le bouton Signup\\/Login")
	public void cliquer_sur_le_bouton_signup_login() {
		WebElement bt_signup = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
		bt_signup.click();
	}
	
	@Then("verifier si le texte Login to your account est visible")
	public void verifier_si_le_texte_login_to_your_account_est_visible() {
		String txt_acces_compte = "Login to your account";
		WebElement case_login_form = driver.findElement(By.xpath("//div[@class='login-form']"));
	   Assert.assertTrue(txt_acces_compte.contains("Login to your account"));
	}


	@When("entrer l email {string} et le password {string}")
	public void entrer_l_email_et_le_password(String string, String string2) {
		WebElement case_email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
		WebElement case_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		case_email.sendKeys(string);
		case_password.sendKeys(string2);

	}

	@When("cliquer le bouton login")
	public void cliquer_le_bouton_login() {
		WebElement bt_log = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
	    bt_log.click();

	}

	@Then("verifier que le texte Logged in as username est visible")
	public void verifier_que_le_texte_logged_in_as_username_est_visible() {
		String profil = " Logged in as wissem ben wissem ";
		WebElement case_header = driver.findElement(By.xpath("//header[@id='header']//li[1]//a[1]"));
		Assert.assertTrue(profil.contains("Logged in as wissem ben wissem"));
	
	}


@Given("ouvrir le navigator")
public void ouvrir_le_navigator() {
    
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}

@Given("taper l url suivant {string}")
public void taper_l_url_suivant(String string) {
	driver.get(string);
}

@When("taper sur le bt Signup\\/Login")
public void taper_sur_le_bt_signup_login() {
	WebElement bt_signup = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
	bt_signup.click();

}


@Then("ecrire l eamil {string} et le mt de passe {string}")
public void ecrire_l_eamil_et_le_mt_de_passe(String string, String string2) {
	WebElement case_email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
	WebElement case_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
	case_email.sendKeys(string);
	case_password.sendKeys(string2);

}

@Then("presser le bouton login")
public void presser_le_bouton_login() {
	WebElement bt_log = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
    bt_log.click();

}

@Then("verifier le resultat {string}")
public void verifier_le_resultat(String string) {
    
	String resultat_obtenu;
	WebElement msg_error = driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']"));
	resultat_obtenu = msg_error.getText();
	Assert.assertTrue(resultat_obtenu.equals(string));

}
}






	