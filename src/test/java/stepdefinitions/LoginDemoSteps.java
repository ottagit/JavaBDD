package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginDemoSteps {
    WebDriver driver = null;
    @Given("browser is open")
    public void browserIsOpen() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        // For slow connections
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @And("user is on login page")
    public void userIsOnLoginPage() {
        driver.navigate().to("https://example.testproject.io/web/");
    }

    @When("user enters valid user name and password")
    public void userEntersValidUserNameAndPassword() throws InterruptedException {
        driver.findElement(By.id("name")).sendKeys("chris");
        driver.findElement(By.id("password")).sendKeys("12345");
        Thread.sleep(2000);
    }

    @And("user clicks on login")
    public void userClicksOnLogin() {
        driver.findElement(By.id("login")).click();
    }

    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() throws InterruptedException {
        driver.findElement(By.id("logout")).isDisplayed();
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
