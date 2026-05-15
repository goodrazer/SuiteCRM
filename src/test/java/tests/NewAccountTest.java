package tests;

import org.testng.annotations.Test;
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
        new InputCreateAccount(driver, "Name").write("Mihail-Circle_Company");
        new InputCreateAccount(driver, "Office Phone").write("+79645637263");
        new InputCreateAccount(driver, "Website").write("Mihailcirclecompany.com");
        new InputCreateAccount(driver, "Fax").write("79645637263");
        new AddressTextareaCreateAccount(driver,"Billing Address", "Street")
                .write("Пролетарская, д.130,");
        new InputAddressCreateAccount(driver, "Billing Address", "City").write("Magadan");
        new InputAddressCreateAccount(driver, "Billing Address", "State/Region").write("Magadan region");
        new InputAddressCreateAccount(driver, "Billing Address", "Postal Code").write("685000");
        new InputAddressCreateAccount(driver, "Billing Address", "Country").write("Russian Federation");
        new AddressTextareaCreateAccount(driver,"Shipping Address", "Street")
                .write("Пролетарская, д.130,");
        new InputAddressCreateAccount(driver, "Shipping Address", "City").write("Magadan");
        new InputAddressCreateAccount(driver, "Shipping Address", "State/Region").write("Magadan region");
        new InputAddressCreateAccount(driver, "Shipping Address", "Postal Code").write("685000");
        new InputAddressCreateAccount(driver, "Shipping Address", "Country").write("Russian Federation");
        new Select(driver, "Type").select("Competitor");
        new Select(driver, "Industry").select("Chemicals");
        new InputCreateAccount(driver, "Annual Revenue").write("5000000");
        new InputCreateAccount(driver, "Employees").write("50");
        new TextAreaCreateAccount(driver, "Description").write("There should be a long description here");
        createAccounts.clickSaveButton()
                      .isPageOpened();
        driver.quit();
    }
}