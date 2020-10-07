package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import util.screens.BaseScreen;

public class PrivacyDataScreen extends BaseScreen {
    @AndroidFindBy(id = "activityCookieConsentContentTitleTextView")
    private WebElement _title;

    @AndroidFindBy(id = "activityCookieConsentContentAcceptButton")
    private WebElement _acceptBtn;

    @AndroidFindBy(id = "activityCookieConsentContentBody1TextView")
    private WebElement _textOfFirstParagraph;

    @AndroidFindBy(id = "activityCookieConsentContentBody2TextView")
    private WebElement _textOfSecondParagraph;

    @AndroidFindBy(id = "activityCookieConsentContentBody3TextView")
    private WebElement _textOfThirdParagraph;

    private final String _firstParagraph = "Creemos que mereces la mejor experiencia posible cuando usas trivago.";
    private final String _secondParagraph = "Por ello, nosotros y los sitios web de nuestros socios externos " +
            "compartimos y recopilamos datos, y usamos cookies y otras tecnologías para funcionamiento del sitio," +
            " seguimiento, análisis y publicidad personalizada dentro y fuera de trivago.";
    private final String _thirdParapraph = "Si estás de acuerdo, confirma tu consentimiento haciendo clic en “Aceptar " +
            "todo” o personaliza tus preferencias en la configuración de privacidad de tus datos.";

    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver
     */
    public PrivacyDataScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    public DestinationScreen acceptPrivacyData() {
        Assert.assertTrue(_title.getText().contains("Privacidad de datos"));
        Assert.assertTrue(_textOfFirstParagraph.getText().contains(_firstParagraph));
        Assert.assertTrue(_textOfSecondParagraph.getText().contains(_secondParagraph));
        Assert.assertTrue(_textOfThirdParagraph.getText().contains(_thirdParapraph));
        _acceptBtn.click();
        //Assert.assertEquals(false, _title.isDisplayed());
        return new DestinationScreen(driver);
    }
}
