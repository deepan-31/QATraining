package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        String url = "https://v1.training-support.net/selenium/input-events";
        driver.get(url);
        //1
        Actions builder = new Actions(driver);
        WebElement e1 = driver.findElement(By.xpath("//*[@class=\"active\"]/h1"));
        Action action1 = builder.click().build();
        action1.perform();
        Action action2 = builder.sendKeys(e1.getText()).build();
        action2.perform();
        WebElement e2 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div[2]"));
        System.out.println(e2.getText());
        //2
        WebElement e3 = driver.findElement(By.xpath("//*[@class=\"active\"]/h1"));
        Action action3 = builder.doubleClick().build();
        action3.perform();
        System.out.println(e3.getText());
        //3
        WebElement e4 = driver.findElement(By.xpath("//*[@class=\"active\"]/h1"));
        Action action4 = builder.contextClick().build();
        action4.perform();
        System.out.println(e4.getText());

        driver.quit();

    }
}
