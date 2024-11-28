package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/drag-drop");

        System.out.println(driver.getTitle());

        Actions builder = new Actions(driver);
        WebElement e1 = driver.findElement(By.id("draggable"));
        WebElement e2 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]"));

        // Perform drag and drop action
        Action action1 = builder.moveToElement(e1).dragAndDrop(e1, e2).build();
        action1.perform();

        // Wait for a while to make sure the drop action is complete
        Thread.sleep(2000);

        // Check the color of the drop zone
        String color = e2.getCssValue("background-color");

        // Now compare the color correctly using .equals()
        if (color.equals("rgb(33, 186, 69)")) {
            System.out.println("Object has been placed");
        } else {
            System.out.println("Object has not been placed");
        }

        driver.quit();
    }
}

/*
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.Objects;

public class Activity7 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/drag-drop");

        System.out.println(driver.getTitle());

        Actions builder = new Actions(driver);
        WebElement e1 = driver.findElement(By.id("draggable"));
        WebElement e2 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]"));
        Action action1 = builder.moveToElement(e1).dragAndDrop(e1,e2).pause(2000).build();
        action1.perform();
        Thread.sleep(2000);
        if (Objects.equals(e2.getCssValue("color"), "rgb(33, 186, 69)")) {
            System.out.println("Object has been placed");
        }else{
            System.out.println("Object has not been placed");
        }

        driver.quit();
    }
}
*/