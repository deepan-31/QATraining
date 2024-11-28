package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity18
{
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/selects");

        System.out.println("Title: "+driver.getTitle());

        WebElement e = driver.findElement(By.xpath("//*[@id=\"multi-select\"]"));

        Select a = new Select(e);

        a.selectByVisibleText("Javascript");
        System.out.println(a.getFirstSelectedOption().getText());

        a.selectByIndex(4);
        a.selectByIndex(5);
        a.selectByIndex(6);
        for(WebElement e1:a.getAllSelectedOptions()){
            System.out.print(e1.getText());
        }
        System.out.println();

        a.selectByValue("node");
        System.out.println(a.getFirstSelectedOption().getText());

        a.deselectByIndex(6);
        for(WebElement e1:a.getAllSelectedOptions()){
            System.out.print(e1.getText());
        }

        driver.quit();
    }
}
