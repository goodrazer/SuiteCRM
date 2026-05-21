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
public class Checkbox {

    WebDriver driver;
    String id;

    @Step("Клик по чекбоксу с выбором 'id'")
    public void clickCheckboxOnAccountPage() {
        log.info("Click on the checkbox with the '{}' selection", id);
        driver.findElement(By.xpath(String.format("//*[@id='%s']", id)))
                .click();
    }
}