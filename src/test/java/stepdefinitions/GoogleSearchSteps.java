package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchSteps {
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

    @And("user is in Google search page")
    public void userIsInGoogleSearchPage() {
        driver.navigate().to("https://google.com");
    }

    @When("user enters text in search box")
    public void userEntersTextInSearchBox() {
        driver.findElement(By.name("q")).sendKeys("Hello");
    }

    @And("hits enter")
    public void hitsEnter() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("user is navigated to search results")
    public void userIsNavigatedToSearchResults() {
        driver.getPageSource().contains("Hello, it's me");
        driver.close();
        driver.quit();
    }

}
