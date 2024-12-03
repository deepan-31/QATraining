package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity2 {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Login page$")
    public void userIsOnLoginPage() throws Throwable {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/login-form");

    }

    @When("^User enters username and password$")
    public void userEntersUsernameAndPassword() throws Throwable {
        // Find the username and password fields
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        // Enter credentials
        username.sendKeys("admin");
        password.sendKeys("password");

    }

    @Then("^Read the page title and confirmation message$")
    public void readThePageTitleAndConfirmationMessage() throws Throwable {
        System.out.println(driver.getTitle());
        // Click login
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        // Read login message
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals("Welcome Back, admin", loginMessage);

    }

    @And("^Close the Browser$")
    public void closeTheBrowser() throws Throwable {
        driver.close();
    }
}