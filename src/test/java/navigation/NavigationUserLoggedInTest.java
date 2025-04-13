package navigation;

import api.Token;
import api.UserClient;
import base.BaseTest;
import credentials.User;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pom.AccountPage;
import pom.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class NavigationUserLoggedInTest extends BaseTest {

    private Response login;
    private MainPage mainPage;
    private AccountPage accountPage;

    private final UserClient userClient = new UserClient();
    private final User user = User.randomUser();

    @BeforeEach
    public void goToRegisteredUserAccount() throws InterruptedException {

        mainPage = new MainPage(browserSelect.getDriver());
        accountPage = new AccountPage(browserSelect.getDriver());

        mainPage.open();

        userClient.register(user);
        login = userClient.login(user);

        new Token().storeTokens(browserSelect.getDriver(), login);

        mainPage.clickAccountButton();
    }

    @Test
    @DisplayName("Check navigation to account page from main page")
    @Description("User is logged in")
    public void goToAccount() {

        assertTrue(accountPage.isDisplayed());
    }

    @Test
    @DisplayName("Check navigation from constructor button")
    @Description("Check constructor button in header of account page")
    public void goToConstructorTest() {

        accountPage.clickConstructor();

        assertTrue(mainPage.isConstructorDisplayed());
    }

    @Test
    @DisplayName("Check navigation from logo button")
    @Description("Check logo button in header of account page")
    public void goToConstructorFromLogoTest() {

        accountPage.clickLogo();

        assertTrue(mainPage.isConstructorDisplayed());
    }

    @AfterEach
    public void deleteUser() throws InterruptedException {
        userClient.getTokenAndDeleteUser(login);
    }
}
