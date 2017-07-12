package runner.steps;

import core.Drivers;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import runner.base.TestPages;

public class Login {

    private static WebDriver driver;
    private TestPages testPages;

    @Before
    public void setup(Scenario scenario) {
        driver = Drivers.getChromeDriver();
        testPages = new TestPages(driver, scenario);
    }

    @Given("^Facebook.com is open$")
    public void openFacebook() throws Throwable {
        driver.navigate().to("http://www.facebook.com");
    }

    @When("^User logs in with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void login(String email, String password) throws Throwable {
        testPages.login.performLogin(email, password);
    }

    @Then("^User should be logged in successfully$")
    public void verifyLogin() throws Throwable {
        testPages.login.verifyLogin();
    }

    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        driver.quit();
    }
}
