import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

public class TestActivity9 {
    WebDriver driver;

    @BeforeMethod
    public void beforemethod(){//ITestResult result) {
//        System.out.println("Before method of test activity 9");
//        Reporter.setCurrentTestResult(result);
        Reporter.log("Before method of test activity 9",true);
        driver.switchTo().defaultContent();
    }

    @BeforeTest
    public void beforetest() {
//        System.out.println("before test of test activity 9");
        Reporter.log("before test of test activity 9",true);
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

    }

    @AfterTest
    public void aftertest() {
//        System.out.println("after test of test activity 9");
        Reporter.log("after test of test activity 9",true);
        driver.close();
    }

    @Test
    public void simpleAlertTestCase() {
//        System.out.println("simpleAlertTestCase");
        Reporter.log("simpleAlertTestCase",true);
        driver.findElement(By.id("simple")).click();
        Alert alert = driver.switchTo().alert();
//        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(), "This is a JavaScript Alert!");
        Reporter.log(alert.getText(),true);
        alert.accept();

    }

    @Test
    public void confirmAlertTestCase() {
//        System.out.println("confirmAlertTestCase");
        Reporter.log("confirmAlertTestCase",true);
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
//        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(), "This is a JavaScript Confirmation!");
        Reporter.log(alert.getText() + "deepan",true);
        alert.accept();

    }

    @Test
    public void promptAlertTestCase() {
//        System.out.println("promptAlertTestCase");
        Reporter.log("promptAlertTestCase",true);
        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();
//        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(), "This is a JavaScript Prompt!");
        Reporter.log(alert.getText(),true);
        alert.sendKeys("hi");
        alert.dismiss();
    }
}
