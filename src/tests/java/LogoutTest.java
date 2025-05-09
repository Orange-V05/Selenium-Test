package tests;

import base.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutTest {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        BasePage.setUp();
        driver = BasePage.getDriver();
    }

    @Test
    public void testLogout() {
        driver.get(BasePage.getProperty("login.url"));
        driver.findElement(By.name("username")).sendKeys("wohoo");
        driver.findElement(By.name("password")).sendKeys("Fordstreets1");
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();

        driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();

        // Add assertion here to verify logout was successful
    }

    @AfterEach
    public void tearDown() {
        BasePage.tearDown();
    }
}