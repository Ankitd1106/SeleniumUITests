package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public static WebDriver driver;
    public static Properties property = new Properties();
    public static FileReader readFile;
    public static SoftAssert softAssert;

    @BeforeTest
    public void setUp() throws IOException {
        if (driver == null) {
            readFile = new FileReader(System.getProperty("user.dir") + "/src/test/resource/config/config.properties");
            property.load(readFile);
        }
        if (property.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(property.getProperty("url"));
            driver.manage().window().maximize();
            Reporter.log(property.getProperty("url")+" launched in chrome browser successfullly", false);
        } else if (property.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(property.getProperty("url"));
            driver.manage().window().maximize();
            Reporter.log(property.getProperty("url")+" launched in firefox browser successfullly", false);

        }
    }

    @AfterTest
    public void quit() {
        if (driver != null) {
            driver.quit();
            Reporter.log("Driver closed successfullly", false);
        }
    }

    public static WebDriverWait explicitWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static FluentWait<WebDriver> fluentWait() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
    }
}
