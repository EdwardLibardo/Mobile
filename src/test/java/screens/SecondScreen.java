package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

/**
 * Object of SecondScreen.
 * 
 **/
public class SecondScreen extends BaseScreen {

	/**
	 * Constructor method.
	 *
	 *
	 * @param androidDriver
	 *            : AndroidDriver
	 */
	public SecondScreen(AndroidDriver<AndroidElement> pDriver) {
		super(pDriver);
	}

	// AndroidElements
	@AndroidFindBy(id = "com.app.example:id/category_list")
	protected AndroidElement listOne;
	@AndroidFindBy(id = "com.app.example:id/button_one")
	private AndroidElement buttonOne;
	
	public void flowInsideSecondScreen() {
		// TODO Auto-generated method stub
		
	}

}
