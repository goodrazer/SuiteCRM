package tests;

import org.testng.annotations.Test;

public class NewAccountTest extends BaseTest {

    @Test
    public void checkAddNewAccount (){
        loginPage.openPage()
                        .isPageOpened()
                        .positiveLogin()
                        .isPageOpened();
        createAccounts.openPage()
                        .isPageOpened();
        driver.quit();
    }
}