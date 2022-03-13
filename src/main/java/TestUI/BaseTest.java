package TestUI;

import constants.Constants;
import constants.XpathConstants;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.MainPage;
import pages.PageObject;
import util.Utility;
import util.WebDriverFactory;

import java.util.Properties;

public class BaseTest {
    public static WebDriver driver;
    protected static WebDriverFactory webDriverFactory;
    protected static PageObject pageObject;
    protected static MainPage mainPage;

    @BeforeSuite
    public void openBrowser() {
        Properties properties = System.getProperties();
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.createWebDriver(Constants.CHROME);
        driver.get(Constants.InsiderURL);
        driver.manage().window().maximize();

        pageObject = new PageObject(driver);
        pageObject.waitExpectedCondition(XpathConstants.AcceptCookies);
        pageObject.clickElement(XpathConstants.AcceptCookies);
        mainPage = new MainPage(driver);

    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void screenShotFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Taking screenshot of failed case");
            Utility.captureScreenshot(driver, result.getName());
        }

    }

}
