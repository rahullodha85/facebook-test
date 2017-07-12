package runner.base;

import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;
import pages.Login;

public class TestPages {

    public Login login;

    public TestPages(WebDriver driver, Scenario scenario) {
        login = new Login(driver, scenario);
    }
}