package assignmentweek4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String P = " ";
		List<String> sort = new ArrayList<String>();

		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Go to Mens Fashion
		WebElement men = driver.findElementByXPath("(//span[@class='catText'])[6]");
		Actions builder = new Actions(driver);
		builder.moveToElement(men).perform();
		
		//Go to Sports Shoes
		driver.findElementByXPath("(//div[@id='category6Data'])/div/div/div/p[2]/a").click();
		
		//Get the count of the sports shoes
		WebElement count = driver.findElementByXPath("//h1[@category='Sports Shoes']/span");
		System.out.println("Sports Shoes count is : " + count.getText());
		
		//Click Training shoes
		driver.findElementByXPath("//div[text()='Training Shoes']").click();
		
		//Sort by Low to High
		driver.findElementByXPath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']").click();
		driver.findElementByXPath("//li[@class='search-li']").click();
		Thread.sleep(1000);
		
		//Check if the items displayed are sorted correctly
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		for (int i = 0; i < price.size(); i++) {
			P = price.get(i).getText();
			// System.out.println(P);

		}
		if (P.equals(sort)) {
			System.out.println("Items displayed are sorted correctly");
		} else {
			System.out.println("Items displayed are not sorted correctly");

		}
		//filtered blue shoe
		driver.findElementByXPath("//label[@for='Color_s-Blue']").click();
		Thread.sleep(1000);
		
		//Mouse Hover on puma Blue Training shoes
		WebElement mouse = driver.findElementByXPath("//img[@title='VSS Blue Training Shoes']");
		builder.moveToElement(mouse).perform();
		
		//click QuickView button
		driver.findElementByXPath("//div[contains(text(),'Quick View')]").click();
		
		//Print the cost and the discount percentage
		WebElement cost = driver.findElementByXPath("//span[@class='payBlkBig']");
		String offer = cost.getText();
		offer = offer.replaceAll("[^\\d.]", "");
		WebElement discount = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		String Discount = discount.getText();
		System.out.println("Cost : " + offer + "\n" + "Discount : " + Discount);
		
		//Take the snapshot of the shoes.
		WebElement ss = driver.findElementByXPath("//img[@class='cloudzoom']");
		File scr = ss.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/snapdeal.png");
		FileUtils.copyFile(scr, dst);
		
		//Close the current window
		driver.findElementByXPath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]").click();
		Thread.sleep(1000);
		
		//Close the main window
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		
		//select the brand Puma
		driver.findElement(By.xpath("//label[@for='Brand-VSS']")).click();

	}

}