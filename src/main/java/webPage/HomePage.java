package webPage;

import static helper.ProcessElement.getValue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  PageObject{

    @FindBy(xpath = ".//*[contains(text(), 'SIGN-OFF')]")
    private WebElement logOutButton;

    By classType = By.xpath(".//input[contains(@name, 'servClass')]");


    public HomePage(WebDriver driver) {
        super(driver);
        checkPage(waiter.waitForElementToBeClicable(logOutButton));
    }

    public LoginPage logOut(){
        waiter.waitForElementToBeClicable(logOutButton).click();
        return new LoginPage(driver);
    }

    public List<String> getValues(){
        waiter.waitForElementToBeClicable(driver.findElement(classType));
        return getValue(driver.findElements(classType));
    }
}
