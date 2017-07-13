package base;

import org.openqa.selenium.WebDriver;
import pages.Login;

public class TestPages {

    public Login login;

    public TestPages(WebDriver driver) {
        login = new Login(driver);
    }
}
