package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By contactLink = By.linkText("Contact Us");
    private By signInLink = By.linkText("Sign In");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToContactPage() {
        driver.findElement(contactLink).click();
    }

    public LoginPage clickSignIn() {
        driver.findElement(signInLink).click();
        return new LoginPage(driver);
    }
}