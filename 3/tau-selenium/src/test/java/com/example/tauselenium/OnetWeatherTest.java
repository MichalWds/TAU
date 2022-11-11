package com.example.tauselenium;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnetWeatherTest {
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
    public void testWeatherInGdansk() throws Exception {
        driver.get("https://www.onet.pl/");
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div/div[6]/button[2]")).click();
        driver.findElement(By.linkText("10")).click();
        driver.get("https://pogoda.onet.pl/prognoza-pogody/warszawa-357732");
        driver.findElement(By.id("locationSearch")).click();
        driver.findElement(By.id("locationSearch")).clear();
        driver.findElement(By.id("locationSearch")).sendKeys("Gda");
        driver.findElement(By.xpath("//div[@id='autocomplete-suggestions']/div/span")).click();
        driver.get("https://pogoda.onet.pl/prognoza-pogody/gdansk-287788");
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
