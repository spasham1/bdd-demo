package tests;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import support.BrowserSetup;

public class BaseTest extends BrowserSetup implements IHookable {

    @BeforeClass
    public void setup() {
        openBrowser("https://www.costa.co.uk/");
        new HomePage(driver).verifyHomePageLinks();
    }

    @AfterClass
    public void quit() throws Exception {
        new HomePage(driver).quit();
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
            new HomePage(driver).screenCapture();
            System.out.println(System.lineSeparator()+"TEST ("+testResult.getName()+") -- FAILED!");
        }
    }
}
