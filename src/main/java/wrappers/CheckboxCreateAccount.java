package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxCreateAccount {

    WebDriver driver;
    String label;

    public CheckboxCreateAccount(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format("//div[contains(text(), '%s')]/parent::div//input", label)))
                .sendKeys(text);
    }
}