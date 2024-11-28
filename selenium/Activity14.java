package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/tables");

        System.out.println(driver.getTitle());

        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        System.out.println("columns "+ cols.size());

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        System.out.println("rows "+rows.size());

        WebElement cellValue = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second cell value: " + cellValue.getText());

        WebElement headerfc = driver.findElement(By.xpath("//*[@id=\"sortableTable\"]/thead/tr/th[1]"));
        headerfc.click();

        WebElement cellValue2 = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second cell value after clicking: " + cellValue2.getText());

        List<WebElement> footerelems = driver.findElements(By.xpath("//*[@id=\"sortableTable\"]/tfoot/tr"));
        for(WebElement e:footerelems){
            System.out.println(e.getText());
        }

        driver.quit();
    }
}
