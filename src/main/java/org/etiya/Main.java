package org.etiya;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args)
    {
        // Bir kullanıcı olarak ben adım adım nasıl yapıyorum?
        // GÖRÜNTÜ => HTML

        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.saucedemo.com/v1/");
        String title = webDriver.getTitle();
        System.out.println(title);
        webDriver.quit();
    }
}