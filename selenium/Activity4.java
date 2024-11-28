package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {

        WebDriver web1 = new FirefoxDriver();
        String url = "https://v1.training-support.net/selenium/target-practice";
        web1.get(url);
        System.out.println(web1.getTitle());

        WebElement e1 = web1.findElement(By.xpath("//*[@id=\"third-header\"]"));

        System.out.println(e1.getText());

        WebElement e2 = web1.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5"));

        System.out.println(e2.getCssValue("color"));

        WebElement e3 = web1.findElement(By.cssSelector(".ui.violet.button"));

        System.out.println(e3.getAttribute("class"));

        WebElement e4 = web1.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));

        System.out.println(e4.getText());

        web1.quit();


    }

}
