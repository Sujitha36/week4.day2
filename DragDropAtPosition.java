package assignmentweek4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class DragDropAtPosition {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drag.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement po = driver.findElement(By.id("content"));
		Point p=po.getLocation();
		int x=(p.getX());
		int y=(p.getY());
		Actions builder=new Actions(driver);
		WebElement drag = driver.findElementById("draggable");
		builder.dragAndDropBy(drag, x, y).perform();
	}
}
