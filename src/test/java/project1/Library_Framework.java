package project1;

import driverFactory.DriverFactory;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webPage.HomePage;
import webPage.LoginPage;

public class Library_Framework {

    WebDriver driver;

    private static final List<String> EXPECTED_VALUES_NAMES = Arrays
            .asList("Coach", "Business", "First");

    private HomePage homePage;

    @BeforeClass
    private void beforeClass() {
        driver = new DriverFactory().driverFactoryDefoult();
    }

    @BeforeMethod
    private void beforeMethod() {
        homePage = new LoginPage(driver, "http://newtours.demoaut.com/").login("Mercury", "mercury");
    }

    @Test
    private void test() {
        Assert.assertEquals(homePage.getValues(), EXPECTED_VALUES_NAMES);
    }

    @AfterMethod
    private void afterMethod() {
        homePage.logOut();
    }

    @AfterClass
    private void finish() {
        driver.quit();
    }
}
