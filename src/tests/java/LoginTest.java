package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import base.BasePage;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setup() {
        BasePage.setUp();
        driver = BasePage.getDriver();
        driver.get(BasePage.getProperty("login.url"));
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.login("username", "password");
        // Add assertions here to verify successful login
    }

    @AfterEach
    public void tearDown() {
        BasePage.tearDown();
    }
}