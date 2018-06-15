package tests;

import org.testng.annotations.*;
import pages.HomePage;
import pages.StoreLocatorPage;

/**
 * Created by spasham@planittesting.com
 */

public class HomePageTest extends BaseTest {

    @DataProvider(name = "tabs")
    public static Object[][] tabs() {
        return new Object[][] {
                { "Coffee Club" },
                { "Responsibility" },
                { "About Us" }
        };
    }

    @Test(priority=1, dataProvider = "tabs")
    public void navigation_tabs(String tab) {
        new HomePage(driver).assertTab(tab);
    }

    @Test(priority=2)
    public void test_should_fail() {
        new HomePage(driver).assertTab("Tab Does not Exist");
    }

    @Test (priority=3)
    public void searchLocation() {
        new HomePage(driver).assertTab("Locations");
        new HomePage(driver).enterTextInSearchBox("holborn");
        new HomePage(driver).clickGo();
        new StoreLocatorPage(driver).verifyStoreLocatorPage();
    }

}