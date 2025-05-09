package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class HomePage {
    private By contactLink = By.linkText("Contact Us");
    private By signInLink = By.linkText("Sign In");

    // Constructor does not take WebDriver as an argument
    public HomePage() {
        // No need to pass WebDriver to the constructor
    }

    public void goToContactPage() {
        BasePage.getDriver().findElement(contactLink).click();
    }

    public LoginPage clickSignIn() {
        BasePage.getDriver().findElement(signInLink).click();
        return new LoginPage(BasePage.getDriver()); // Pass WebDriver to LoginPage constructor
    }
}
