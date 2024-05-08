package org.etiya;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class LoginPageTests
{
    WebDriver webDriver;

    // BeforeEach -> TestCase -> AfterEach

    @BeforeEach
    public void start()
    {
        webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.saucedemo.com/v1/");
    }
    @AfterEach
    public void end()
    {
        webDriver.quit();
    }

    public void common()
    {
        // ....
    }


    @Test
    public void titleTest()
    {
        common();
        String expectedResult = "Etiya";
        String title = webDriver.getTitle();
        assertEquals(expectedResult, title); // verilen iki değerin eşit olma durumunu testin sonucuna bağlar.
    }

    @Test
    public void loginSuccessfull()
    {
        common();
        WebElement usernameInput = webDriver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");


        WebElement passwordInput = webDriver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = webDriver.findElement(By.id("login-button"));
        loginBtn.click();

        String expectedResult = "https://www.saucedemo.com/v1/inventory.html";
        String actualResult = webDriver.getCurrentUrl();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void loginWithWrongPassword()
    {
    }
}
// Yazdığınız 10 adet fonksiyonu JUnit kullanarak test methodlarına çevirmeniz.