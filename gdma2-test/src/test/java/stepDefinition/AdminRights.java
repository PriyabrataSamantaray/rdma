package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;

import appModules.Navigation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class AdminRights extends Init{

  
	@Given("^Log in as admin user$")
	public void log_in_as_admin_user() throws Throwable {
	    
		Navigation.login(driver, username, password);
		Log.info("User logged in as admin user");
	}

	@Then("^Admin user is able to see configuration button$")
	public void admin_user_is_able_to_see_configuration_button() throws Throwable {
		
		 Assert.assertTrue("Configuration button is displayed on the page", driver.findElement(By.id("btn-admin")).isDisplayed());
		 Log.info("Admin user can see configuration button");
	  
	}

}
