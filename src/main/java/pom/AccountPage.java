package pom;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RequiredArgsConstructor
public class AccountPage {

    @Getter
    private static final String PREFIX = "account/profile";

    @NonNull
    private final WebDriver driver;

    private final By shopLogo = By.xpath("//*[@xmlns='http://www.w3.org/2000/svg']");
    private final By logoutButton = By.xpath("//*[text()='Выход']");
    private final By constructorButton = By.xpath("//*[text()='Конструктор']");

    @Step("Click logo in header")
    public void clickLogo() {
        driver.findElement(shopLogo).click();
    }

    @Step("Click constructor button in header")
    public void clickConstructor() {
        driver.findElement(constructorButton).click();
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
