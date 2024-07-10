package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class RegisterUser {

	public static void main(String[] args) {

		
		// ouvrir chromeDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// maximaze
		driver.manage().window().maximize();
		// implicity wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// ouvrir URL
		String URL = "https://automationexercise.com/";
		driver.navigate().to(URL);
		
		// declaration et identification page HOME
		WebElement bt_home = driver.findElement(By.xpath("//a[@style='color: orange;']"));
		// verification couleur
		String couleur_attendu = "rgba(255, 165, 0, 1)";
		String couleur_obtenu;
		couleur_obtenu = bt_home.getCssValue("color");
		Assert.assertEquals(couleur_attendu, couleur_obtenu);
		System.out.println(couleur_obtenu);
		// declaration et identification bouton signUp / login
		WebElement bt_signup = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
		bt_signup.click();
		
		// verification du texte'New User Signup!' est visible
		String txt_NUSignup = "New User Signup!";
		WebElement case_signup = driver.findElement(By.xpath("//div[@class='signup-form']"));
		Assert.assertTrue(txt_NUSignup.contains("New User Signup!"));
		
		// saisie des champs 'New User Signup!"
		WebElement case_name = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
		case_name.sendKeys("wissem ben wissem");
		WebElement case_email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
		case_email.sendKeys("wissem2024-1996-3@gmail.com");
		WebElement bt_submit = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
		bt_submit.click();
		
		// verification de la visibilité de la page "ENTER ACCOUNT INFORMATION" 
		String txt_EAInformation = "ENTER ACCOUNT INFORMATION";
		WebElement case_loginform = driver.findElement(By.xpath("//div[@class='login-form']"));
		Assert.assertTrue(txt_EAInformation.contains("ENTER ACCOUNT INFORMATION"));
		System.out.println("test est ok");
		
		//declaration et identification des champs d'informations
		WebElement bt_genre = driver.findElement(By.id("id_gender1"));
		bt_genre.click();
		WebElement case_password = driver.findElement(By.id("password"));
		case_password.sendKeys("bonjour1996*");
		WebElement ld_day = driver.findElement(By.id("days"));
		String day ="10";
		Select select = new Select(ld_day);
		select.selectByValue(day);
		WebElement ld_month = driver.findElement(By.id("months"));
		String month = "October";
		Select select_month = new Select (ld_month);
		select_month.selectByVisibleText(month);
		WebElement ld_year = driver.findElement(By.id("years"));
		String year = "2010";
		Select select_year = new Select (ld_year);
		select_year.selectByValue(year);
		WebElement bt_checkbox = driver.findElement(By.id("newsletter"));
		bt_checkbox.click();
		WebElement bt_checkbox1 = driver.findElement(By.id("optin"));
		bt_checkbox1.click();
		WebElement case_firstname = driver.findElement(By.id("first_name"));
		case_firstname.sendKeys("wissem");
		WebElement case_lastname = driver.findElement(By.id("last_name"));
		case_lastname.sendKeys("ben wissem");
		WebElement case_company = driver.findElement(By.id("company"));
		case_company.sendKeys("company wissem");
		WebElement case_address1 = driver.findElement(By.id("address1"));
		case_address1.sendKeys("10 avenue Mongi slim");
		WebElement ld_country = driver.findElement(By.id("country"));
		String country = "New Zealand";
		Select select_country = new Select (ld_country);
		select_country.selectByValue(country);
		WebElement case_state = driver.findElement(By.id("state"));
		case_state.sendKeys("ardhaniya");
		WebElement case_city = driver.findElement(By.id("city"));
		case_city.sendKeys("tunis");
		String zipcode = "1000";
		WebElement case_zipcode = driver.findElement(By.id("zipcode"));
		case_zipcode.sendKeys(zipcode);
		String mobile_nr  = "55667788";
		WebElement case_nrmobile = driver.findElement(By.id("mobile_number"));
		case_nrmobile.sendKeys(mobile_nr);
		WebElement bt_createC = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
		bt_createC.click();
		
		// verification de la visibilité de la page "Account Created!"
		String txt_account_created = "Account Created!";
		WebElement case_txtcenter = driver.findElement(By.xpath("//h2[@class='title text-center']"));
		case_txtcenter.getText().contains(txt_account_created);
		System.out.println("le compte crée est visible");
		WebElement bt_continue1 = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
		bt_continue1.click();
		
		// verification de la visibilité de la page "Logged in as wissem ben wissem"
		String resultat_attendu = " Logged in as ";
		String resultat_obtenu;
		WebElement resultat_user = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
		resultat_obtenu = resultat_user.getText();
		Assert.assertEquals(resultat_attendu, resultat_obtenu);
		System.out.println("test est ok");
		
		// Click 'Delete Account' button
		WebElement bt_Delete = driver.findElement(By.xpath("//a[@style='color: rgb(165 42 42);']"));
		String coul_attendu = "rgba(165, 42, 42, 1)";
		String coul_obtenu;
		coul_obtenu = bt_Delete.getCssValue("color");
		Assert.assertEquals(coul_attendu, coul_obtenu);
		bt_Delete.click();
		System.out.println(coul_obtenu);
		
		// verification de la visibilité de la page "Account Deleted!"
		String txt_account_deleted = "Account Deleted!";
		WebElement case_center = driver.findElement(By.xpath("//h2[@class='title text-center']"));
		case_center.getText().contains(txt_account_deleted);
		System.out.println("le compte est supprimé");
		WebElement bt_continue = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
		bt_continue.click();
		
		
	}

}
