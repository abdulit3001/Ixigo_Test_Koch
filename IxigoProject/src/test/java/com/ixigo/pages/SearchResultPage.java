package com.ixigo.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ixigo.pages.HomePage;

import junit.framework.Assert;

public class SearchResultPage {
	
	WebDriver driver = new ChromeDriver();
	
	@FindBy(how=How.XPATH, using="//div[text()='Non stop']")
	private WebElement nonStop;
	
	
	public void ValidateSearchResultPage()
	
	{
		
		WebDriverWait waitNew = new WebDriverWait(driver, 400);
		waitNew.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='stops']")));

		WebElement stop = driver.findElement(By.xpath("//div[@class='stops']"));
		WebElement earlyMorning = driver.findElement(By.xpath("(//div[text()='Early Morning'])[1]"));
		

		Assert.assertTrue(stop.isDisplayed());
		Assert.assertTrue(earlyMorning.isDisplayed());
		
		
	}

	public void ClickNonStop() {
		
		
		nonStop.click();
		
	}
	
	public void PrintDetails()  {
		
		List<WebElement> divs = driver.findElements(By.xpath("//div[@class='result-col-inner']/div[1]/div"));
	
		String fare = "";
		String airlines = "";
		String departTime = "";
		for (int i = 1; i <= divs.size(); i++) {
			fare = driver.findElement(By.xpath("//div[@class='result-col-inner']/div[" + i + "]/div[1]/div[5]"))
					.getText();
			int departamount = Integer.valueOf(fare);
			if (departamount < 5000) {
				airlines = driver
						.findElement(By.xpath("//div[@class='result-col-inner']/div[" + i + "]/div[1]/div[3]/div[4]"))
						.getText();
				departTime = driver
						.findElement(By.xpath("//div[@class='result-col-inner']/div[" + i + "]/div[1]/div[3]/div[1]"))
						.getText();
				System.out.println("flight < 5000:"+i);
				System.out.println("Airlines name:" + airlines + ", Fare:" + fare + ", departTime:" + departTime);
			}
		}

		
		List<WebElement> divReturn = driver.findElements(By.xpath("//*[@class='result-col']/div/div"));

		

		String returnfare = "";
		String returnairlines = "";
		String returnTime = "";
		for (int i = 1; i <= divReturn.size(); i++) {
			returnfare = driver.findElement(By.xpath("//div[@class='result-col']/div/div[" + i + "]/div[1]/div[5]"))
					.getText();
			int returnamount = Integer.valueOf(returnfare);
			if (returnamount < 5000) {

				returnairlines = driver
						.findElement(By.xpath("//div[@class='result-col']/div/div[" + i + "]/div[1]/div[3]/div[4]"))
						.getText();
				returnTime = driver
						.findElement(By.xpath("//div[@class='result-col']/div/div[" + i + "]/div[1]/div[3]/div[1]"))
						.getText();
				System.out.println("Return details flight < 5000:"+i);
				System.out.println(
						"Airlines name:" + returnairlines + ", Fare:" + returnfare + ", departTime:" + returnTime);
			}
		}
		
	}
	
	
	

}
