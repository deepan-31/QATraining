package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    WebDriver driver;
    Alert alert;

    @Given("User is on the page")
    public void userIsOnThePage() throws Throwable {
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        driver.switchTo().defaultContent();
    }

    @When("User clicks the Simple Alert button")
    public void userClicksTheSimpleAlertButton() throws Throwable {
        driver.findElement(By.id("simple")).click();
    }

    @When("User clicks the Confirm Alert button")
    public void userClicksTheConfirmAlertButton() throws Throwable {
        driver.findElement(By.id("confirm")).click();
    }

    @When("User clicks the Prompt Alert button")
    public void userClicksThePromptAlertButton() throws Throwable {
        driver.findElement(By.id("prompt")).click();
    }

    @Then("Alert opens")
    public void alertOpens() throws Throwable {
        alert = driver.switchTo().alert();
    }

    @And("Read the text from it and print it")
    public void readTheTextFromItAndPrintIt() throws Throwable {
        System.out.println(alert.getText());
    }

    @And("Write a custom message in it")
    public void writeACustomMessageInIt() {
        alert.sendKeys("hi");
    }

    @And("Close the alert")
    public void closeTheAlert() throws Throwable {
        alert.accept();
    }

    @And("Close the alert with Cancel")
    public void closeTheAlertWithCancel() throws Throwable {
        alert.dismiss();
    }

    @And("Close Browser")
    public void closeBrowser() throws Throwable {
        System.out.println("Close browser");
        driver.close();
    }
}
