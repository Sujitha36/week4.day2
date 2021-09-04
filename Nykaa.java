package assignmentweek4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;


public class Nykaa {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement brnd = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder=new Actions(driver);

		//2) Mouseover on Brands and Mouseover on Popular
		builder.moveToElement(brnd).perform();
		WebElement pop= driver.findElementByXPath("//a[text()='Popular']");
		builder.moveToElement(pop).perform();

		//3) Click L'Oreal Paris
		driver.findElement(By.xpath("//div[@id='brandCont_Popular']//li[5]/a")).click();
		
		//4) Go to the newly opened window and check the title contains L'Oreal Paris
		Set<String> WH1 = driver.getWindowHandles();
		List<String> L=new ArrayList<String>(WH1);
		driver.switchTo().window(L.get(1));
		String title=driver.getTitle();
		if (title.contains("L'Oreal")) {
			System.out.println("Title contains L'Oreal");
		}
		
		// Click sort By and select customer top rated
			driver.findElementByXPath("//span[@class='pull-left']").click();
			driver.findElementByXPath("(//div[@class='control__indicator radio'])[4]").click();
			Thread.sleep(1000);
			
			//Click Category and click Shampoo
			driver.findElementByXPath("(//div[@class='clearfix'])[2]").click();
			driver.findElementByXPath("//span[text()='Hair']").click();
			driver.findElementByXPath("//span[text()='Hair Care']").click();
			driver.findElementByXPath("//span[text()='Shampoo']//following::div[1]").click();
			
			//check whether the Filter is applied with Shampoo
			WebElement fltr = driver.findElement(By.xpath("//div[@class='filter-applied']//following::li[1]"));
			String s=fltr.getText();
			if (s.contains("Shampoo")) {
				System.out.println("Filters applied with : "+fltr.getText());
					}
			else {
				System.out.println("Wrong filters applied");
			}
			
			//Click on L'Oreal Paris Colour Protect Shampoo
			driver.findElementByXPath("(//div[@class='clearfix'])[2]").click();
			driver.findElement(By.xpath("(//div[@class='clearfix'])[8]")).click();
			driver.findElement(By.xpath("//span[text()='Color Protection']//following::div")).click();
			Thread.sleep(1000);
			
			//GO to the new window and select size as 175ml
			driver.findElementByXPath("(//div[@class='m-content__product-list__title'])[1]/h2").click();
			Set<String> wh2 = driver.getWindowHandles();
			List<String>WH2=new ArrayList<String>(wh2);
			driver.switchTo().window(WH2.get(2));
			driver.findElement(By.xpath("//span[text()='175ml']")).click();

			//Print the MRP of the product
			WebElement Price=driver.findElementByXPath("//div[@class='price-info']");
			System.out.println("Product Price "+Price.getText());
			
			//Click on ADD to BAG
			driver.findElement(By.xpath("(//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  '])[1]")).click();
			Thread.sleep(1000);

			//Go to Shopping Bag 
			driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
			
			//Print the Grand Total amount
			WebElement grand = driver.findElement(By.xpath("//div[@class='value medium-strong']"));
			Thread.sleep(1000);
			String gtotal=grand.getText();
			System.out.println("Grand total is : "+gtotal);
			Thread.sleep(7000);
			
			//Click Proceed
			driver.findElement(By.xpath("//div[@class='second-col']")).click();
			
			//Click on Continue as Guest
			driver.findElement(By.xpath("//button[@class='btn full big']")).click();
			
			//Check if this grand total is the same in step 13
			WebElement finalgrand = driver.findElement(By.xpath("//div[text()='Grand Total']/following::div"));
			String finalgt=finalgrand.getText();
			boolean check=gtotal.contains(finalgt);
			if (check=true) {
				System.out.println("Grand Total is correct");
			}
			else {
				System.out.println("Grand Total is incorrect");
			}
			
			//Close all windows
			/*
			 * driver.close(); driver.switchTo().window(WH2.get(1)); driver.close();
			 * driver.switchTo().window(L.get(0)); driver.close();
			 */
			driver.quit();
			
	
	}
	}

