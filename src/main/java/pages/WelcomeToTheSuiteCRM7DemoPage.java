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
        log.info("Open the Welcome To The Suite CRM 7 Demo Page");
        driver.get(BASE_URL + "/index.php?module=Home&action=Demo");
        return this;
    }

    @Step("Проверка отображения страницы 'Welcome to the SuiteCRM 7 Demo'")
    @Override
    public BasePage isPageOpened() {
        try {
        log.info("Checking the display of the 'Welcome to the SuiteCRM 7 Demo' page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(H1_WELCOME_TO_THE_SUITE_CRM_7_DEMO));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("The page did not open!!!");
        }
        return this;
    }
}