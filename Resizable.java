package assignmentweek4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Resizable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions builder=new Actions(driver);
		//WebElement frm1 = driver.findElementByXPath("//iframe[@class='demo-frame']");
		driver.switchTo().frame(0);
		WebElement mouse = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		WebElement box = driver.findElementById("resizable");
		System.out.println(box.getSize());
		builder.clickAndHold(mouse).moveToElement(box, 100, 100).release().perform();
	}

}