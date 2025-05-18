package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

public class DriverFactory {

    // ThreadLocal to ensure each thread has its own WebDriver instance
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * Initializes the WebDriver instance based on browser type.
     * @param browser The name of the browser (e.g., "chrome", "firefox")
     */
    public WebDriver initDriver() {
    	String browser = ConfigReader.getProperty("browser");
        System.out.println("Initializing browser: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
        	tlDriver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
        	tlDriver.set(new FirefoxDriver());
        } else {
            System.out.println("Invalid browser: " + browser);
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        // Common WebDriver settings
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return getDriver();
    }

    /**
     * Returns the thread-safe WebDriver instance.
     * @return WebDriver instance associated with the current thread
     */
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    /**
     * Quits the WebDriver instance for the current thread and removes it from ThreadLocal.
     */
    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}