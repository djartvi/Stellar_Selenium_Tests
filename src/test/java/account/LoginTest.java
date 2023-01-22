package account;

import api.UserClient;
import credentials.User;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pom.*;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    @Rule
    public BrowserSelect browserSelect = new BrowserSelect();

    private User user;

    private MainPage mainPage;
    private LoginPage loginPage;
    private final UserClient userClient = new UserClient();

    @Before
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

    @After
    public void assertAndDeleteUser() throws InterruptedException {
        userClient.getTokenAndDeleteUser(userClient.login(user));
    }
}
