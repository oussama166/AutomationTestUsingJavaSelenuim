package org.services.scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/**
 * <p>
 * This class is dedicated to automation for the processes of test on the page login
 * </p>
 * <p>
 * The Base Url for this version of test is <strong>"https://demo.guru99.com/V1/"</strong>
 * </p>
 * <p>
 * The 1st scenario <i>Interaction of element in login</i></br>
 * The 2nd scenario <i>User connect successful</i></br>
 * The 3rd scenario <i>User connect failed</i></br>
 * </p>
 */
@Test
public class LoginFormTest {

    ChromeDriver driver;

    final String BASE_URL = "https://demo.guru99.com/V1/";

    WebElement uuid;
    WebElement password;
    WebElement login;


    // =============================== Helper function ======================================= //

    private void gettingBaseInput() {
        this.uuid = driver.findElement(By.name("uid"));
        this.password = driver.findElement(By.name("password"));
        this.login = driver.findElement(By.name("btnLogin"));
    }


    private void hitTheUrl() {
        driver.get(BASE_URL + "index.php");
    }


    private void hitTheUrl(String url) {
        driver.get(BASE_URL + url);
    }

    // =============================== Helper function ======================================= //

    @BeforeMethod
    public void setUpChromeDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownChromeDriver() {
        driver.close();
        driver.quit();
    }


    @Test()
    public void testLoginPageByInsertTheUserIdAndPassword() {
        // Getting the page of login
        this.hitTheUrl();

        // Getting the fields
        this.gettingBaseInput();

        // Setting the credential
        uuid.sendKeys("mngr616311");
        password.sendKeys("vUgageq");
        login.click();

        Duration pageLoadTimeout = Duration.ofSeconds(50);
        new WebDriverWait(driver, pageLoadTimeout).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        // testing if the login was success
        String expectedTitle = "GTPL Bank Manager HomePage";
        String actualTitle = driver.getTitle();

        assertEquals(actualTitle, expectedTitle);

    }

    @Test()
    public void testLoginPageByInsertOnlyTheUserIdFailed() throws InterruptedException {
        // Getting the page of login
        this.hitTheUrl();

        // Getting the fields
        this.gettingBaseInput();

        // Setting the credential
        uuid.sendKeys("testid");
        login.click();

        Thread.sleep(30);

        Alert alert = driver.switchTo().alert();

        String expectedTitle = "User is not valid";
        String actualTitle = alert.getText();

        // accept the prompt show up in the page
        alert.accept();

        assertEquals(actualTitle, expectedTitle);
    }

    @Test()
    public void testLoginPageByInsertTheUserIdAndPasswordFailed() throws InterruptedException {

        // Getting the page of login
        this.hitTheUrl();

        // Getting the fields
        this.gettingBaseInput();

        // Setting the credential
        uuid.sendKeys("testid");
        password.sendKeys("testpass");
        login.click();

        Thread.sleep(50);

        Alert alert = driver.switchTo().alert();

        String expectedTitle = "User is not valid";
        String actualTitle = alert.getText();

        // accept the prompt show up in the page
        alert.accept();

        assertEquals(actualTitle, expectedTitle);

    }


}