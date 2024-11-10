package testcases;

import base.BaseTest;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static pageobjects.EaseMyTripHomePage.*;

public class BaseMyTripTests extends BaseTest {

    @BeforeMethod
    public void hitUrl() {
        driver.get(property.getProperty("emt_url"));
        Reporter.log(property.getProperty("emt_url") + " launched in " + property.getProperty("browser") + " browser successfully", false);
        softAssert = new SoftAssert();
        action = new Actions(driver);
    }

    @Test(alwaysRun = true)
    public void easeMyTripFlightBooking() throws InterruptedException {
        softAssert.assertEquals(driver.getTitle().trim(), property.getProperty("emt_title"), "Incorrect Title on ease my trip landing page");
        flightMenuOption().click();
        softAssert.assertEquals(driver.getTitle().trim(), property.getProperty("emt_flight_title"), "Incorrect Title on ease my trip flight booking landing page");
        loginOrSignupButton().click();
        Thread.sleep(3000);
        customerLoginMenuOption().click();
        explicitlyWait().until(ExpectedConditions.visibilityOf(loginPopup()));
        System.out.println("login pop up displayed ="+loginPopup().isDisplayed());
        explicitlyWait().until(ExpectedConditions.visibilityOf(emailIdField()));
        System.out.println("email field displayed ="+emailIdField().isDisplayed());
        explicitlyWait().until(ExpectedConditions.visibilityOf(continueButton()));
        System.out.println("continue displayed ="+continueButton().isDisplayed());
        emailIdField().sendKeys(property.getProperty("emt_email"));
        Thread.sleep(5000);
        System.out.println("email");
        continueButton().click();
        System.out.println("continue");
        Thread.sleep(5000);
        explicitlyWait().until(ExpectedConditions.visibilityOf(passwordField()));
        System.out.println("password field displayed ="+passwordField().isDisplayed());
        passwordField().sendKeys(property.getProperty("emt_password"));
        System.out.println("passwedf");
        Thread.sleep(5000);
        loginButton().click();
        Thread.sleep(5000);
        System.out.println("login");
        Assert.assertTrue(confirmLogin().isDisplayed());
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "easeMyTripFlightBooking")
    public void selectAndBookFlights() throws InterruptedException {
        easeMyTripFlightBooking();

    }
}