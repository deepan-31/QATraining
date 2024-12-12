package org.example;

import java.io.File;
import java.io.IOException;
import java.rmi.Remote;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart {
    public static void screenshotmaker(FirefoxDriver driver){
        String fileName = System.currentTimeMillis() + "Test";
        File screenshot =  driver.getScreenshotAs(OutputType.FILE);
        File outputFile = new File("loggerScreenshots/"+fileName+".png");
        try{
            FileUtils.copyFile(screenshot,outputFile);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        FirefoxDriver driver = new FirefoxDriver();
        // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        Wait wait = new FluentWait(driver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofSeconds(5))
        .ignoring(NoSuchElementException.class);
        driver.get("https://www.flipkart.com/");

        WebElement searchbar = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input"));

        searchbar.sendKeys("Iphone 15");
        searchbar.sendKeys(Keys.ENTER);
        // Actions builder = new Actions(driver);
        // builder.sendKeys(Keys.ENTER).perform();
        wait.until(ExpectedConditions.urlContains("https://www.flipkart.com/search?q=Iphone"));

        Flipkart.screenshotmaker(driver);
        WebElement item1 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[3]/div[1]/div[1]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[3]/div[1]/div[1]")));
        item1.click();
        
        String originalWindow = driver.getWindowHandle();
        Thread.sleep(5000);
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) { if (!windowHandle.equals(originalWindow)) { driver.switchTo().window(windowHandle); break; }}
        System.out.println("Title of the new tab: " +driver.getTitle());

        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")));
        addToCart.click();

        //Iphone cart details
        wait.until(ExpectedConditions.urlContains("https://www.flipkart.com/viewcart"));

        WebElement prize = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/span[2]"));
        WebElement productname = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/div[1]/a"));
        System.out.println(productname.getText() + "$" +prize.getText());
        
        //proceed to pay
        System.out.println(driver.getCurrentUrl());
        WebElement placeOrder= driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[3]/div/form/button"));
        Flipkart.screenshotmaker(driver);
        placeOrder.click();
        wait.until(ExpectedConditions.urlContains("https://www.flipkart.com/checkout/init"));

        Flipkart.screenshotmaker(driver);

        driver.quit();


    }
}
