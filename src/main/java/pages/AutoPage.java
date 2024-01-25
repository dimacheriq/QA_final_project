package pages;

import org.openqa.selenium.WebDriver;

public class AutoPage extends BasePage{
    public AutoPage(WebDriver driver) {
        super(driver);
    }

    public void autoVoid(){
        System.out.println("Auto");
    }
}
