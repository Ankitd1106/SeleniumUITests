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
    public void setUp() {
        try {
            loadProperties();
            initializeDriver();
        } catch (IOException e) {
            Reporter.log("Error loading configuration file: " + e.getMessage(), true);
        }
    }

    private void loadProperties() throws IOException {
        if (driver == null) {
            readFile = new FileReader(System.getProperty("user.dir") + "/src/test/resource/config/config.properties");
            property.load(readFile);
        }
    }

    private void initializeDriver() {
        String browser = property.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.get(property.getProperty("url"));
        driver.manage().window().maximize();
        Reporter.log(property.getProperty("url") + " launched in " + browser + " browser successfully", false);
    }

    @AfterTest
    public void quit() {
        if (driver != null) {
            driver.quit();
            Reporter.log("Driver closed successfully", false);
        }
    }

    public WebDriverWait explicitlyWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(property.getProperty("explicitWaitTimeout"))));
    }

    public FluentWait<WebDriver> fluentlyWait() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(Integer.parseInt(property.getProperty("fluentWaitTimeout"))))
                .pollingEvery(Duration.ofSeconds(Integer.parseInt(property.getProperty("pollingInterval"))))
                .ignoring(NoSuchElementException.class);
    }
}
