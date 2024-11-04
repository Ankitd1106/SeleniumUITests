package testcases;

import base.BaseTest;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static pageobjects.HomePage.*;

public class SeleniumUiTests extends BaseTest {

    @Test()
    public static void amazonLogin() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
        Actions action = new Actions(driver);
        action.moveToElement(getSignInPopupToHover()).perform();
        signInButton().click();
        explicitWait().until(ExpectedConditions.visibilityOf(emailField()));
        emailField().sendKeys(property.getProperty("email"));
        continueBtn().click();
        explicitWait().until(ExpectedConditions.visibilityOf(passwordField()));
        explicitWait().until(ExpectedConditions.elementToBeClickable(passwordField()));
        passwordField().sendKeys(property.getProperty("password"));
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
//        Assert.assertEquals(otpMessage().getText(), "For your security, we have sent the code to your phone ***-***-**27.");
    }
}
