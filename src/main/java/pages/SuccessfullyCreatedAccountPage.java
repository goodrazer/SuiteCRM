package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessfullyCreatedAccountPage extends BasePage{

    public SuccessfullyCreatedAccountPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By ELEMENT_DATE_CREATED = By.xpath("//*[contains(text(), 'Date Created')]");

    @Step("Открыть страницу 'Successfully Created Account'")
    @Override
    public BasePage openPage() {
        return null;
    }

    @Step("Проверка отображения страницы 'Successfully Created Account'")
    @Override
    public SuccessfullyCreatedAccountPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ELEMENT_DATE_CREATED));
        return this;
    }
}