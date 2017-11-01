package ie.clients.gdma2.test.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import ie.clients.gdma2.test.page.LoginPage;

public class Navigation {
	
	public static void login(WebDriver driver, String username, String password) throws InterruptedException
	{
		LoginPage login=new LoginPage(driver);
		login.usernameField.sendKeys(username);
		login.passwordField.sendKeys(password);
		login.loginButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
	}

}
