package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

        System.out.println(driver.getTitle());

        WebElement confirmalert = driver.findElement(By.cssSelector(".ui.inverted.blue.button"));

        confirmalert.click();

        Alert alert = driver.switchTo().alert();

        System.out.println(driver.switchTo().alert().getText());

        alert.accept();

        driver.quit();
    }

}
