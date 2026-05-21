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
public class AddressTextarea {

    WebDriver driver;
    String addressLabel;
    String label;

    @Step("Заполнение полей 'Textarea' с наименованием 'Street' в зависимости от параметров " +
            "'{Billing Address}' или '{Shipping Address}'")
    public void writeAddressTextareaOnCreateAccountPage(String text) {
        log.info("Writing in the 'Textarea' fields named 'Street' with a selection of parameters '{}' and '{}'",
                addressLabel, label);
        driver.findElement(By.xpath(String.format("//*[contains(text(), '%s')]/ancestor::" +
                "div[contains(@class, 'edit-view-row-item')]//*[contains(text(), '%s')]//ancestor::" +
                "tr//textarea", addressLabel, label))).sendKeys(text);
    }
}