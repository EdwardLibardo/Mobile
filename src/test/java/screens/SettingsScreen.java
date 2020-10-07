package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import util.screens.BaseScreen;

public class SettingsScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
            ".scrollIntoView(new UiSelector().textContains(\"Configurar privacidad de datos\").instance(0))")
    private WebElement _configPrivacyDataBtn;

    @AndroidFindBy(className = "android.widget.TextView")
    private WebElement _titleText;


    public SettingsScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    public ConfigurationPrivacyData clickOnConfigurationOfPrivacyData() {
        _configPrivacyDataBtn.click();
        Assert.assertTrue(_titleText.getText().contains("Configurar privacidad de datos"));
        return new ConfigurationPrivacyData(driver);
    }
}
