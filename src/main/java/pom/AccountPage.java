package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private final WebDriver driver;

    private final By logoutButton = By.xpath("//*[text()='Выход']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click logout")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    @Step("Check registered account page exists")
    public boolean  isDisplayed() {
        return driver.findElements(logoutButton).size() > 0;
    }
}
