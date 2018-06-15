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

    public HomePageSteps() throws Exception {
        openBrowser("https://www.costa.co.uk/");
        new HomePage(driver).verifyHomePageLinks();
    }

    @After
    public void quit() throws Exception {
        new HomePage(driver).quit();
    }

    @Given("^I'm on costa web page$")
    public void HomePageLoaded() throws Exception {
        new HomePage(driver).homePageLoaded();
    }

    @Given("^I hover on tab (.+)$")
    public void hoverOnTab(String option) throws Exception {
        new HomePage(driver).hoverOnTab(option);
    }

    @Then("^I get popup with further options$")
    public void wrapper() throws Exception {
        new HomePage(driver).waitForPopup();
    }

    @When("^I enter text in search box (.+)$")
    public void enterText(String text) throws Exception {
        new HomePage(driver).enterTextInSearchBox(text);
    }

    @And("^I click go button$")
    public void clickGo() throws Exception {
        new HomePage(driver).clickGo();
    }

    @Then("^search results are displayed$")
    public void displayResults() throws Exception {
        new StoreLocatorPage(driver).verifyStoreLocatorPage();
    }
}
