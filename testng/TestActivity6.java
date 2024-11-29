import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestActivity6 {
    WebDriver driver;
//    @DataProvider(name = "Authentication")
//    public static Object[][] credentials() {
//        return new Object[][] {
//                { "admin", "password" },
//                { "testuser_2", "Test@456" }
//        };
//    }
    @BeforeClass(alwaysRun = true)
    public void beforeclass(){
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    @Test
    public void checkpagetitle(){
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login Form");
    }
    @Test//(dataProvider = "Authentication")
    @Parameters({ "sUsername", "sPassword" })
    public void test1(String susername,String spassword){
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys(susername);
        password.sendKeys(spassword);

        driver.findElement(By.xpath("//*[@onclick='signIn()']")).click();
        WebElement confmsg = driver.findElement(By.id("action-confirmation"));
        Assert.assertEquals(confmsg.getText(),"Welcome Back, admin");
    }

    @AfterClass(alwaysRun = true)
    public void afterclass(){
        driver.quit();
    }
}
