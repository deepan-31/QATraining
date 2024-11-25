package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity6 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        String url = "https://v1.training-support.net/selenium/input-events";
        driver.get(url);
        System.out.println(driver.getTitle());
        //1
        Actions builder = new Actions(driver);
        Action action1 = builder.keyDown("D").keyUp("D").build();
        action1.perform();

        Action action2 = builder.keyDown(Keys.CONTROL).keyDown("A").keyUp(Keys.CONTROL).keyUp("A").keyDown(Keys.CONTROL).keyDown("C").keyUp(Keys.CONTROL).keyUp("C").build();
        action2.perform();

        driver.quit();


    }
}
/*


Input Events
Mouse and Keyboard events.
1
2
3
4
You pressed
D

 */
