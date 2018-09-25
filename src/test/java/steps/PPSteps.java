package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import paypoint.PPCorporatePage;
import support.BrowserSetup;

/**
 * Created by spasham@planittesting.com
 */

public class PPSteps extends BrowserSetup {

    public PPSteps() {
        openBrowser("http://corporate.paypoint.com/");
        new PPCorporatePage(driver).verifyPageTabs();
    }

    @After
    public void quit() {
        new PPCorporatePage(driver).quit();
    }

    @Given("^I'm on paypoint corporate page$")
    public void verifyCorporatePage() {
        new PPCorporatePage(driver).verifyTitle();
    }

    @Given("^I hover on navigation link (.+)$")
    public void hoverOnLink(String option) {
        new PPCorporatePage(driver).hoverOnTab(option);
    }

    @Then("^I get sub navigation options$")
    public void subNavigationMenu() {
        new PPCorporatePage(driver).waitForPopup();
    }

    @Given("^I click on site selector (.+)$")
    public void selectSite(String text) {
        new PPCorporatePage(driver).selectSiteLink(text);
    }

    @When("^I get to page with title(.+) and navigate the menu$")
    public void verifyPageMenu(String title) {
        new PPCorporatePage(driver).acceptCookie();
        new PPCorporatePage(driver).pageShouldContainTitle(title);
    }

    @Then("^I get options with sub navigation links$")
    public void subNavigationTabs() {
        new PPCorporatePage(driver).assertOtherTabs();
    }

    @And("^I enter postcode (.+)$")
    public void enterPostCode(String postcode) throws Exception {
        new PPCorporatePage(driver).acceptCookie();		
        Thread.sleep(2000);
        new PPCorporatePage(driver).findPostCode(postcode);
    }

    @Then("^I get results with PostCode locations$")
    public void waitForResults() {
        new PPCorporatePage(driver).waitForResults();
    }
}