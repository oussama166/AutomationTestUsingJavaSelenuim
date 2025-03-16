# Selenium & Automation Testing 101 - Guru99

## Introduction
This repository serves as a beginner-friendly guide to **Selenium automation testing**. We will use the [Guru99](https://www.guru99.com/) website for our test cases, covering essential Selenium concepts like locating elements, interacting with forms, and running automated browser tests.

## Prerequisites
Before getting started, ensure you have the following installed:

- **Java (JDK 8+)**: [Download here](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Maven (for dependencies management)**: [Install guide](https://maven.apache.org/install.html)
- **Selenium WebDriver**: Included via Maven dependencies
- **TestNG (for test execution)**
- **An IDE** (Eclipse, IntelliJ IDEA, or VS Code)
- **Google Chrome & ChromeDriver** (or other browser drivers)

## Project Setup
1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-repo/selenium-guru99.git
   cd selenium-guru99
   ```
2. **Set up dependencies using Maven**
   Add the following to `pom.xml`:
   ```xml
   <dependencies>
       <!-- Selenium WebDriver -->
       <dependency>
           <groupId>org.seleniumhq.selenium</groupId>
           <artifactId>selenium-java</artifactId>
           <version>4.10.0</version>
       </dependency>
       
       <!-- TestNG -->
       <dependency>
           <groupId>org.testng</groupId>
           <artifactId>testng</artifactId>
           <version>7.8.0</version>
           <scope>test</scope>
       </dependency>
       <dependency>
           <groupId>bayern.steinbrecher.jcommander</groupId>
           <artifactId>jcommander</artifactId>
           <version>1.8.0</version>
           <scope>test</scope>
       </dependency>
   </dependencies>
   ```
3. **Download and place the ChromeDriver in your system path**
   - Download from [here](https://chromedriver.chromium.org/downloads)
   - Place it in a known directory and add to the system environment variable (PATH)

## Writing a Basic Selenium Test
Create a test file `LoginTest.java` under `src/test/java/tests/scripts/`:

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    
    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    
    @Test
    public void testLogin() {
        driver.get("https://www.demo.guru99.com/V4/");
        WebElement username = driver.findElement(By.name("uid"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("btnLogin"));
        
        username.sendKeys("testuid");
        password.sendKeys("testpassword");
        loginButton.click();
        
        String expectedTitle = "Guru99 Bank Manager HomePage";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
    
    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
```

## Running the Tests
To run tests using **TestNG**, execute:
```bash
mvn test
```
Or in **IntelliJ IDEA**:
1. Right-click `LoginTest.java`
2. Select **Run 'LoginTest'**

## Advanced Topics
- **Page Object Model (POM)** for better test structuring
- **Data-driven testing** using TestNG & Excel
- **Headless execution** for faster testing
- **CI/CD integration** (Jenkins, GitHub Actions)

## Conclusion
This guide provides a foundational start for **Selenium automation testing** using the Guru99 website. As you progress, explore advanced concepts to enhance your automation skills.

## Learning Progress
I am currently learning Selenium and automation testing. 🚀

