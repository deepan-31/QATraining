import org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/*
Activity 5
Write tests for:

Checking the page title
Header Tests:
Find the third header and assert the text in the h3 tag.
Find and assert the colour of the fifth header tag element.
Button Tests:
Find the button with the class olive and assert it text.
Find and assert the colour of the first button in the third row.
Group the Header tests under a group, HeaderTests.
Group the Button tests under a group, ButtonTests.

 */
public class TestActivity5 {
    WebDriver driver;
    @BeforeClass (alwaysRun = true)
    public void beforeclass(){
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }
    @Test
    public void checkpagetitle(){
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Target Practice");
    }
    @Test(groups = {"Header tests"})
    public void headtest1(){
        WebElement thrhead = driver.findElement(By.id("third-header"));
        Assert.assertEquals(thrhead.getText(),"Third header");
    }
    @Test(groups = {"Header tests"})
    public void headtest2(){
        WebElement fifhead = driver.findElement(By.cssSelector(".ui.green.header"));
        Assert.assertEquals(fifhead.getCssValue("color"),"rgb(33, 186, 69)");
    }
    @Test(groups = {"Button tests"})
    public void butttest1(){
        WebElement olivebutt = driver.findElement(By.cssSelector(".ui.olive.button"));
        Assert.assertEquals(olivebutt.getText(),"Olive");
    }
    @Test(groups = {"Button tests"})
    public void butttest2(){
        WebElement olivebutt = driver.findElement(By.cssSelector(".ui.brown.button"));
        Assert.assertEquals(olivebutt.getCssValue("background-color"),"rgb(165, 103, 63)");
    }
    @AfterClass(alwaysRun = true)
    public void afterclass(){
        driver.quit();
    }
}
