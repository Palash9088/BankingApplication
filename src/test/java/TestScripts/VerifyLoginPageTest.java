package TestScripts;//import java.util.*;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class VerifyLoginPageTest extends TestBase {
    //1. Verify login functionality of application

    @Test
    public void verifyLogin() {
        LoginPage loginPage = getLoginPageObj();
        String expectedTitle = "Guru99 Bank Home Page";
        String actualTitle = loginPage.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        ArrayList<String> credList = loginPage.getLoginCred();
        loginPage.enterLoginCredentials(credList.get(0), credList.get(1));

        loginPage.clickOnLoginBtn();

        boolean isUserAuthorized = loginPage.isUserAuthorized(credList.get(0));
        Assert.assertTrue(isUserAuthorized);
    }
}
