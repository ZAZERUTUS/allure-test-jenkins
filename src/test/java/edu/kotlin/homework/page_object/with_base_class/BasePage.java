package edu.kotlin.homework.page_object.with_base_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;
    protected String addressPage;

    public BasePage(WebDriver driver, String addressPage) {
        this.driver = driver;
        this.addressPage = addressPage;
    }

    public void goTo() {
        driver.get(addressPage);
    }


    public WebElement customFindElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }
}
