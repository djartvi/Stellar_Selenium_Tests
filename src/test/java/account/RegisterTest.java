package account;

import api.UserClient;
import base.BaseTest;
import credentials.Password;
import credentials.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pom.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest extends BaseTest {

    private User user;
    private RegisterPage registerPage;

    private final UserClient userClient = new UserClient();

    @BeforeEach
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

    @AfterEach
    @DisplayName("Delete user")
    public void deleteUser() throws InterruptedException {

        if (registerPage.isRegistered()) {
            userClient.getTokenAndDeleteUser(userClient.login(user));
        }
    }
}
