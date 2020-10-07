package util.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.CustomWait;

import static java.lang.String.format;

import org.openqa.selenium.support.PageFactory;
import org.pmw.tinylog.Logger;

/**
 * Base class for all Screen Objects.
 * 
 */
public abstract class BaseScreen {
	/** The driver. */
	protected AndroidDriver<AndroidElement> driver;
	protected CustomWait customWait = new CustomWait();
	private static final int PERCENT = 100;

	/**
	 * Constructor method for standard screen object.
	 * 
	 * @param driver : AndroidDriver
	 */
	public BaseScreen(AndroidDriver<AndroidElement> pDriver) {
		this.driver = pDriver;
		initElements();
	}

	/**
	 * Page factory.
	 */
	private void initElements() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/**
	 * Tab on back button.
	 */
	public void tapBack() {
		driver.navigate().back();
	}

	/**
	 * Scroll to the text attribute received by parameter.
	 *
	 * @param text : String
	 */
	public void scrollToText(String text) {
		String automator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"%s\"))";
		AndroidElement textOnElement = driver.findElementByAndroidUIAutomator(format(automator, text));
		Logger.info(textOnElement.getText());
	}

}
