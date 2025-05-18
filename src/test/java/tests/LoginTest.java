package tests;

import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.DashboardActions;
import actions.LoginActions;
import actions.SignInActions;
import base.BaseTest;
import utils.ExcelUtil;
import utils.RetryAnalyzer;

@Listeners(listeners.ExtentReportListener.class)
public class LoginTest extends BaseTest {

	@Test(dataProvider = "loginData",retryAnalyzer = RetryAnalyzer.class)
    public void loginFlowTest(String username, String password) {

        // Step 1: Login Page Actions
    	//If you don’t assign it, you lose that object reference.
        LoginActions loginActions = new LoginActions(driver);
        loginActions.verifySymbol();
        SignInActions signInActions = loginActions.clickSignInButton();

     
        signInActions.verifySignInOrCreateAccountforSignIn();
        signInActions.loginWithCredentials(username, password);
        DashboardActions dashboardActions = signInActions.clickSignin();

        // Step 3: Dashboard Page Actions
        
        dashboardActions.verifySymbol();
        SignInActions signInActions2 =   dashboardActions.signOut();

        // Step 4: Post Sign-Out Verification
        signInActions2.verifySignInOrCreateAccountforSignIn();
    }
    
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        List<Map<String, String>> testData = ExcelUtil.getTestData();
        Object[][] data = new Object[testData.size()][2];

        for (int i = 0; i < testData.size(); i++) {
            data[i][0] = testData.get(i).get("Username");
            data[i][1] = testData.get(i).get("Password");
        }

        ExcelUtil.close(); // Clean up
        return data;
    }
}
