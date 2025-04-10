package edu.kotlin.homework.page_object.belhard.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderObject {

    private WebDriver driver;

    public HeaderObject(WebDriver driver) {
        this.driver = driver;
    }

    private final By loc1 = By.xpath("//*[@id=\"rec649425645\"]/div/div/div[9]/div/a");

    public void clickContact() {
        driver.findElement(loc1).click();
    }
}
