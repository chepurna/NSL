package org.learning.selecucumone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingHome1 {
	
	WebDriver driver;
	//By ScartRef = By.xpath("//div[@id='page']/div/header[@id='header']/div[3]/div/div/div[3]/div/a/span[5]");
	@FindBy(xpath="//div[@id='page']/div/header[@id='header']/div[3]/div/div/div[3]/div/a/span[5]")
	WebElement Scart;
	
	//WebElement Scart= driver.findElement();
	public ShoppingHome1(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement Scart(){
		//return driver.findElement(ScartRef);
		return Scart;
	}
	

}
