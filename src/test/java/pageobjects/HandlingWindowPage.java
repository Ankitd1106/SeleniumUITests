package pageobjects;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HandlingWindowPage extends BaseTest {

    public static WebElement newTabButton() {
        return driver.findElement(By.id("tabButton"));
    }

    public static WebElement newWindowButton() {
        return driver.findElement(By.id("windowButton"));
    }

    public static WebElement newWindowMessageButton() {
        return driver.findElement(By.id("messageWindowButton"));
    }
}
