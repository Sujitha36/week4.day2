package assignmentweek4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Dropelement {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drop.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement drag = driver.findElementById("draggable");
		System.out.println(drag.getText());
		WebElement drop = driver.findElementById("droppable");
		System.out.println(drop.getText());
		Actions builder= new Actions(driver);
		builder.dragAndDrop(drag, drop).perform();
		System.out.println(drop.getText());

}}
