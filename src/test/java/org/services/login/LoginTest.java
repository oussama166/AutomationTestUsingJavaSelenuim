package org.services.login;

import org.services.pages.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void LoginTestUsingValidUserIdAndPassword() {
        driver.get(BASE_URL);

        loginPage.setUserId(dotEnv.get("LOGIN_CREDENTIAL_USERID"));
        loginPage.setPassword(dotEnv.get("LOGIN_CREDENTIAL_PASSWORD"));
        var homePage = loginPage.clickLoginButton();

        boolean loggedIn =  homePage.isSlideHeaderPresent();

        Assert.assertTrue(loggedIn);

    }

    @Test(description = "Failed login when the credential not valid")
    public void LoginTestUsingInvalidUserIdAndPassword() {
        driver.get(BASE_URL);
        loginPage.setUserId("invalid");
        loginPage.setPassword("invalid");

        var homePage = loginPage.clickLoginButton();
        String errorMsg = loginPage.getAlertText();


        Assert.assertEquals(errorMsg, "User is not valid");
    }


}
