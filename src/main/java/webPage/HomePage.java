package webPage;

import static helper.ProcessElement.getValue;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  PageObject{

    @FindBy(xpath = ".//*[contains(text(), 'SIGN-OFF')]")
    private WebElement logOutButton;

    @FindBy(xpath = ".//input[contains(@name, 'servClass')]")
    private List<WebElement> classesTypes;

    public HomePage(WebDriver driver) {
        super(driver);
        checkPage(waiter.waitForElementToBeClicable(logOutButton));
    }

    public LoginPage logOut(){
        waiter.waitForElementToBeClicable(logOutButton).click();
        return new LoginPage(driver);
    }

    public List<String> getValues(){
        return getValue(waiter.waitForElementsListToBeDisplayed(classesTypes));
    }
}
