package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {

        WebDriver web1 = new FirefoxDriver();
        String url = "https://v1.training-support.net/selenium/login-form";
        web1.get(url);

        System.out.println(web1.getTitle());

        WebElement we1 = web1.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement we2 = web1.findElement(By.xpath("//*[@id=\"password\"]"));

        we1.sendKeys("admin");
        we2.sendKeys("password");

        WebElement login = web1.findElement(By.xpath("//button[text()='Log in']"));

        login.click();

        WebElement loginconf = web1.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]"));

        System.out.println(loginconf.getText());

//        web1.close();

        web1.quit();
    }
}
