package edu.kotlin.homework.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertTrue;

public class DragAndDropPage {

    private WebDriver driver;

    public final By fieldA =  By.xpath("//header[text()='A']");
    public final By fieldB = By.xpath("//header[text()='B']");

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }

    public void moveAtoB(By aLocator, By bLocator) {
        WebElement a = driver.findElement(aLocator);
        WebElement b = driver.findElement(bLocator);

        Actions actions = new Actions(driver);

        actions
                .moveToElement(a)
                .clickAndHold()
                .moveToElement(b)
                .release()
                .perform();

        a.click();
    }

    public void assertElem2UnderElem1(String elem1, String elem2) {
        String xpath = "//header[text()='" + elem1 + "']/parent::div/following-sibling::div/header[text()='" + elem2 + "']";
        WebElement forAssert2 = driver.findElement(By.xpath(xpath));
        assertTrue(forAssert2.isDisplayed());
    }
}
