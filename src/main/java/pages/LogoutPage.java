package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage {
    private By logoutButton = By.id("logoutButton");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        driver.findElement(logoutButton).click();
    }
}