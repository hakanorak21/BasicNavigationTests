package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {

    public static void main(String[] args) throws InterruptedException {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                                            "http://practice.cybertekschool.com/dropdown",
                                            "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get(urls.get(0));
        Thread.sleep(1000);
        String title1 = driver.getTitle();
        String url1 = driver.getCurrentUrl();

        driver.navigate().to(urls.get(1));
        Thread.sleep(1000);
        String title2 = driver.getTitle();
        String url2 = driver.getCurrentUrl();

        driver.navigate().to(urls.get(2));
        Thread.sleep(1000);
        String title3 = driver.getTitle();
        String url3 = driver.getCurrentUrl();

        StringUtility.verifyEquals(title1, title2);
        StringUtility.verifyEquals(title2, title3);

        if(url1.startsWith("http://practice.cybertekschool.com"))
            System.out.println("url1 starts with http://practice.cybertekschool.com");
        else
            System.out.println("url1 doesn't start with http://practice.cybertekschool.com");

        if(url2.startsWith("http://practice.cybertekschool.com"))
            System.out.println("url2 starts with http://practice.cybertekschool.com");
        else
            System.out.println("url2 doesn't start with http://practice.cybertekschool.com");

        if(url3.startsWith("http://practice.cybertekschool.com"))
            System.out.println("url3 starts with http://practice.cybertekschool.com");
        else
            System.out.println("url2 doesn't start with http://practice.cybertekschool.com");
        
        driver.quit();

    }
}
