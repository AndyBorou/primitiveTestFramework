package webPage;

import helper.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    public Waiter waiter;

    protected WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
        pageInit();
    }

    public PageObject(WebDriver driver, String url){
        this.driver = driver;
        driver.navigate().to(url);
        pageInit();
    }

    private void pageInit(){
        PageFactory.initElements(driver, this);
        waiter = new Waiter(driver);
    }

    public void checkPage(WebElement element){
        if(!waiter.waitForElementToBeDisplayed(element).isDisplayed()){
            throw new RuntimeException();
        }
    }
}
