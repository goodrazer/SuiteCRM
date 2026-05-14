package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CreateAccounts  extends BasePage{

    public CreateAccounts(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By USERNAME_FIELD = By.xpath("//h2[text()=' CREATE ']");
    @Step("Открытие страницы 'Create Accounts'")
    public CreateAccounts openPage() {
        driver.get(BASE_URL +
                "/index.php?module=Accounts&action=EditView&return_module=Accounts&return_action=DetailView");
        return this;
    }

    @Step("Проверка отображения страницы 'Create Accounts'")
    @Override
    public CreateAccounts isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_FIELD));
        return this;
    }
}