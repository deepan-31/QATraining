package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity15 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        String url = "https://v1.training-support.net/selenium/dynamic-attributes";
        driver.get(url);
        System.out.println(driver.getTitle());

        WebElement username = driver.findElement(By.xpath("//input[starts-with(@class,'username')]"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.cssSelector("input[class^='password-']"));
        password.sendKeys("password");

        WebElement login = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button"));
        login.click();

        driver.quit();

    }
}
