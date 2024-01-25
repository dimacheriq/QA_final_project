import driverFactory.DriverSetUp;
import functions.ActionClass;
import functions.AssertionsClass;
import functions.ElementsClass;
import functions.WaitersClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.AutoPage;
import pages.BasePage;
import pages.ClickerPage;
import pages.MapPage;
import utils.TestResultListeners;

@Listeners(TestResultListeners.class)
public class BaseTest {

    protected WebDriver driver = DriverSetUp.startChromeDriver();

    protected ActionClass action = new ActionClass(driver);
    protected AssertionsClass assertions = new AssertionsClass(driver);
    protected ElementsClass elements = new ElementsClass(driver);
    protected WaitersClass waiters = new WaitersClass(driver);

    protected BasePage basePage = new BasePage(driver);
    protected ClickerPage clickerPage = new ClickerPage(driver);
    protected AutoPage autoPage = new AutoPage(driver);
    protected MapPage mapPage = new MapPage(driver);

    @BeforeSuite
    public void startDriver() {
        driver = DriverSetUp.startChromeDriver();
    }

    @AfterSuite
    public void closeDriver() {
        driver.quit();
    }
}
