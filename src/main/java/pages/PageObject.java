package pages;


import org.junit.Assert;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


public class PageObject {
    protected WebDriver driver;
    protected JavascriptExecutor jse;
    protected WebDriverWait wait;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30);
        this.jse = (JavascriptExecutor) driver;
    }


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
        try {
            jse.executeScript("window.scrollBy(0,2000)");
        } catch (Exception e) {
            Assert.fail("Can not scroll down");
        }
    }

}
