package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    WebDriver driver;
    String label;
    private final String INPUT_PATTERN_XPATH = "//div[contains(text(), '%s')]/parent::div//input";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(INPUT_PATTERN_XPATH, label)))
                .sendKeys(text);
    }

    public String getText() {
        return driver.findElement(By.xpath(String.format(INPUT_PATTERN_XPATH, label)))
                .getAttribute("value");
    }
}