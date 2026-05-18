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

    private final By ELEMENT_DATE_CREATED = By.xpath("//h2[@class='module-title-text']");
    private final By NAME = By.id("name");
    private final By WEBSITE = By.id("website");
    private final By EMAIL_ADDRESS = By.id("email1_span");
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
        return null;
    }

    @Step("Проверка отображения страницы 'Successfully Created Account'")
    @Override
    public SuccessfullyCreatedAccountPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ELEMENT_DATE_CREATED));
        return this;
    }

    @Step("Получить наименование созданного аккаунта на странице 'Successfully Created Account Page'")
    public String getNameSuccessfullyCreatedAccountPage() {
        return driver.findElement(NAME).getText();
    }

    @Step("Получить наименование вэб-сайта созданного аккаунта на странице 'Successfully Created Account Page'")
    public String getWebsiteSuccessfullyCreatedAccountPage() {
        return driver.findElement(WEBSITE).getText();
    }

    @Step("Получить телефон офиса созданного аккаунта на странице 'Successfully Created Account Page'")
    public String getOfficePhoneSuccessfullyCreatedAccountPage() {
        return driver.findElement(OFFICE_PHONE).getText();
    }

    @Step("Получить факс созданного аккаунта на странице 'Successfully Created Account Page'")
    public String getFaxSuccessfullyCreatedAccountPage() {
        return driver.findElement(FAX).getText();
    }

    @Step("Получить описание созданного аккаунта на странице 'Successfully Created Account Page'")
    public String getDescriptionSuccessfullyCreatedAccountPage() {
        return driver.findElement(DESCRIPTION).getText();
    }

    @Step("Получить информацию на кого назначено (исполнитель) " +
            "созданного аккаунта на странице 'Successfully Created Account Page'")
    public String getAssignedToSuccessfullyCreatedAccountPage() {
        return driver.findElement(ASSIGNED_TO).getText();
    }

    @Step("Клик по вкладке 'MORE INFORMATION' на странице 'Successfully Created Account Page'")
    public SuccessfullyCreatedAccountPage clickTabMoreInformation() {
        wait.until(ExpectedConditions.presenceOfElementLocated(TAB_MORE_INFORMATION));
        org.openqa.selenium.WebElement tab = driver.findElement(TAB_MORE_INFORMATION);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tab);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", tab);
        return this;
    }

    @Step("Получить тип созданного аккаунта на странице 'Successfully Created Account Page'")
    public String getTypeSuccessfullyCreatedAccountPage() {
        return driver.findElement(TYPE).getText();
    }

    @Step("Получить индустрию созданного аккаунта на странице 'Successfully Created Account Page'")
    public String getIndustrySuccessfullyCreatedAccountPage() {
        return driver.findElement(INDUSTRY).getText();
    }
}