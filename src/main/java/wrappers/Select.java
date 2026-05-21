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
public class Select {

    WebDriver driver;
    String label;
    private final String PATTERN_SELECT_XPATH = "//*[contains(text(), '%s')]/following-sibling::div//";

    @Step("Выбор элементов 'Dropdown' исходя из наименования и выбор опции выбранного элемента 'Dropdown'")
    public void selectOnAccountPage(String option) {
        log.info("Select 'Dropdown' elements based on the name and select the option of the selected " +
                "'Dropdown' element with the parameters:'{}' and '{}'", label, option);
        driver.findElement(By.xpath(String.format(PATTERN_SELECT_XPATH + "select", label))).click();
        driver.findElement(By.xpath(String.format(PATTERN_SELECT_XPATH + "option[contains(text(), '%s')]",
                label, option))).click();
    }
}