package webPage;

import helper.Waiter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageObject {

    @FindBy(xpath = ".//*[contains(@name,'userName')]")
    private WebElement userNameBox;

    @FindBy(xpath = ".//*[contains(@name, 'password')]")
    private WebElement passwordNameBox;

    @FindBy(xpath = ".//*[contains(@name, 'login')]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        checkPage(loginButton);
    }

    public HomePage login(String Username, String Password) {
        waiter.waitForElementToBeClicable(userNameBox).sendKeys(Username);
        waiter.waitForElementToBeClicable(passwordNameBox).sendKeys(Password);
        waiter.waitForElementToBeClicable(loginButton).click();
        return new HomePage(driver);
    }
}
