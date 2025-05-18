package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import actions.DashboardActions;
import actions.SignInActions;

public abstract class SignInPage {
	
	protected By mobileOrEmailField = By.id("ap_email_login");
	protected By continueField = By.xpath("//input[@type='submit']");
	protected By passwordField = By.name("password");
	protected By signinButton = By.xpath("(//input[@class='a-button-input'])[1]");
	protected By countryCodeField = By.id("claim-input-dropdown-select-element");
	protected By signInOrCreateAccountTextBox = By.xpath("//h1[contains(text(),'Sign in or create account')]");
	
	private WebDriver driver;

	public SignInPage(WebDriver driver) {
        this.setDriver(driver);
    }
	
	 public abstract SignInActions verifySignInOrCreateAccountforSignIn();
	 public abstract SignInActions loginWithCredentials(String username, String password);
	 public abstract DashboardActions clickSignin();
	 
	 public WebDriver getDriver() {
		return driver;
	 }

	 public void setDriver(WebDriver driver) {
		this.driver = driver;
	 }

}
