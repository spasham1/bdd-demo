package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.*;

/**
 * Created by spasham@planittesting.com
 */

public class HomePage extends BaseSetup {

    By searchAddress = By.id("txtHeaderSearchAddress");
    By IAgree = By.className("cc-compliance");
    By goButton = By.id("btn-go");
    By wrapper = By.xpath("//*[contains(@class, 'meganav mn') and contains(@style, 'display: block;')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage verifyHomePageLinks() {
        acceptCookie();
    	String[] tabs = {"Our Coffees", "Locations", "Coffee Club", "Responsibility", "About Us"};
    	for(String tab: tabs) {
    		waitForVisibilityOf(By.xpath("//a[text()='"+tab+"']"));
    	}
    	return new HomePage(driver);
    }

    public HomePage homePageLoaded() {
        pageShouldContainTitle("The Nation's Favourite Coffee Shop | Costa Coffee");
        return new HomePage(driver);
    }

    public HomePage enterTextInSearchBox(String text) throws Exception {
        waitForVisibilityOf(searchAddress);
    	input(searchAddress, text);
        return new HomePage(driver);
    }

    public HomePage acceptCookie() {
        if(isElementPresent(IAgree)==true)
            click(IAgree);
        return new HomePage(driver);
    }

    public HomePage hoverOnTab(String tab) {
        hover(By.xpath("//a[text()='"+tab+"']"));
        waitForVisibilityOf(wrapper);
        return new HomePage(driver);
    }

    public HomePage waitForPopup() {
        waitForVisibilityOf(wrapper);
        return new HomePage(driver);
    }

    public HomePage clickGo() {
        click(goButton);
        return new HomePage(driver);
    }

}
