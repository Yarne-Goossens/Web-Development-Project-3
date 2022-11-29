package ui.view;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverHelper {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-GB");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}