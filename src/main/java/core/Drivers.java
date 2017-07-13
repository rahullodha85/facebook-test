package core;

import cucumber.api.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Drivers {

    private static WebDriver driver;

    public static WebDriver getChromeDriver() {
        String driverPath = System.getProperty("user.dir") + "/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-geolocation");

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

    public static void takeScreenShot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }
}
