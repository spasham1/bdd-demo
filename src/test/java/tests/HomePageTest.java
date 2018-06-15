package tests;

import org.testng.annotations.*;
import pages.HomePage;
import pages.StoreLocatorPage;

/**
 * Created by spasham@planittesting.com
 */

public class HomePageTest extends BaseTest {

    private void verifyTab(String tab) {
        new HomePage(driver).hoverOnTab(tab);
        new HomePage(driver).waitForPopup();
    }

    @Test(priority=1)
    public void tab_coffeeClub() throws Exception {
        verifyTab("Coffee Club");
    }

    @Test(priority=2)
    public void test_should_fail() throws Exception {
        verifyTab("Tab Does not Exist");
    }

    @Test (priority=3)
    public void searchLocation() throws Exception {
        verifyTab("Locations");
        new HomePage(driver).enterTextInSearchBox("holborn");
        new HomePage(driver).clickGo();
        new StoreLocatorPage(driver).verifyStoreLocatorPage();
    }

}