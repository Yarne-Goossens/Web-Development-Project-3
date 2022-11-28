package ui.view;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverHelper {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver;
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}