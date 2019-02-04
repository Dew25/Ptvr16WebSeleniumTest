/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Melnikov
 */
public class SeleniumTest {
    
    private static WebDriver driver;
    
    public SeleniumTest() {
    }
    
    @BeforeClass // Выполняется один раз при запуске теста
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/Ptvr16WebSeleniumTest/");
    }
    
    
    @AfterClass // Выполняется один раз после выплнения теста
    public static void tearDownClass() {
        driver.quit();
        
    }
    
    @Before // Выполняется один раз перед каждой функцией теста
    public void setUp() {
    }
    
    @After // Выполняется один раз после каждой функции теста
    public void tearDown() {
    }

    
     @Test
     public void loginTest() {
         WebElement el = driver.findElement(By.id("showLogin"));
         el.click();
         el = driver.findElement(By.id("login"));
         el.sendKeys("admin");
         el = driver.findElement(By.id("password"));
         el.sendKeys("admin");
         el = driver.findElement(By.id("btnEnter"));
         el.click();
         el = driver.findElement(By.id("info"));
         assertEquals("Вы вошли", el.getText());
     }
}
