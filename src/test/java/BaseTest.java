import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.WebDriverFactory;

public class BaseTest {

    protected WebDriver driver;
    @Before
    public void setup() {
        driver = WebDriverFactory.get();}
    @After
    public void teardown() {
        driver.quit();
    }
}
