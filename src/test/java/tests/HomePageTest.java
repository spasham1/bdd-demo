package tests;

import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.StoreLocatorPage;
import support.BrowserSetup;

/**
 * Created by spasham@planittesting.com
 */

public class HomePageTest extends BrowserSetup {

    public HomePageTest() {
        openBrowser("https://www.costa.co.uk/");
        new HomePage(driver).verifyHomePageLinks();
    }

    @AfterClass
    public void quit() throws Exception {
        new HomePage(driver).quit();
    }

    private void verifyTab(String tab) {
        new HomePage(driver).hoverOnTab(tab);
        new HomePage(driver).waitForPopup();
    }

    @Test(priority=1)
    public void tab_coffeeClub() throws Exception {
        verifyTab("Coffee Club");
    }

    @Test (priority=2)
    public void searchLocation() throws Exception {
        verifyTab("Locations");
        new HomePage(driver).enterTextInSearchBox("holborn");
        new HomePage(driver).clickGo();
        new StoreLocatorPage(driver).verifyStoreLocatorPage();
    }

    @AfterMethod
    public void testSetup(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println(System.lineSeparator()+result.getName()+" -- FAILED!");
            new HomePage(driver).screenCapture();
        }
    }
}