package runner.steps;

import core.Drivers;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import base.TestPages;

import java.util.Map;

import static core.Drivers.takeScreenShot;

public class Login {

    private static WebDriver driver;
    private TestPages testPages;
    private Scenario scenario;

    @Before
    public void setup(Scenario scenario) {
        driver = Drivers.getChromeDriver();
        testPages = new TestPages(driver);
        this.scenario = scenario;
    }

    @Given("^Facebook.com is open$")
    public void openFacebook() throws Throwable {
        driver.navigate().to("http://www.facebook.com");
        takeScreenShot(scenario);
    }

    @When("^User logs in with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void login(String email, String password) throws Throwable {
        testPages.login.performLogin(email, password);
        takeScreenShot(scenario);
    }

    @When("^User logs in with email and password$")
    public void user_logs_in_with_email_and_password(Map<String, String> input) throws Throwable {
        for (String key : input.keySet()) {
            testPages.login.performLogin(key, input.get(key).toString());
            takeScreenShot(scenario);
        }
    }

    @Then("^User should be logged in successfully$")
    public void verifyLogin() throws Throwable {
        testPages.login.verifyLogin();
        takeScreenShot(scenario);
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
