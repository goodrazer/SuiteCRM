package wrappers;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class InputAccount {

    WebDriver driver;
    String label;

    private final String INPUT_PATTERN_XPATH_ON_ACCOUNTS_PAGE = "//div[contains(text(), '%s')]/parent::div//input";

    @Step("Заполнение полей 'Input' в зависимости от наименования поля на странице 'Account Page'")
    public void writeInputOnAccountPage(String text) {
        log.info("Writing the 'Input' fields with a parameter '{}' on Account Page", label);
        driver.findElement(By.xpath(String.format(INPUT_PATTERN_XPATH_ON_ACCOUNTS_PAGE, label)))
                .sendKeys(text);
    }

    @Step("Получение текста из заполненного поля 'Input' в зависимости от наименования")
    public String getTextOnAccountPage() {
        log.info("Get text from a populated 'Input' field with a parameter '{}'", label);
        return driver.findElement(By.xpath(String.format(INPUT_PATTERN_XPATH_ON_ACCOUNTS_PAGE, label)))
                .getAttribute("value");
    }
}