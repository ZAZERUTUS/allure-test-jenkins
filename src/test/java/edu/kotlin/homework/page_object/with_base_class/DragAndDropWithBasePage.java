package edu.kotlin.homework.page_object.with_base_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertTrue;

public class DragAndDropWithBasePage extends BasePage {

    public final String fieldA =  "//header[text()='A']";
    public final String fieldB = "//header[text()='B']";

    public DragAndDropWithBasePage(WebDriver driver) {
        super(driver, "https://the-internet.herokuapp.com/drag_and_drop");
    }

    public void moveAtoB(String aLocator, String bLocator) {
        WebElement a = customFindElementByXpath(aLocator);
        WebElement b = customFindElementByXpath(bLocator);

        Actions actions = new Actions(driver);

        actions
                .moveToElement(a)
                .clickAndHold()
                .moveToElement(b)
                .release()
                .perform();
    }

    public void assertElem2UnderElem1(String elem1, String elem2) {
        String xpath = "//header[text()='" + elem1 + "']/parent::div/following-sibling::div/header[text()='" + elem2 + "']";
        WebElement forAssert2 = customFindElementByXpath(xpath);
        assertTrue(forAssert2.isDisplayed());
    }
}
