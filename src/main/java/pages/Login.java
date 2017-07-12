package pages;

import cucumber.api.Scenario;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    WebDriver driver;
    Scenario scenario;

    public Login(WebDriver driver, Scenario scenario) {
        this.driver = driver;
        this.scenario = scenario;
    }

    public void clickLogin() {
        driver.findElement(By.id("loginbutton")).click();
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(password);
    }

    public void performLogin(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    public void verifyLogin() {
        Assert.assertTrue(driver.findElement(By.cssSelector("input[placeholder='Search Facebook']")).isDisplayed());
    }
}
