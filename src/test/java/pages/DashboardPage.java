package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import actions.DashboardActions;
import actions.SignInActions;

public abstract class DashboardPage {
	
	protected By symbol = By.xpath("//a[@id='nav-logo-sprites']");
	protected By accountAndListmenu = By.xpath("//div[contains(@id,'nav-link-accountList')]");       
	protected By signOut = By.id("nav-item-signout");      
	
	private WebDriver driver;

	public DashboardPage(WebDriver driver) {
        this.setDriver(driver);
    }
    
	public abstract DashboardActions verifySymbol();
	public abstract SignInActions signOut();
    
	public WebDriver getDriver() {
			return driver;
	}

	public void setDriver(WebDriver driver) {
			this.driver = driver;
	}
}
	