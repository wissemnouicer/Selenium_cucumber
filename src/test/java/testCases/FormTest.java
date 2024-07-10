package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormTest {

	public static void main(String[] args) throws InterruptedException {

		
		// appel WebDriverManager
		WebDriverManager.chromedriver().setup();
		// ouvrir chrome
		WebDriver driver = new ChromeDriver();
		// maximaze
		driver.manage().window().maximize();
		// implicity wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// ouvrir URL
	    driver.get("https://demoqa.com/automation-practice-form");
		
		
		// declaration et identification et action
		WebElement case_Name = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		case_Name.sendKeys("wissem");
		WebElement case_Lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
		case_Lastname.sendKeys("nouicer");
		WebElement case_Email = driver.findElement(By.id("userEmail"));
		case_Email.sendKeys("nouicerwissem@gmail.com");
		WebElement bt_gender = driver.findElement(By.id("gender-radio-1"));
		Actions action = new Actions(driver);
		action.click(bt_gender).perform();
		
		// défiler la page web
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement cha_subjects;
		cha_subjects = driver.findElement(By.id("subjectsInput"));
		executor.executeScript("window.scrollBy(0, 400);", cha_subjects);
		
		// declaration et identification et action
		WebElement case_mobile = driver.findElement(By.id("userNumber"));
		case_mobile.sendKeys("5000000102");
		// sleep 5s
		Thread.sleep(5000);
		
		// calendrier date de naissance
		driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
		WebElement ld_year = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		action.click(ld_year).perform();
		String year = "1978";
		Select select_year = new Select (ld_year);
		select_year.selectByValue(year);
		// sleep 3s
		Thread.sleep(3000);
		
		WebElement ld_month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		action.click(ld_month).perform();
		String month = "9";
		Select select_month = new Select (ld_month);
		select_month.selectByValue(month);
		driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--029 react-datepicker__day--weekend']")).click();
		
		
		// declaration et identification et action
		WebElement bt_hobsports;
		bt_hobsports = driver.findElement(By.id("hobbies-checkbox-1"));
		action.click(bt_hobsports).build().perform();
		WebElement bt_hobreading;
		bt_hobreading = driver.findElement(By.id("hobbies-checkbox-2"));
		action.click(bt_hobreading).build().perform();
		
		WebElement bt_hobmusique;
		bt_hobmusique = driver.findElement(By.id("hobbies-checkbox-3"));
		action.click(bt_hobmusique).build().perform();
		cha_subjects.sendKeys("test subjects");
		
		WebElement cha_adress;
		cha_adress = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
		cha_adress.sendKeys("maison 55, rue 88, tunis");
		
		WebElement select_state;
		select_state = driver.findElement(By.xpath("//div[text()='Select State']"));
		action.click(select_state).perform();
		WebElement state_NCR;
		state_NCR = driver.findElement(By.id("react-select-3-input"));
		action.click(state_NCR).perform();
		
		
		
		
		WebElement submit = driver.findElement(By.id("submit"));
		action.click(submit).perform();
		

		System.out.println("saisie est ok");

	}

}
