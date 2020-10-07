package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import util.screens.BaseScreen;

public class LandingScreen extends BaseScreen {

    @AndroidFindBy(id = "action_home")
    private WebElement _searchLabel;

    @AndroidFindBy(id = "action_explore")
    private WebElement _surprisingLabel;

    @AndroidFindBy(id = "action_favourites")
    private WebElement _favoritesLabel;

    @AndroidFindBy(id = "action_settings")
    private WebElement _settingsLabel;

    public LandingScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    public LandingScreen verifyTheNavigationBar() {
        _searchLabel.isDisplayed();
        _surprisingLabel.isDisplayed();
        _favoritesLabel.isDisplayed();
        _settingsLabel.isDisplayed();
        return this;
    }

    public SettingsScreen clickOnSettings() {
        _settingsLabel.click();
        _settingsLabel.isEnabled();
        return new SettingsScreen(driver);
    }
}
