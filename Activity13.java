package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity13 {

    public static void main(String[] args) {


        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/tables");

        System.out.println(driver.getTitle());

        List<WebElement> cols = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[1]/td"));
        System.out.println("columns "+ cols.size());

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr"));
        System.out.println("rows "+rows.size());

        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[3]/td"));
        for(WebElement cell : thirdRow) {
            System.out.println(cell.getText());
        }

        WebElement cellValue = driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second cell value: " + cellValue.getText());

        driver.quit();

    }
}
