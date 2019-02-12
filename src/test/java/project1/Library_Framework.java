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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webPage.HomePage;
import webPage.LoginPage;

public class Library_Framework {

    private WebDriver driver;
    private LoginPage loginPage;

    private static final List<String> EXPECTED_VALUES_NAMES = Arrays
            .asList("Coach", "Business", "First");

    private HomePage homePage;

    @BeforeClass
    private void beforeClass() {
        driver = new DriverFactory().driverFactoryDefoult();
        loginPage = new LoginPage(driver, "http://newtours.demoaut.com/");
    }

    @BeforeMethod
    private void beforeMethod() {
        homePage = loginPage.login("Mercury", "mercury");
    }

    @Parameters({"paramName1", "paramName2"})
    @Test
    private void test1(String param1, String param2) {
        Assert.assertEquals(homePage.getValues(), EXPECTED_VALUES_NAMES);
        System.out.println("====== " + param1 + " " + param2 + " ========");
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
