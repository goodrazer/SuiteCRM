package tests;

import dto.ContactsDTO;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewContactsTest extends BaseTest{

    @Test(testName = "Создание нового контакта",
            description = "Создание нового контакта с проверкой создания контакта и проверкой введенных значений",
            priority = 1,
            groups = "Positive")
    @Description("Создание нового контакта с проверкой создания контакта и проверкой введенных значений")
    @Epic("EPIC01.Создание контакта")
    @Feature("Создание нового контакта авторизованного пользователя")
    @Story("Успешное создание контакта")
    @Severity(SeverityLevel.CRITICAL)
    @Link ("DocumentationLink")
    @TmsLink("TestCaseLink")
    @Issue("BugLink")
    @Flaky
    @Owner("Malevaniy Anton")
    public void checkAddNewAccount() {
        loginStep.successfulAuthorization("will", "will");
        createContactsPage.openPage()
                .isPageOpened();
        ContactsDTO contactsDTO = ContactsDTO.builder()
                .firstName("Anton")
                .lastName("Malevaniy")
                .jobTitle("ololoCompany")
                .officePhone("+79645637263")
                .fax("79645637263")
                .department("ololoDepartment")
                .mobile("+79645637263")
                .build();
        createContactsPage.addNewContact(contactsDTO);
        createContactsPage.clickSaveButton()
                .isPageOpened();
        SoftAssert softAssert = new SoftAssert();
        String actualFirstName = "Anton";
        String expectedFirstName = successfullyCreatedContactsPage.getLastNameSuccessfullyCreatedContactsPage();
        softAssert.assertEquals(actualFirstName, expectedFirstName,
                "Имя, введенное на этапе создания контакта " +
                        "не совпадает с именем в созданном аккаунте!");
        String actualLastName = "Malevaniy";
        String expectedLastName = successfullyCreatedContactsPage.getFirstNameSuccessfullyCreatedContactsPage();
        softAssert.assertEquals(actualLastName, expectedLastName,
                "Фамилия, введенная на этапе создания аккаунта " +
                        "не совпадает с фамилией в созданном аккаунте!");
        softAssert.assertAll();
        driver.quit();
    }
}