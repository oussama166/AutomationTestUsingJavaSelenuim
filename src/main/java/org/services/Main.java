package org.services;


import org.services.base.ChromeDriverBase;

public class Main {
    public static void main(String[] args) {
        ChromeDriverBase driver = new ChromeDriverBase();

        driver.setUpChromeDriver();
        driver.getTitle();
        driver.quit();
    }
}