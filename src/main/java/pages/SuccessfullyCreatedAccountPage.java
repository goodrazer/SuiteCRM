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
public class SuccessfullyCreatedAccountPage extends BasePage{

    public SuccessfullyCreatedAccountPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By ELEMENT_DATE_CREATED = By.xpath("//h2[@class='module-title-text']");
    private final By NAME = By.id("name");
    private final By WEBSITE = By.id("website");
    private final By OFFICE_PHONE = By.xpath("//*[@field='phone_office']");
    private final By FAX = By.xpath("//*[@field='phone_fax']");
    private final By DESCRIPTION = By.xpath("//*[@field='description']");
    private final By ASSIGNED_TO = By.id("assigned_user_id");
    private final By TYPE = By.xpath("//*[@field='account_type']");
    private final By INDUSTRY = By.xpath("//*[@field='industry']");
    private final By TAB_MORE_INFORMATION = By.xpath("//a[contains(text(), 'MORE INFORMATION')]");

    @Step("Открыть страницу 'Successfully Created Account'")
    @Override
    public BasePage openPage() {
        log.info("Open the 'Successfully Created Account' page");
        driver.get(BASE_URL + "/index.php?action=DetailView&module=Accounts&record=" +
                "c9d369c5-7bde-4c1d-ae98-b1b6e5c5de88&return_module=Accounts&return_action=DetailView&offset=1");
        return this;
    }

    @Step("Проверка отображения страницы 'Successfully Created Account'")
    @Override
    public SuccessfullyCreatedAccountPage isPageOpened() {
        try {
        log.info("Checking the display of the 'Successfully Created Account' page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ELEMENT_DATE_CREATED));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("The page did not open!!!");
        }
        return this;
    }

    @Step("Получить наименование созданного аккаунта на странице 'Successfully Created Account Page'")
    public String getNameSuccessfullyCreatedAccountPage() {
        log.info("get Name Successfully Created Account Page");
        log.info("Get the name of the created account on the 'Successfully Created Account Page'");
        return driver.findElement(NAME).getText();
    }

    @Step("Получить наименование вэб-сайта созданного аккаунта на странице 'Successfully Created Account Page'")
    public String getWebsiteSuccessfullyCreatedAccountPage() {
        log.info("Get the website name of the created account on the 'Successfully Created Account Page'");
        return driver.findElement(WEBSITE).getText();
    }

    @Step("Получить телефон офиса созданного аккаунта на странице 'Successfully Created Account Page'")
    public String getOfficePhoneSuccessfullyCreatedAccountPage() {
        log.info("Get the office phone number for the account you created on the 'Successfully Created Account Page'");
        return driver.findElement(OFFICE_PHONE).getText();
    }

    @Step("Получить факс созданного аккаунта на странице 'Successfully Created Account Page'")
    public String getFaxSuccessfullyCreatedAccountPage() {
        log.info("Get a fax of your created account on the 'Successfully Created Account Page'");
        return driver.findElement(FAX).getText();
    }

    @Step("Получить описание созданного аккаунта на странице 'Successfully Created Account Page'")
    public String getDescriptionSuccessfullyCreatedAccountPage() {
        log.info("Get a description of the created account on the 'Successfully Created Account Page'");
        return driver.findElement(DESCRIPTION).getText();
    }

    @Step("Получить информацию на кого назначено (исполнитель) " +
            "созданного аккаунта на странице 'Successfully Created Account Page'")
    public String getAssignedToSuccessfullyCreatedAccountPage() {
        log.info("Get information about the assigned user (performer) of a created account on the " +
                "'Successfully Created Account Page'");
        return driver.findElement(ASSIGNED_TO).getText();
    }

    @Step("Клик по вкладке 'MORE INFORMATION' на странице 'Successfully Created Account Page'")
    public SuccessfullyCreatedAccountPage clickTabMoreInformation() {
        log.info("Click on the 'MORE INFORMATION' tab on the 'Successfully Created Account Page'");
        wait.until(ExpectedConditions.presenceOfElementLocated(TAB_MORE_INFORMATION));
        org.openqa.selenium.WebElement tab = driver.findElement(TAB_MORE_INFORMATION);
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", tab);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", tab);
        return this;
    }

    @Step("Получить тип созданного аккаунта на странице 'Successfully Created Account Page'")
    public String getTypeSuccessfullyCreatedAccountPage() {
        log.info("Get the created account type on the 'Successfully Created Account Page'");
        return driver.findElement(TYPE).getText();
    }

    @Step("Получить индустрию созданного аккаунта на странице 'Successfully Created Account Page'")
    public String getIndustrySuccessfullyCreatedAccountPage() {
        log.info("Get the industry of the created account on the 'Successfully Created Account Page'");
        return driver.findElement(INDUSTRY).getText();
    }
}