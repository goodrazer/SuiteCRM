package tests;

import dto.AccountDTO;
import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import wrappers.*;

@Log4j2
public class NewAccountTest extends BaseTest {

    @Test (testName = "Создание нового аккаунта",
            description = "Создание нового аккаунта с проверкой создания аккаунта и проверкой введенных значений",
            priority = 1,
            groups = "Positive")
    @Description("Создание нового аккаунта с проверкой создания аккаунта и проверкой введенных значений")
    @Epic("EPIC01.Создание аккаунта")
    @Feature("Создание нового аккаунта авторизованного пользователя")
    @Story("Успешное создание аккаунта")
    @Severity(SeverityLevel.CRITICAL)
    @Link ("DocumentationLink")
    @TmsLink("TestCaseLink")
    @Issue("BugLink")
    @Flaky
    @Owner("Malevaniy Anton")
    public void checkAddNewAccount() {
        log.info("Creating a new account");
        loginStep.successfulAuthorization("will", "will");
        createAccountsPage.openPage()
                        .isPageOpened();
        AccountDTO accountDTO = AccountDTO.builder()
                .officePhone("+79645637263")
                .website("mihailcirclecompany.com")
                .fax("79645637263")
                .billingAddressStreet("Proletarskaya")
                .billingAddressCity("Magadan")
                .billingAddressStateRegion("Magadan region")
                .billingAddressPostalCode("685000")
                .billingAddressCountry("Russian Federation")
                .shippingAddressStreet("Proletarskaya")
                .shippingAddressCity("Magadan")
                .shippingAddressStateRegion("Magadan region")
                .shippingAddressPostalCode("685000")
                .shippingAddressCountry("Russian Federation")
                .annualRevenue("5000000")
                .employees("50")
                .type("Competitor")
                .industry("Chemicals")
                .build();
        createAccountsPage.addNewAccount(accountDTO);
        String actualName = new InputAccount(driver, "Name").getTextOnAccountPage();
        createAccountsPage.clickSaveButton()
                      .isPageOpened();
        SoftAssert softAssert = new SoftAssert();
        String expectedName = successfullyCreatedAccountPage.getNameSuccessfullyCreatedAccountPage();
        softAssert.assertEquals(actualName, expectedName,
                "Наименование компании, введенное на этапе создания аккаунта " +
                        "не совпадает с наименованием компании в созданном аккаунте!");
        String actualOfficePhone = "+79645637263";
        String expectedOfficePhone = successfullyCreatedAccountPage.getOfficePhoneSuccessfullyCreatedAccountPage();
        softAssert.assertEquals(actualOfficePhone, expectedOfficePhone,
                "Номер телефона офиса, введенный на этапе создания аккаунта " +
                        "не совпадает с номером в созданном аккаунте!");
        String actualWebsite = "http://mihailcirclecompany.com";
        String expectedWebsite = successfullyCreatedAccountPage.getWebsiteSuccessfullyCreatedAccountPage();
        softAssert.assertEquals(actualWebsite, expectedWebsite,
                "Вэб-сайт, введенный на этапе создания аккаунта " +
                        "не совпадает с вэб-сайтом в созданном аккаунте!");
        String actualFax = "79645637263";
        String expectedFax = successfullyCreatedAccountPage.getFaxSuccessfullyCreatedAccountPage();
        softAssert.assertEquals(actualFax, expectedFax,
                "Номер факса, введенный на этапе создания аккаунта " +
                        "не совпадает с номером факса в созданном аккаунте!");
        String actualDescription = "There should be a long description here";
        String expectedDescription = successfullyCreatedAccountPage.getDescriptionSuccessfullyCreatedAccountPage();
        softAssert.assertEquals(actualDescription, expectedDescription,
                "Опитсание, введенное на этапе создания аккаунта " +
                        "не совпадает с описанием в созданном аккаунте!");
        String actualAssignedTo = "Will Westin";
        String expectedAssignedTo = successfullyCreatedAccountPage.getAssignedToSuccessfullyCreatedAccountPage();
        softAssert.assertEquals(actualAssignedTo, expectedAssignedTo,
                "Ответственый, введенный на этапе создания аккаунта " +
                        "не совпадает с ответственным в созданном аккаунте!");
        successfullyCreatedAccountPage.clickTabMoreInformation();
        String actualType = "Competitor";
        String expectedType = successfullyCreatedAccountPage.getTypeSuccessfullyCreatedAccountPage();
        softAssert.assertEquals(actualType, expectedType,
                "Тип, введенный на этапе создания аккаунта " +
                        "не совпадает с типом в созданном аккаунте!");
        String actualIndustry = "Chemicals";
        String expectedIndustry = successfullyCreatedAccountPage.getIndustrySuccessfullyCreatedAccountPage();
        softAssert.assertEquals(actualIndustry, expectedIndustry,
                "Индустрия, введенная на этапе создания аккаунта " +
                        "не совпадает с индустрией в созданном аккаунте!");
        softAssert.assertAll();
        driver.quit();
    }
}