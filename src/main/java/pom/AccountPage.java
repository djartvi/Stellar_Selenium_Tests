package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;

    private By logoutButton = By.xpath("//*[text()='Выход']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public boolean  isDisplayed() {
        return driver.findElements(logoutButton).size() > 0;
    }
}
