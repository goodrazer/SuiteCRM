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
public class Input {

    WebDriver driver;
    String label;
    private final String INPUT_PATTERN_XPATH = "//div[contains(text(), '%s')]/parent::div//input";

    @Step("Заполнение полей 'Input' в зависимости от наименования")
    public void write(String text) {
        log.info("Writing the 'Input' fields with a parameter '{}'", label);
        driver.findElement(By.xpath(String.format(INPUT_PATTERN_XPATH, label)))
                .sendKeys(text);
    }

    @Step("Получение текста из заполненного поля 'Input' в зависимости от наименования")
    public String getText() {
        log.info("Get text from a populated 'Input' field with a parameter '{}'", label);
        return driver.findElement(By.xpath(String.format(INPUT_PATTERN_XPATH, label)))
                .getAttribute("value");
    }
}