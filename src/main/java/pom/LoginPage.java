package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public static final String PREFIX = "login";

    private WebDriver driver;

    private By email = By.xpath("//*[@type='text']");
    private By password = By.xpath("//*[@type='password']");
    private By loginButton = By.xpath("//button[text()='Войти']");
    private By registerButton = By.xpath("//*[contains(@href,'/register')]");
    private By passwordRecoveryButton = By.xpath("//*[contains(@href,'/forgot-password')]");
    private By constructorButton = By.xpath("//*[text()='Конструктор']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage inputEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public void clickPasswordRecoveryButton() {
        driver.findElement(passwordRecoveryButton).click();
    }

    public LoginPage scrollToRegister() {
        WebElement element = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public LoginPage scrollToPasswordRecovery() {
        WebElement element = driver.findElement(passwordRecoveryButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public void clickConstructor() {
        driver.findElement(constructorButton).click();
    }

    public boolean isDisplayed() {
        return driver.findElements(loginButton).size() > 0;
    }
}
