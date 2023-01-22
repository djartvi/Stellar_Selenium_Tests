package navigation;

import api.Token;
import api.UserClient;
import credentials.User;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pom.AccountPage;
import pom.BrowserSelect;
import pom.MainPage;

import static org.junit.Assert.assertTrue;

public class NavigationUserLoggedInTest {

    @Rule
    public BrowserSelect browserSelect = new BrowserSelect();

    private Response login;
    private MainPage mainPage;
    private AccountPage accountPage;

    private final UserClient userClient = new UserClient();
    private final User user = User.randomUser();

    @Before
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

    @After
    public void deleteUser() throws InterruptedException {
        userClient.getTokenAndDeleteUser(login);
    }
}
