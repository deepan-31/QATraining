package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity16 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

        System.out.println(driver.getTitle());

        WebElement uname = driver.findElement(By.cssSelector("input[class$='-username'][placeholder='Username']"));
        WebElement pword = driver.findElement(By.cssSelector("input[class$='-password']"));
        WebElement cpword = driver.findElement(By.xpath("//label[contains(text(),'Confirm Password')]/following-sibling::input"));
        WebElement email = driver.findElement(By.cssSelector("input[class^='email']"));

        uname.sendKeys("deepan");
        pword.sendKeys("dfgh");
        cpword.sendKeys("dfgh");
        email.sendKeys("manifestodeep@gmail.com");

        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/button")).click();
        WebElement succ = driver.findElement(By.cssSelector(".ui.massive.green.label"));

        System.out.println(succ.getText());

        driver.quit();


    }
}
