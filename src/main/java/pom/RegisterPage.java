package pom;

import credentials.User;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;

    private By name = By.xpath("//*[text()='Имя']/../*[@type='text']");
    private By email = By.xpath("//*[text()='Email']/../*[@type='text']");
    private By password = By.xpath("//*[@type='password']");
    private By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private By loginButton = By.xpath("//*[text()='Войти']");
    private By wrongPassword = By.xpath("//*[@type='password']/../../*[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }

    public void inputEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    public void inputPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public RegisterPage registerUser(User user) {
        inputName(user.getName());
        inputEmail(user.getEmail());
        inputPassword(user.getPassword());
        clickRegisterButton();

        return this;
    }

    public void waitRegistration() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.urlToBe(MainPage.getURL() + LoginPage.PREFIX));
    }

    public boolean isWrongPassword() {
        return driver.findElements(wrongPassword).size() > 0;
    }

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

    public RegisterPage scrollToLoginButton() {
        WebElement element = driver.findElement(loginButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }
}
