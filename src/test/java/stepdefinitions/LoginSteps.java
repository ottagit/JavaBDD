package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    @Given("user is on login page")
    public void userIsOnLoginPage() {
        System.out.println("Inside step - user on login page");
    }

    @When("user enters valid user name and password")
    public void userEntersValidUserNameAndPassword() {
        System.out.println("Inside step - user enters username and password");
    }

    @And("clicks the login button")
    public void clicksTheLoginButton() {
        System.out.println("Inside step - user clicks on button");
    }

    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() {
        System.out.println("Inside step - user is navigated to home page");
    }
}
