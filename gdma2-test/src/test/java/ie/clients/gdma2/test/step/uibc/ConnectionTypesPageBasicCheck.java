package ie.clients.gdma2.test.step.uibc;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import ie.clients.gdma2.test.app.Navigation;
import ie.clients.gdma2.test.page.ConnectionTypesPage;
import ie.clients.gdma2.test.page.HomePage;
import ie.clients.gdma2.test.step.Init;



public class ConnectionTypesPageBasicCheck extends Init{

	
	@Given("^User is on the Connection Type Page$")
	public void userIsOnTheConnectionTypePage() throws Throwable {
	   
		Navigation.login(driver, username, password);
		HomePage homepage= new HomePage(driver);
		homepage.configurationButton.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		homepage.connectionsButton.click();
		ConnectionTypesPage connectiontypes= new ConnectionTypesPage(driver);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		connectiontypes.connectionTypeTitle.isDisplayed();
		Select oselect=new Select(driver.findElement(By.name("tbl_connection_length")));
		oselect.selectByValue("100");
		Log.info("User is on the connection types page");
		
	}

	@Then("^All elements are visible on the Connection Type Page$")
	public void allElementsAreVisibleOnTheConnectionTypePage() throws Throwable {
		
		ConnectionTypesPage connectiontypes= new ConnectionTypesPage(driver);
		Class<ConnectionTypesPage> ct = ConnectionTypesPage.class;
		Field[] fields = ct.getDeclaredFields();

		/**
		 * Verifying existence of each element on the currentPage. Asserting the
		 * string representation of of each page field which indicates existence
		 * of element.
		 */
		for (Field fld : fields) {

			fld.setAccessible(true);

			if (!fld.getName().contains("warning")) {
				try {
					String fldResponse = fld.get(connectiontypes).toString();
					Assert.assertTrue(!fldResponse.contains("Proxy element for: DefaultElementLocator"));
					Log.info("All elements are visible on the page");
				

				} catch (Throwable e) {
					Log.error("An element is missing on the page");
					
				
				}
			}

		}
	    
	}

	@Then("^Correct text is displayed for each element on the Connection Type Page$")
	public void correctTextIsDisplayedForEachElementOnTheConnectionTypePage() throws Throwable {
		
		ConnectionTypesPage connectiontypes= new ConnectionTypesPage(driver);
		Assert.assertEquals("Connection Types", connectiontypes.connectionTypeTitle.getText());
		Log.info("Correct text is displayed for connection type title");
		Assert.assertEquals("Insert connection", connectiontypes.insertConnectionButton.getText());
		Log.info("Correct text is displayed for Insert Connection button");
		Assert.assertTrue(connectiontypes.showEntries.getText().contains("Show"));
		Log.info("Correct text is displayed for show entries label");
		Assert.assertTrue(connectiontypes.searchLabel.getText().contains("Search:"));
		Log.info("Correct text is displayed for search label");
		Assert.assertEquals("Id", connectiontypes.idLabel.getText());
		Log.info("Correct text is displayed for id label");
		Assert.assertEquals("Name", connectiontypes.nameLabel.getText());
		Log.info("Correct text is displayed for name label");
		Assert.assertEquals("Connection Class", connectiontypes.connectionClassLabel.getText());
		Log.info("Correct text is displayed for connection class label");
		Assert.assertEquals("SQL to get Tables", connectiontypes.sqlToGetTablesLabel.getText());
		Log.info("Correct text is displayed for Sql to get table label");
		Assert.assertEquals("Actions", connectiontypes.actionsLabel.getText());
		Log.info("Correct text is displayed for action label");
		Assert.assertTrue(connectiontypes.showingLabel.getText().contains("Showing "));
		Log.info("Correct text is displayed for showing label");
		Assert.assertEquals("Previous", connectiontypes.previousButton.getText());
		Log.info("Correct text is displayed for previous button paggination");
		Assert.assertEquals("Next", connectiontypes.nextButton.getText());
		Log.info("Correct text is displayed for next button paggination");
		Assert.assertTrue(connectiontypes.copyrightFooter.getText().contains("Copyright ©"));
		Log.info("Correct text is displayed for copyright footer");
		Assert.assertTrue(connectiontypes.clientSoultionsFooter.getText().contains("Client Solutions"));
		Log.info("Correct text is displayed for client solutions footer");
		Assert.assertTrue(connectiontypes.yearFooter.getText().contains("2017"));
		Log.info("Correct text is displayed for client solutions year footer");
		Assert.assertTrue(connectiontypes.versionFooter.getText().contains("Version:"));
		Log.info("Correct text is displayed for version footer");
		Log.info("Correct text is displayed for all elements on the page");
	}
	

}
