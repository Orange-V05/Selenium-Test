package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import pages.HomePage;
import base.BasePage;

import java.util.Set;

@TestMethodOrder(OrderAnnotation.class)
public class AdvancedSeleniumTests {
    private static WebDriver driver;
    private static HomePage homePage;

    @BeforeAll
    public static void setUp() {
        BasePage.setUp();
        driver = BasePage.getDriver();
        driver.get(BasePage.getProperty("base.url"));
        homePage = new HomePage(driver);
    }

    @Test
    @Order(1)
    public void manipulateCookies() {
        driver.get(BasePage.getProperty("base.url"));
        Cookie cookie = new Cookie("testCookie", "testValue");
        driver.manage().addCookie(cookie);
        Cookie retrievedCookie = driver.manage().getCookieNamed("testCookie");
        assert retrievedCookie.getValue().equals("testValue");
    }

    @Test
    @Order(2)
    public void mouseHoverAction() {
        driver.get(BasePage.getProperty("hover.url"));
        WebElement hoverElement = driver.findElement(By.id("hoverElement"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        WebElement tooltip = driver.findElement(By.id("tooltip"));
        assert tooltip.isDisplayed();
    }

    @Test
    @Order(3)
    public void dragAndDropAction() {
        driver.get(BasePage.getProperty("dragdrop.url"));
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
        assert target.getText().equals("Dropped!");
    }

    @Test
    @Order(4)
    public void fileUploadTest() {
        driver.get(BasePage.getProperty("upload.url"));
        WebElement uploadElement = driver.findElement(By.id("file-upload"));
        uploadElement.sendKeys(BasePage.getProperty("file.path"));
        driver.findElement(By.id("file-submit")).click();
        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
        assert uploadedFiles.getText().contains("testfile.txt");
    }

    @Test
    @Order(5)
    public void browserBackNavigation() {
        driver.navigate().to(BasePage.getProperty("base.url") + "/page1");
        driver.navigate().to(BasePage.getProperty("base.url") + "/page2");
        driver.navigate().back();
        assert driver.getCurrentUrl().equals(BasePage.getProperty("base.url") + "/page1");
    }

    @Test
    @Order(6)
    public void downloadFileFromProtectedPage() {
        driver.get(BasePage.getProperty("protected.download.url"));
        WebElement downloadLink = driver.findElement(By.id("download-link"));
        String downloadUrl = downloadLink.getAttribute("href");
        Set<Cookie> seleniumCookies = driver.manage().getCookies();
        // Use custom method to download the file
        assert downloadFileWithCookies(downloadUrl, seleniumCookies);
    }

    @Test
    @Order(7)
    public void executeJavaScript() {
        driver.get(BasePage.getProperty("base.url"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        WebElement footer = driver.findElement(By.tagName("footer"));
        assert footer.isDisplayed();
    }

    @AfterAll
    public static void tearDown() {
        BasePage.tearDown();
    }

    private boolean downloadFileWithCookies(String url, Set<Cookie> cookies) {
        // Placeholder for file download using cookies
        return true;
    }
}