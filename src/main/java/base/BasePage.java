package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load config.properties");
        }
    }

    // Constructor to initialize WebDriver and WebDriverWait
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Static method to create and return a new WebDriver instance
    public static WebDriver createDriver() {
        String chromeDriverPath = getProperty("chromedriver.path");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    // Common utility method to get the current page title
    public String getPageTitle() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized.");
        }
        return driver.getTitle();
    }

    // Common utility method to get properties from config
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Utility method to close the driver
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
