package tests;

import org.testng.annotations.Test;

import screens.*;
import util.tests.BaseMobileTest;

public class SomeTest extends BaseMobileTest {

    LandingScreen _landingScreen;
    CountriesScreen _countriesScreen;
    PrivacyDataScreen _privacyDataScreen;
    DestinationScreen _destinationScreen;
    DateScreen _dateScreen;
    SettingsScreen _settingsScreen;
    ConfigurationPrivacyData _configurationPrivacyData;


    /*@Parameters({"someParameter", "someParameter"})
    @Test(groups = {"someGroup"})
    public void someTest() {
        FirstScreen nameOfMyFirstScreen = returnFirstScreen();
        nameOfMyFirstScreen.someInstructions();
        SecondScreen nameOfMySecondScreen = nameOfMyFirstScreen.returnSecondScreen();
        nameOfMySecondScreen.flowInsideSecondScreen();
    }*/
    @Test(priority = 1)
    public void acceptingPrivacyDataTest() {
        _countriesScreen = returnCountriesScreen();
        _privacyDataScreen = _countriesScreen.selectCountry("Colombia");
        _privacyDataScreen.acceptPrivacyData();
        _privacyDataScreen.verifyTheNewView();
    }

    @Test(priority = 2)
    public void lookingForHotel() throws InterruptedException {
        _countriesScreen = returnCountriesScreen();
        _privacyDataScreen = _countriesScreen.selectCountry("Colombia");
        _destinationScreen = _privacyDataScreen.acceptPrivacyData();
        _dateScreen = _destinationScreen.clckOnTextBox().writeTheCity("Cartagena");
        _dateScreen.selectingDateToBookTheHotel("1", "5");
    }

    @Test(priority = 3)
    public void navigationBarElements() throws InterruptedException {
        _countriesScreen = returnCountriesScreen();
        _privacyDataScreen = _countriesScreen.selectCountry("Colombia");
        _destinationScreen = _privacyDataScreen.acceptPrivacyData();
        _dateScreen = _destinationScreen.clckOnTextBox().writeTheCity("Cartagena");
        _landingScreen = _dateScreen.selectingDateToBookTheHotel("1", "5");
        _landingScreen.verifyTheNavigationBar();
    }

    @Test(priority = 4)
    public void configurationOfPrivacyData() throws InterruptedException {
        _countriesScreen = returnCountriesScreen();
        _privacyDataScreen = _countriesScreen.selectCountry("Colombia");
        _destinationScreen = _privacyDataScreen.acceptPrivacyData();
        _dateScreen = _destinationScreen.clckOnTextBox().writeTheCity("Cartagena");
        _landingScreen = _dateScreen.selectingDateToBookTheHotel("1", "5");
        _settingsScreen = _landingScreen.verifyTheNavigationBar().clickOnSettings();
        _configurationPrivacyData = _settingsScreen.clickOnConfigurationOfPrivacyData();
        //The checkboxes AppsFlyer, GTM+Firebase and Facebook are checked/true by default
        _configurationPrivacyData.enableAppsFlyerCheckbox(true)
                .enableFacebookCheckbox(false)
                .enableGTMFirebaseCheckbox(false)
                .clickOnSaveButton();
    }
}
