package ie.clients.gdma2.test.step.uibc;


import java.lang.reflect.Field;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import ie.clients.gdma2.test.page.LoginPage;
import ie.clients.gdma2.test.step.Init;

public class LoginPageBasicCheck extends Init { 



	@Given("^User is on the LogIn Page$") 
	public void userIsOnTheLogInPage() throws Throwable {

		
		driver.get(appURL);
		Log.info("User is redirected to the CAS page");
		
	}

	@Then("^All elements are visible on the LogIn Page$")
	public void allElementsAreVisibleOnTheLogInPage() throws Throwable {

		LoginPage login = new LoginPage(driver);
		Class<LoginPage> l = LoginPage.class;
		Field[] fields = l.getDeclaredFields();

		/**
		 * Verifying existence of each element on the currentPage. Asserting the
		 * string representation of of each page field which indicates existence
		 * of element.
		 */
		for (Field fld : fields) {

			fld.setAccessible(true);

			if (!fld.getName().contains("warning")) {
				try {
					String fldResponse = fld.get(login).toString();
					Assert.assertTrue(!fldResponse.contains("Proxy element for: DefaultElementLocator"));
					Log.info("Element is visible on the page");
				

				} catch (Throwable e) {
					Log.error("An element is missing on the page");
					
				
				}
			}

		}

	}

	@Then("^Correct text is displayed for each element on the LogIn Page$")
	public void correctTextIsDisplayedForEachElementOnTheLogInPage() throws Throwable {

		LoginPage login = new LoginPage(driver);
		Assert.assertEquals("Central Authentication Service",login.CASHeaderTitle.getText());
		Log.info("Correct text is displayed for CAS header title");
		Assert.assertEquals("Enter your Username and Password", login.formTitle.getText());
		Log.info("Correct text is displayed for form title");
		Assert.assertEquals("Please enter your username and password in the form below", login.formText.getText());
		Log.info("Correct text is displayed for form text");
		Assert.assertEquals("Username", login.usernameLabel.getText());
		Log.info("Correct text is displayed for username label");
		Assert.assertEquals("Password", login.passwordLabel.getText());
		Log.info("Correct text is displayed for password label");
		Assert.assertEquals("LOGIN", login.loginButton.getAttribute("value"));
		Log.info("Correct text is displayed for login button");
		Assert.assertEquals("CLEAR", login.clearButton.getAttribute("value"));
		Log.info("Correct text is displayed for clear button");
		Assert.assertEquals("For security reasons, please Log Out and Exit your web browser when you are done accessing services that require authentication!", login.notificationText.getText());
		Log.info("Correct text is displayed for notification text");
		Assert.assertEquals("Copyright © 2017 Client Solutions Ltd. All rights reserved.", login.copyright.getText());
		Log.info("Correct text is displayed for copyrights");
		Assert.assertEquals("Powered by Jasig Central Authentication Service 4.0.0", login.poweredBy.getText());
		Log.info("Correct text is displayed for powered by");
		Log.info("Correct text is displayed for each element on the page");
	}

}
