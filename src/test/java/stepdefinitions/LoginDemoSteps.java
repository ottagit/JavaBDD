package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.loginPage;

import java.time.Duration;

public class LoginDemoSteps {
    WebDriver driver;
    loginPage login;
    @Given("browser is open")
    public void browserIsOpen() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        //For slow connections
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @And("user is on login page")
    public void userIsOnLoginPage() {
        login = new loginPage(driver);
        driver.navigate().to("https://example.testproject.io/web/");
    }

    @When("^user enters valid (.*) and (.*)$")
    public void userEntersValidUserNameAndPassword(String username, String password) throws InterruptedException {
        login.enterUsername(username);
        login.enterPassword(password);
        Thread.sleep(2000);
    }

    @And("user clicks on login")
    public void userClicksOnLogin() {
        login.clickLogin();
    }

    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() throws InterruptedException {
        login.checkLogOutDisplay();
        Thread.sleep(2000);
        driver.close();
        //driver.quit();
    }
}
