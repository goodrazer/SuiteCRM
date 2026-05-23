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
public class InputAddress {

    WebDriver driver;
    String addressLabel;
    String label;

    @Step("Заполнение полей 'Input' с выбором различных наименований в зависимости от выбора блоков:" +
            " '{Billing Address}' или '{Shipping Address}'")
    public void writeInputAddressOnAccountPage(String text) {
        log.info("Writing in the 'Input' fields various names depending on the choice of parameters:" +
                " '{}' and '{}'", addressLabel, label);
        driver.findElement(By.xpath(String.format("//*[contains(text(), '%s')]/ancestor::div[contains(@class, " +
                "'edit-view-row-item')]//*[contains(text(), '%s')]//ancestor::tr//input", addressLabel, label))).sendKeys(text);
    }
}