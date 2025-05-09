package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {
    // Make these static to allow usage in static context in tests
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Properties properties;

    // Static block to load properties from config
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

    // Static method to initialize WebDriver and WebDriverWait
    public static void setUp() {
        String chromeDriverPath = getProperty("chromedriver.path");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Getter for WebDriver instance (static)
    public static WebDriver getDriver() {
        return driver;
    }

    // Getter for WebDriverWait instance (static)
    public static WebDriverWait getWait() {
        return wait;
    }

    // Utility method to get properties from config
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Static method to close the driver
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
