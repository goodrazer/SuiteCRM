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
public class TextArea {

    WebDriver driver;
    String label;

    @Step("Заполнение полей 'Textarea' в зависимости от наименования")
    public void write(String text) {
        log.info("Writing in the 'Textarea' fields depending on the name: '{}'", label);
        driver.findElement(By.xpath(String.format("//*[contains(text(), '%s')]/ancestor::div[contains(@class, " +
                        "'edit-view-row-item')]//textarea", label)))
                .sendKeys(text);
    }
}