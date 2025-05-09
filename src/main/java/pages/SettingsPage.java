package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage {
    private By settingsHeader = By.tagName("h1");

    // No need to pass the WebDriver here
    public SettingsPage() {
        // No need to initialize WebDriver in the constructor
    }

    public boolean isAtSettingsPage() {
        // Directly use the static WebDriver instance from BasePage
        return BasePage.getDriver().findElement(settingsHeader).getText().contains("Settings");
    }
}
