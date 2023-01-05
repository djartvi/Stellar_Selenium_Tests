package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public static final String PREFIX = "login";

    private final WebDriver driver;

    private final By shopLogo = By.xpath("//*[@xmlns='http://www.w3.org/2000/svg']");
    private final By email = By.xpath("//*[@type='text']");
    private final By password = By.xpath("//*[@type='password']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By registerButton = By.xpath("//*[contains(@href,'/register')]");
    private final By passwordRecoveryButton = By.xpath("//*[contains(@href,'/forgot-password')]");
    private final By constructorButton = By.xpath("//*[text()='Конструктор']");

    public LoginPage(WebDriver driver) {
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
    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }

    @Step("Click register user")
    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    @Step("Click recover password")
    public void clickPasswordRecoveryButton() {
        driver.findElement(passwordRecoveryButton).click();
    }

    @Step("Scroll to element to make it visible")
    public LoginPage scrollToRegister() {
        WebElement element = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    @Step("Scroll to element to make it visible")
    public LoginPage scrollToPasswordRecovery() {
        WebElement element = driver.findElement(passwordRecoveryButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    @Step("Check visibility of login page")
    public boolean isDisplayed() {
        return driver.findElements(loginButton).size() > 0;
    }
}
