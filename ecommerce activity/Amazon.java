package org.example;

import java.io.File;
import java.io.IOException;
import java.rmi.Remote;
import java.time.Duration;
import java.util.NoSuchElementException;

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

public class Amazon {
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
    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
        // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        Wait wait = new FluentWait(driver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofSeconds(5))
        .ignoring(NoSuchElementException.class);
        driver.get("https://www.amazon.in/");

        WebElement searchbar = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));

        searchbar.sendKeys("Iphone 15");
        searchbar.sendKeys(Keys.ENTER);
        // Actions builder = new Actions(driver);
        // builder.sendKeys(Keys.ENTER).perform();
        wait.until(ExpectedConditions.urlContains("https://www.amazon.in/s?k=Iphone+15"));

        Amazon.screenshotmaker(driver);
        WebElement addToCartitem = driver.findElement(By.xpath("//*[@id=\"a-autoid-1-announce\"]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-1-announce\"]")));
        addToCartitem.click();

        WebElement addToCart = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[4]/div[1]/span[2]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[4]/div[1]/span[2]")));
        addToCart.click();

        //Iphone cart details

        WebElement prize = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[5]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/ul/div[1]/div/div/div/span"));
        WebElement productname = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[5]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/ul/li/span/a/span[1]/h4/span/span[2]"));
        System.out.println(productname.getText() + "$" +prize.getText());
        
        //proceed to pay
        System.out.println(driver.getCurrentUrl());
        WebElement proceedToPay = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[5]/div/div[1]/div[1]/div/form/div/div[3]/span/span/span/input"));
        Amazon.screenshotmaker(driver);
        proceedToPay.click();
        wait.until(ExpectedConditions.urlContains("https://www.amazon.in/ap/signin?"));

        Amazon.screenshotmaker(driver);

        driver.quit();


    }
}
