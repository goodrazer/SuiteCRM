package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

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
        driver.get(BASE_URL + "/index.php?module=Users&action=Login");
        return this;
    }

    @Step("Проверка отображения страницы 'Login'")
    @Override
    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

    @Step("Авторизация пользователя с валидными данными")
    public WelcomeToTheSuiteCRM7DemoPage positiveLogin() {
        driver.findElement(USERNAME_FIELD).sendKeys("will");
        driver.findElement(PASSWORD_FIELD).sendKeys("will");
        driver.findElement(LOGIN_BUTTON).click();
        return new WelcomeToTheSuiteCRM7DemoPage(driver);
    }
}