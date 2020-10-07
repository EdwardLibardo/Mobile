package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import util.screens.BaseScreen;

public class ConfigurationPrivacyData extends BaseScreen {

    @AndroidFindBy(id = "activityDataManagerAppsFlyerCheckbox")
    private WebElement _appsFlyerCheckbox;

    @AndroidFindBy(id = "activityDataManagerFirebaseCheckbox")
    private WebElement _gtmFirebaseCheckbox;

    @AndroidFindBy(id = "activityDataManagerFacebookCheckbox")
    private WebElement _facebookCheckbox;

    @AndroidFindBy(id = "activityDataManagerSaveButton")
    private WebElement _saveBtn;

    public ConfigurationPrivacyData(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    public ConfigurationPrivacyData enableGTMFirebaseCheckbox(boolean enable) {
        enableCheckbox(_gtmFirebaseCheckbox, enable);
        return this;
    }


    public ConfigurationPrivacyData enableAppsFlyerCheckbox(boolean enable) {
        enableCheckbox(_appsFlyerCheckbox, enable);
        return this;
    }

    public ConfigurationPrivacyData enableFacebookCheckbox(boolean enable) {
        enableCheckbox(_facebookCheckbox, enable);
        return this;
    }

    public SettingsScreen clickOnSaveButton() {
        _saveBtn.click();
        return new SettingsScreen(driver);
    }

    private void enableCheckbox(WebElement element, boolean enable) {
        element.isDisplayed();
        if (!enable) {
            element.click();
        }  //do nothing
    }

}
