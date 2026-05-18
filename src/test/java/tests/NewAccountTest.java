package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import wrappers.*;

public class NewAccountTest extends BaseTest {

    @Test
    public void checkAddNewAccount() {
        loginPage.openPage()
                        .isPageOpened()
                        .positiveLogin()
                        .isPageOpened();
        createAccounts.openPage()
                        .isPageOpened();
        Faker faker = new Faker();
        String name = faker.name().fullName();
        new Input(driver, "Name").write(name);
        String actualName = new Input(driver, "Name").getText();
        new Input(driver, "Office Phone").write("+79645637263");
        new Input(driver, "Website").write("mihailcirclecompany.com");
        new Input(driver, "Fax").write("79645637263");
        new Checkbox(driver, "Invalid").clickCheckbox();
        new Checkbox(driver, "Opted Out").clickCheckbox();
        new AddressTextarea(driver,"Billing Address", "Street")
                .write("Пролетарская, д.130,");
        new InputAddress(driver, "Billing Address", "City").write("Magadan");
        new InputAddress(driver, "Billing Address", "State/Region").write("Magadan region");
        new InputAddress(driver, "Billing Address", "Postal Code").write("685000");
        new InputAddress(driver, "Billing Address", "Country").write("Russian Federation");
        new AddressTextarea(driver,"Shipping Address", "Street")
                .write("Пролетарская, д.130,");
        new InputAddress(driver, "Shipping Address", "City").write("Magadan");
        new InputAddress(driver, "Shipping Address", "State/Region").write("Magadan region");
        new InputAddress(driver, "Shipping Address", "Postal Code").write("685000");
        new InputAddress(driver, "Shipping Address", "Country").write("Russian Federation");
        new Checkbox(driver, "Copy address from left").clickCheckbox();
        new Select(driver, "Type").select("Competitor");
        new Select(driver, "Industry").select("Chemicals");
        new Input(driver, "Annual Revenue").write("5000000");
        new Input(driver, "Employees").write("50");
        new TextArea(driver, "Description").write("There should be a long description here");
        createAccounts.clickSaveButton()
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