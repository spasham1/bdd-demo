package paypoint;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import support.BaseSetup;

/**
 * Created by spasham@planittesting.com
 * 19/09/2018
 */

public class PPCorporatePage extends BaseSetup {

    By subNavigation=By.xpath("//*[contains(@class, 'SubNavigation') and contains(@style, 'display: block;')]");

    public PPCorporatePage(WebDriver driver) {
        super(driver);
    }

    @Step
    public PPCorporatePage verifyPageTabs() {
        acceptCookie();
        verifyTitle();
    	String[] tabs = {"Our proposition", "Our company", "Investor centre", "News", "Careers", "Contact"};
    	for(String tab: tabs) {
            waitForVisibilityOf(By.xpath("//a[contains(@class, 'MainNavItem') and contains(.,'"+tab+"')]"));
    	}
    	return new PPCorporatePage(driver);
    }

    @Step
    public PPCorporatePage verifyTitle() {
        pageShouldContainTitle("Home | PayPoint");
        return new PPCorporatePage(driver);
    }

    @Step
    public PPCorporatePage acceptCookie() {
        clickText("Accept");
        return new PPCorporatePage(driver);
    }

    @Step
    public PPCorporatePage hoverOnTab(String tab) {
        hover(By.xpath("//a[text()='"+tab+"']"));
        waitForVisibilityOf(subNavigation);
        return new PPCorporatePage(driver);
    }

    @Step
    public PPCorporatePage waitForPopup() {
        waitForVisibilityOf(subNavigation);
        return new PPCorporatePage(driver);
    }

    @Step
    public PPCorporatePage assertNavigationItems() {
        String[] tabs = {"Our proposition", "Our company", "Investor centre", "Careers"};
        for(String tab: tabs) {
            hoverOnTab(tab);
            try {
                Thread.sleep(500);
                waitForPopup();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new PPCorporatePage(driver);
    }

    @Step
    public PPCorporatePage assertOtherTabs() {
        String[] tabs = {"Solutions", "Resources", "Support"};
        for(String tab: tabs) {
            hover(By.xpath("//span[contains(., '"+tab+"')]"));
            isElementPresent(By.xpath("//*[contains(@class, 'main-sub-menu-inner')]"));
        }
        return new PPCorporatePage(driver);
    }

    @Step
    public void selectSite(String site) {
        click(By.xpath("//a[contains(., '"+site+"')]"));
        if(site.equalsIgnoreCase("Retailer")){
            switchToNewTab();
            acceptCookie();
        }
    }

    @Step
    public void selectSiteLink(String site) {
        click(By.xpath("//a[contains(., '"+site+"')]"));
    }

    @Step
    public void findPostCode(String postcode) {
        input(By.xpath("//input[@placeholder='Enter your postcode']"), postcode);
        clickReturn();
        waitForResults();
    }

    @Step
    public void waitForResults() {
        waitForVisibilityOf(By.xpath("//*[contains(@class, 'resultsPopupContainer')]"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
