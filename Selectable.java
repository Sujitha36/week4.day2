package assignmentweek4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.interactions.Actions;

public class Selectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions builder=new Actions(driver);
		driver.switchTo().frame(0);
		WebElement frm = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement to = driver.findElementByXPath("//li[text()='Item 5']");
		builder.clickAndHold(frm).moveToElement(to).release().perform();
		driver.switchTo().defaultContent();

		
	}

}