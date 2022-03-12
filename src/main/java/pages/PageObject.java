package pages;


import org.junit.Assert;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


public class PageObject {
    protected WebDriver driver;
    public JavascriptExecutor jse;

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    WebDriverWait wait = new WebDriverWait(driver, 30);


    public void waitExpectedCondition(String xpath) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
        } catch (Exception e) {
            Assert.fail("xpath element is not visible");
        }
    }

    public void clickElement(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).click();
        } catch (Exception e) {
            Assert.fail("Can not be clicked button");
        }
    }

    public void scrollDown() {
        jse = (JavascriptExecutor) driver;
        try {
            jse.executeScript("window.scrollBy(0,2000)");
        } catch (Exception e) {
            Assert.fail("Can not scroll down");
        }
    }

}
