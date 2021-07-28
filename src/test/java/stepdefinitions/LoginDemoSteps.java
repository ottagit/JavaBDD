package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
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
    //@Given("browser is open")
    @Before(value ="@smoke", order = 1)
    public void browserSetup() {
        System.out.println("Inside browser setup");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        //For slow connections
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Before(order = 0)
    public void step1(){
        System.out.println("---Inside step 1---");
    }

    @After(order = 1)
    public void tearDown(){
        System.out.println("Inside teardown");
        driver.close();
        driver.quit();
    }
    @After(order = 2)
    public void tearDown2(){
        System.out.println("---Inside teardown 2---");
    }
    @BeforeStep
    public void beforeSteps(){
        System.out.println("---Inside before steps---");
    }

    @AfterStep
    public void afterSteps(){
        System.out.println("---Inside after steps---");
    }

    @Given("user is on login page")
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
    }
}
