package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import pages.LoginPage;

public class LoginActions extends LoginPage {
	
	public LoginActions(WebDriver driver) {
        super(driver);
    }
	
	@Override
	public LoginActions verifySymbol() {
	    String expected = "Amazon.in";
	    String actual = getDriver().findElement(symbol).getAttribute("aria-label");
	    Assert.assertEquals(actual, expected, "Logo mismatch");
	    return this;
	}

    @Override
    public SignInActions clickSignInButton() {
    	Actions action = new Actions(getDriver());
        action.moveToElement(getDriver().findElement(signinButton)).build().perform();
        action.click(getDriver().findElement(actualSigninButton)).perform();
        return new SignInActions(getDriver());
    }

}
