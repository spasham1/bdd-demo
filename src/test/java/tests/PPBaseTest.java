package tests;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import paypoint.PPCorporatePage;
import support.BrowserSetup;

public class PPBaseTest extends BrowserSetup implements IHookable {

    @BeforeClass
    public void setup() {
        openBrowser("http://corporate.paypoint.com/");
        new PPCorporatePage(driver).verifyPageTabs();
    }

    @AfterClass
    public void quit() throws Exception {
        new PPCorporatePage(driver).quit();
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
            new PPCorporatePage(driver).screenCapture(testResult.getName());
            System.out.println(System.lineSeparator()+"TEST ("+testResult.getName()+") -- FAILED!");
        }
    }
}
