package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import screens.*;
import util.tests.BaseMobileTest;

public class SomeTest extends BaseMobileTest {

    LandingScreen _landingScreen;

    /*@Parameters({"someParameter", "someParameter"})
    @Test(groups = {"someGroup"})
    public void someTest() {
        FirstScreen nameOfMyFirstScreen = returnFirstScreen();
        nameOfMyFirstScreen.someInstructions();
        SecondScreen nameOfMySecondScreen = nameOfMyFirstScreen.returnSecondScreen();
        nameOfMySecondScreen.flowInsideSecondScreen();
    }*/
    @Test(groups = {"FirstTest"})
    public void acceptingPrivacyDataTest() {
        CountriesScreen countriesScreen = returnCountriesScrenn();
        PrivacyDataScreen privacyDataScreen = countriesScreen.selectCountry("Colombia");
        privacyDataScreen.acceptPrivacyData();
    }

    @Test(dependsOnMethods = {"acceptingPrivacyDataTest"}, groups = {"trivago"})
    public void lookingForHotel() {
        //acceptingPrivacyDataTest();
        DestinationScreen destinationScreen = returnDestinationScreen();
        DateScreen dateScreen = destinationScreen.clckOnTextBox().writeTheCity("Cartagena");
        dateScreen.selectingDateToBookTheHotel("1", "5");
    }

    @Test(groups = {"ThirdTest"})
    public void navigationBarElements() {
        //lookingForHotel();
        _landingScreen = returnLandingScreen();
        _landingScreen.verifyTheNavigationBar();
    }

    @Test(groups = {"FourthTest"})
    public void configurationOfPrivacyData() {
        //navigationBarElements();
        SettingsScreen settingsScreen = _landingScreen.clickOnSettings();
        ConfigurationPrivacyData configurationPrivacyData = settingsScreen.clickOnConfigurationOfPrivacyData();
        //The checkboxes AppsFlyer, GTM+Firebase and Facebook are checked/true by default
        configurationPrivacyData.enableAppsFlyerCheckbox(true)
                .enableFacebookCheckbox(false)
                .enableGTMFirebaseCheckbox(false)
                .clickOnSaveButton();
    }
}
