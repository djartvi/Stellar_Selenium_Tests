package base;

import org.junit.jupiter.api.extension.RegisterExtension;
import pom.BrowserSelect;


public abstract class BaseTest {

    @RegisterExtension
    protected BrowserSelect browserSelect = new BrowserSelect();
}
