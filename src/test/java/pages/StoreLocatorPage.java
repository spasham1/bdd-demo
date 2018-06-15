package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.BaseSetup;

/**
 * Created by spasham@planittesting.com
 */

public class StoreLocatorPage extends BaseSetup {

    By storeLocator = By.xpath("//*[@class='store-form filter-container']");
    By mapContainer = By.xpath("//*[@class='map-container']");
    By miniMapDetails = By.xpath("//*[@class='main map-details']");
    By headerText = By.xpath("//*[text()='Showing coffee shops near you']");
    By locDetailsPane = By.id("location-details");

    public StoreLocatorPage(WebDriver driver) {
        super(driver);
    }

    public StoreLocatorPage verifyStoreLocatorPage() {
        pageShouldContainTitle("Store Locator - Find a Coffee Shop Near You | Costa Coffee ");
        By elements[] = {storeLocator, mapContainer, miniMapDetails, headerText, locDetailsPane};
        for (By element: elements) {
            waitForVisibilityOf(element);
        }
    	return new StoreLocatorPage(driver);
    }
}
