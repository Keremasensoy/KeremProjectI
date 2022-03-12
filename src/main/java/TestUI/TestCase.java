package TestUI;

import constants.XpathConstants;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.PageObject;

import java.io.IOException;

public class TestCase extends BaseTest{

    @Test
    public void Test() throws IOException, InterruptedException {
        mainPage.CheckInsiderPageOpen();
        mainPage.clickMoreMenu();
        mainPage.clickCareersMenu();
        mainPage.checkLocationTeamLifeMenu();
        Thread.sleep(30);
        mainPage.clickSeeAllTeams();
        pageObject.scrollDown();
        Thread.sleep(40);
        mainPage.clickQualityAssurance();
        mainPage.clickSeeAllQAJobs();
        Thread.sleep(3000);
        mainPage.keyDownIstanbul();
        Thread.sleep(3000);
        pageObject.scrollDown();
        mainPage.findPosition("Quality Assurance","Quality Assurance","Istanbul, Turkey");
        mainPage.applyNow();
    }
}
