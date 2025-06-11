package com.vj.todo.base;

import com.vj.todo.factory.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

public class BaseTest {

    protected ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        WebDriver driver = new DriverFactory().initializeDriver();
        tlDriver.set(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String testCaseName = result.getMethod().getMethodName();
        File destfile = new File("target" + File.separator + "screenshots" + File.separator + testCaseName + ".png");
        takeScreenshot(destfile);
        tlDriver.get().quit();
    }

    public  void takeScreenshot(File destFile) {
        File file = ((TakesScreenshot)tlDriver.get()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, destFile);
            InputStream is = new FileInputStream(destFile);
            Allure.addAttachment("Screenshot", is);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe.getMessage());
        }
    }
}
