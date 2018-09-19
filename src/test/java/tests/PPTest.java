package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import paypoint.PPCorporatePage;

/**
 * Created by spasham@planittesting.com
 */

public class PPTest extends PPBaseTest {

    @Test(priority = 1)
    public void corporate_page_tabs() {
        new PPCorporatePage(driver).assertNavigationItems();
    }

    @Test(priority = 2)
    public void retailer_page_tabs() {
        new PPCorporatePage(driver).selectSite("Retailer");
        new PPCorporatePage(driver).pageShouldContainTitle("Everything you need to run your store | PayPoint");
        new PPCorporatePage(driver).assertOtherTabs();
    }

    @Test(priority = 3)
    public void service_provider_page_tabs() {
        new PPCorporatePage(driver).selectSite("Service provider");
        new PPCorporatePage(driver).pageShouldContainTitle("Market-leading omnichannel payments and services for your customers | PayPoint");
        new PPCorporatePage(driver).assertOtherTabs();
    }

    @Test(priority = 4)
    public void service_provider_page_tabs_should_fail() {
        new PPCorporatePage(driver).selectSite("Consumer");
        new PPCorporatePage(driver).pageShouldContainTitle("Market-leading omnichannel payments and services for your customers | PayPoint");
        new PPCorporatePage(driver).assertOtherTabs();
    }

    @Test(priority = 5)
    public void consumer_page_search_postcode() {
        new PPCorporatePage(driver).findPostCode("AL7 1EL");
    }
}