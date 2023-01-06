package account;

import api.UserClient;
import credentials.Password;
import credentials.User;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pom.*;

import static org.junit.Assert.assertTrue;

public class RegisterTest {

    @Rule
    public BrowserSelect browserSelect = new BrowserSelect();

    private User user;
    private RegisterPage registerPage;

    private final UserClient userClient = new UserClient();

    @Before
    public void goToRegisterPage() {

        MainPage mainPage = new MainPage(browserSelect.getDriver());
        registerPage = new RegisterPage(browserSelect.getDriver());

        mainPage.goToPage("register");
    }

    @Test
    @DisplayName("Check registration with valid password length")
    public void registerTest() {

        user = User.randomUser(Password.VALID_LENGTH);

        registerPage.registerUser(user);

        assertTrue(registerPage.isRegistered());
    }

    @Test
    @DisplayName("Check registration with invalid password length")
    public void wrongPasswordTest() {

        user = User.randomUser(Password.INVALID_LENGTH);

        registerPage.registerUser(user);

        assertTrue(registerPage.isWrongPassword());
    }

    @After
    public void deleteUser() throws InterruptedException {
        if (registerPage.isRegistered()) {
            userClient.getTokenAndDeleteUser(userClient.login(user));
        }
    }
}
