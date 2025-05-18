package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import actions.LoginActions;
import actions.SignInActions;

public abstract class LoginPage {
	
	protected By symbol = By.xpath("//a[@href='/ref=nav_logo']");
	protected By signinButton =By.xpath("//span[text()='Hello, sign in']");
	protected By actualSigninButton =By.xpath("//span[text()='Sign in']");
	
	private WebDriver driver;

	 public LoginPage(WebDriver driver) {
	        this.setDriver(driver);
	  }
    
	public abstract LoginPage verifySymbol();
    public abstract SignInActions clickSignInButton();

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}



	
