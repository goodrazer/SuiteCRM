package pages;

import com.github.javafaker.Faker;
import dto.ContactsDTO;
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
public class CreateContactsPage extends BasePage
{
    public CreateContactsPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By ELEMENT_FIRST_NAME = By.xpath("//*[@data-label = 'LBL_FIRST_NAME']");
    private final By SAVE_BUTTON = By.id("SAVE");

    @Step("Открытие страницы 'Create Accounts'")
    public CreateContactsPage openPage() {
        log.info("Opening the 'Create Contacts' page");
        driver.get(BASE_URL +
                "/index.php?module=Contacts&action=EditView&return_module=Contacts&return_action=DetailView");
        return this;
    }

    @Step("Проверка отображения страницы 'Create Contacts'")
    @Override
    public CreateContactsPage isPageOpened() {
        try {
            log.info("Checking the display of the 'Create Accounts' page");
            wait.until(ExpectedConditions.visibilityOfElementLocated(ELEMENT_FIRST_NAME));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("The page did not open!!!");
        }
        return this;
    }
    @Step("Создание нового аккаунта c параметором 'contactsDTO'")
    public void addNewContact(ContactsDTO contactsDTO){
        log.info("Creating a new account with parameter {}", contactsDTO);
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        new InputContacts(driver, "First Name", "first_name").writeInputOnContactPage(firstName);
        String job = faker.company().name();
        new InputAccount(driver, "Job Title").writeInputOnAccountPage(job);
        String officePhone = faker.phoneNumber().phoneNumber();
        new InputContacts(driver, "Office Phone","phone_work").writeInputOnContactPage(officePhone);
        new InputContacts(driver, "Last Name","last_name").writeInputOnContactPage(contactsDTO.getLastName());
        new InputContacts(driver, "Mobile","phone_mobile").writeInputOnContactPage(contactsDTO.getMobile());
        new InputContacts(driver, "Department", "department").writeInputOnContactPage(contactsDTO.getDepartment());
        new InputContacts(driver, "Fax","phone_fax").writeInputOnContactPage(contactsDTO.getFax());
    }

    @Step("Клик кнопки 'SAVE' на странице 'Create Contacts'")
    public SuccessfullyCreatedContactsPage clickSaveButton() {
        log.info("Click the 'SAVE' button on the 'Create Contacts' page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON)).click();
        return new SuccessfullyCreatedContactsPage(driver);
    }
}