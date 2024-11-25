package  org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        String url1 = "https://v1.training-support.net";
        // Open the browser
        driver.get(url1);

        // Perform testing and assertions
        System.out.println(driver.getTitle());

//        driver.navigate().to(url1+"/selenium/");
//        System.out.println(driver.getTitle());
//
//        WebElement username = driver.findElement(By.id("content"));
//
//        System.out.println(username.getText());
//
//        driver.quit();

        WebElement au1 = driver.findElement(By.xpath("//*[@id=\"about-link\"]"));

        au1.click();

        System.out.println(driver.getTitle());

        driver.quit();
    }
}
