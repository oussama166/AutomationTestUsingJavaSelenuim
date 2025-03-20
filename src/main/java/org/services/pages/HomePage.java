package org.services.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By header = By.xpath("//marquee[@class='heading3']");

    public boolean isSlideHeaderPresent(){
        return findElement(header).getText().contains("Welcome To Manager's Page of GTPL Bank");
    }
}
