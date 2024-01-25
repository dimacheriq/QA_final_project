package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AssertionsClass {
    private final WebDriver driver;
    private final ElementsClass elementsClass;
    private final WaitersClass waiters;
    private final ActionClass action;

    public AssertionsClass(WebDriver driver) {
        this.driver = driver;
        elementsClass = new ElementsClass(driver);
        waiters = new WaitersClass(driver);
        action = new ActionClass(driver);
    }

    public void equalsOfInts(int actual, int expected){
        Assert.assertEquals(actual, expected, "Я ожидал получить " + expected + ", а получил " + actual);
    }
    public void equalsOfText(String actual, String expected){
        Assert.assertEquals(actual, expected, "В поле пошуку було введено " + expected + ",а пошук показав "+ actual);
    }
    public void isValid (By element){
        Assert.assertNotNull(element, "Очікував побачити " +element);
    }
    public void isEmpty (String text){
        Assert.assertNotNull(text, "I expected empty, but have " +text);
    }

}
