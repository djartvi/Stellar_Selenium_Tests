package account;

import credentials.User;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pom.*;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    @Rule
    public BrowserSelect browserSelect = new BrowserSelect();

    private MainPage mainPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private User user;

    @Before
    public void registerUser() {
        mainPage = new MainPage(browserSelect.getDriver());
        loginPage = new LoginPage(browserSelect.getDriver());
        registerPage = new RegisterPage(browserSelect.getDriver());
        user = User.randomUser();

        mainPage
                .open()
                .clickAccountButton();

        loginPage
                .scrollToRegister()
                .clickRegister();

        registerPage
                .registerUser(user);
    }

    @Test
    @DisplayName("Check login from login button")
    public void loginFromLoginButtonTest() {
        mainPage
                .open()
                .clickLoginButton();

        loginPage
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickLoginButton();

        assertTrue(mainPage.registeredView());
    }

    @Test
    @DisplayName("Check login from account button in header")
    public void loginFromAccountButtonTest() {
        mainPage
                .open()
                .clickAccountButton();

        loginPage
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickLoginButton();

        assertTrue(mainPage.registeredView());
    }

    @Test
    @DisplayName("Check login from registration page")
    public void loginFromRegisterPageTest() {
        loginPage
                .scrollToRegister()
                .clickRegister();

        registerPage
                .scrollToLoginButton()
                .clickLoginButton();

        loginPage
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickLoginButton();

        assertTrue(mainPage.registeredView());
    }

    @Test
    @DisplayName("Check login from password recovery page")
    public void loginFromPasswordRecoveryPageTest() {
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(browserSelect.getDriver());

        loginPage
                .scrollToPasswordRecovery()
                .clickPasswordRecoveryButton();

        passwordRecoveryPage
                .clickLoginButton();

        loginPage
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickLoginButton();

        assertTrue(mainPage.registeredView());
    }
}
