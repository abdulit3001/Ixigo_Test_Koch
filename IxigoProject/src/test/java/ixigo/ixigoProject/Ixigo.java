package ixigo.ixigoProject;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ixigo.pages.HomePage;
import com.ixigo.pages.SearchResultPage;



public class Ixigo  {

	public HomePage homePage;
	public SearchResultPage searchResultPage;
	
	
    WebDriver driver;
	
    @Test
	public void login() throws Exception {
		
    	homePage.LoginIxigo();
    	homePage.ValidatePage();
    	homePage.EnterDetails();
    	searchResultPage.ValidateSearchResultPage();
    	searchResultPage.ClickNonStop();
    	searchResultPage.PrintDetails();		
	}
}
