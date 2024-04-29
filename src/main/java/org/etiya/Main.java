package org.etiya;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Bir kullanıcı olarak ben adım adım nasıl yapıyorum?
        // GÖRÜNTÜ => HTML

        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.saucedemo.com/v1/");
        String title = webDriver.getTitle();
        System.out.println(title);

        // Locator => Html'deki bir elemente ulaşmak için gerekli rota.

        // //*[@id="login_button_container"]/div/form
        // /html/body/div[2]/div[1]/div/div/form
        WebElement usernameInput = webDriver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
        Thread.sleep(1000);


        WebElement passwordInput = webDriver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        Thread.sleep(1000);

        WebElement loginBtn = webDriver.findElement(By.id("login-button"));
        loginBtn.click();
        Thread.sleep(5000);
        webDriver.quit();
    }
}
//  10 adet Selenium fonksiyonu
//  click fonksiyonu ..... ..... ....
//  loginBtn.click();

//