package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.openqa.selenium.WebElement;
import util.screens.BaseScreen;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class CountriesScreen extends BaseScreen {

    @AndroidFindBy(id="activityPlatformSelectionConfirmButton")
    private WebElement _confirmationBtnCountry;
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver
     */
    public CountriesScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }


    // Locators
    private static final String FIRST_LOCATOR = "com.myApp:id/someButton";
    private static final String SECOND_LOCATOR = "com.myApp:id/someList";

    // AndroidElements
    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(id = FIRST_LOCATOR + "SsomeOtherLocator")
    @AndroidFindBy(id = FIRST_LOCATOR)
    private AndroidElement optionColombia;

    public PrivacyDataScreen selectCountry(String country) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().textContains(\""+ country + "\").instance(0))").click();
        _confirmationBtnCountry.click();
        return new PrivacyDataScreen(driver);
    }
}
