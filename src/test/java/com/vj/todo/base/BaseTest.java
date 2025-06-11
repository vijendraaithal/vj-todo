package com.vj.todo.base;

import com.vj.todo.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        WebDriver driver = new DriverFactory().initializeDriver();
        tlDriver.set(driver);
    }

    @AfterMethod
    public void tearDown() {
        tlDriver.get().quit();
    }
}
