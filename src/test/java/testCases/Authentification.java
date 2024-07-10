package testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Authentification {

	public static void main(String[] args) throws InterruptedException {
		// Chemin ChromeDriver
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		// ouvrir chrome
		WebDriver driver = new ChromeDriver();
		// maximaze
		driver.manage().window().maximize();
		// ouvrir URL
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// sleep 5s
		Thread.sleep(5000);
		// donnée
		String user = "Admin";
		String mdp = "admin123";
		// declaration et identification
		WebElement txt_username = driver.findElement(By.xpath("//input[@name='username' and @placeholder='Username']"));
		WebElement txt_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		WebElement bt_login = driver.findElement(By.xpath("//button[@type='submit']"));
		// action
		txt_username.sendKeys(user);
		txt_password.sendKeys(mdp);
		bt_login.click();
		// sleep 3s
		Thread.sleep(3000);
		// resultat
		String resultat_attendu = "Aston4173 some";
		String resultat_obtenu;
		WebElement resultat_user = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
		resultat_obtenu = resultat_user.getText();
		Assert.assertEquals(resultat_attendu, resultat_obtenu);
		System.out.println("test est ok");
		

	}

}
