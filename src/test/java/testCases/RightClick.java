package testCases;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class RightClick {

	public static void main(String[] args) {
		// chemin chromedriver
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		// ouvrir chrome
		WebDriver driver = new ChromeDriver();
		// maximaze
		driver.manage().window().maximize();
		// ouvrir URL
		driver.get("https://demoqa.com/buttons");
		
		// declaration
		WebElement bt_RightClick;
		// identification
		bt_RightClick = driver.findElement(By.id("rightClickBtn"));
		//actions
		Actions action = new Actions(driver);
		action.contextClick(bt_RightClick).perform();
		
		// verification
		String msg_attendu = "You have done a right click";
		String msg_obtenu;
		WebElement txt_resultat;
		txt_resultat = driver.findElement(By.id("rightClickMessage"));
		msg_obtenu = txt_resultat.getText();
		Assert.assertEquals(msg_attendu, msg_obtenu);
		System.out.println("test ok");
		
	}

}
