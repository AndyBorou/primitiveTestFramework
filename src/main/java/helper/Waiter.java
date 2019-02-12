package helper;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

    WebDriver webDriver;

    public Waiter(WebDriver driver) {
        this.webDriver = driver;
    }

    public WebElement waitForElementToBeDisplayed(WebElement element){
        return new WebDriverWait(webDriver, 20).until(
                ExpectedConditions.visibilityOf(element)
        );
    }

    public List<WebElement> waitForElementsListToBeDisplayed(List<WebElement> element){

       waitForElementToBeDisplayed(element.get(0));
       return element;
    }

    public WebElement waitForElementToBeClicable(WebElement element){
        return new WebDriverWait(webDriver, 20).until(
                ExpectedConditions.elementToBeClickable(element)
        );
    }
}
