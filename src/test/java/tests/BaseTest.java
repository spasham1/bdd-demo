package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import ru.yandex.qatools.allure.annotations.Attachment;
import support.BrowserSetup;

public class BaseTest extends BrowserSetup implements IHookable{

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
            screenCapture(testResult.getMethod().getMethodName());
        }
    }

    @Attachment(value = "Failure in method {0}", type = "image/png")
    public byte[] screenCapture(String name) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterMethod
    public void testSetup(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println(System.lineSeparator()+result.getName()+" -- FAILED!");
            //new HomePage(driver).screenCapture();
        }
    }

    @BeforeClass
    public void setup() {
        openBrowser("https://www.costa.co.uk/");
        new HomePage(driver).verifyHomePageLinks();
    }

    @AfterClass
    public void quit() throws Exception {
        new HomePage(driver).quit();
    }
}
