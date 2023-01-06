package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    private static final String PREFIX = "account/profile";

    private final WebDriver driver;

    private final By shopLogo = By.xpath("//*[@xmlns='http://www.w3.org/2000/svg']");
    private final By logoutButton = By.xpath("//*[text()='Выход']");
    private final By constructorButton = By.xpath("//*[text()='Конструктор']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

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

    public static String getPREFIX() {
        return PREFIX;
    }
}
