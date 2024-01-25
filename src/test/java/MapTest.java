import org.testng.Assert;
import org.testng.annotations.Test;

public class MapTest extends BaseTest{
    @Test
    public void searchSettlement(){
        mapPage.openWebsite();
        mapPage.inputStream();
        mapPage.clickOnSearchBtn();
        mapPage.assertSearchSettlement();
    }
    @Test (dependsOnMethods = {"searchSettlement"})
    public void buildRoute (){
        mapPage.clickOnRouteBtn();
        mapPage.assertRouteBuild();
    }
    @Test (dependsOnMethods = {"buildRoute"})
    public void anotherSearch (){
        mapPage.clickWithKeys();
        mapPage.assertRouteBuild();
    }
    @Test (dependsOnMethods = {"anotherSearch"})
    public void searchHotel(){
        mapPage.openWebsite();
        mapPage.inputStream();
        mapPage.clickOnSearchBtn();
        mapPage.searchHotel();
        mapPage.assertValidElement();
    }
    @Test (dependsOnMethods = {"searchHotel"})
    public void closeSearch(){
        mapPage.closeSearch();
        mapPage.assertEmptySearch();
    }
}
