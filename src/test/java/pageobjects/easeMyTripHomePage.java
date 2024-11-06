package pageobjects;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class easeMyTripHomePage extends BaseTest {

    public static WebElement flightMenuOption() {
        return driver.findElement(By.xpath("//a[contains(@href,'flights.html') and @class='_actvrmenu']"));
    }

    public static WebElement loginOrSignupButton() {
        return driver.findElement(By.xpath("//a[@class=\"_btnclick\"]/span[text()='Login or Signup']"));
    }

    public static WebElement customerLoginMenuOption() {
        return driver.findElement(By.xpath("//div[@class=\"_dropdownromenu drhvr\"]/a/span/following-sibling::span/span[text()='Customer Login']"));
    }

    public static WebElement loginPopup() {
        return driver.findElement(By.id("lgnBox"));
    }

    public static WebElement continueButton() {
        return driver.findElement(By.xpath("//div[@id='lgnBox']/div[1]/div[4]"));
    }

    public static WebElement emailIdField() {
        return driver.findElement(By.id("txtEmail"));
    }

    public static WebElement loginButton() {
        return driver.findElement(By.xpath("//div[@id=\"ValidPass\"]/following-sibling::div[2]/input[@type='button']"));
    }

    public static WebElement passwordField() {
        return driver.findElement(By.xpath("//input[@id='txtEmail2' and @type='password']"));
    }

    public static WebElement confirmLogin() {
        return driver.findElement(By.xpath("//span[@id='welcome-det-User' and text()=\"Ankit Das\"]"));
    }

    public static WebElement from() {
        return driver.findElement(By.xpath("//input[@id='FromSector_show']"));
    }
}
