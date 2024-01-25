package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class MapPage extends BasePage{
    public MapPage(WebDriver driver) {
        super(driver);
    }
    private static class Locators {
        private static final  By closeSearchBtn = By.xpath("//*[@id='searchbox']/div[2]/button");
        private final static By hotelsLviv = By.xpath("//*[@id='QA0Szd']/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[1]/div[2]/div[2]");
        private static final By anotherSearch = By.xpath("//*[@id='sb_ifc51']/input");
        private static final By routeBtn = By.xpath("//*[@id='QA0Szd']/div/div/div[1]/div[2]/div/div[1]/div/div/div[4]/div[1]/button");
        private static final By carRoute = By.xpath("//*[@id='omnibox-directions']/div/div[2]/div/div/div/div[2]");
        private static final By searchBoxInput = By.id("searchboxinput");
        private final static By searchBtn = By.id("searchbox-searchbutton");
        private final static By afterSearchText = By.xpath("//*[@id='QA0Szd']/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div/div[1]/div[1]/h1");
    }
    private static class Strings {
        private final static String websiteUrl = "https://www.google.com/maps/";
        private final static String searchSettlement = "Львів";

        private final static String searchOptionFuel = "АЗС";
        private final static String searchOptionHotel = "Hotel";

    }
    public void openWebsite (){
        logger.info("Open website");
        driver.get(Strings.websiteUrl);
    }
    public void inputStream (){
        logger.info("Ввожу текст в поле пошуку" + Strings.searchSettlement);
        elements.sendKeys(Locators.searchBoxInput, Strings.searchSettlement);
    }
    public void clickOnSearchBtn (){
        logger.info("Клікаю елемент для пошуку" + Locators.searchBtn);
        elements.click(Locators.searchBtn);

    }
    public void assertSearchSettlement (){
        assertions.equalsOfText(getTextAfterSearch(),Strings.searchSettlement);

    }
    public String getTextAfterSearch (){

        waiters.waitForVisabilityOfWebElement(Locators.afterSearchText);
        return elements.getTextFromElement(Locators.afterSearchText);
    }
    public String getTextSearchBox (){

        waiters.waitForVisabilityOfWebElement(Locators.searchBoxInput);
        return elements.getTextFromElement(Locators.searchBoxInput);
    }
    public void clickOnRouteBtn (){
        logger.info("Клікаю клавішу 'маршрут'" + Locators.routeBtn);
        elements.click(Locators.routeBtn);
    }
    public void assertRouteBuild (){
        assertions.isValid(Locators.carRoute);
    }
    public void clickWithKeys (){
        logger.info("Клікаю на поле пошуку кінцевої точки маршруту" + Locators.anotherSearch);
        elements.click(Locators.anotherSearch);
        logger.info("Вставляю текст і натискаю клавішу 'Enter'" + Strings.searchOptionFuel);
        elements.sendKeys(Locators.anotherSearch, Strings.searchOptionFuel, Keys.ENTER);
    }
    public void searchHotel() {
        logger.info("Ввожу в поле пошуку і клікаю " + Strings.searchOptionHotel);
        elements.sendKeys(Locators.searchBoxInput, Strings.searchOptionHotel, Keys.ENTER);
    }
    public void assertValidElement(){
        assertions.isValid(Locators.hotelsLviv);
    }
    public void closeSearch(){
        logger.info("Close search" + Locators.closeSearchBtn);
        elements.click(Locators.closeSearchBtn);
    }
    public void assertEmptySearch(){
        assertions.isEmpty(getTextSearchBox());
    }



}
