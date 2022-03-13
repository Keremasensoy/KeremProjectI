package util;

import constants.Constants;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory {
    public WebDriver createWebDriver(String type) {
        WebDriver driver = null;

        switch (type) {
            case Constants.CHROME:
                System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("disable-infobars");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-extensions");

                driver = new ChromeDriver(chromeOptions);
                return driver;

            case Constants.FIREFOX:
                System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER);
                System.setProperty("java.awt.headless", "false");
//                DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
//                desiredCapabilities.setCapability("marionette", true);
                driver = new FirefoxDriver();
                return driver;

            default:
//                throw new IllegalStateException("Unexpected value: " + type);\
                Assert.fail(String.format("dfadsfasdfasdf",type));
                break;
        }
        return driver;
    }
}
