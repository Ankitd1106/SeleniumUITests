package pageobjects;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BstackDemoPage extends BaseTest {

    public static WebElement orderByDropdown() {
        return driver.findElement(By.xpath("//div[@class='sort']/select"));
    }

    public static List<WebElement> itemsOnPage() {
        return driver.findElements(By.xpath("//div[@class='shelf-item__thumb']"));
    }

    public static WebElement priceOfItems(int i) {
        return driver.findElement(By.xpath("(//div[@class='shelf-item']//div[3]/div[@class='val']/b)[" + i + "]"));
    }

}
