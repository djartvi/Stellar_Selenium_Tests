package account;

import credentials.Password;
import credentials.User;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pom.*;

import static org.junit.Assert.assertTrue;

public class RegisterTest {
    @Rule
    public BrowserSelect browserSelect = new BrowserSelect();

    private RegisterPage registerPage;

    @Before
    public void goToRegisterPage() {
        MainPage mainPage = new MainPage(browserSelect.getDriver());
        LoginPage loginPage = new LoginPage(browserSelect.getDriver());
        registerPage = new RegisterPage(browserSelect.getDriver());

        mainPage
                .open()
                .clickAccountButton();

        loginPage
                .scrollToRegister()
                .clickRegister();
    }

    @Test
    @DisplayName("Check registration with valid password length")
    public void registerTest() {
        User user = User.randomUser(Password.VALID_LENGTH);

        registerPage.registerUser(user);

        assertTrue(registerPage.isRegistered());
    }

    @Test
    @DisplayName("Check registration with invalid password length")
    public void wrongPasswordTest() {
        User user = User.randomUser(Password.INVALID_LENGTH);

        registerPage.registerUser(user);

        assertTrue(registerPage.isWrongPassword());
    }
}
