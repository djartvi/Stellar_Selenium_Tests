package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static final String PREFIX = "login";

    private final WebDriver driver;

    private final By email = By.xpath("//*[@type='text']");
    private final By password = By.xpath("//*[@type='password']");
    private final By loginButton = By.xpath("//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static String getPREFIX() {
        return PREFIX;
    }

    @Step("Input email into email field")
    public LoginPage inputEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
        return this;
    }

    @Step("Input password into password field")
    public LoginPage inputPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
        return this;
    }

    @Step("Click login button")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Check visibility of login page")
    public boolean isDisplayed() {
        return driver.findElements(loginButton).size() > 0;
    }
}
