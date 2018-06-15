package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.*;
import pages.HomePage;
import pages.StoreLocatorPage;
import support.BrowserSetup;

/**
 * Created by spasham@planittesting.com
 */

public class HomePageSteps extends BrowserSetup {

    public HomePageSteps() {
        openBrowser("https://www.costa.co.uk/");
        new HomePage(driver).verifyHomePageLinks();
    }

    @After
    public void quit() {
        new HomePage(driver).quit();
    }

    @Given("^I'm on costa web page$")
    public void HomePageLoaded() {
        new HomePage(driver).homePageLoaded();
    }

    @Given("^I hover on tab (.+)$")
    public void hoverOnTab(String option) {
        new HomePage(driver).hoverOnTab(option);
    }

    @Then("^I get popup with further options$")
    public void wrapper() {
        new HomePage(driver).waitForPopup();
    }

    @When("^I enter text in search box (.+)$")
    public void enterText(String text) {
        new HomePage(driver).enterTextInSearchBox(text);
    }

    @And("^I click go button$")
    public void clickGo() {
        new HomePage(driver).clickGo();
    }

    @Then("^search results are displayed$")
    public void displayResults() {
        new StoreLocatorPage(driver).verifyStoreLocatorPage();
    }
}
