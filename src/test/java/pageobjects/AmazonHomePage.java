package pageobjects;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AmazonHomePage extends BaseTest {

    public static WebElement getSignInPopupToHover() {
        return driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
    }

    public static WebElement signInButton() {
        return driver.findElement(By.xpath("//div[@id=\"nav-flyout-ya-signin\"]/a/span"));
    }

    public static WebElement emailField() {
        return driver.findElement(By.id("ap_email"));
    }

    public static WebElement passwordField() {
        return driver.findElement(By.id("ap_password"));
    }

    public static WebElement continueBtn() {
        return driver.findElement(By.id("continue"));
    }

    public static WebElement signInBtn() {
        return driver.findElement(By.id("signInSubmit"));
    }

    public static WebElement keepMeSignedInCheckBox() {
        return driver.findElement(By.xpath("//input[@type='checkbox']"));
    }

    public static WebElement otpMessage() {
        return driver.findElement(By.xpath("//div[@id=\"channelDetailsForOtp\"]/div/span"));
    }

}
