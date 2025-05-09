package tests;

import base.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormTest {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        BasePage.setUp();
        driver = BasePage.getDriver();
    }

    @Test
    public void testFormSubmission() {
        driver.get(BasePage.getProperty("case.tracker.url"));

        // Wait for the form fields to be visible
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='name']")));  // Complex XPath for name field
        nameField.sendKeys("Vardaan");

        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        emailField.sendKeys("vardaankapania48@gmail.com");

        WebElement subjectField = driver.findElement(By.xpath("//input[@name='subject']"));
        subjectField.sendKeys("Test Subject");

        WebElement messageField = driver.findElement(By.xpath("//textarea[@name='message']"));
        messageField.sendKeys("This is a test message.");

        // Submit the form using complex XPath
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submitButton.click();

        // Optionally, you can add a wait to ensure submission was successful,
        // for example, checking for a success message or confirmation
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='confirmation-message']")));  // Example complex XPath for confirmation message

        // Optionally, you can assert if the confirmation message is displayed
        assert confirmationMessage.isDisplayed();
    }

    @AfterEach
    public void tearDown() {
        BasePage.tearDown();
    }
}
