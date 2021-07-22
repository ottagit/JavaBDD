package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    protected WebDriver driver;
    // Create locators for web object elements to be used in page
    By txt_username = By.id("name");
    By txt_password = By.id("password");
    By btn_login = By.id("login");
    By btn_logout = By.id("logout");

    public loginPage(WebDriver driver){
        this.driver = driver;
        // Validate user is on right page
//        if(!driver.getTitle().equals("TestProject Demo")){
//            throw new IllegalStateException("This is not the login page. The login page is " +
//                    driver.getCurrentUrl());
//        }
    }
    // Create methods or actions to be performed on page objects
    public void enterUsername(String username){
        driver.findElement(txt_username).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(txt_password).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(btn_login).click();
    }
    // The above methods can be refactored into a single method taking username and password as arguments
    public void checkLogOutDisplay(){
        driver.findElement(btn_logout).isDisplayed();
    }
}
