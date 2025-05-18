package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import pages.DashboardPage;

public class DashboardActions extends DashboardPage {

    public DashboardActions(WebDriver driver) {
        super(driver);
    }

    public DashboardActions verifySymbol() {
    	String expected = "Amazon.in Prime";
        String actual = getDriver().findElement(symbol).getAttribute("aria-label");
        Assert.assertEquals(actual, expected, "Not matching Logo");
        return this;
    }

    public SignInActions signOut() {
    	Actions action = new Actions(getDriver());
        action.moveToElement(getDriver().findElement(accountAndListmenu)).build().perform();
        getDriver().findElement(signOut).click();
        return new SignInActions(getDriver());
    }

	
}
