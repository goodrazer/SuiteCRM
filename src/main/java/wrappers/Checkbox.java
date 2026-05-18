package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox {

    WebDriver driver;
    String label;

    public Checkbox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void clickCheckbox() {
        driver.findElement(By.xpath(String.format("//input[@type='checkbox' and contains(@name, '%s')]", label)))
                .click();
    }
}