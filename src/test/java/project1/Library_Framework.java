package project1;

import driverFactory.DriverFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webPage.HomePage;
import webPage.LoginPage;

public class Library_Framework {

    private WebDriver driver;
    private LoginPage loginPage;
    private Properties properties = new Properties();
    private final static String PROPERTIES_FILE_SOURCE = "config.properties";

    private static final List<String> EXPECTED_VALUES_NAMES = Arrays
            .asList("Coach", "Business", "First");

    private HomePage homePage;

    @BeforeClass
    private void beforeClass() {
        driver = new DriverFactory().driverFactoryDefoult();
        loginPage = new LoginPage(driver, "http://newtours.demoaut.com/");

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_SOURCE)) {
            properties.load(inputStream);
        } catch (IOException io) {
            System.err.println("Unable to load properties file : " + PROPERTIES_FILE_SOURCE);
        }
        properties.forEach((k, v) -> System.out.println("====== " + k + " : " + v + " ========"));
    }

    @BeforeMethod
    private void beforeMethod() {
        homePage = loginPage.login("Mercury", "mercury");
    }

    @Parameters({"paramName1", "paramName2"})
    @Test
    private void test1(@Optional("paramName1")String param1, @Optional("paramName2")String param2) {
        Assert.assertEquals(homePage.getValues(), EXPECTED_VALUES_NAMES);
        System.out.println("====== " + param1 + " " + param2 + " ========");

    }

    @AfterMethod(alwaysRun = true)
    private void afterMethod() {
        homePage.logOut();
    }

    @AfterSuite(alwaysRun = true)
    private void finish() {
        driver.quit();
    }
}
