package support;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.ArrayList;

/**
 * Created by spasham@planittesting.com
 */

public class BaseSetup {

    protected WebDriver driver;
    protected WebElement element;
    protected int timeout =5;

    public BaseSetup(WebDriver driver) {
        this.driver = driver;
    }

	public void quit() {
		if(driver!=null)
			driver.quit();
	}

    public void waitForVisibilityOf(By locator) {
    	try {
    		WebDriverWait wait = new WebDriverWait(driver, timeout);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    	} catch (Exception e) {
    		Assert.fail("Element '"+locator+"' is not visible in "+timeout+" seconds");
    	}
    }

    public WebElement findElement(By locator) {
    	try{
    	element = new WebDriverWait(driver, timeout)
    			.until(ExpectedConditions.presenceOfElementLocated(locator)); 
    	} catch (Exception e) {
    		Assert.fail("Failed to find element '"+locator+"' in "+timeout+" seconds");
    	}
    	return element;
    }

	public boolean isElementPresent(By locator) {
		element=findElement(locator);
		if(element.isDisplayed()==true)
			return true;
		else
			return false;
	}

	public void hover(By locator) {
		element = findElement(locator);
		new Actions(driver).moveToElement(element).perform();
	}

    public void click(By locator) {
    	element = findElement(locator);
    	element.click();
    }

	public void clickText(String text) {
    	By locator=null;
		if(text.endsWith("}")){
			String[] splitText=text.split("[{}]");
			locator=By.xpath("(//*[text()[contains(., '"+splitText[0].substring("@".length())+"')]])["+splitText[1]+"]");
		} else {
			locator=By.xpath("//*[text()='"+text+"']");
		}
		click(locator);
	}

    public void input(By locator, String text) {
    	click(locator);
    	element.clear();
    	element.sendKeys(text);
    }

    public void pageShouldContainTitle(String title) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.titleContains(title));
        } catch (Exception e) {
            Assert.fail("Page does not contain title: " +title);
        }
    }

    public void clickReturn() {
        new Actions(driver).sendKeys(Keys.RETURN).perform();
    }

    public void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1)).manage().window().maximize();
    }

	@Attachment(value = "Failure in method {0}", type = "image/png")
	public byte[] screenCapture(String name) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

}