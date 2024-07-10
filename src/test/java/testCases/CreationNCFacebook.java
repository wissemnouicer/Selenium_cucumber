package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreationNCFacebook {

	public static void main(String[] args) {
		// appel WebdriverManager
		WebDriverManager.chromedriver().setup();
		// ouvrir ChromeDriver
		WebDriver driver = new ChromeDriver();
		// maximize
		driver.manage().window().maximize();
		// implicity wait
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   // ouvrir URL
	    String URL = "https://www.facebook.com/?locale=fr_FR";
	    driver.get(URL);
	    // declaration et identification et action
	    WebElement bt_CNV = driver.findElement(By.xpath("//a[text()='Créer nouveau compte']"));
	    Actions action = new Actions(driver);
	    action.click(bt_CNV).perform();
	    
	    // saisie champ name
	    WebElement name = driver.findElement(By.xpath("//input[@name='firstname']"));
		name.sendKeys("wissem");
		// saisie champ last name
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastname.sendKeys("nouicer");
	    // saisie Nr mobile
		WebElement nr_mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		nr_mobile.sendKeys("88779966");
		// saisie nouveau mot de passe
		WebElement nmdp = driver.findElement(By.id("password_step_input"));
		nmdp.sendKeys("wissem2024*");
		// date de naissance
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
		
		// genre
		WebElement bt_genre;
		bt_genre = driver.findElement(By.xpath("//label[text()='Homme']"));
		action.click(bt_genre).perform();
		
		// s'inscrire
		WebElement bt_submit;
		bt_submit = driver.findElement(By.xpath("//button[@name='websubmit']"));
		action.click(bt_submit).perform();
	
		
	}

}
