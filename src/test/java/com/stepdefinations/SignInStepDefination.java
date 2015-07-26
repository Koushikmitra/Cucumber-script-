package com.stepdefinations;

import gargiCucumberproject.common.ShareDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.actions.SignInGmail;
import com.pages.Homepage;

import cucumber.api.java.en.Given;

//import cucumber.api.java.en.Given;

public class SignInStepDefination {

	public WebDriver driver;
	
	public SignInStepDefination(ShareDriver driver){
	  this.driver=driver;	
	}
	
@Given("^I am in the login pages$")
public void i_enter_valid_credentials() throws Throwable{
//Write code here that turns the phrase above into concrete actions
	PageFactory.initElements(driver,Homepage.class);
	SignInGmail.execute();
	
}


}
