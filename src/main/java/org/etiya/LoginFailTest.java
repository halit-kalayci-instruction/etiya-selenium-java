package org.etiya;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class LoginFailTest {
  private WebDriver driver;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver; // Tarayıcıda javascript kodu çalıştırabilmenizi sağlayan arayüz.
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void loginFail() throws Exception{
    driver.get("https://www.saucedemo.com/v1/");
    js.executeScript("console.log('merhaba')");
    driver.manage().window().maximize();
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("secret_sauce");
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("abc");
    driver.findElement(By.id("login-button")).click();
    {
      WebElement element = driver.findElement(By.id("login-button"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    assertThat(driver.findElement(By.cssSelector("*[data-test=\"error\"]")).getText(), is("Email or password is incorrect."));
  }
}
