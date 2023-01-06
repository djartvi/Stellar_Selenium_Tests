package constructor;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pom.BrowserSelect;
import pom.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest {

    @Rule
    public BrowserSelect browserSelect = new BrowserSelect();

    private MainPage mainPage;

    @Before
    public void openMainPage() {

        mainPage = new MainPage(browserSelect.getDriver());

        mainPage.open();
    }

    @Test
    @DisplayName("Check buttons switching in constructor section")
    public void constructorButtonsTest() throws InterruptedException {

        int sousesY = mainPage
                .clickSousesButton()
                .getElementLocation(mainPage.getContainerSouses());

        int filingsY = mainPage
                .clickFilingsButton()
                .getElementLocation(mainPage.getContainerFilings());

        int bunsY = mainPage
                .clickBunsButton()
                .getElementLocation(mainPage.getContainerBuns());

        assertTrue(sousesY==filingsY && sousesY==bunsY);
    }

    @Test
    @DisplayName("Check manual scrolling in constructor section")
    public void constructorScrollingTest() {

        mainPage.scrollToElement(mainPage.getContainerBuns());
        boolean isBunsButtonActive = mainPage.isActiveButton(mainPage.getBunsButton());

        mainPage.scrollToElement(mainPage.getContainerSouses());
        boolean isSousesButtonActive = mainPage.isActiveButton(mainPage.getSousesButton());

        mainPage.scrollToElement(mainPage.getContainerFilings());
        boolean isFilingsButtonActive = mainPage.isActiveButton(mainPage.getFilingsButton());

        assertTrue(isBunsButtonActive && isSousesButtonActive && isFilingsButtonActive);
    }
}
