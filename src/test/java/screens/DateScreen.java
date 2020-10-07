package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import util.screens.BaseScreen;

public class DateScreen extends BaseScreen {

    @AndroidFindBy(className = "android.widget.TextView")
    private WebElement _title;

    @AndroidFindBy(id = "activityDatesSelectionCalendarApplyTextView")
    private WebElement _confirmBtnDate;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
            ".scrollIntoView(new UiSelector().textContains(\"diciembre de 2020\").instance(0))")
    private WebElement _scrollingToDecember;


    String _date = "new UiSelector().textContains(\"number\")";

    public DateScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    public LandingScreen selectingDateToBookTheHotel(String sinceDateParameter, String untilDateParameter) {
        Assert.assertTrue(_title.getText().contains("Seleccionar fechas"));
        Assert.assertTrue(_confirmBtnDate.getText().contains("Confirmar fechas"));
        Assert.assertTrue(_confirmBtnDate.isEnabled());
        _scrollingToDecember.isDisplayed();
        String sinceDate = _date.replace("number", sinceDateParameter);
        driver.findElementByAndroidUIAutomator(sinceDate).click();
        String untilDate = _date.replace("number", untilDateParameter);
        driver.findElementByAndroidUIAutomator(untilDate).click();
        _confirmBtnDate.click();
        return new LandingScreen(driver);
    }

}
