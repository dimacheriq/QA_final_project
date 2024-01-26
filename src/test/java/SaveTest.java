import driverFactory.DriverSetUp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SaveTest extends BaseTest {
    @BeforeClass
    public void startDriver() {
        driver = DriverSetUp.startChromeDriver();
    }
    @Test
    public void searchHistoryPlace(){
        savePage.openWebsite();
        savePage.inputStream();
        savePage.clickOnSearchBtn();
        savePage.assertSearchSettlement();
    }
    @Test (dependsOnMethods = {"searchHistoryPlace"})
    public void seeLastPlaces (){
        savePage.seeLastPlace();
        savePage.assertLastPlace();
    }
    @Test(dependsOnMethods = {"seeLastPlaces"})
    public void aroundOfPlace(){
        savePage.optionsOfPlace();
        savePage.assertVisabilityOpt();
    }
    @Test(dependsOnMethods = {"aroundOfPlace"})
    public void introduceThisPlace(){
        savePage.introduceThisPlace();
        savePage.assertModalDialog();

    }

}
