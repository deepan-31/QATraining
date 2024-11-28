package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// import java.security.Key;
import java.time.Duration;

public class fungoogle
{
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        driver.get("https://www.google.com");

        WebElement searchbar = driver.findElement(By.tagName("textarea"));

        searchbar.sendKeys("cheese");

        Actions builder = new Actions(driver);

        Action a1 = builder.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build();
        a1.perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"hdtb-tls\"]")));
        WebElement toolsbutton = driver.findElement(By.xpath("//div[@id=\"hdtb-tls\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"hdtb-tls\"]")));
        toolsbutton.click();

        //Action a2 = builder.moveToElement(toolsbutton).click().build();
        //a2.perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"result-stats\"]")));
        System.out.println(driver.findElement(By.xpath("//div[@id=\"result-stats\"]")).getText());


        driver.quit();

    }
}
