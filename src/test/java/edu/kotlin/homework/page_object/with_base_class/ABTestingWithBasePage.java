package edu.kotlin.homework.page_object.with_base_class;

import org.openqa.selenium.WebDriver;

public class ABTestingWithBasePage extends BasePage{

    public ABTestingWithBasePage(WebDriver driver) {
        super(driver, "https://the-internet.herokuapp.com/abtest");
    }
}
