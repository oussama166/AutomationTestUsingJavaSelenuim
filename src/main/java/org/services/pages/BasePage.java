package org.services.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    public static WebDriver driver;

    public void setDriver (WebDriver driver){
        BasePage.driver = driver;
    }

    protected WebElement findElement (By locator){
        return driver.findElement(locator);
    }

    protected void setElement (By locator, String text){
        findElement(locator).clear();
        findElement(locator).sendKeys(text);
    }
    protected void setElement (By locator){
        findElement(locator).getText();
    }

    protected WebElement getElement (By locator){
        return driver.findElement(locator);
    }

    protected void clickElement (By locator){
        findElement(locator).click();
    }

    protected Alert alert (){
        return driver.switchTo().alert();
    }

}
