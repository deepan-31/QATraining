import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity1 {
    WebDriver driver = new FirefoxDriver();
    @BeforeClass
    public void beforeclasstest() {
        System.out.println("Before class fired");
    }
    @Test
    public void testmethod1() {
        System.out.println("Test fired");
        driver.get("https://v1.training-support.net");
        String title = driver.getTitle();
        Assert.assertEquals(title,"Training Support");
    }
    @Test
    public void testmethod2() {
        WebElement e = driver.findElement(By.id("about-link"));
        e.click();
        Assert.assertEquals(driver.getTitle(),"About Training Support");

    }

    @AfterClass
    public void afterclasstest() {
        System.out.println("After class fired");
        driver.quit();
    }

}
