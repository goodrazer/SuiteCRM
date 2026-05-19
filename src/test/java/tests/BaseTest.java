package tests;

import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.CreateAccountsPage;
import pages.SuccessfullyCreatedAccountPage;
import step.LoginStep;

public class BaseTest {
    protected WebDriver driver;
    protected final String URL =
            "https://demo.suiteondemand.com";

    protected CreateAccountsPage createAccountsPage;
    protected SuccessfullyCreatedAccountPage successfullyCreatedAccountPage;
    protected LoginStep loginStep;

    @Parameters({"browser"})
    @BeforeMethod (alwaysRun = true, description = "Настройка браузера")
    @Description("Настройка браузера")
    public void setUp (@Optional("chrome") String browser, ITestContext iTestContext) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        driver = new ChromeDriver(options);
        driver.get(URL + "/index.php?action=Login&module=Users&login_module=Users&login_action=Logout");
        iTestContext.setAttribute("driver", driver);
        createAccountsPage = new CreateAccountsPage(driver);
        successfullyCreatedAccountPage = new SuccessfullyCreatedAccountPage(driver);
        loginStep = new LoginStep(driver);

    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    @Description("Закрытие браузера")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}