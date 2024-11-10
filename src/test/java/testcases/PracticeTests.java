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
import java.util.List;

import static pageobjects.PracticeTestPage.*;

public class PracticeTests extends BaseTest {

    @BeforeMethod
    public void hitUrl() {
        driver.get(property.getProperty("pt_url"));
        Reporter.log(property.getProperty("pt_url") + " launched in " + property.getProperty("browser") + " browser successfully", false);
        softAssert = new SoftAssert();
        action = new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;
    }

    @Test(alwaysRun = true)
    public void omayoTests() throws InterruptedException {

        //scrolling to the end of the page
        jsExecutor.executeScript("window.scrollBy(0,1700)", "");

        //click on dropdown and wait until dropdown is visible
        delayedDropdownButton().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        if (delayedDropdownList().isDisplayed()) {
            List<WebElement> elements = delayedDropdownListValues();
            Reporter.log("Drodown values", true);
            for (WebElement element : elements) {
                Reporter.log("Dropdown value = " + element.getText() + " | " + "href link = " + element.getAttribute("href"), true);
            }

            //navigate to facebook
            delayedDropdownListValues().get(0).click();
            explicitlyWait().until(ExpectedConditions.urlContains("facebook"));
            Reporter.log("Navigated to " + driver.getTitle(), true);

            //navigate back and go to flipkart
            driver.navigate().back();
            explicitlyWait().until(ExpectedConditions.titleContains(("omayo")));
            delayedDropdownButton().click();
            if (delayedDropdownList().isDisplayed()) {
                delayedDropdownListValues().get(1).click();
            }
            explicitlyWait().until(ExpectedConditions.urlContains("flipkart"));
            Reporter.log("Navigated to " + driver.getTitle(), true);

            //navigate back and go to google
            driver.navigate().back();
            explicitlyWait().until(ExpectedConditions.titleContains(("omayo")));
            delayedDropdownButton().click();
            if (delayedDropdownList().isDisplayed()) {
                delayedDropdownListValues().get(2).click();
            }
            explicitlyWait().until(ExpectedConditions.urlContains("gmail"));
            Reporter.log("Navigated to " + driver.getTitle(), true);

            driver.navigate().back();
            explicitlyWait().until(ExpectedConditions.titleContains(("omayo")));
            driver.navigate().refresh();

        }
    }

}