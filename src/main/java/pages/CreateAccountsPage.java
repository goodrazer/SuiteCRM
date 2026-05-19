package pages;

import com.github.javafaker.Faker;
import dto.AccountDTO;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrappers.*;

import java.time.Duration;

public class CreateAccountsPage extends BasePage{

    public CreateAccountsPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By USERNAME_FIELD = By.xpath("//h2[text()=' CREATE ']");
    private final By SAVE_BUTTON = By.xpath("(//*[@id='SAVE'])[2]");

    @Step("Открытие страницы 'Create Accounts'")
    public CreateAccountsPage openPage() {
        driver.get(BASE_URL +
                "/index.php?module=Accounts&action=EditView&return_module=Accounts&return_action=DetailView");
        return this;
    }

    @Step("Проверка отображения страницы 'Create Accounts'")
    @Override
    public CreateAccountsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_FIELD));
        return this;
    }

    @Step("Создание нового аккаунта")
    public SuccessfullyCreatedAccountPage addNewAccount(AccountDTO accountDTO){
        Faker faker = new Faker();
        String name = faker.name().fullName();
        new Input(driver, "Name").write(name);
        new Input(driver, "Office Phone").write(accountDTO.getOfficePhone());
        new Input(driver, "Website").write(accountDTO.getWebsite());
        new Input(driver, "Fax").write(accountDTO.getFax());
        new Checkbox(driver, "Accounts0emailAddressOptOutFlag0").clickCheckbox();
        new Checkbox(driver, "Accounts0emailAddressInvalidFlag0").clickCheckbox();
        new AddressTextarea(driver,"Billing Address", "Street")
                .write(accountDTO.getBillingAddressStreet());
        new InputAddress(driver, "Billing Address", "City").
                write(accountDTO.getBillingAddressCity());
        new InputAddress(driver, "Billing Address", "State/Region")
                .write(accountDTO.getBillingAddressStateRegion());
        new InputAddress(driver, "Billing Address", "Postal Code")
                .write(accountDTO.getBillingAddressPostalCode());
        new InputAddress(driver, "Billing Address", "Country")
                .write(accountDTO.getBillingAddressCountry());
        new AddressTextarea(driver,"Shipping Address", "Street")
                .write(accountDTO.getShippingAddressStreet());
        new InputAddress(driver, "Shipping Address", "City")
                .write(accountDTO.getShippingAddressCity());
        new InputAddress(driver, "Shipping Address", "State/Region")
                .write(accountDTO.getShippingAddressStateRegion());
        new InputAddress(driver, "Shipping Address", "Postal Code")
                .write(accountDTO.getShippingAddressPostalCode());
        new InputAddress(driver, "Shipping Address", "Country")
                .write(accountDTO.getShippingAddressCountry());
        new Checkbox(driver, "shipping_checkbox").clickCheckbox();
        new Select(driver, "Type").select(accountDTO.getType());
        new Select(driver, "Industry").select(accountDTO.getIndustry());
        new Input(driver, "Annual Revenue").write(accountDTO.getAnnualRevenue());
        new Input(driver, "Employees").write(accountDTO.getEmployees());
        new TextArea(driver, "Description").write(accountDTO.getDescription());
        return new SuccessfullyCreatedAccountPage(driver);
    }

    @Step("Клик кнопки 'SAVE' на странице 'Create Accounts'")
    public SuccessfullyCreatedAccountPage clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON)).click();
        return new SuccessfullyCreatedAccountPage(driver);
    }
}