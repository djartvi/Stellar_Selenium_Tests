package pom;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;

    private By name = By.xpath("//*[text()='Имя']/../*[@type='text']");
    private By email = By.xpath("//*[text()='Email']/../*[@type='text']");
    private By password = By.xpath("//*[@type='password']");
    private By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
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

    public void registerRandomUser(int length) {
        Faker faker = new Faker();

        inputName(faker.name().firstName());
        inputEmail(faker.internet().safeEmailAddress());
        inputPassword(faker.internet().password(length, length + 1));
        clickRegisterButton();
    }

    public boolean isWrongPassword() {
        return driver.findElements(wrongPassword).size() > 0;
    }

    public boolean isRegistered() {
        boolean result;

        try {
            new WebDriverWait(driver, Duration.ofSeconds(3)).
                    until(ExpectedConditions.urlToBe(MainPage.getURL() + "login"));
            result = true;
        } catch (TimeoutException e) {
            result = false;
        }

        return result;
    }
}
