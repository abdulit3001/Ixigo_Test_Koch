package com.ixigo.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
//import resources.base;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class HomePage {

	WebDriver driver = new ChromeDriver();
	
	@FindBy(how=How.XPATH, using="(//input[@placeholder= 'Enter city or airport'])[1]")
	private WebElement from;
	
	@FindBy(how=How.XPATH, using="(//input[@placeholder= 'Enter city or airport'])[2]")
	private WebElement to;
	
	
	@FindBy(how=How.XPATH, using="//button[text()= 'Search']")
	private WebElement btn_Search;
	
	public void LoginIxigo()
	{
	   System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Ixigo_Test\\IXIGO Project\\chromedriver.exe");  
	   driver.get("https://www.ixigo.com"); // URL in the browser
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	
	}
	
	public void ValidatePage()
	
	{
		
		String windowtitle = driver.getTitle();
		System.out.println("windowtitle:" + windowtitle);
		Assert.assertTrue(windowtitle.contains("ixigo"));
		System.out.println("ixigo page validated");
		
	}
	
	
	public void EnterDetails() throws Exception
	
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Round Trip']"))));
		driver.findElement(By.xpath("//span[text()='Round Trip']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@placeholder= 'Enter city or airport'])[1]")).click();
		from.sendKeys("PUNE");
		from.sendKeys(Keys.ENTER);
        System.out.println("pune inserted:" + from.getAttribute("value"));
		Assert.assertTrue(from.getAttribute("value").contains("Pune"));
		System.out.println("Pune selected");
		to.sendKeys("Hyderabad");
		Thread.sleep(2000);
		to.sendKeys(Keys.ENTER);
		System.out.println("hyderabad inserted:" + to.getAttribute("value"));
		Assert.assertTrue(to.getAttribute("value").contains("Hyderabad"));
		System.out.println("Hyderabad selected");
		driver.findElement(By.xpath("//input[@placeholder='Depart']")).click();
		
		
        WebElement NovMonth = driver.findElement(By.xpath("//div[text()='November 2020']"));
		System.out.println("Nov selected");
		List<WebElement> tableRows = NovMonth.findElements(By.xpath("//table[@class='rd-days']/tbody/tr"));
        WebElement departureDate = tableRows.get(3).findElement(By.xpath("//td[@data-date='17112020']/div[1]"));
        departureDate.click();
        
        WebElement passengers = driver.findElement(By.xpath("//div[text()='Travellers | Class']"));
		Actions act = new Actions(driver);
		act.moveToElement(passengers).build().perform();

		driver.findElement(By.xpath("//div[text()='Travellers | Class']")).click();

		driver.findElement(By.xpath("(//span[@data-val='2'])[1]")).click();
		
	    driver.findElement(By.xpath("//div[@class='close-btn u-pos-abs ixi-icon-cross']")).click();

		driver.findElement(By.xpath("//*[@placeholder='Return']")).click();
		
		WebElement DecMonth = driver.findElement(By.xpath("//div[text()='December 2020']"));

		List<WebElement> tableRows1 = DecMonth.findElements(By.xpath("//table[@class='rd-days']/tbody/tr"));
   
		WebElement returnDate = tableRows1.get(4).findElement(By.xpath("//td[@data-date='24122020']/div[1]"));
		
		driver.findElement(By.xpath("//*[@placeholder='Return']")).click();
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", returnDate);

		btn_Search.click();
		

	}
	
	
	
	
	
}
