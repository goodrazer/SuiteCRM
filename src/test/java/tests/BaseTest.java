package tests;

import jdk.jfr.Description;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.CreateAccountsPage;
import pages.SuccessfullyCreatedAccountPage;
import step.LoginStep;
import utils.TestListener;

@Listeners(TestListener.class)
@Log4j2
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
        log.info("Launching a browser with a choice of options");
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
        log.info("Closing the browser");
        if (driver != null) {
            driver.quit();
        }
    }
}