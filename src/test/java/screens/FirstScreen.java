package screens;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

import org.pmw.tinylog.Logger;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.screens.BaseScreen;

/**
 * Description:
 *
 */
public class FirstScreen extends BaseScreen {

	/**
	 * Constructor method.
	 * 
	 * 
	 * @param driver : AndroidDriver
	 */
	public FirstScreen(AndroidDriver<AndroidElement> pDriver) {
		super(pDriver);
	}

	// Locators
	private static final String FIRST_LOCATOR = "com.myApp:id/someButton";
	private static final String SECOND_LOCATOR = "com.myApp:id/someList";

	// AndroidElements
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(id = FIRST_LOCATOR + "SsomeOtherLocator")
	@AndroidFindBy(id = FIRST_LOCATOR)
	private AndroidElement buttonOfSomething;

	@AndroidFindBy(id = SECOND_LOCATOR)
	private AndroidElement listOfSomething;

	/**
	 * Returns a SecondScreen after to do something.
	 * 
	 * 
	 * @return SecondScreen
	 */
	public SecondScreen returnSecondScreen() {
		// code
		return new SecondScreen(driver);
	}

	/**
	 * Click on button.
	 * 
	 */
	public void tabOnButton() {
		Logger.info("Alert Message: " + buttonOfSomething.getText());
		buttonOfSomething.click();
	}

	public void someInstructions() {
		// code.
	}
}