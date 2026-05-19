package step;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.WelcomeToTheSuiteCRM7DemoPage;

public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;


    public LoginStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    public WelcomeToTheSuiteCRM7DemoPage successfulAuthorization (String user, String password){
        loginPage.openPage()
                .isPageOpened()
                .positiveLogin("will", "will");
        return new WelcomeToTheSuiteCRM7DemoPage(driver);
    }
}
