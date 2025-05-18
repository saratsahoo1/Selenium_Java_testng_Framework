package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;
import utils.ExcelUtil;
import utils.ExtentManager;

public class BaseTest {
	
	protected DriverFactory driverFactory;
	protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize DriverFactory
        driverFactory = new DriverFactory();

        // Launch the browser using config.properties values
        driver = driverFactory.initDriver();
        
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        
        String url = ConfigReader.getProperty("url");
        
        
        driver.get(url);
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown() {
        // Quit and cleanup the WebDriver
        DriverFactory.quitDriver();
        ExtentManager.flushExtentReport();
        ExcelUtil.close();
    }
}

