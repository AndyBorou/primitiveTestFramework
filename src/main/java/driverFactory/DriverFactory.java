package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    String HARDCODE_DRIVERNAME = "firefox";
    private WebDriver driver;

    public WebDriver driverFactoryDefoult() {
        return driverFactory(HARDCODE_DRIVERNAME);
    }

    public WebDriver driverFactory(String browserDriver) {
        switch (browserDriver) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                break;
            default:
                throw new IllegalArgumentException("incorrect driver name");
        }
        return driver;
    }
}
