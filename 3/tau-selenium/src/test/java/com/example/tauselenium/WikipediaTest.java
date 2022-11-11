package com.example.tauselenium;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;
    @Before
    public void setUp() throws Exception {
        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/michalwa/Desktop/Projects/Selenium/executables/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.pl/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void findRybaInWikipedia() throws Exception {
        driver.get("https://www.google.pl/");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).sendKeys("ryba");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[@id='rso']/div/div/div/div/div/a/h3")).click();
        driver.get("https://pl.wikipedia.org/wiki/Ryby");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}