package org.stepDefinition;

import org.test.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pojoClasses.LoginPOJO;

public class FacebookTask extends BaseClass {
	 LoginPOJO l;

	@Given("User has to launch the chrome browser and max the window")
	public void user_has_to_launch_the_chrome_browser_and_max_the_window() {
	    browserLaunch();
	}

	@When("User has o launch the fb applicaion in browser")
	public void user_has_o_launch_the_fb_applicaion_in_browser() {
	   launchUrl("https://www.facebook.com/");
	}

	@When("User has to pass invalid username in email field")
	public void user_has_to_pass_invalid_username_in_email_field() {
	  
		 l = new LoginPOJO();
	     userName(l.getEmailTxt(), "Selenium@gmail.com");
	} 

	@When("User has to pass invalid password in password field")
	public void user_has_to_pass_invalid_password_in_password_field() {
		
		passWord(l.getPassTxt(), "12345678");
	}

	@When("User has to click the login browser")
	public void user_has_to_click_the_login_browser() {
		
		l.getLoginBtn().click();
	}

	@Then("User has to close the browser")
	public void user_has_to_close_the_browser() {
	   driver.quit();
	}

	
	
}
