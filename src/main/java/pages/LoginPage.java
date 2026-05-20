package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

@Log4j2
public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By USERNAME_FIELD = By.id("user_name");
    private final By PASSWORD_FIELD = By.id("username_password");
    private final By LOGIN_BUTTON = By.name("Login");
    private final String BASE_URL = "https://demo.suiteondemand.com";

    @Step("Открытие стартовой страницы 'Login'")
    public LoginPage openPage() {
        log.info("Opening the 'Login' start page");
        driver.get(BASE_URL + "/index.php?module=Users&action=Login");
        return this;
    }

    @Step("Проверка отображения страницы 'Login'")
    @Override
    public LoginPage isPageOpened() {
        try {
            log.info("Checking the display of the 'Login' page");
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("The page did not open!!!");
        }
        return this;
    }

    @Step("Авторизация пользователя с валидными данными логина и пароля")
    public WelcomeToTheSuiteCRM7DemoPage positiveLogin(String user, String password) {
        log.info("User authorization with valid data '{}' and '{}'", user,password);
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new WelcomeToTheSuiteCRM7DemoPage(driver);
    }
}