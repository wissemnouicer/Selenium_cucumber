package testCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class DragAndDrop {

	public static void main(String[] args) {
		// chemin chromedriver
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		// ouvrir chrome
		WebDriver driver = new ChromeDriver();
        // maximaze
		driver.manage().window().maximize();
		// ouvrir URL
		driver.get("https://demoqa.com/droppable");
		// declaration
		WebElement bt_dragme;
		WebElement bt_drophere;
		// identification
		bt_dragme = driver.findElement(By.id("draggable"));
		bt_drophere = driver.findElement(By.id("droppable"));
		// action
		Actions action = new Actions (driver);
		action.dragAndDrop(bt_dragme, bt_drophere).perform();
		// resultat
		
		// verification txt
		String txt_attendu = "Dropped!";
		String txt_obtenu;
		WebElement resultat;
		resultat = driver.findElement(By.id("droppable"));
		txt_obtenu = resultat.getText();
		Assert.assertEquals(txt_attendu, txt_obtenu);
		System.out.println("test text est ok");
		// verification couleur
		String couleur_attendu = "rgba(70, 130, 180, 1)";
		String couleur_obtenu;
		couleur_obtenu = resultat.getCssValue("background-color");
		Assert.assertEquals(couleur_attendu, couleur_obtenu);
		System.out.println("test couleur est ok");
		System.out.println(couleur_obtenu);
		
		
	}

}
