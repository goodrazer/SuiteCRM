package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WelcomeToTheSuiteCRM7DemoPage extends BasePage{

    public WelcomeToTheSuiteCRM7DemoPage(WebDriver driver) {
            super(driver);
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

    private final By H1_WELCOME_TO_THE_SUITE_CRM_7_DEMO = By.xpath
            ("//h1[text()='Welcome to the SuiteCRM 7 Demo']");

    @Step("Открыть страницу Welcome To The Suite CRM 7 Demo Page")
    @Override
    public BasePage openPage() {
        driver.get(BASE_URL + "/index.php?module=Home&action=Demo");
        return this;
    }

    @Step("Проверка отображения страницы 'Welcome to the SuiteCRM 7 Demo'")
    @Override
    public BasePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(H1_WELCOME_TO_THE_SUITE_CRM_7_DEMO));
        return this;
    }
}