package pom;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RequiredArgsConstructor
public class PasswordRecoveryPage {

    @Getter
    private static final String PREFIX = "forgot-password";

    @NonNull
    private final WebDriver driver;

    private final By loginButton = By.xpath("//*[text()='Войти']");

    @Step("Click login button")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
