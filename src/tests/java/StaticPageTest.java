package tests;

import base.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class StaticPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        BasePage.setUp();
        driver = BasePage.getDriver();
    }

    @Test
    public void testContactPage() {
        driver.get(BasePage.getProperty("contact.url"));
        String title = driver.getTitle();
        System.out.println("Page Title: " + title); // ✅ Print the title to console
        // Add assertion to verify the title
        assert title != null && !title.isEmpty();
    }

    @AfterEach
    public void tearDown() {
        BasePage.tearDown();
    }
}
