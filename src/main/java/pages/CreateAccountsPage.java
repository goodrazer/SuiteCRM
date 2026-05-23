package pages;

import com.github.javafaker.Faker;
import dto.AccountDTO;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import wrappers.*;
import java.time.Duration;

@Log4j2
public class CreateAccountsPage extends BasePage{

    public CreateAccountsPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By USERNAME_FIELD = By.xpath("//h2[text()=' CREATE ']");
    private final By SAVE_BUTTON = By.xpath("(//*[@id='SAVE'])[2]");

    @Step("Открытие страницы 'Create Accounts'")
    public CreateAccountsPage openPage() {
        log.info("Opening the 'Create Accounts' page");
        driver.get(BASE_URL +
                "/index.php?module=Accounts&action=EditView&return_module=Accounts&return_action=DetailView");
        return this;
    }

    @Step("Проверка отображения страницы 'Create Accounts'")
    @Override
    public CreateAccountsPage isPageOpened() {
        try {
            log.info("Checking the display of the 'Create Accounts' page");
            wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_FIELD));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("The page did not open!!!");
        }
        return this;
    }

    @Step("Создание нового аккаунта c параметором 'accountDTO'")
    public SuccessfullyCreatedAccountPage addNewAccount(AccountDTO accountDTO) {
        log.info("Creating a new account with parameter {}", accountDTO);
        Faker faker = new Faker();
        String name = faker.name().fullName();
        new InputAccount(driver, "Name").writeInputOnAccountPage(name);
        new InputAccount(driver, "Office Phone").writeInputOnAccountPage(accountDTO.getOfficePhone());
        new InputAccount(driver, "Website").writeInputOnAccountPage(accountDTO.getWebsite());
        new InputAccount(driver, "Fax").writeInputOnAccountPage(accountDTO.getFax());
        new Checkbox(driver, "Accounts0emailAddressOptOutFlag0").clickCheckboxOnAccountPage();
        new Checkbox(driver, "Accounts0emailAddressInvalidFlag0").clickCheckboxOnAccountPage();
        new AddressTextareaAndInput(driver,"Billing Address", "Street")
                .writeAddressTextareaOnCreateAccountPage(accountDTO.getBillingAddressStreet());
        new AddressTextareaAndInput(driver, "Billing Address", "City")
                .writeAddressInputOnCreateAccountPage(accountDTO.getBillingAddressCity());
        new AddressTextareaAndInput(driver, "Billing Address", "State/Region")
                .writeAddressInputOnCreateAccountPage(accountDTO.getBillingAddressStateRegion());
        new AddressTextareaAndInput(driver, "Billing Address", "Postal Code")
                .writeAddressInputOnCreateAccountPage(accountDTO.getBillingAddressPostalCode());
        new AddressTextareaAndInput(driver, "Billing Address", "Country")
                .writeAddressInputOnCreateAccountPage(accountDTO.getBillingAddressCountry());
        new AddressTextareaAndInput(driver,"Shipping Address", "Street")
                .writeAddressTextareaOnCreateAccountPage(accountDTO.getShippingAddressStreet());
        new AddressTextareaAndInput(driver, "Shipping Address", "City")
                .writeAddressInputOnCreateAccountPage(accountDTO.getShippingAddressCity());
        new AddressTextareaAndInput(driver, "Shipping Address", "State/Region")
                .writeAddressInputOnCreateAccountPage(accountDTO.getShippingAddressStateRegion());
        new AddressTextareaAndInput(driver, "Shipping Address", "Postal Code")
                .writeAddressInputOnCreateAccountPage(accountDTO.getShippingAddressPostalCode());
        new AddressTextareaAndInput(driver, "Shipping Address", "Country")
                .writeAddressInputOnCreateAccountPage(accountDTO.getShippingAddressCountry());
        new Checkbox(driver, "shipping_checkbox").clickCheckboxOnAccountPage();
        new Select(driver, "Type").selectOnAccountPage(accountDTO.getType());
        new Select(driver, "Industry").selectOnAccountPage(accountDTO.getIndustry());
        new InputAccount(driver, "Annual Revenue").writeInputOnAccountPage(accountDTO.getAnnualRevenue());
        new InputAccount(driver, "Employees").writeInputOnAccountPage(accountDTO.getEmployees());
        new TextArea(driver, "Description").writeTextareaOnAccountPage(accountDTO.getDescription());
        return new SuccessfullyCreatedAccountPage(driver);
    }

    @Step("Клик кнопки 'SAVE' на странице 'Create Accounts'")
    public SuccessfullyCreatedAccountPage clickSaveButton() {
        log.info("Click the 'SAVE' button on the 'Create Accounts' page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON)).click();
        return new SuccessfullyCreatedAccountPage(driver);
    }
}