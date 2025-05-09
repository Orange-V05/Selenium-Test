package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class LogoutPage {
    private By logoutButton = By.id("logoutButton");

    // Constructor that no longer takes a WebDriver argument
    public LogoutPage() {
        // No need to pass WebDriver to BasePage constructor anymore
    }

    public void logout() {
        BasePage.getDriver().findElement(logoutButton).click();
    }
}
