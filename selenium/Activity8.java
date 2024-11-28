package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        String url = "https://v1.training-support.net/selenium/dynamic-controls";

        driver.get(url);

        System.out.println(driver.getTitle());
        //1
        WebElement e1 = driver.findElement(By.id("toggleCheckbox"));

        Actions builder = new Actions(driver);

        Action action1 = builder.moveToElement(e1).click().build();

        action1.perform();
        //2
        WebElement e2 = driver.findElement(By.xpath("//*[@id=\"dynamicCheckbox\"]/input"));

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> !(e2.isDisplayed()));
        //3
        Action action2 = builder.moveToElement(e1).click().build();

        action1.perform();
        Wait<WebDriver> wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait2.until(d -> e2.isDisplayed());

        Action action3 = builder.moveToElement(e2).click().pause(3000).build();
        action3.perform();

        driver.quit();

    }
}
