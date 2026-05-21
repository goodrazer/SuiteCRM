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
public class InputContacts {

    WebDriver driver;
    String label;
    String id;

    private final String INPUT_PATTERN_XPATH_ON_CONTACTS_PAGE = "//*[contains(text(), '%s')]/ancestor::div[@class='tab-content']//parent::div//input[@id='%s']";

    @Step("Получение текста из заполненного поля 'Input' в зависимости от наименования")
    public String getTextOnContactPage() {
        log.info("Get text from a populated 'Input' field with a parameter '{}'", label);
        return driver.findElement(By.xpath(String.format(INPUT_PATTERN_XPATH_ON_CONTACTS_PAGE, label, id)))
                .getAttribute("value");
    }

    @Step("Заполнение полей 'Input' в зависимости от наименования")
    public void writeInputOnContactPage(String text) {
        log.info("Writing the 'Input' fields with a parameters '{}' and '{}' on Contacts Page", label, id);
        driver.findElement(By.xpath(String.format(INPUT_PATTERN_XPATH_ON_CONTACTS_PAGE, label, id)))
                .sendKeys(text);
    }
}