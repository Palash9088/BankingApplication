package Pages;//import java.util.*;

import Base.PredefinedActions;
import Constants.ConstantPaths;
import Utils.PropertyReading;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends PredefinedActions {
    private static LoginPage loginPage;
    PropertyReading loginPageProp;
    PropertyReading loginPageCredProp;

    private LoginPage() {
        //Private Constructor for Singleton Design Pattern
        loginPageProp = new PropertyReading(ConstantPaths.PROP_PATH + "LoginPageProp.properties");
        loginPageCredProp = new PropertyReading(ConstantPaths.PROP_PATH + "LoginPageCredentials.properties");

    }

    public static LoginPage getLoginPage() {
        if (loginPage == null)
            loginPage = new LoginPage();
        return loginPage;
    }

    public String getTitle() {
        return getWebpageTitle();
    }

    public ArrayList<String> getLoginCred() {
        ArrayList<String> credList = new ArrayList<>();
        credList.add(loginPageCredProp.getValue("username"));
        credList.add(loginPageCredProp.getValue("password"));
        return credList;
    }

    public void enterLoginCredentials(String username, String password) {
        enterText(getElement(loginPageProp.getValue("usernameField"), true), username);
        enterText(getElement(loginPageProp.getValue("passwordField"), true), password);
    }

    public void clickOnLoginBtn() {
        clickOnElement(loginPageProp.getValue("loginBtn"), true);
    }
    public boolean isUserAuthorized (String username)
    {
        String value = getElementText(getElement(loginPageProp.getValue("loginAssert"),true));
        return value.contains(username);
    }


}
