package pageobjects;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PracticeTestPage extends BaseTest {

    public static WebElement delayedDropdownButton() {
        return driver.findElement(By.xpath("//div[@id='HTML34']/div[1]/div/button"));
    }

    public static WebElement delayedDropdownList() {
        return driver.findElement(By.xpath("//div[@id='myDropdown' and @class='dropdown-content show']"));
    }

    public static List<WebElement> delayedDropdownListValues() {
        return driver.findElements(By.xpath("//div[@id='myDropdown' and @class='dropdown-content show']/a"));
    }

}
