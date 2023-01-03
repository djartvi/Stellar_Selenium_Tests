package constructor;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pom.BrowserSelect;
import pom.LoginPage;
import pom.MainPage;

import static org.junit.Assert.assertTrue;

public class Constructor {
    @Rule
    public BrowserSelect browserSelect = new BrowserSelect();

    private MainPage mainPage;

    @Before
    public void openMainPage() {
        mainPage = new MainPage(browserSelect.getDriver());

        mainPage.open();
    }

    @Test
    public void constructorSectionTest() throws InterruptedException {
        mainPage.clickSousesButton();
        int sousesY = mainPage.getElementLocation(mainPage.getContainerSouses());

        mainPage.clickFilingsButton();
        int filingsY = mainPage.getElementLocation(mainPage.getContainerFilings());

        mainPage.clickBunsButton();
        int bunsY = mainPage.getElementLocation(mainPage.getContainerBuns());

        assertTrue(sousesY==filingsY && sousesY==bunsY);
    }
}
