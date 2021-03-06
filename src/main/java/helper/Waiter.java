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
        return new WebDriverWait(webDriver, 30).until(
                ExpectedConditions.visibilityOf(element)
        );
    }

    public WebElement waitForElementToBeClicable(WebElement element){
        return new WebDriverWait(webDriver, 30).until(
                ExpectedConditions.elementToBeClickable(element)
        );
    }
}
