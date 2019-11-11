package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static void main(String[] args) throws InterruptedException {

        chromeTest();
        safariTest();
        firefoxTest();

    }

    private static void NavigationTest(String browser) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.get("https://google.com");
        Thread.sleep(2000);
        String title1 = driver.getTitle();

        driver.navigate().to("https://etsy.com");
        Thread.sleep(2000);
        String title2 = driver.getTitle();

        System.out.println("Test on " + browser + " browser");

        driver.navigate().back();
        Thread.sleep(2000);
        StringUtility.verifyEquals(driver.getTitle(), title1);

        driver.navigate().forward();
        Thread.sleep(2000);
        StringUtility.verifyEquals(driver.getTitle(), title2);

        driver.quit();

    }

    public static void chromeTest() throws InterruptedException {
        NavigationTest("chrome");
    }

    public static void safariTest() throws InterruptedException {
        NavigationTest("safari");
    }

    public static void firefoxTest() throws InterruptedException {
        NavigationTest("firefox");
    }

}
