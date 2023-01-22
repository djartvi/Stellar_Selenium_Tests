package pom;

import credentials.User;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@RequiredArgsConstructor
public class RegisterPage {

    @Getter
    private static final String PREFIX = "register";

    @NonNull
    private final WebDriver driver;

    private final By name = By.xpath("//*[text()='Имя']/../*[@type='text']");
    private final By email = By.xpath("//*[text()='Email']/../*[@type='text']");
    private final By password = By.xpath("//*[@type='password']");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By loginButton = By.xpath("//*[text()='Войти']");
    private final By wrongPassword = By.xpath("//*[@type='password']/../../*[text()='Некорректный пароль']");

    @Step("Input name into name field")
    public void inputName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }

    @Step("Input email into email field")
    public void inputEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    @Step("Input password into password field")
    public void inputPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    @Step("Click register button")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Click login button")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Register user")
    public void registerUser(User user) {
        inputName(user.getName());
        inputEmail(user.getEmail());
        inputPassword(user.getPassword());
        clickRegisterButton();

    }

    @Step("Waiting for visibility of login page")
    public void waitRegistration() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.urlToBe(MainPage.getURL() + LoginPage.getPREFIX()));
    }

    @Step("Check wrong password warning under the password field")
    public boolean isWrongPassword() {
        return driver.findElements(wrongPassword).size() > 0;
    }

    @Step("Check registration of user")
    public boolean isRegistered() {
        boolean result;

        try {
            waitRegistration();
            result = true;
        } catch (TimeoutException e) {
            result = false;
        }

        return result;
    }
}
