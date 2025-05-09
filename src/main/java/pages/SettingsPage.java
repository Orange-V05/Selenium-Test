package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePage {
    private By settingsHeader = By.tagName("h1");

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAtSettingsPage() {
        return driver.findElement(settingsHeader).getText().contains("Settings");
    }
}