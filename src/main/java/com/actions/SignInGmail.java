package com.actions;

//import org.openqa.selenium.WebDriver;

import com.pages.Homepage;


public class SignInGmail {

	
	public static void execute() throws Exception{
		try{
	Homepage.sign_in.click();
	Homepage.login_id.sendKeys("");
	Homepage.next.click();
	Homepage.pwd.sendKeys("");
	Homepage.signtogmail.click();
	}catch(Exception e){
	
		System.out.println("Sign in to Gmail unsuccessful");
		throw(e);
	}
	}

}
