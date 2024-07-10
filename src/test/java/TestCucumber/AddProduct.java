package TestCucumber;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class AddProduct {

	WebDriver driver;

	@Given("lancer chrome")
	public void lancer_chrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("naviguer sur l URL suivant {string}")
	public void naviguer_sur_l_url_suivant(String string) {
		driver.get(string);
	}
	@When("cliquer sur le bouton Products et defiler la page vers haut")
	public void cliquer_sur_le_bouton_products_et_defiler_la_page_vers_haut() {
		WebElement bt_products = driver.findElement(By.xpath("//a[@href='/products']"));
	    bt_products.click();
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("window.scrollBy(0, 1000)");
	    
	}

	
	@When("choisir le premier produit {string} et cliquer sur Add to cart")
	public void choisir_le_premier_produit_et_cliquer_sur_add_to_cart(String string) {
	    WebElement image_produit = driver.findElement(By.xpath("//body/section/div[@class='container']/div[@class='row']/div[@class='col-sm-9 padding-right']/div[@class='features_items']/div[3]/div[1]/div[1]/div[1]/a[1]"));
	    image_produit.click();
	    
	}
	
	@When("cliquer sur le bouton Continue Shopping et defiler la page vers haut")
	public void cliquer_sur_le_bouton_continue_shopping_et_defiler_la_page_vers_haut() {
    WebElement bt_continueShopping = driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']"));
    bt_continueShopping.click();
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("window.scrollBy(0, 7000)");
		 	
	}

	@When("choisir le deuxieme produit {string} et cliquer sur Add to cart")
	public void choisir_le_deuxieme_produit_et_cliquer_sur_add_to_cart(String string) {
     WebElement image_produit1 = driver.findElement(By.xpath("//body/section/div[@class='container']/div[@class='row']/div[@class='col-sm-9 padding-right']/div[@class='features_items']/div[35]/div[1]/div[1]/div[1]/a[1]"));
     image_produit1.click();
		
	}

	@When("cliquer sur le bouton View Cart")
	public void cliquer_sur_le_bouton_view_cart() {
     WebElement bt_viewCart = driver.findElement(By.xpath("//u[normalize-space()='View Cart']"));
     bt_viewCart.click();
	}

	@Then("verifier que les deux produits {string} et {string} sont ajoutes au panier")
	public void verifier_que_les_deux_produits_et_sont_ajoutes_au_panier(String string, String string2) {
		WebElement bt_cart = driver.findElement(By.xpath("//a[normalize-space()='Cart']"));
		String couleur_attendu = "rgba(255, 165, 0, 1)";
		String couleur_obtenu;
		couleur_obtenu = bt_cart.getCssValue("color");
		Assert.assertEquals(couleur_attendu, couleur_obtenu);
		string = "Men Tshirt";
		WebElement case_productDetail = driver.findElement(By.xpath("//a[normalize-space()='Men Tshirt']"));
		Assert.assertTrue(string.contains("Men Tshirt"));
		string2 = "GRAPHIC DESIGN MEN T SHIRT - BLUE";
		WebElement case_productDetail1 = driver.findElement(By.xpath("//a[normalize-space()='GRAPHIC DESIGN MEN T SHIRT - BLUE']"));
		Assert.assertTrue(string2.contains("GRAPHIC DESIGN MEN T SHIRT - BLUE"));
		
	}
	
	@Then("verifier leurs prix {string} et {string} et leurs quantites {string} et {string} et leurs prix totaux {string} et {string}")
	public void verifier_leurs_prix_et_et_leurs_quantites_et_et_leurs_prix_totaux(String string, String string2, String string3, String string4, String string5, String string6) {
		String resultat_obtenu;
		WebElement resultat_attendu = driver.findElement(By.xpath("//p[normalize-space()='Rs. 400']"));
		resultat_obtenu = resultat_attendu.getText();
		Assert.assertTrue(resultat_obtenu.equals(string));
		
		String resultat_obtenu1;
		WebElement resultat_attendu1 = driver.findElement(By.xpath("//button[normalize-space()='5']"));
		resultat_obtenu = resultat_attendu1.getText();
		Assert.assertTrue(resultat_obtenu.equals(string3));
		
		String resultat_obtenu11;
		WebElement resultat_attendu11 = driver.findElement(By.xpath("//p[normalize-space()='Rs. 2000']"));
		resultat_obtenu = resultat_attendu11.getText();
		Assert.assertTrue(resultat_obtenu.equals(string5));
		
		
		String resultat_obtenu2;
		WebElement resultat_attendu2 = driver.findElement(By.xpath("//p[normalize-space()='Rs. 1389']"));
		resultat_obtenu2 = resultat_attendu2.getText();
		Assert.assertTrue(resultat_obtenu2.equals(string2));
		String resultat_obtenu21;
		WebElement resultat_attendu21 = driver.findElement(By.xpath("//button[normalize-space()='2']"));
		resultat_obtenu21 = resultat_attendu21.getText();
		Assert.assertTrue(resultat_obtenu21.equals(string4));
		String resultat_obtenu210;
		WebElement resultat_attendu210 = driver.findElement(By.xpath("//p[normalize-space()='Rs. 2778']"));
		resultat_obtenu210 = resultat_attendu210.getText();
		Assert.assertTrue(resultat_obtenu210.equals(string6));
		
		System.out.println("Test Ok");
		
		
	}

	
}
