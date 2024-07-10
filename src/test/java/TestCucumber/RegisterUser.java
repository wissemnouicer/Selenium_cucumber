package TestCucumber;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterUser {

	WebDriver driver;
	
	@Given("acceder au browser")
	public void acceder_au_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Given("ouvrir l url suivant {string}")
	public void ouvrir_l_url_suivant(String string) {
		driver.get(string);
	}

	@Then("verifier si la page d acceuil est visible")
	public void verifier_si_la_page_d_acceuil_est_visible() {
		WebElement bt_home = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
		String couleur_attendu = "rgba(255, 165, 0, 1)";
		String couleur_obtenu;
		couleur_obtenu = bt_home.getCssValue("color");
		Assert.assertEquals(couleur_attendu, couleur_obtenu);
	}

	@When("cliquer sur le bt Signup\\/Login")
	public void cliquer_sur_le_bt_signup_login() {
		WebElement bt_signup = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
		bt_signup.click();
	}

	@Then("verifier que New User Signup! est visible")
	public void verifier_que_new_user_signup_est_visible() {
		String txt_NUSignup = "New User Signup!";
		WebElement case_signup = driver.findElement(By.xpath("//div[@class='signup-form']"));
		Assert.assertTrue(txt_NUSignup.contains("New User Signup!"));
	}

	@When("saisir le nom {string} et l email {string}")
	public void saisir_le_nom_et_l_email(String string, String string2) {
		WebElement case_name = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
		WebElement case_email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
		case_name.sendKeys(string);
		case_email.sendKeys(string2);
		
	}

	@When("cliquer sur le bt Signup")
	public void cliquer_sur_le_bt_signup() {
	    
		WebElement bt_submit = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
		bt_submit.click();
	}

	@Then("verifier que ENTER ACCOUNT INFORMATION est visible")
	public void verifier_que_enter_account_information_est_visible() {
		String txt_EAInformation = "ENTER ACCOUNT INFORMATION";
		WebElement case_loginform = driver.findElement(By.xpath("//div[@class='login-form']"));
		Assert.assertTrue(txt_EAInformation.contains("ENTER ACCOUNT INFORMATION"));
	}

	@When("choisir Title {string}")
	public void choisir_title(String string) {
		WebElement bt_genre = driver.findElement(By.id("id_gender1"));
		bt_genre.click();
	}

	@When("entrer le mot de passe {string}")
	public void entrer_le_mot_de_passe(String string) {
		WebElement case_password = driver.findElement(By.id("password"));
		case_password.sendKeys(string);
	}

	@When("selectionner la date de naissance sous forme {string} et {string} et {string}")
	public void selectionner_la_date_de_naissance(String string, String string2, String string3) {
		WebElement ld_day = driver.findElement(By.id("days"));
		String day ="10";
		Select select = new Select(ld_day);
		select.selectByValue(string);
		
		WebElement ld_month = driver.findElement(By.id("months"));
		String month = "October";
		Select select_month = new Select (ld_month);
		select_month.selectByVisibleText(string2);
		
		WebElement ld_year = driver.findElement(By.id("years"));
		String year = "2010";
		Select select_year = new Select (ld_year);
		select_year.selectByValue(string3);
		
	}

	@When("crocher la case Sign up for our newsletter")
	public void crocher_la_case_sign_up_for_our_newsletter() {
		WebElement bt_checkbox = driver.findElement(By.id("newsletter"));
		bt_checkbox.click();
	}

	@When("crocher la case Receive special offers from our partners!")
	public void crocher_la_case_receive_special_offers_from_our_partners() {
		WebElement bt_checkbox1 = driver.findElement(By.id("optin"));
		bt_checkbox1.click();
	}

	@When("remplir les champs First name {string} et Last name {string} et company {string}")
	public void remplir_les_champs_fist_name_et_last_name_et_company(String string, String string2, String string3) {
	    
		WebElement case_firstname = driver.findElement(By.id("first_name"));
		case_firstname.sendKeys(string);
		WebElement case_lastname = driver.findElement(By.id("last_name"));
		case_lastname.sendKeys(string2);
		WebElement case_company = driver.findElement(By.id("company"));
		case_company.sendKeys(string3);
	}

	@When("remplir l adresse {string}")
	public void remplir_l_adresse(String string) {
		WebElement case_address1 = driver.findElement(By.id("address1"));
		case_address1.sendKeys(string);
	}

	@When("selectionner Country {string}")
	public void selectionner_country(String string) {
		WebElement ld_country = driver.findElement(By.id("country"));
		String country = "New Zealand";
		Select select_country = new Select (ld_country);
		select_country.selectByValue(string);
	}

	@When("saisir state {string} et city {string}")
	public void saisir_state_et_city(String string, String string2) {
	    
		WebElement case_state = driver.findElement(By.id("state"));
		case_state.sendKeys(string);
		WebElement case_city = driver.findElement(By.id("city"));
		case_city.sendKeys(string2);
	}

	@When("saisir le Zipcode {string} et le Nr mobile {string}")
	public void saisir_le_zipcode_et_le_nr_mobile(String string, String string2) {
	    
		String zipcode = "1000";
		WebElement case_zipcode = driver.findElement(By.id("zipcode"));
		case_zipcode.sendKeys(string);
		String mobile_nr  = "55667788";
		WebElement case_nrmobile = driver.findElement(By.id("mobile_number"));
		case_nrmobile.sendKeys(string2);
	}

	@When("cliquer sur le bt Create Account")
	public void cliquer_sur_le_bt_create_account() {
		WebElement bt_createC = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
		bt_createC.click();
	}

	@Then("verifier que le compte cree est visible")
	public void verifier_que_le_compte_cree_est_visible() {
	    
		String txt_account_created = "Account Created!";
		WebElement case_txtcenter = driver.findElement(By.xpath("//h2[@class='title text-center']"));
		case_txtcenter.getText().contains(txt_account_created);
		System.out.println("le compte crée est visible");
		WebElement bt_continue1 = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
		bt_continue1.click();
	}

	
}
