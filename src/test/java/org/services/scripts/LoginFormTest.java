package org.services.scripts;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

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
    Dotenv dotenv = Dotenv.load();

    final String BASE_URL = dotenv.get("DOMAIN_ENV");

    WebElement uuid;
    WebElement password;
    WebElement login;

    WebElement hintUserId;
    WebElement hintPassword;


    @BeforeMethod(alwaysRun = true)
    public void setUpChromeDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

    }



    @AfterMethod(alwaysRun = true)
    public void tearDownChromeDriver() {
        driver.close();
        driver.quit();
    }


    // =============================== Helper function ======================================= //

    private void gettingBaseInput() {
        this.uuid = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("uid")));
        this.password = driver.findElement(By.name("password"));
        this.login = driver.findElement(By.name("btnLogin"));
    }

    private void gettingHint() {
        hintUserId = driver.findElement(By.id("message23"));
        ;
        hintPassword = driver.findElement(By.id("message18"));
    }


    private void hitTheUrl() {
        driver.get(BASE_URL + "index.php");
    }


    private void hitTheUrl(String url) {
        driver.get(BASE_URL + url);
    }

    // =============================== Helper function ======================================= //


    @Test(groups = {"valid_login"})
    public void testLoginPageByInsertTheUserIdAndPassword() {

        // Getting the page of login
        this.hitTheUrl();

        // Getting the fields
        this.gettingBaseInput();

        // Setting the credential
        uuid.sendKeys(dotenv.get("LOGIN_CREDENTIAL_USERID"));
        password.sendKeys(dotenv.get("LOGIN_CREDENTIAL_PASSWORD"));
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
        uuid.sendKeys("fake_user_id");
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
        uuid.sendKeys("fake_user_id");
        password.sendKeys("fake_password");
        login.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());


        String expectedTitle = "User is not valid";
        String actualTitle = alert.getText();

        // accept the prompt show up in the page
        alert.accept();

        assertEquals(actualTitle, expectedTitle);

    }

    @Test
    public void testLoginPageByHintMessageOnIdFiled() throws InterruptedException {
        this.hitTheUrl();

        this.gettingBaseInput();


        // perform the click behavior
        uuid.click();
        password.click();

        Thread.sleep(50);

        this.gettingHint();

        // get the hint field
        String expectedTitle = "User-ID must not be blank";
        String actualTitle = hintUserId.getText();

        assertEquals(actualTitle, expectedTitle);

    }


    @Test
    public void testLoginPageByHintMessageOnPasswordFiled() throws InterruptedException {
        this.hitTheUrl();

        this.gettingBaseInput();


        // perform the click behavior
        password.click();
        uuid.click();

        Thread.sleep(50);

        this.gettingHint();

        // get the hint field
        String expectedTitle = "Password must not be blank";
        String actualTitle = hintPassword.getText();

        assertEquals(actualTitle, expectedTitle);

    }


}