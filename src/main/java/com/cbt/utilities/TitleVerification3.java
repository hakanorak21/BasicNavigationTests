package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {

    public static void main(String[] args) throws InterruptedException {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com", "https://wayfair.com",
                "https://walmart.com", "https://westelm.com");

        for (String each: urls){
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get(each);
            Thread.sleep(1000);
            String title = driver.getTitle().replaceAll(" ", "").toLowerCase();
            String storeName = each.substring(8, each.length()-4);
            if(title.contains(storeName))
                System.out.println("PASSED");
            else {
                System.out.println("FAILED");
                System.out.println("Title: " + title);
                System.out.println("Store name: " + storeName);
            }
            driver.quit();
        }
    }
}
