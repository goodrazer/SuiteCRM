package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox {

    WebDriver driver;
    String id;

    public Checkbox(WebDriver driver, String label) {
        this.driver = driver;
        this.id = label;
    }

    public void clickCheckbox() {
        driver.findElement(By.xpath(String.format("//*[@id='%s']", id)))
                .click();
    }
}