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
public class SuccessfullyCreatedContactsPage extends BasePage{

    public SuccessfullyCreatedContactsPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By ELEMENT_DATE_CREATED = By.xpath("//h2[@class='module-title-text']");
    private final By LAST_NAME = By.id("first_name");
    private final By FIRST_NAME = By.id("last_name");

    @Step("Открыть страницу 'Successfully Created Contact'")
    @Override
    public BasePage openPage() {
        log.info("Open the 'Successfully Created Contact' page");
        driver.get(BASE_URL + "/index.php?action=DetailView&module=Contacts&record=" +
                "d1e83b6c-0790-4374-a037-7209e9220788&offset=1");
        return this;
    }

    @Step("Проверка отображения страницы 'Successfully Created Contact'")
    @Override
    public SuccessfullyCreatedContactsPage isPageOpened() {
        try {
            log.info("Checking the display of the 'Successfully Created Contact' page");
            wait.until(ExpectedConditions.visibilityOfElementLocated(ELEMENT_DATE_CREATED));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("The page did not open!!!");
        }
        return this;
    }

    @Step("Получить имя созданного контакта на странице 'Successfully Created Contacts Page'")
    public String getLastNameSuccessfullyCreatedContactsPage() {
        log.info("Get Last Name Successfully 'Created Contacts' Page");
        return driver.findElement(LAST_NAME).getText();
    }

    @Step("Получить фамилию созданного контакта на странице 'Successfully Created Contacts Page'")
    public String getFirstNameSuccessfullyCreatedContactsPage() {
        log.info("Get First Name Successfully 'Created Contacts' Page");
        return driver.findElement(FIRST_NAME).getText();
    }
}
