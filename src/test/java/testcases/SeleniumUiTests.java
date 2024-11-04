package testcases;

import base.BaseTest;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static pageobjects.HomePage.*;

public class SeleniumUiTests extends BaseTest {

    @Test(invocationCount = 0)
    public void amazonLogin() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle().trim());
        Actions action = new Actions(driver);
        action.moveToElement(getSignInPopupToHover()).perform();
        signInButton().click();
        explicitlyWait().until(ExpectedConditions.visibilityOf(emailField()));
        emailField().sendKeys(property.getProperty("amz_email"));
        continueBtn().click();
        explicitlyWait().until(ExpectedConditions.visibilityOf(passwordField()));
        explicitlyWait().until(ExpectedConditions.elementToBeClickable(passwordField()));
        passwordField().sendKeys(property.getProperty("amz_password"));
        if (keepMeSignedInCheckBox().isDisplayed()) {
            if (keepMeSignedInCheckBox().isSelected()) {
                signInBtn().click();
            } else {
                keepMeSignedInCheckBox().click();
                Assert.assertTrue(keepMeSignedInCheckBox().isSelected());
//                signInBtn().click();
            }
        } else {
//            signInBtn().click();
        }
//        Assert.assertEquals(otpMessage().getText().trim(), "For your security, we have sent the code to your phone ***-***-**27.");
    }

    @Test(invocationCount = 1)
    public void makeMyTrip() {
        System.out.println("i am cool");
    }
}