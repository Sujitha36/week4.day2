package assignmentweek4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Sortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		WebElement frm = driver.findElementByXPath("//li[@class='ui-state-default ui-sortable-handle']");
		WebElement to = driver.findElementByXPath("(//li[@class='ui-state-default ui-sortable-handle'])[5]");
		Point p=to.getLocation();
		int x=p.getX();
		int y=p.getY();
		Actions builder=new Actions(driver);
		builder.dragAndDropBy(frm, x, y).perform();
		System.out.println("Item sortted");
	}

}