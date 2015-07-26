package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Homepage {
	
	public WebDriver driver;
	
	public Homepage(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='gmail-sign-in']")
	public static WebElement sign_in;
	
	@FindBy(how=How.ID,using="Email")
	public static WebElement login_id;
	
	@FindBy(how=How.ID,using="next")
	public static WebElement next;
	
	@FindBy(how=How.ID,using="Passwd")
	public static WebElement pwd;
	
	@FindBy(how=How.ID,using="signIn")
	public static WebElement signtogmail;
	
	
	
	

}
