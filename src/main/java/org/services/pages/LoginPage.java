package org.services.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By userId = By.name("uid");
    private final By userHint = By.xpath("//label[@id='message23']");
    private final By password = By.name("password");
    private final By passwordHint = By.xpath("//label[@id='message18']");
    private final By loginButton = By.name("btnLogin");


    public void setUserId(String userIdText) {
        setElement(userId, userIdText);
    }

    public void setPassword(String passwordText) {
        setElement(password, passwordText);
    }

    public String getAlertText() {
        return alert().getText();
    }

    public String getHint(By locator) {
        return getElement(locator).getText();
    }

    public String getUserIdHint(){
        return getElement(userHint).getText();
    }

    public String getPasswordHint(){
        return getElement(passwordHint).getText();
    }

    public HomePage clickLoginButton() {
        clickElement(loginButton);
        return new HomePage();
    }

    public HomePage logIntoHomePage(String userIdText, String passwordText) {
        setUserId(userIdText);
        setPassword(passwordText);
        return clickLoginButton();
    }



}
