package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SavePage extends BasePage{
    public SavePage(WebDriver driver) {
        super(driver);
    }

    private static class Locators {
        private static final By modalDialog = By.xpath("//*[@id='modal-dialog']/div/div[2]/div");
        private static final By introduceBtn = By.xpath("//*[@id='QA0Szd']/div/div/div[1]/div[3]/div/div[1]/div/div/div[2]/div[4]/div[5]/button");
        private static final By closeModalDialog = By.cssSelector("#modal-dialog>div>div.hoUMge>div>div.ryQ5yd>button");
        private static final By headOfModalDialog = By.xpath("//*[@id='modal-dialog']/div/div[2]/div/div[3]/div/div/div/div[1]/h1");
        private static final By aroundOptions = By.xpath("//*[@id='QA0Szd']/div/div/div[1]/div[3]/div/div[1]/div/div/div[2]/div[4]/div[3]/button/span");
        private static final By options = By.xpath("//*[@id='ydp1wd-haAclf']");
        private static final By firstLastPlace = By.xpath("//*[@id='QA0Szd']/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[3]/button[1]/div[2]/div[1]");
        private static final By lastPlace = By.xpath("//*[@id='QA0Szd']/div/div/div[1]/div[1]/ul/li[3]/button/div[1]/span");
        private static final By saveBtn = By.xpath("//*[@id='QA0Szd']/div/div/div[1]/div[2]/div/div[1]/div/div/div[4]/div[2]/button");
        private static final By closeSearchBtn = By.xpath("//*[@id='searchbox']/div[2]/button");
        private final static By hotelsLviv = By.xpath("//*[@id='QA0Szd']/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[1]/div[2]/div[2]");
        private static final By anotherSearch = By.xpath("//*[@id='sb_ifc51']/input");
        private static final By routeBtn = By.xpath("//*[@id='QA0Szd']/div/div/div[1]/div[2]/div/div[1]/div/div/div[4]/div[1]/button");
        private static final By carRoute = By.xpath("//*[@id='omnibox-directions']/div/div[2]/div/div/div/div[2]");
        private static final By searchBoxInput = By.id("searchboxinput");
        private final static By searchBtn = By.id("searchbox-searchbutton");
        private final static By afterSearchText = By.xpath("//*[@id='QA0Szd']/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div/div[1]/div[1]/h1");

    }

    private static class Strings {

        private final static String websiteUrl = "https://www.google.com/maps";
        private final static String searchHistoryPlace = "Музей історії Полтавської битви";

        private final static String introduce = "Поділитися";
        private final static String searchOptionHotel = "Hotel";
    }
    public void openWebsite (){
        logger.info("Open website");
        driver.get(SavePage.Strings.websiteUrl);
    }
    public void inputStream (){
        logger.info("Ввожу текст в поле пошуку" + SavePage.Strings.searchHistoryPlace);
        elements.sendKeys(SavePage.Locators.searchBoxInput, SavePage.Strings.searchHistoryPlace);
    }
    public void clickOnSearchBtn (){
        logger.info("Клікаю елемент для пошуку" + SavePage.Locators.searchBtn);
        elements.click(SavePage.Locators.searchBtn);

    }
    public void assertSearchSettlement (){
        assertions.equalsOfText(getTextAfterSearch(), SavePage.Strings.searchHistoryPlace);

    }
    public String getTextAfterSearch (){

        waiters.waitForVisabilityOfWebElement(SavePage.Locators.afterSearchText);
        return elements.getTextFromElement(SavePage.Locators.afterSearchText);
    }
    public String getTextLastPlacesBox (){

        waiters.waitForVisabilityOfWebElement(Locators.firstLastPlace);
        return elements.getTextFromElement(Locators.firstLastPlace);
    }
    public void seeLastPlace (){
        logger.info("");
        waiters.waitForVisabilityOfWebElement(Locators.lastPlace);
        elements.click(Locators.lastPlace);

    }
    public void assertLastPlace(){
        assertions.equalsOfText(Strings.searchHistoryPlace,getTextLastPlacesBox());
    }
    public void optionsOfPlace(){
        logger.info("");
        waiters.waitForVisabilityOfWebElement(Locators.firstLastPlace);
        elements.click(Locators.firstLastPlace);
        logger.info("");
        waiters.waitForVisabilityOfWebElement(Locators.aroundOptions);
        elements.click(Locators.aroundOptions);
    }
    public void assertVisabilityOpt(){
        assertions.isValid(Locators.options);
    }
    public void introduceThisPlace(){
        logger.info("click button Поділитися");
        waiters.waitForVisabilityOfWebElement(Locators.introduceBtn);
        elements.click(Locators.introduceBtn);
        logger.info("open window with introduce options");
        waiters.waitForVisabilityOfWebElement(Locators.headOfModalDialog);
      //  logger.info("close modal dialog");
      //  elements.click(Locators.closeModalDialog);
    }
    public void assertModalDialog(){
        assertions.isValid(Locators.modalDialog);
        assertions.equalsOfText(getTextHeadModalDialog(),Strings.introduce);
    }
    public String getTextHeadModalDialog(){
        waiters.waitForVisabilityOfWebElement(Locators.headOfModalDialog);
        return elements.getTextFromElement(Locators.headOfModalDialog);
    }


}