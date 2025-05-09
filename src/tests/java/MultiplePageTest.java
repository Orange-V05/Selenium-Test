package tests;

import base.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class MultiplePageTest {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        BasePage.setUp();
        driver = BasePage.getDriver();
    }

    @Test
    public void testMultiplePages() {
        String[] pages = {
                BasePage.getProperty("member.mywebsite.url"),
                BasePage.getProperty("member.myemail.url"),
                BasePage.getProperty("contact.url")
        };

        for (String url : pages) {
            driver.get(url);
            // Add assertions to verify each page loaded correctly
            assert driver.getTitle() != null && !driver.getTitle().isEmpty();
        }
    }

    @AfterEach
    public void tearDown() {
        BasePage.tearDown();
    }
}