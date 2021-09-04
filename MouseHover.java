package assignmentweek4.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class MouseHover {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement mouse = driver.findElementByClassName("btnMouse");
		Actions builder = new Actions(driver);
		builder.moveToElement(mouse).perform();
		List<WebElement> link = driver.findElements(By.tagName("a"));
		for (WebElement links : link) {
			System.out.println(links.getText()+" : "+links.getAttribute("href"));
		}
		driver.findElementByLinkText("Selenium").click();
		Thread.sleep(500);
		driver.switchTo().alert().accept();

	}
}
