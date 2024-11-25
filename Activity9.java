package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/ajax");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement e1 = driver.findElement(By.cssSelector(".ui.violet.button"));

        e1.click();
        WebElement e6 = driver.findElement(By.xpath("//*[@id=\"ajax-content\"]/h1"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ajax-content\"]/h1")));
        System.out.println(e6.getText());
        WebElement e2  = driver.findElement(By.xpath("//*[@id=\"ajax-content\"]/h3"));
        System.out.println(e2.getText());
        wait.until(ExpectedConditions.textToBePresentInElementLocated( By.tagName("h3"),"I'm late!"));

        System.out.println(e2.getText());

        driver.quit();
    }
}
