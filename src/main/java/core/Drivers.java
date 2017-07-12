package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Drivers {

    private static WebDriver driver;

    public static WebDriver getChromeDriver() {
        String driverPath = Drivers.class.getClassLoader().getResource("drivers/chromedriver").getPath();
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        return options;
    }

    public static void customWait(WebDriver driver, By by) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        try {
            webDriverWait.until((WebDriver drv) -> drv.findElement(by));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
