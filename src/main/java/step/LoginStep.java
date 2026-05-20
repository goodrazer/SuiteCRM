package step;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.WelcomeToTheSuiteCRM7DemoPage;

@Log4j2
public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    @Step("Авторизация пользователя с валидными данными логина и пароля с кликом по кнопке 'Login'")
    public WelcomeToTheSuiteCRM7DemoPage successfulAuthorization (String user, String password){
        log.info("User authorization with valid data '{}' and '{}' by clicking on the 'Login' button",
                user, password);
        loginPage.openPage()
                .isPageOpened()
                .positiveLogin(user, password);
        return new WelcomeToTheSuiteCRM7DemoPage(driver);
    }
}