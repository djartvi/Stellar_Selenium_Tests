package base;


import org.junit.Rule;
import pom.BrowserSelect;

public abstract class BaseTest {

    @Rule
    public BrowserSelect browserSelect = new BrowserSelect();
}
