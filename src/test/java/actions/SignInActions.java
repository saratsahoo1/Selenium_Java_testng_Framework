package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pages.SignInPage;


public class SignInActions extends SignInPage{
	
	public  SignInActions(WebDriver driver) {
        super(driver);
    }
	
	@Override
	public SignInActions verifySignInOrCreateAccountforSignIn() {
		 
		WebElement container = getDriver().findElement(By.xpath("//div[@id='claim-collection-container']"));
        WebElement heading = container.findElement(By.xpath(".//h1[contains(normalize-space(), 'Sign in or create account')]"));
        String actualText = heading.getText().trim();
        String expectedText = "Sign in or create account";
        Assert.assertEquals(actualText, expectedText, "Expected heading text is not displayed.");
        return this;
	}
	
	public SignInActions loginWithCredentials(String username, String password) {
	    getDriver().findElement(mobileOrEmailField).sendKeys(username);
	    
	    if (username.matches("\\d+")) {
            Select select = new Select(getDriver().findElement(countryCodeField));
            select.selectByVisibleText("India +91");
        }
	    getDriver().findElement(continueField).click();
	    
	    getDriver().findElement(passwordField).sendKeys(password);
	    
	    return this;
	}
	
    @Override
    public DashboardActions clickSignin() {
        getDriver().findElement(signinButton).click();
        return new DashboardActions(getDriver());
    }
    
}