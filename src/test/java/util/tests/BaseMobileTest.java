package util.tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.pmw.tinylog.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import screens.CountriesScreen;
import screens.DestinationScreen;
import screens.FirstScreen;
import screens.LandingScreen;
import util.ConfigCapabilities;

/**
 * Base class for Test classes.
 * 
 */
public abstract class BaseMobileTest {

	private AndroidDriver<AndroidElement> driver;
	protected FirstScreen firstScreen;

	/**
	 * SetUp before to run suite of test.
	 * 
	 * @author Arley.Bolivar
	 * 
	 */
	@BeforeMethod(alwaysRun = true)
	public void environmentSetUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		ConfigCapabilities.deviceSetUp(capabilities);
		ConfigCapabilities.applicationSetUp(capabilities);
		try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException exception) {
			Logger.error(exception.getMessage(), exception);
		}
	}

	/**
	 * Close the application after completing the test.
	 * 
	 */
	@AfterMethod(alwaysRun = true)
	public void mobileApplicationEnd() {
		 driver.quit();
	}

	/**
	 * returns FirstScreen.
	 * 
	 * @author Arley.Bolivar
	 * 
	 * @return FirstScreen
	 */
	protected FirstScreen returnFirstScreen() {
		return new FirstScreen(driver);
	}

	protected CountriesScreen returnCountriesScreen(){
		return new CountriesScreen(driver);
	}

	protected DestinationScreen returnDestinationScreen(){
		return new DestinationScreen(driver);
	}

	protected LandingScreen returnLandingScreen(){
		return new LandingScreen(driver);
	}
}
