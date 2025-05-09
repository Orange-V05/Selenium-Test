package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import base.BasePage;

public class SignUpTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        BasePage.setUp();
        driver = BasePage.getDriver();
        driver.get(BasePage.getProperty("base.url"));
        homePage = new HomePage();  // No longer passing WebDriver here
    }

    @Test
    public void testSignUp() {
        LoginPage loginPage = homePage.clickSignIn();

        // 1. First Name Field
        driver.findElement(By.xpath("//input[@name='firstName' and @placeholder='First Name']")).sendKeys("John");

        // 2. Last Name Field
        driver.findElement(By.xpath("//input[@name='lastName' and @placeholder='Last Name']")).sendKeys("Doe");

        // 3. Email Field (complex XPath example)
        driver.findElement(By.xpath("//input[@type='email' and @name='email' and @aria-label='Email Address']")).sendKeys("john.doe@example.com");

        // 4. Username Field
        driver.findElement(By.xpath("//input[@name='username' and contains(@id,'username')]")).sendKeys("john_doe_123");

        // 5. Password Field (complex XPath example)
        driver.findElement(By.xpath("//input[@name='password' and @placeholder='Create a password']")).sendKeys("SecurePassword123!");

        // 6. Sign-Up Button
        driver.findElement(By.xpath("//button[contains(@class,'sign-up') and text()='Sign Up']")).click();

        // Add assertions for sign-up success if needed
    }

    @AfterEach
    public void tearDown() {
        BasePage.tearDown();
    }
}
