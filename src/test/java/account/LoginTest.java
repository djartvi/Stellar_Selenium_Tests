package account;

import api.UserClient;
import base.BaseTest;
import credentials.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import pom.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    private User user;

    private MainPage mainPage;
    private LoginPage loginPage;
    private final UserClient userClient = new UserClient();

    @BeforeEach
    public void registerUser() throws InterruptedException {

        mainPage = new MainPage(browserSelect.getDriver());
        loginPage = new LoginPage(browserSelect.getDriver());

        user = User.randomUser();

        userClient.register(user);
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

        RegisterPage registerPage = new RegisterPage(browserSelect.getDriver());

        mainPage.goToPage(RegisterPage.getPREFIX());

        registerPage.clickLoginButton();

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

        mainPage.goToPage(PasswordRecoveryPage.getPREFIX());

        passwordRecoveryPage
                .clickLoginButton();

        loginPage
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickLoginButton();

        assertTrue(mainPage.registeredView());
    }

    @AfterEach
    @DisplayName("Delete user")
    public void deleteUser() throws InterruptedException {
        userClient.getTokenAndDeleteUser(userClient.login(user));
    }
}
