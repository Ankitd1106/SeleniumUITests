package testcases;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static pageobjects.AmazonHomePage.*;

public class AmazonTests extends BaseTest {

    @BeforeMethod
    public void hitUrl() {
        driver.get(property.getProperty("amazon_url"));
        Reporter.log(property.getProperty("amazon_url") + " launched in " + property.getProperty("browser") + " browser successfully", true);
    }

    @Test(enabled = true)
    public void login() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals(property.getProperty("amz_title").trim(), driver.getTitle().trim());
        Actions action = new Actions(driver);
        action.moveToElement(getSignInPopupToHover()).perform();
        signInButton().click();
        explicitlyWait().until(ExpectedConditions.visibilityOf(emailField()));
        emailField().sendKeys(property.getProperty("amz_email"));
        continueBtn().click();
        explicitlyWait().until(ExpectedConditions.visibilityOf(passwordField()));
        explicitlyWait().until(ExpectedConditions.elementToBeClickable(passwordField()));
        passwordField().sendKeys(property.getProperty("amz_password"));
        try {
            WebElement checkBox = explicitlyWait().until(ExpectedConditions.visibilityOf(keepMeSignedInCheckBox()));
            if (checkBox.isDisplayed()) {
                if (!checkBox.isSelected()) {
                    checkBox.click();
                    Assert.assertTrue(checkBox.isSelected());
                }
                signInBtn().click();
            }
        } catch (NoSuchElementException e) {
            signInBtn().click();
        }
        Assert.assertEquals(otpMessage().getText().trim(), property.getProperty("amz_otp_message").trim());
    }

}