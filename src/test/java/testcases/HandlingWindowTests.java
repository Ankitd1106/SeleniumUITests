package testcases;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static pageobjects.HandlingWindowPage.*;

public class HandlingWindowTests extends BaseTest {

    @BeforeMethod
    public void hitUrl() {
        driver.get(property.getProperty("demoqa_url"));
        Reporter.log(property.getProperty("demoqa_url") + " launched in " + property.getProperty("browser") + " browser successfully", false);
        softAssert = new SoftAssert();
        action = new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;
    }

    @Test(alwaysRun = true)
    public void windowHandle() {
        String parentTab = driver.getWindowHandle();
        newTabButton().click();
        String newTab1 = driver.getWindowHandle();
        driver.switchTo().window(parentTab);
        newTabButton().click();
        String newTab2 = driver.getWindowHandle();
        driver.switchTo().window(parentTab);
        newTabButton().click();
        String newTab3 = driver.getWindowHandle();
        driver.switchTo().window(parentTab);
        jsExecutor.executeScript("window.scrollBy(0,1700)", "");
        newWindowButton().click();
        String newWindow1 = driver.getWindowHandle();
        driver.switchTo().window(parentTab);
        newWindowButton().click();
        String newWindow2 = driver.getWindowHandle();
        driver.switchTo().window(parentTab);
        newWindowButton().click();
        String newWindow3 = driver.getWindowHandle();
        driver.switchTo().window(parentTab);
        newWindowMessageButton().click();
        String newMessageWindow1 = driver.getWindowHandle();

        Set<String> tabs = driver.getWindowHandles();

        Iterator<String> i = tabs.iterator();

        driver.switchTo().window(newWindow3);









    }

}