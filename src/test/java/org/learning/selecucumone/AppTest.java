package org.learning.selecucumone;

import java.util.List;
//import org.learning.selecucumone.ShoppingHome;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
//import org.testng.Assert;
//import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

/**
 * Unit test for simple App.
 */

//@Test
public class AppTest{ 
    
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	WebDriver driver=null;
	ShoppingHome sHome=null;
	
	public AppTest(){
		System.setProperty("webdriver.chrome.driver", "c:\\SeleniumWebdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		sHome = new ShoppingHome(driver);
	}
	
	@When("^Shopping Home Page is opened in browser$")
	public void Shopping_Home_Page_is_opened_in_browser(){
		//System.out.println("iam in Shopping Home Page is opened in browse");
		//System.setProperty("webdriver.chrome.driver", "c:\\SeleniumWebdrivers\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		driver.manage().window().maximize();
		try {
			
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Unexpected error , Closing browser ");
			driver.close();
			e.printStackTrace();
			
		}
		finally{
			//System.out.println("No Finally Instructions ");
			
		}
			
	}
	
	@Then("^Asset Title of shopping home page$")
	public void Asset_Title_of_shopping_home_page(){
		String Pgtitle="";
		Pgtitle=driver.getTitle();
		Assert.assertEquals("My Store", Pgtitle);
		System.out.println("i am in Asset_Title_of_shopping_home_page ");
	}
	
	@Then("^Close the Browser$")
	public void close_the_Browser() {
		System.out.println("i am in close_the_Browser ");
		driver.close();
	}

	@Then("^Asset Shoppingcart Empty$")
	public void asset_Shoppingcart_Empty() {
	    // Write code here that turns the phrase above into concrete actions
		//WebElement Scart= driver.findElement(By.xpath("//div[@id='page']/div/header[@id='header']/div[3]/div/div/div[3]/div/a/span[5]"));
		WebElement Scart= sHome.Scart();
		Assert.assertEquals("(empty)", Scart.getText());
		System.out.println("asset_Shoppingcart_Empty in progress..... "+Scart.getText());
	    
	}
	
	@Then("^Asset Shoppingcart tooltip$")
	public void asset_Shoppingcart_tooltip() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Scart= driver.findElement(By.xpath("//div[@id='page']/div/header[@id='header']/div[3]/div/div/div[3]/div/a/span[5]"));
		WebElement Scarta= driver.findElement(By.xpath("//div[@id='page']/div/header[@id='header']/div[3]/div/div/div[3]/div/a"));
		System.out.println(Scarta.getAttribute("title"));
		//Actions A1 = new Actions(driver);
		//A1.moveToElement(Scart).build().perform();
		
		
	}
	
	@Then("^select Women section$")
	public void select_Women_section()  {
	    // Write code here that turns the phrase above into concrete actions
	   WebElement wmnEle=driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]/a[@title='Women']"));
	   wmnEle.click();
	}

	@Then("^verify sort by dropdown has instock option \"([^\"]*)\"$")
	public void verify_sort_by_dropdown_has_instock_option(String ddItem) {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverWait wdw = new WebDriverWait(driver,5);
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)");
		WebElement wmnselectEle=driver.findElement(By.xpath("//select[@id='selectProductSort']"));
		//wdw.until(ExpectedConditions.textToBePresentInElementValue(wmnselectEle, "In Stock"));
		//wdw.until(ExpectedConditions.visibilityOf(wmnselectEle));
		Select aSortDD = new Select(wmnselectEle);
		aSortDD.selectByVisibleText(ddItem);
		List<WebElement> sortItems = aSortDD.getOptions();
		System.out.println("First item = " + sortItems.get(1).getText());
	}
	
	
}
