import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity2 {
    WebDriver driver;
    @BeforeClass
    public void beforeclass(){
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }
    @Test
    public void test1ac1(){
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Target Practice");
    }
    @Test
    public void test2ac1(){
        WebElement blackbutton = driver.findElement(By.cssSelector(".ui.black.button"));
        Assert.assertSame(blackbutton,null);
    }
    @Test(enabled = false)
    public void test3ac1(){

    }
    @Test
    public void test4ac1(){
        throw new SkipException("skiped test");
    }
    @AfterClass
    public void afterclass(){
        driver.quit();
    }
}
