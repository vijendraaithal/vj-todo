package com.vj.todo.base;

import com.vj.todo.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new DriverFactory().initializeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
