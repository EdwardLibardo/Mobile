package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import util.screens.BaseScreen;

public class DestinationScreen extends BaseScreen {

    @AndroidFindBy(id="fragmentHomeExpandedDealformDestinationTextView")
    private WebElement _destinationLabel;

    @AndroidFindBy(id="activitySearchDestinationSearchEditText")
    private WebElement _destinationTextBox;

    //This element contains the text Colombia, because we want to look for Cartagena in colombia, and there are other options
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Colombia\")")
    private WebElement _cityOption;

    public DestinationScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    public DestinationScreen clckOnTextBox(){
        _destinationLabel.click();
        return this;
    }

    public DateScreen writeTheCity(String city) throws InterruptedException {
        _destinationTextBox.sendKeys(city);
        Thread.sleep(3000);
        _cityOption.click();
        return new DateScreen(driver);
    }
}
