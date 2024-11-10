package testcases;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.BstackDemoPage;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import static pageobjects.BstackDemoPage.orderByDropdown;
import static pageobjects.BstackDemoPage.priceOfItems;

public class BstackDemoTests extends BaseTest {

    @BeforeMethod
    public void hitUrl() {
        driver.get(property.getProperty("bstackdemo_url"));
        Reporter.log(property.getProperty("bstackdemo_url") + " launched in " + property.getProperty("browser") + " browser successfully", false);
        softAssert = new SoftAssert();
        action = new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;
    }

    @Test(alwaysRun = true)
    public void bStackDemoTests() throws InterruptedException {
        orderByDropdown().click();
        Select select = new Select(orderByDropdown());
        select.selectByVisibleText("Lowest to highest");

        //validate low to high sorting
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(4000);
        List<Integer> prices_LtoH = new LinkedList<>();

        for (int i = 1; i <= BstackDemoPage.itemsOnPage().size(); i++) {
            prices_LtoH.add(Integer.parseInt(priceOfItems(i).getText()));
        }

        Reporter.log(prices_LtoH.toString(), true);

        for (int p = 0; p < prices_LtoH.size() - 1; p++) {
            Assert.assertTrue(prices_LtoH.get(p) <= prices_LtoH.get(p + 1));
        }

        //sort high to low
        select.selectByVisibleText("Highest to lowest");

        //validate low to high sorting
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(4000);
        List<Integer> prices_HtoL = new LinkedList<>();

        for (int i = 1; i <= BstackDemoPage.itemsOnPage().size(); i++) {
            prices_HtoL.add(Integer.parseInt(priceOfItems(i).getText()));
        }

        Reporter.log(prices_HtoL.toString(), true);
        for (int p = 0; p < prices_LtoH.size() - 1; p++) {
            Assert.assertTrue(prices_HtoL.get(p) >= prices_HtoL.get(p + 1));
        }

        //additional validation - compare both lists
        if (prices_LtoH.size() == prices_HtoL.size()) {
            for (int at = 0; at < prices_LtoH.size(); at++) {
                softAssert.assertTrue(prices_LtoH.get(at).equals(prices_HtoL.get(prices_HtoL.size()-1-at)), "Element " + prices_LtoH.get(at) + " from prices_LtoH does not match element " + prices_HtoL.get(prices_HtoL.size() - 1 - at) + " from prices_HtoL.");
            }
        }
        else {
            System.out.println("difference is size");
        }

        softAssert.assertAll();

    }
}

