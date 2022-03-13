package pages;

import constants.XpathConstants;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;


public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }


    public void CheckInsiderPageOpen() {

        waitExpectedCondition(XpathConstants.LoginButton);
    }

    public void clickMoreMenu() {
        clickElement(XpathConstants.MoreMenu);
    }

    public void clickCareersMenu() {
        clickElement(XpathConstants.CareersMenu);
    }

    public void checkLocationTeamLifeMenu() {
        waitExpectedCondition(XpathConstants.LocationBlock);
        waitExpectedCondition(XpathConstants.LifeBlock);
        waitExpectedCondition(XpathConstants.TeamBlock);
    }

    public void clickSeeAllTeams() {
        WebElement el = driver.findElement(By.xpath(XpathConstants.SeeAllTeams));
        try {
            jse.executeScript("arguments[0].click()", el);
        } catch (Exception e) {
            Assert.fail("Can not click See All Teams");
        }
    }

    public void clickQualityAssurance() {
        waitExpectedCondition(XpathConstants.QualityAssurance);
        WebElement el1 = driver.findElement(By.xpath(XpathConstants.QualityAssurance));
        try {
            jse.executeScript("arguments[0].click()", el1);
        } catch (Exception e) {
            Assert.fail("Can not click Quality Assurance");
        }

    }

    public void clickSeeAllQAJobs() {
        waitExpectedCondition(XpathConstants.SeeALLQAJobs);
//        clickElement(XpathConstants.SeeALLQAJobs);
        WebElement el5 = driver.findElement(By.xpath(XpathConstants.SeeALLQAJobs));
        try {
            jse.executeScript("arguments[0].click()", el5);
        } catch (Exception e) {
            Assert.fail("Can not click Quality Assurance");
        }

    }

    public void keyDownIstanbul() {
        waitExpectedCondition(XpathConstants.CheckBoxLocation);
        clickElement(XpathConstants.CheckBoxLocation);
        waitExpectedCondition(XpathConstants.LocationIstanbul);
        clickElement(XpathConstants.LocationIstanbul);
    }

    public void keyDownQualityAssurance() {
        waitExpectedCondition(XpathConstants.JobListLocation);
        clickElement(XpathConstants.JobListLocation);
        waitExpectedCondition(XpathConstants.JobQuality);
        clickElement(XpathConstants.JobQuality);

    }

    public void selectLocation() {
        clickElement(XpathConstants.CheckBoxLocation);

    }


    public void findPosition(String position, String department, String location) {
        waitExpectedCondition(XpathConstants.QualityAssurancePage);
        List<WebElement> elements = driver.findElements(By.id("jobs-list"));
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            String text = elements.get(i).getText();
            System.out.print(text);

            Assert.assertTrue(text + " does not contain " + position, text.contains(position));
            Assert.assertTrue(text + " does not contain " + location, text.contains(location));
            Assert.assertTrue(text + " does not contain " + department, text.contains(department));
        }

    }

    public void applyNow() {

        WebElement el2 = driver.findElement(By.xpath(XpathConstants.ApplyNow));
        try {
            jse.executeScript("arguments[0].click()", el2);
        } catch (Exception e) {
            Assert.fail("Can not click applyNow");
        }
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }
    public void checkApplyPage()   {
        waitExpectedCondition(XpathConstants.ApplyPage);

        }
    }


