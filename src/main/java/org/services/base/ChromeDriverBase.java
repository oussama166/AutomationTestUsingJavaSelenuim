package org.services.base;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverBase {

    ChromeDriver driver;

    final String BASE_URL = "http://demo.guru99.com/";

    public void setUpChromeDriver() {
        driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    public void getTitle() {
        driver.get(BASE_URL);

        String title = driver.getTitle();

        System.out.println(title);

    }

    public void quit() {
        driver.quit();
    }

}
